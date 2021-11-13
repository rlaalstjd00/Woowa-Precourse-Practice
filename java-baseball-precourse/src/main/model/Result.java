package main.model;

import main.utils.DataUtils;

public class Result {
	int ballCount;
	int strikeCount;
	Game game;
	
	public Result(Game game) {
		this.ballCount = DataUtils.countBalls(game.getComputerNumber(), game.getUserInputNumber());
		this.strikeCount = DataUtils.countStrikes(game.getComputerNumber(), game.getUserInputNumber());
		this.game = game;
	}
	
	public String getResult() {
		String printMsg = "";
		if(ballCount == 0 && strikeCount == 0) {
			printMsg += "낫싱";
		}
		if(ballCount != 0) {
			printMsg += ballCount + "볼 ";
		}
		if(strikeCount != 0) {
			printMsg += strikeCount + "스트라이크 ";
		}
		return printMsg;
	}
	
	public boolean checkResult() {
		if(strikeCount == 3) {
			return true;
		}
		return false;
	}
}
