import java.util.*;
public class Board {
 
 int board[][] = new int[][]{  
   { 0, 1, 0, 1, 0, 1, 0, 1 },
   { 1, 0, 1, 0, 1, 0, 1, 0 },
   { 0, 1, 0, 1, 0, 1, 0, 1 },
   { 0, 0, 0, 0, 0, 0, 0, 0 },
   { 0, 0, 0, 0, 0, 0, 0, 0 },
   { 2, 0, 2, 0, 2, 0, 2, 0 },
   { 0, 2, 0, 1, 0, 1, 0, 2 },
   { 2, 0, 2, 0, 2, 0, 2, 0 } 
       };  
       
       
 int EMPTY = 0;
 int RED = 1;
 int REDKING = 2;
 int BLACK = 3;
 int BLACKKING = 4;
 String player1;
 String player2;

 
 public void updateBoard(){
   for (int row=0; row < 8; row++)
     for(int col =0; col < 8; col++)
     {
      if(row % 2 == col % 2)
      {
       if(row < 3)
       {
        board[row][col] = RED; //RED
       }
       else if(row > 4)
       {
        board[row][col] = BLACK; //BLACK
       }else
       {
        board[row][col] = EMPTY; //EMPTY
       }
       
      }else 
      {
       board[row][col] = EMPTY; //EMPTY
      }
     // System.out.print(board[row][col]);
     }
     
     
 }
 
 public void printBoard()
 {
 System.out.println("1" + " " + "2" + " 3 " + "4 " + "5 " + "6 " + "7 " + "8 ");
 for(int row=0; row < 8; row++){
  for(int col=0; col< 8; col++){
   System.out.print(board[row][col] + " ");
 }
  System.out.println("");
 }

 }

}