package com.joonson.assignment4;

public class MyEdge implements Cloneable{
	private MyNode one;
	private MyNode other;
	
	public MyEdge(MyNode one, MyNode other) {
		this.one = one;
		this.other = other;
	}
	
	
	public MyNode getOne() {
		return one;
	}

	public void setOne(MyNode one) {
		this.one = one;
	}

	public MyNode getOther() {
		return other;
	}

	public void setOther(MyNode other) {
		this.other = other;
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new MyEdge(one, other);
	}


	@Override
	public String toString() {
		return "MyEdge [one=" + one.getId() + ", other=" + other.getId() + "]";
	}
	
	

	
	
}
