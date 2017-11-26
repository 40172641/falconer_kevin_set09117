

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
	
	public boolean canPieceMove(int fromRow, int fromCol, int toRow, int toCol) {
		if (fromRow < 0 || fromRow > 8 || toRow < 0 || toCol > 8) {
			System.out.print("Out of Bounds");
			return false; // Piece cannot go out of the bounds of the board
		}

		if (board.board[fromRow][fromCol] == board.EMPTY) {
			System.out.print("Cannot Move Empty Piece");
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
			if (board.board[fromRow][fromCol] == board.RED && fromRow > toRow) {
				System.out.print("Red cannot move up");
				return false; // Red Piece's can only move down
						
			}
			if(board.board[toRow][toCol] == board.RED)
			{
				System.out.println("Cannot move onto a Red Piece");
				return false;
			}
			if(toCol != fromCol-1 && toCol != fromCol+1)
			{
				System.out.println("Red Cannot Move Vertically");
				return false;
			}
			if(toRow != fromRow-1 && toRow != fromRow+1)
			{
				System.out.println("Red Cannot Move Horizontally");
				return false;
			}		
			if(toCol != fromCol-1 && toCol != fromCol+1 && toRow != fromRow-1) {
				if(toCol != fromCol-2 && toCol != fromCol+2 && toRow !=fromRow-2 && board.board[toRow][toCol] != 0) 
					{
						System.out.print("Illegal Move");
						return false;
					}
				} return true;
			} 
				else {
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
				if(board.board[fromRow][fromCol] == board.EMPTY)
				{
					System.out.println("Cannot select empty piece");
					return false;
				}
				if (board.board[fromRow][fromCol] == board.BLACK && toRow == fromRow+1 && toCol == fromCol + 1) 
				{
					System.out.print("Black cannot vertically!");
					return false; // Red Piece's can only move down
				}if (board.board[fromRow][fromCol] == board.BLACK && toRow == fromRow+0 && toCol == fromCol + 1) 
				{
					System.out.print("Black cannot Horizontally");
					return false; // Red Piece's can only move down
				}
				
				return true; // Legal Move
			}
		}
	
		return true;
	}
}