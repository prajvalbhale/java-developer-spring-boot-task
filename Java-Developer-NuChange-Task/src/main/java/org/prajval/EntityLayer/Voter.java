package org.prajval.EntityLayer;

public class Voter {

	private String name;
	private int vote;

	public Voter() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return "Voter [getName()=" + getName() + ", getVote()=" + getVote() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Voter(String name, int vote) {
		super();
		this.name = name;
		this.vote = vote;
	}

}
