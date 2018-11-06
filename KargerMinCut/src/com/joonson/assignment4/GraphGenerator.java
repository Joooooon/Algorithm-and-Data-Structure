package com.joonson.assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphGenerator {
	private final String filePath = "src/file/kargerMinCut.txt";
	private ArrayList<MyNode> theGraph;
	private ArrayList<MyEdge> theEdges;
	
	public GraphGenerator() {}
	
	public void generateNewCopy() {
		ArrayList<String[]> lines = new ArrayList<String[]>();
		try {
			File file = new File(filePath);
			BufferedReader br = new BufferedReader(new FileReader(file));						
			String st;
			while((st = br.readLine()) != null ) 
				lines.add(st.split("\t")) ;	
		}catch(FileNotFoundException fe) {}
		catch(IOException ie) {}
						
		theGraph = new ArrayList<MyNode>();
		//create Nodes		
		for(int i = 0; i < lines.size(); i++) {
			theGraph.add(new MyNode(lines.get(i)));
		}
		//create edges
		theEdges = new ArrayList<MyEdge>();
		
		for(MyNode node: theGraph) {
			for(int otherId:node.getEndPoints()) {
				MyNode other = theGraph.get(otherId-1);
				theEdges.add(new MyEdge(node, other));
			}
		}
		//delete duplicated edges
				
		for(int i=0; i<theEdges.size(); i++) {
			MyEdge edge = theEdges.get(i);
			for(int j=i+1; j<theEdges.size(); j++) {
				MyEdge other = theEdges.get(j);				
				if(other.getOne().equals(edge.getOther()) && other.getOther().equals(edge.getOne())) {
					//System.out.println(edge.toString() + " / " +other.toString());
					theEdges.remove(j);
					break;
				}
			}
		}
		
		for(MyEdge e: theEdges) {
			MyNode end = e.getOne();
			end.addEdge(e);
			
			end = e.getOther();
			end.addEdge(e);
		}
		
//		System.out.println("Number of nodes: "+theGraph.size());
//		System.out.println("Number of edges: "+theEdges.size());		
	}

	public ArrayList<MyNode> getTheGraph() {
		return theGraph;
	}

	public void setTheGraph(ArrayList<MyNode> theGraph) {
		this.theGraph = theGraph;
	}

	public ArrayList<MyEdge> getTheEdges() {
		return theEdges;
	}

	public void setTheEdges(ArrayList<MyEdge> theEdges) {
		this.theEdges = theEdges;
	}
	
}
