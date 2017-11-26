
import java.util.*;

public class Board {

	int board[][] = new int[][] { { 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 3, 0, 3, 0, 3, 0, 3, 0 },
			{ 0, 3, 0, 3, 0, 3, 0, 3 }, { 3, 0, 3, 0, 3, 0, 3, 0 } };

	int EMPTY = 0;
	int RED = 1;
	int REDKING = 2;
	int BLACK = 3;
	int BLACKKING = 4;
	boolean player1 = true;

	public void updateBoard() {
		for (int row = 0; row < 8; row++)
			for (int col = 0; col < 8; col++) {
				if (row % 2 == col % 2) {
					if (row < 3) {
						board[row][col] = RED; // RED
					} else if (row > 4) {
						board[row][col] = BLACK; // BLACK
					} else {
						board[row][col] = EMPTY; // EMPTY
					}

				} else {
					board[row][col] = EMPTY; // EMPTY
				}
				// System.out.print(board[row][col]);
			}

	}

	public void printBoard() {
		System.out.println("\n" +"   0" + " " + "  1" + "   2 " + "  3 " + "  4 " + "  5 " + "  6 " + "  7 ");
		System.out.println("--------------------------------");
		for (int row = 0; row < 8; row++) {
			System.out.print(row);
			for (int col = 0; col < 8; col++) {
				System.out.print("| " + board[row][col] + " ");
			}
			System.out.println("\n");
		}

	}

}