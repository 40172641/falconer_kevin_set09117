package checkers;

//Move Class
import java.util.*;
import java.util.ArrayList;

public class Move {

	Board board;
	
	public Move(Board b)
	{
		board = b;
		
	}
	int fromRow;
	int fromCol;
	int toRow;
	int toCol;
	ArrayList<Move> moves = new ArrayList<Move>();

	// Move constructor
	boolean isJump() {
		return (fromRow - toRow == 2 || fromRow - toRow == -2);
	}

	public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
		board.board[toRow][toCol] = board.board[fromRow][fromCol];
		board.board[fromRow][fromCol] = 0;

		if (toRow == 7 && board.board[toRow][toCol] == board.RED) {
			board.board[toRow][toCol] = board.REDKING; // Converts RED Piece
		}
		if (toRow == 0 && board.board[toRow][toCol] == board.BLACK) {
			board.board[toRow][toCol] = board.BLACKKING;
		}

	}
	// ArrayList which will store all of the Legal Moves within the Game

	public boolean canPieceMove(int fromRow, int fromCol, int toRow, int toCol) {
		if (fromRow < 0 || fromRow > 8 || toRow < 0 || toCol > 8) {
			System.out.print("Out of Bounds");
			return false; // Piece cannot go out of the bounds of the board
		}

		if (board.board[toRow][toCol] != board.EMPTY) {
			System.out.print("Already contains a Piece");
			return false; // Already Contains a Piece
		}

		if (board.board[fromRow][fromCol] == board.RED) {
			if(!board.player1) 
			{
				System.out.println("Wrong Piece");
				return false;
			}
			if (board.board[fromRow][fromCol] == board.RED && fromRow > toRow) {
				System.out.print("Red cannot move up");
				return false; // Red Piece's can only move down
				
			}
			if(toCol != fromCol-1 && toCol != fromCol+1 && toRow != fromRow-1) {
				if(toCol != fromCol-2 && toCol != fromCol+2 && toRow !=fromRow-2 && board.board[toRow][toCol] != 0) 
				{
					System.out.print("Illegal Move");
					return false;
				}// Legal Move	
			} 
			{
				
			}
		} else {
			if (board.board[fromRow][fromCol] == board.BLACK) {
				if(board.player1) 
				{
					System.out.println("Wrong Piece");
					return false;
				}
				if (board.board[fromRow][fromCol] == board.BLACK && fromRow < toRow) {
					System.out.print("Black cannot move down");
					return false; // Red Piece's can only move up
				}
				
				if(toCol != fromCol-1 && toCol != fromCol+1) {
					System.out.println("Illegal Move");
					return false; // Legal Move
				}
				return true; // Legal Move
			}
		}
	
		return true;
	}
}