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
    
    System.out.println("Please input a Row");
    fromRow = input.nextInt();
    System.out.println("Please input a Column");
    fromCol = input.nextInt();
      
    System.out.println("Please input a Row");
    toRow = input.nextInt();
    System.out.println("Please input a Column");
    toCol = input.nextInt();
    
    // fromRow = input.nextInt();
      if(fromRow < 0 || fromRow > 8 || toRow < 0 || toCol > 8)
      {
        System.out.println("This Move is not legal");
      }
      
      else
      {
      System.out.println("piece at  "  + fromRow + ":" + fromCol + " is : " + board.board[fromRow][fromCol]);
      System.out.println("piece at  "  + toRow + ":" + toCol + " is : " + board.board[toRow][toCol]);
      }
    
    if(board.board[fromRow][fromCol] == board.RED){
    if(board.board[fromRow][fromCol] == board.RED && fromRow > toRow)
    {
      System.out.println("Move is not legal");
    }
    if(board.board[toRow][toCol] == board.RED || board.board[toRow][toCol] == board.BLACK)
    {
      System.out.print("Already Contains a Piece" + "\n");
      
    }
    }
    // if(board.board[fromRow][fromCol] == board.RED  && toRow + 1)
      {
      //  System.out.print("Move Not Legal");
      //}
   

    if(toCol == 7 && board.board[toRow][toCol] == board.RED)
    {
      board.board[toRow][toCol] = board.REDKING;
    }
    if(toCol == 0 && board.board[toRow][toCol] == board.BLACK)
    {
      board.board[toRow][toCol] = board.BLACKKING;
    }
  
      board.board[fromRow][fromCol] = board.board[toRow][toCol];
      board.board[fromRow][fromCol] = 0;
    
    System.out.println("Array at Postion Input " + board.board[fromRow][fromCol] + " New Postion " + board.board[toRow][toRow]);
    
    board.printBoard();
    }
    
  }
}
  




