import java.util.*;
import java.util.Arrays;
public class QueenBoard {
  public static void main (String args[]) {
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
  }

  public boolean solve() {
    for (int col = 0; col < board.length; col++) {
      if (board[0][col] != 0) {
        throw new IllegalStateException ("You have already solved this board");
      }
    }
    return (realSolve(0));
  }

  private boolean realSolve(int row) {
    if (row == board.length) {
      return true;
    }
    else {
      for (int col = 0; col < board.length; col++) {
        if (addQueen(row, col)) {
          board[row][col] = -1;
          if (realSolve(row + 1)) {
            return true;
          }
        }
        board[row][col] = 0;
      }
    }
    return false;
  }

  private boolean addQueen (int r, int c) {
    if (avail(r,c)) {
      return true;
    }
    return false;
  }

  private void removeQueen (int r, int c) {
    board[r][c] = 0;
  }

  private boolean avail (int rowPotQueen, int colPotQueen) {
    // What does this do? --> Tells you whether a specified position is good to place a queen.
    // rowPotQueen = row of potential queen
    // colPotQueen = column of potential queen
    // board[row][column]

    // Mission: given the column that I want to place, check the other previous columns in row.
      // row clear?
    for (int col = 0; col < colPotQueen; col++) {
    // all squares with queens will have a -1
      if (board[rowPotQueen][col] == -1) {
        return false;
      }
    }
    // Mission: given a given a column I want to place, check the previous rows in the column.
      // col clear?
    for (int row = 0; row < rowPotQueen; row++) {
      if (board[row][colPotQueen] ==  -1) {
        return false;
      }
    }
    // Mission: given a point(x,y) I want to make sure there is no queen on the left diagonal
      // left diag clear?
    for (int col = colPotQueen, row = rowPotQueen; col >= 0 && row >= 0; col--, row--) {
      if (board[row][col] == -1) {
        return false;
      }
    }
    // Mission: given a point(x,y) I want to make sure there is no queen on the right diagonal
      // right diag clear?
      for (int col = colPotQueen, row = rowPotQueen; row >= 0 && col <= board.length - 1; col++, row--) {
        if (board[row][col] == -1) {
          return false;
        }
      }
    return true;
  }

  public int countSolutions(){
    for (int col = 0; col < board.length; col++) {
      if (board[0][col] != 0) {
        throw new IllegalStateException ("You have already solved this board");
      }
    }
    return realCount(0);
  }

  private int realCount(int row) {
    int total = 0;
    if (row == board.length) {
      return 1;
    }
    else {
      for (int col = 0; col < board.length; col++) {
        if (addQueen(row, col)) {
          board[row][col] = -1;
          total += realCount(row + 1);
          removeQueen(row, col);
        }
      }
    }
    return total;
  }



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
}
