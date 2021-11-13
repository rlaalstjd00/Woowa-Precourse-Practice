package main.utils;

import java.util.Arrays;

import main.model.Game;

public class DataUtils {
	// 세자리 수 생성
	public static void createComputerNumber(Game game) {
		final int START_INCLUSIVE = 1;
		final int END_INCLUSIVE = 9;
		final int COMPUTER_NUMBER_LENGTH = 3;
		
		int[] computerNumber = new int[COMPUTER_NUMBER_LENGTH];
		for(int i = 0; i < COMPUTER_NUMBER_LENGTH; i++) {
			int number = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
				if(checkComputerNumber(computerNumber,number)) {
					computerNumber[i] = number;
				} else {
					i--;
				}
		}
		game.setComputerNumber(computerNumber);	
	}
	
	private static boolean checkComputerNumber(int[] computerNumber, int number) {
		for (int i = 0; i < computerNumber.length; i++) {
			if(computerNumber[i] == number) {
				return false;
			}
		}
		return true;
	}
	
	// 사용자 입력값 저장
	public static void saveUserInputNumber(String[] userInput, Game game) {
		int[] userInputNumber = new int[3];
		for (int i = 0; i < userInput.length; i++) {
			userInputNumber[i] = Integer.parseInt(userInput[i]);
		}
		game.setUserInputNumber(userInputNumber);
	}
	
	// ball 카운트
	public static int countBalls(int[] computerNumber, int[] userNumber) {
		int counts = 0;
		Integer[] comNumberArr = new Integer[computerNumber.length];
		Integer[] userNumberArr = new Integer[userNumber.length];
		for (int i = 0; i < userNumberArr.length; i++) {
			comNumberArr[i] = computerNumber[i];
			userNumberArr[i] = userNumber[i];
		}
		for (int i = 0; i < 3; i++) {
			if(Arrays.asList(comNumberArr).contains(userNumberArr[i])
					&& Arrays.asList(comNumberArr).indexOf(userNumberArr[i]) != i) {
				counts ++;
			}
		}
		return counts;
	}
	
	// strike 카운트
	public static int countStrikes(int[] computerNumber, int[] userNumber) {
		int counts = 0;
		for (int i = 0; i < 3; i++) {
			if(computerNumber[i]
					== userNumber[i]) {
				counts ++;
			}
		}
		return counts;
	}
}