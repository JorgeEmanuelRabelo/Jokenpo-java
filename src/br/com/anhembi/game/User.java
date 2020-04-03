package br.com.anhembi.game;

public class User {

	private String name = "";
	private int wonRounds = 0;
	private int action = 0;
	private int tie = 0;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getWonRounds() {
		return wonRounds;
	}

	public void setWonRounds(int wonRounds) {
		this.wonRounds = wonRounds;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getTie() {
		return tie;
	}

	public void setTie(int tie) {
		this.tie = tie;
	}

}
