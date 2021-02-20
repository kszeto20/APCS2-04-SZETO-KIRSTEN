import java.util.*;
import java.util.Arrays;
public class QueenBoard {
  public static void main (String args[]) {
   QueenBoard test = new QueenBoard(6);
   System.out.println();
   System.out.println(test.avail(3, 3));
  }
  private int[][] board;
  //constructor
  public QueenBoard (int size) {
    board = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = 0;
      }
    }

    //check for toString
    //board[0][3] = -1;
    board[1][0] = -1;
    board[2][4] = -1;
    //board[3][1] = -1;
    //board[4][5] = -1;
  }

//only use to String after solve() is completed
  public String toString() {
    String toRet = "";
    //all rows except last
    for (int i = 0; i < board.length - 1; i++) {
      //all columns except last
      for (int j = 0; j < board.length - 1; j++) {
        if (board[i][j] == -1) {
          toRet += "Q ";
        }
        else {
          toRet += "_ ";
        }
      }
      //last columns of all rows
      if (board[i][board.length - 1] == -1) {
        toRet += "Q\n";
      }
      else {
        toRet += "_\n";
      }
    }
    //last row
    for (int j = 0; j < board.length; j++) {
      if (board[board.length - 1][j] == -1) {
        toRet += "Q ";
      }
      else {
        toRet += "_ ";
      }
    }
    return toRet;
  }


//  public boolean addQueen (int rowPotQueen, int colPotQueen) {}
// avail == the check
// place == placement
  public boolean avail (int rowPotQueen, int colPotQueen) {
    // rowPotQueen = row of potential queen
    // colPotQueen = column of potential queen
    // board[row][column]

    // Mission: given the column that I want to place, check the other previous columns in row.
      // row clear?
    for (int col = 0; col < colPotQueen; col++) {
    // all squares with queens will have a -1
      if (board[rowPotQueen][col] == -1) {
        System.out.println("row has queen");
        return false;
      }
    }
    // Mission: given a given a column I want to place, check the previous rows in the column.
      // col clear?
    for (int row = 0; row < rowPotQueen; row++) {
      if (board[row][colPotQueen] ==  -1) {
        System.out.println("col has queen");
        return false;
      }
    }
    // Mission: given a point(x,y) I want to make sure there is no queen on the left diagonal
      // left diag clear?
    for (int col = colPotQueen, row = rowPotQueen; col >= 0 && row >= 0; col--, row--) {
      if (board[row][col] == -1) {
        System.out.println("upper left has queen");
        return false;
      }
    }
    // Mission: given a point(x,y) I want to make sure there is no queen on the right diagonal
      // right diag clear?
      for (int col = colPotQueen, row = rowPotQueen; col <= board.length && row >= 0; col++, row--) {
        if (board[row][col] == -1) {
          System.out.println("upper right has queen");
          return false;
        }
      }
    return true;
  }
}
/*
Private methods (suggested):
private boolean addQueen(int r, int c) adding a queen to a location may not be possible so we want to have a way to determine if it worked.
private void removeQueen(int r, int c) removing a queen should always work

public boolean solve(){}
public int countSolutions(){}
*/
