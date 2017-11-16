//Move Class
import java.util.*;
public class Move {
  
  Board board = new Board(); 
  int fromRow;
  int fromCol;
  int toRow;
  int toCol;  
  Scanner input = new Scanner(System.in);
    
  public void movePiece()
  {
      board.updateBoard();
      board.printBoard();
      
      board.board[fromRow][fromCol] = board.board[toRow][toCol];
      board.board[fromRow][fromCol] = 0;
      
      if(toRow == 7 && board.board[toRow][toCol] == board.RED)
      {
          board.board[toRow][toCol] = board.REDKING; //Converts RED Piece 
      }
      if(toRow == 0 && board.board[toRow][toCol] == board.BLACK)
      {
          board.board[toRow][toCol] = board.BLACKKING;
      }
    
  }
  
  public ArrayList<Move> pieceLegalMoves(int row, int col)
  {
    
  }
    
    private boolean canPieceMove(int fromRow, int fromCol, int toRow, int toCol)
    {
      if(fromRow < 0 || fromRow > 8 || toRow < 0 || toCol > 8)
      {
        return false; // Piece cannot go out of the bounds of the board
      } 
      
      if(board.board[toRow][toCol] != board.EMPTY)
      {
        return false; //Already Contains a Piece
      }

      if(board.board[fromRow][fromCol] == board.RED)
      {
        if(board.board[fromRow][fromCol] == board.RED && fromRow > toRow)
        {
          return false; // Red Piece's can only move down
        
        }
        return true; //Legal Move
      }
      else
      {
        if(board.board[fromRow][fromCol] == board.BLACK)
        {
          if(board.board[fromRow][fromCol] == board.BLACK && fromRow > toRow)
          {
            return false; // Red Piece's can only move up
          }return true; //Legal Move
        }
      }return true;
    }
}
    
  
    
    
  

  




