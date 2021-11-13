package main.baseball;
import java.util.Scanner;
import main.model.Game;
import main.model.Result;
import main.utils.DataUtils;
import main.utils.InputUtils;

public class Process {
	private Scanner scanner;
	private Game newGame;
	
	public Process(Scanner scanner) {
		this.scanner = scanner;
	}
	
	// 게임 초기 세팅
	public void initialize() {
		this.newGame = new Game();
		DataUtils.createComputerNumber(newGame);
		getUserInput();
	}
	
	// 사용자 입력값 받기
	private void getUserInput() {
		System.out.print("숫자를 입력해 주세요 : ");
		try {
			String userInput = scanner.next();
			new InputUtils(userInput, newGame).checkUserInputValid();
			printResult();
			return;
		} catch (IllegalArgumentException e) {
			getUserInput();
		}
	}
	
	// 결과 출력
	private void printResult() {
		Result result = new Result(newGame);
		System.out.println(result.getResult());
		if(result.checkResult()) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			checkRestart();
		} else {
			getUserInput();
		}
	}
	
	// 게임 재시작 여부
	private void checkRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String restart = scanner.next();
		
		if(restart.equals("1")) {
			initialize();
		} else if(restart.equals("2")){
			return;
		}
		
		try {
			new InputUtils(restart).checkRestart();
		}catch(IllegalArgumentException e) {
			checkRestart();
		}	
	}
}
