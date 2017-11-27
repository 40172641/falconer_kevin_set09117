
import java.util.*;

public class Game {
	Board myBoard;
	int fromRow;
	int fromCol;
	int toRow;
	int toCol;
	
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
			System.out.println(playerChoice + " Turn");
			userInput();
			if (!moveClass.canPieceMove(fromRow, fromCol, toRow, toCol)) {
				continue;
			} else {
				moveClass.movePiece(fromRow, fromCol, toRow, toCol);
				myBoard.player1 = !myBoard.player1;
			}if(moveClass.blackPieces == 12)
			{
				System.out.println("Winner Red, Congrats!");
				break;	
			}if(moveClass.redPieces == 12)
			{
				System.out.println("Winner Black, Congrats!");
			}
		}
	}

	public void userInput() {
		System.out.print("\n" +"Please input a row ");
		fromRow = input.nextInt();
		System.out.print("Please input a column ");
		fromCol = input.nextInt();
		System.out.println("Please input a row to ");
		toRow = input.nextInt();
		System.out.println("Please input a Column to ");
		toCol = input.nextInt();
	}
}