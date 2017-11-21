//Move Class
import java.util.*;
import java.util.ArrayList;
public class Move {
  
  Board board = new Board(); 
  int fromRow;
  int fromCol;
  int toRow;
  int toCol;  
  ArrayList<Move> moves = new ArrayList<Move>();
  Scanner input = new Scanner(System.in);
  
  //Move constructor
  public Move(int row1, int col1, int row2, int col2) {
      fromRow = row1;
      fromCol = col1;
      toRow = row2;
      toCol = col2;
    }
    
    boolean isJump() 
    {
        return (fromRow - toRow == 2 || fromRow - toRow == -2);
    }


  
  public void movePiece(int fromRow, int toRow, int fromCol, int toCol)
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
  //ArrayList which will store all of the Legal Moves within the Game
  public ArrayList<Move> pieceLegalMoves(int row, int col)
  {
    
    if(board.board[row][col] == board.RED || board.board[row][col] == board.REDKING)
    {
      if(canPieceMove(row, col, row + 1, col +1))
      {
        moves.add(new Move(row, col, row + 1, col +1));
      }
      if(canPieceMove(row, col, row-1, col+1))
      {
        moves.add(new Move(row, col, row -1, col +1));
      }
      if(canPieceMove(row, col, row + 1 , col -1))
      {
        moves.add(new Move(row, col, row + 1, col -1 ));
      }
      if(canPieceMove(row, col, row - 1, row -1))
      {
        moves.add(new Move(row, col, row - 1, col - 1));
      }
    }
    return moves;
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
    
  
    
    
  

  




