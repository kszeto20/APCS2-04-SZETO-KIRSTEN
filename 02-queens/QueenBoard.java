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

    //check for toString
    //board[0][3] = -1;
    //board[1][0] = -1;
    //board[2][4] = -1;
    //board[3][1] = -1;
    //board[4][5] = -1;
    //board[5][2] = -1;
  }

  public boolean solve() {
    return (realSolve(0, 0, board.length));
  }

  public boolean realSolve(int row, int col, int qNum) {
    int qLeft = qNum;
    if (qLeft == 0) {
      return true;
    }
    else {
      for (int i = 0; i < qNum - 1; i++) {
        System.out.println("new row");
        for (int j = 0; j < qNum - 1; j++) {
          System.out.println("new column");
          if (addQueen(i, j)) {
            System.out.println("adding");
            board[i][j] = -1;
            qLeft--;
          }
        }
      }
    }
    return false;
  }

/*
  public static boolean nQueen(int row, int numOfQ) {
    int numOfQLeft = numOfQ;
      if (numOfQueens==0) {
        return true;
      }
      for (int i = 1; i <= NumOfQLeft; i++) {
        if(addQueen(row, j, board, N)) {
          board[row][j] = 1;

          if (nQueen(row+1, n-1, N, board))
            return true;

          board[row][j] = 0; //backtracking
        }
    }
    return false;
    }
    */

  public boolean addQueen (int r, int c) {
    if (avail(r,c)) {
      return true;
    }
    return false;
  }

  public void removeQueen (int r, int c) {
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
      for (int col = colPotQueen, row = rowPotQueen; row >= 0 && col <= board.length - 1; col++, row--) {
        if (board[row][col] == -1) {
          System.out.println("upper right has queen");
          return false;
        }
      }
    return true;
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
}
/*


public boolean solve(){}
public int countSolutions(){}
*/
