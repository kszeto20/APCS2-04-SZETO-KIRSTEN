import java.util.*;
import java.util.Arrays;
public class QueenBoard {
  public static void main (String args[]) {
   QueenBoard test = new QueenBoard(4);
   System.out.println();
   System.out.println(test.avail(3, 0));
  }
  private int[][] board;
  private int n;
  //constructor
  public QueenBoard (int size) {
    board = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = 0;
      }
    }

    //check for toString
    board[0][1] = -1;
    board[1][3] = -1;
    board[2][0] = -1;
    board[3][2] = -1;

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
  // personal methods

//addQueen substitute
  public boolean avail (int rowPotQueen, int colPotQueen) {
    // Debug statement: System.out.println("DEBUG: " + board[0][2]);
    // rowPotQueen = row of potential queen
    // colPotQueen = column of potential queen
    // board[row][column]
    // given the column that I want to place, check the other columns in the same row.
    // all squares with queens will have a -1
      for (int col = 0; col < colPotQueen; col++) {

        // row clear?
        if (board[rowPotQueen][col] != 0) {
          //Debug Statement: System.out.println("initialized");
          return false;
        }
      }
      return true;
    }
  }
/*

  //required methods
  public boolean solve(int nQueens, int[][] board, int rows) {
    // nQueens is the number of queens to be place
    // row is the the row that we are currently solving for.
    // board is the empty QueenBoard
  }

  public int countSolutions() {}


  //suggested methods
  private void removeQueen (int r, int c) {}
    */
