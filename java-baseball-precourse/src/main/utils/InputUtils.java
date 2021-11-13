package main.utils;

import main.model.Game;

public class InputUtils {
	
	private String userInput;
	private Game game;
	
	public InputUtils(String userInput, Game game) {
		this.userInput = userInput;
		this.game = game;
	}
	
	public InputUtils(String userInput) {
		this.userInput = userInput;
	}
	
	public void checkUserInputValid() throws IllegalArgumentException{
		String[] userInputArr = isUserInputDigit(userInput).split("");
		DataUtils.saveUserInputNumber(userInputArr, game);
	}
	
	// 문자 입력에 대한 예외처리
	private String isUserInputDigit(String userInput) throws IllegalArgumentException {
		try {
			Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		return isUserInputLength(userInput);
	}
	
	// 3자리 이상,이하 입력에 대한 예외처리
	private String isUserInputLength(String userInput) throws IllegalArgumentException {
		if(userInput.length() != 3) {
			throw new IllegalArgumentException();
		}
		return isUserInputDiffDigits(userInput);
	}
	
	// 중복값 입력에 대한 예외처리
	private String isUserInputDiffDigits(String userInput) throws IllegalArgumentException {
		if(userInput.charAt(0) == userInput.charAt(1)
				|| userInput.charAt(1) == userInput.charAt(2)
				|| userInput.charAt(0) == userInput.charAt(2)) {
			throw new IllegalArgumentException();
		}
		return isValidNumber(userInput);
	}
	
	// 0 입력에 대한 예외처리
	private String isValidNumber(String userInput) throws IllegalArgumentException {
		if(userInput.contains("0")) {
			throw new IllegalArgumentException();
		}
		return userInput;
	}
	
	// (재시작 여부 선택시) 1혹은 2 외의 값 선택시 예외처리
	public void checkRestart() throws IllegalArgumentException{
		if(!userInput.equals("1") && !userInput.equals("2")) {
			throw new IllegalArgumentException();
		}
	}
}
