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
	int redPieces = 0;
	int blackPieces = 0;

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
		//RED KING LEGAL MOVES
		if(board.board[fromRow][fromCol] == board.REDKING)
		{
			if(!board.player1) 
			{
				System.out.println("Wrong Piece");
				return false;
			}
			if(toRow == fromRow +1 && board.board[toRow][toCol] == board.BLACK || board.board[toRow][toCol] == board.BLACKKING)
			{
				System.out.print("Cannot directly capture that Piece");
				return false;
			}
			if(toRow == fromRow -1 && board.board[toRow][toCol] == board.BLACK || board.board[toRow][toCol] == board.BLACKKING)
			{
				System.out.print("Cannot directly capture that Piece");
				return false;
			}
			
			if(board.board[toRow][toCol] == board.EMPTY){	
				if(toRow == fromRow + 2 && toCol == fromCol + 2)
				{
					if(board.board[fromRow+1][fromCol+1] == board.BLACK || board.board[fromRow+1][fromCol+1] == board.BLACKKING)
						{
							System.out.println("Black Piece Captured on Right!!!");
							board.board[fromRow+1][fromCol+1] = board.EMPTY;
							return true;
						}
				}
				if(toRow == fromRow - 2 && toCol == fromCol - 2)
				{
					if(board.board[fromRow-1][fromCol-1] == board.BLACK || board.board[fromRow-1][fromCol-1] == board.BLACKKING)
						{
							System.out.println("Black Piece Captured on 1!!!");
							board.board[fromRow-1][fromCol-1] = board.EMPTY;
							return true;
						}
				}
				if(toRow == fromRow - 2 && toCol == fromCol + 2)
				{
					if(board.board[fromRow-1][fromCol+1] == board.BLACK || board.board[fromRow-1][fromCol+1] == board.BLACKKING)
						{
							System.out.println("Black Piece Captured on 1!!!");
							board.board[fromRow-1][fromCol+1] = board.EMPTY;
							return true;
						}
				}
				
				if(toRow == fromRow + 2 && toCol == fromCol - 2)
				{
					if(board.board[fromRow+1][fromCol-1] == board.BLACK || board.board[fromRow+1][fromCol-1] == board.BLACKKING)
					{
						System.out.println("Black Piece on the Left!!!");
						board.board[fromRow+1][fromCol-1] = board.EMPTY;
						return true;
					}
				}
			}	
			if(toCol != fromCol-1 && toCol != fromCol+1)
			{
				System.out.println("Red King Cannot Move Vertically");
				return false;
			}
			if(toRow != fromRow-1 && toRow != fromRow+1)
			{
				System.out.println("Red King Cannot Move Horizontally");
				return false;
			}
			if(board.board[toRow][toCol] == board.RED || board.board[toRow][toCol] == board.REDKING)
			{
				System.out.println("Cannot move onto a Red Piece");
				return false;
			}
			return true;
		}else
		{
			if(board.board[fromRow][fromCol] == board.BLACKKING)
			{
				if(board.player1) 
				{
					System.out.println("Wrong Piece");
					return false;
				}
				if(board.board[toRow][toCol] == board.EMPTY){	
					if(toRow == fromRow + 2 && toCol == fromCol + 2)
					{
						if(board.board[fromRow+1][fromCol+1] == board.RED || board.board[fromRow+1][fromCol+1] == board.REDKING)
							{
								System.out.println("Black Piece Captured on Right!!!");
								board.board[fromRow+1][fromCol+1] = board.EMPTY;
								return true;
							}
					}
					if(toRow == fromRow - 2 && toCol == fromCol - 2)
					{
						if(board.board[fromRow-1][fromCol-1] == board.RED || board.board[fromRow-1][fromCol-1] == board.REDKING)
							{
								System.out.println("Black Piece Captured!!!");
								board.board[fromRow-1][fromCol-1] = board.EMPTY;
								return true;
							}
					}
					if(toRow == fromRow - 2 && toCol == fromCol + 2)
					{
						if(board.board[fromRow-1][fromCol+1] == board.RED|| board.board[fromRow-1][fromCol+1] == board.REDKING)
							{
								System.out.println("Black Piece Captured!!!");
								board.board[fromRow-1][fromCol+1] = board.EMPTY;
								return true;
							}
					}
					
					if(toRow == fromRow + 2 && toCol == fromCol - 2)
					{
						if(board.board[fromRow+1][fromCol-1] == board.RED || board.board[fromRow+1][fromCol-1] == board.REDKING)
						{
							System.out.println("Black Piece on the Left!!!");
							board.board[fromRow+1][fromCol-1] = board.EMPTY;
							return true;
						}
					}
				}	
				if(toCol != fromCol-1 && toCol != fromCol+1)
				{
					System.out.println("Black King Cannot Move Vertically");
					return false;
				}
				if(toRow != fromRow-1 && toRow != fromRow+1)
				{
					System.out.println("Black King Cannot Move Horizontally");
					return false;
				}
				if(board.board[toRow][toCol] == board.BLACK || board.board[toRow][toCol] == board.BLACKKING)
				{
					System.out.println("Cannot move onto a Black Piece");
					return false;
				}
				if(toRow == fromRow -1 && board.board[toRow][toCol] == board.RED || board.board[toRow][toCol] == board.REDKING)
				{
					System.out.print("Cannot directly capture that Piece");
					return false;
				}
				if(toRow == fromRow +1 && board.board[toRow][toCol] == board.RED || board.board[toRow][toCol] == board.REDKING)
				{
					System.out.print("Cannot directly capture that Piece");
					return false;
				}
				return true;	
			}
		}
		
		// RED PIECE MOVEMENT
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
			if(board.board[toRow][toCol] == board.EMPTY){	
				if(toRow == fromRow + 2 && toCol == fromCol + 2)
				{
					if(board.board[fromRow+1][fromCol+1] == board.BLACK || board.board[fromRow+1][fromCol+1] == board.BLACKKING)
						{
							System.out.println("Black Piece Captured on Right!!!");
							board.board[fromRow+1][fromCol+1] = board.EMPTY;
							blackPieces= blackPieces + 1;
							System.out.println("Black Piece's Captured: " + blackPieces);
							return true;
						}
				}
				if(toRow == fromRow + 2 && toCol == fromCol - 2)
				{
					if(board.board[fromRow+1][fromCol-1] == board.BLACK || board.board[fromRow+1][fromCol-1] == board.BLACKKING)
					{
						System.out.println("Black Piece on the Left!!!");
						board.board[fromRow+1][fromCol-1] = board.EMPTY;
						return true;
					}
				}
			}
		
			
			////	Jumping 	/////
			///Capture on the Right ////
			if(board.board[toRow][toCol] == board.EMPTY)
			{	
				if(toRow == fromRow + 4 && toCol == fromCol + 4)
				{
					if(board.board[fromRow+1][fromCol+1] == board.BLACK || board.board[fromRow+1][fromCol+1] == board.BLACKKING)
					{
						if(board.board[fromRow+2][fromCol+2] == board.EMPTY)
						{
							if(board.board[fromRow+3][fromCol+3] == board.BLACK || board.board[fromRow+3][fromCol+3] == board.BLACKKING)
							{
							System.out.println("Black Piece Captured on Right!!!");
							board.board[fromRow+1][fromCol+1] = board.EMPTY;
							board.board[fromRow+3][fromCol+3] = board.EMPTY;
							blackPieces= blackPieces + 2;
							System.out.println("Black Piece's Captured: " + blackPieces);
							return true;
							}
						}
					}
				}
				if(toRow == fromRow + 4 && toCol == fromCol - 4)
				{
					if(board.board[fromRow+1][fromCol-1] == board.BLACK || board.board[fromRow+1][fromCol-1] == board.BLACKKING)
					{
						if(board.board[fromRow+2][fromCol-2] == board.EMPTY)
						{
							if(board.board[fromRow+3][fromCol-3] == board.BLACK || board.board[fromRow+3][fromCol-3] == board.BLACKKING)
							{
							System.out.println("Black Piece Captured on Right!!!");
							board.board[fromRow+1][fromCol-1] = board.EMPTY;
							board.board[fromRow+3][fromCol-3] = board.EMPTY;
							blackPieces= blackPieces + 2;
							System.out.println("Black Piece's Captured: " + blackPieces);
							return true;
							}
						}
					}
				}
			}
								
			if(toCol != fromCol-1 && toCol != fromCol+1) {
				System.out.println("Red Cannot Move Vertically, Illegal Move");
				return false; // Legal Move
			}
			if(toRow != fromRow-1 && toRow != fromRow+1) {
				System.out.println("Red Cannot Move Vertically, Illegal Move");
				return false; // Legal Move
			}				
			if(board.board[toRow][toCol] == board.RED)
			{
				System.out.println("Cannot move onto a Red Piece");
				return false;
			}
			if(toRow == fromRow +1 && board.board[toRow][toCol] == board.BLACK || board.board[toRow][toCol] == board.BLACKKING)
			{
				System.out.print("Cannot directly capture that Piece");
				return false;
			}	
			 return true;
			} 
			//BLACK PIECE MOVEMENT
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
				if(board.board[toRow][toCol] == board.EMPTY)
				{
					if(toRow == fromRow - 2 && toCol == fromCol - 2)
						if(board.board[fromRow-1][fromCol-1] == board.RED || board.board[fromRow-1][fromCol-1] == board.REDKING){
						{
							System.out.println("Red Piece Captured 1!!!");
							board.board[fromRow-1][fromCol-1] = board.EMPTY;
							return true;
							}
						}
					if(toRow == fromRow - 2 && toCol == fromCol + 2)
					{
						if(board.board[fromRow-1][fromCol+1] == board.RED || board.board[fromRow-1][fromCol+1] == board.REDKING)
						{
							System.out.println("Red Piece Captured 2!!!");
							board.board[fromRow-1][fromCol+1] = board.EMPTY;
							return true;
						}
					}
				}
				
				////	Jumping 	/////
				///Capture on the Right ////
				if(board.board[toRow][toCol] == board.EMPTY)
				{	
					if(toRow == fromRow - 4 && toCol == fromCol - 4)
					{
						if(board.board[fromRow-1][fromCol-1] == board.RED || board.board[fromRow-1][fromCol-1] == board.REDKING)
						{
							if(board.board[fromRow-2][fromCol-2] == board.EMPTY)
							{
								if(board.board[fromRow-3][fromCol-3] == board.RED || board.board[fromRow+3][fromCol+3] == board.REDKING)
								{
								System.out.println("Black Piece Captured on Right!!!");
								board.board[fromRow-1][fromCol-1] = board.EMPTY;
								board.board[fromRow-3][fromCol-3] = board.EMPTY;
								redPieces= redPieces + 2;
								System.out.println("Double Jump!");
								System.out.println("Black Piece's Captured: " + redPieces);
								return true;
								}
							}
						}
					}
					if(toRow == fromRow - 4 && toCol == fromCol + 4)
					{
						if(board.board[fromRow-1][fromCol+1] == board.RED || board.board[fromRow-1][fromCol+1] == board.REDKING)
						{
							if(board.board[fromRow-2][fromCol+2] == board.EMPTY)
							{
								if(board.board[fromRow-3][fromCol+3] == board.RED || board.board[fromRow-3][fromCol+3] == board.REDKING)
								{
								System.out.println("Black Piece Captured on Right!!!");
								board.board[fromRow-1][fromCol+1] = board.EMPTY;
								board.board[fromRow-3][fromCol+3] = board.EMPTY;
								redPieces= redPieces + 2;
								System.out.println("Double Jump");
								System.out.println("Red Piece's Captured: " + redPieces);
								return true;
								}
							}
						}
					}
				}
				if(toCol != fromCol-1 && toCol != fromCol+1) {
					System.out.println("Black Cannot Move Vertically, Illegal Move");
					return false; // Legal Move
				}
				if(toRow != fromRow-1 && toRow != fromRow+1) {
					System.out.println("Black Cannot Move Vertically, Illegal Move");
					return false; // Legal Move
				}
				if(board.board[fromRow][fromCol] == board.EMPTY)
				{
					System.out.println("Cannot select empty piece");
					return false;
				}
				if(board.board[toRow][toCol] == board.BLACK)
				{
					System.out.println("Cannot move onto a Black Piece");
					return false;
				}
				if(toRow == fromRow -1 && board.board[toRow][toCol] == board.RED)
				{
					System.out.print("Cannot directly capture that Piece");
					return false;
				}
				if(toCol != fromCol-1 && toCol != fromCol+1 && toRow != fromRow-1) {
					if(toCol != fromCol-2 && toCol != fromCol+2 && toRow !=fromRow-2 && board.board[toRow][toCol] != 0) 
						{
							System.out.print("Illegal Move");
							return false;
						}
				}
				return true; // Legal Move
			}
		}	
	
		return true;
	}
}