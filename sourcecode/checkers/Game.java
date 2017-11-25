package checkers;

import java.util.*;

public class Game {
	Board myBoard;
	int froRow;
	int froCol;
	int tRow;
	int tCol;
	
	Move moveClass; 
	Scanner input = new Scanner(System.in);

	boolean gameInProgress;

	public Game(Board board) {
		myBoard = board;
		moveClass = new Move(myBoard);
	}
	

	public void gameLoop() {
		while (gameInProgress) {
			myBoard.printBoard();
			String playerChoice = myBoard.player1?"Red":"Black";
			System.out.println(playerChoice + "Turn");
			userInput();
			if (!moveClass.canPieceMove(froRow, froCol, tRow, tCol)) {
				continue;
			} else {
				moveClass.movePiece(froRow, froCol, tRow, tCol);
				myBoard.player1 = !myBoard.player1;
			}
		}
	}

	public void userInput() {
		System.out.print("Please input a row");
		froRow = input.nextInt();
		System.out.print("Please input a column");
		froCol = input.nextInt();
		System.out.println("Please input a row to");
		tRow = input.nextInt();
		System.out.println("Please input a Column to");
		tCol = input.nextInt();
	}
}