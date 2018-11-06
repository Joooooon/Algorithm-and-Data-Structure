package com.joonson.assignment4;

import java.util.ArrayList;
import java.util.List;

public class KargerMinCut {
	private int minimumCut = Integer.MAX_VALUE;
	private int loop;
	private List<MyNode> theGraph;
	private List<MyEdge> theEdges;	
	private GraphGenerator gGenerator;
	
	public KargerMinCut(GraphGenerator gGenerator) {
		this.gGenerator = gGenerator;
	}
		
	public int getMinCut() {
		loop = 200;
		System.out.println("-----------------------------------------------------------------------");
		while(loop>0) {
			gGenerator.generateNewCopy();
			theGraph = gGenerator.getTheGraph();
			theEdges = gGenerator.getTheEdges();
			
			int cut = execSubKargerMinCut(theGraph, theEdges);
			minimumCut = cut>minimumCut ? minimumCut:cut;
			System.out.println("loop: "+loop+" minimum cut: "+minimumCut);
			loop--;
		}		
		return minimumCut;
	}
	
	private int execSubKargerMinCut(List<MyNode> targetGraph, List<MyEdge> targetEdges) {
		int cut =0;
		while(targetGraph.size() > 2) {
		//choose a edge randomly
			int idx = (int)(Math.random() * targetEdges.size());
			MyEdge edge = targetEdges.get(idx);
			MyNode one = edge.getOne();
			MyNode other = edge.getOther();
			
//			System.out.println("one: "+one.getId()+" other: "+other.getId());
//			System.out.println("\t one: "+one.getEdges().size());
//			System.out.println("\t other: "+other.getEdges().size());
			one.execMerge(other);
//			System.out.println("\t one: "+one.getEdges().size());
//			System.out.println("\t other: "+other.getEdges().size());
			for(int i=0; i<targetEdges.size(); i++) {
				if(targetEdges.get(i).getOne() == targetEdges.get(i).getOther()) {
					targetEdges.remove(i);
					i--;
				}
			}
			targetGraph.remove(other);
		}
		cut = targetGraph.get(0).getEdges().size();
		
		return cut;
	}
}
