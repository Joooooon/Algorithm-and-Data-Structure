package com.joonson.assignment4;

import java.util.ArrayList;

public class MyNode implements Cloneable {
	private int id = -1;
	private ArrayList<Integer> endPoints = new ArrayList<Integer>(); //duplicated nodes are allowed
	private ArrayList<MyEdge> edges = new ArrayList<MyEdge>();
	private String[] originData;
	
	public MyNode(String[] idAndEndpoints) {
		this.id = Integer.parseInt(idAndEndpoints[0]);
		this.originData = idAndEndpoints;
		for(int i=1; i<idAndEndpoints.length; i++) endPoints.add(Integer.valueOf(idAndEndpoints[i]));
	}
	
	public void execMerge(MyNode other) {
		for(MyEdge edge: other.getEdges()) {
			if(edge.getOne() == other) edge.setOne(this);
			else if(edge.getOther() == other) edge.setOther(this);
			
			if(edge.getOne() != edge.getOther()) this.edges.add(edge);
		}
		for(int i=0; i<this.edges.size(); i++) {
			if(this.edges.get(i).getOne() == this.edges.get(i).getOther()) {
				this.edges.remove(i);
				i--;
			}
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getEndPoints() {
		return endPoints;
	}

	public void setEndPoints(ArrayList<Integer> endPoints) {
		this.endPoints = endPoints;
	}
	
	public void addEdge(MyEdge e) {
		edges.add(e);
	}

	public ArrayList<MyEdge> getEdges() {
		return edges;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		MyNode node =  new MyNode(this.originData);
		ArrayList<MyEdge> cpEdges = new ArrayList<MyEdge>();
		for(MyEdge edge: edges) cpEdges.add((MyEdge)edge.clone());
		node.edges = cpEdges;
		
		return node;		
	}
	
	
}
