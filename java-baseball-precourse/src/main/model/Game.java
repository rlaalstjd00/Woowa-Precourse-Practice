package main.model;

public class Game {
	private int[] computerNumber = new int[3];
	private int[] userInputNumber = new int[3];
	
	public int[] getComputerNumber() {
		return computerNumber;
	}
	public void setComputerNumber(int[] computerNumber) {
		this.computerNumber = computerNumber;
	}
	public int[] getUserInputNumber() {
		return userInputNumber;
	}
	public void setUserInputNumber(int[] userInputNumber) {
		this.userInputNumber = userInputNumber;
	}
	
	
}
