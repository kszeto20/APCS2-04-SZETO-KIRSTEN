import java.util.*;
import java.util.Arrays;
public class QueenBoard {
  public static void main (String args[]) {
   QueenBoard test = new QueenBoard(4);
   System.out.println();
   System.out.println(avail(test.getBoard(), 3, 3));
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
  }

  public int[][] getBoard() {
    return board;
  }
  public String toString() {
    String toRet = "";
    for (int i = 0; i < board.length - 1; i++) {
      for (int j = 0; j < board.length - 1; j++) {
        toRet += board[i][j] + ", ";
      }
      toRet += board[i][board.length - 1];
      toRet += "\n";
    }
    for (int j = 0; j < board.length - 1; j++) {
      toRet += board[board.length - 1][j] + ", ";
    }
    toRet += board[board.length - 1][board.length - 1];
    return toRet;
  }

  /*
  public String toString() {
    String toRet = "";
    // convert to dash and Qs

    char[][] print = new char[board.length][board.length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != 0) {
          print[i][j] = 'Q';
        }
        print[i][j] = '_';
      }
    }

    for (int i = 0; i < print.length - 1; i++) {
      for (int j = 0; j < print.length - 1; j++) {
        toRet += print[i][j] + ", ";
      }
      toRet += print[i][print.length - 1];
      toRet += "\n";
    }
    for (int j = 0; j < print.length - 1; j++) {
      toRet += print[print.length - 1][j] + ", ";
    }
    toRet += print[print.length - 1][print.length - 1];


    return toRet;
  }
  */
  // personal methods

  public static boolean avail (int[][] board, int rowPotQueen, int colPotQueen) {
      System.out.println("DEBUG: " + board[0][2]);
    // rowPotQueen = row of potential queen
    // colPotQueen = column of potential queen
    // board[row][column]
    // given the column that I want to place, check the other columns in the same row.
    // all squares with queens will have a -1

      for (int col = 0; col < colPotQueen; col++) {

        // row clear?
        if (board[rowPotQueen][col] != 0) {
          System.out.println("initialized");
          return false;
        }
      }
      return true;
    }

    /*
    // board[] = row
    // board[][] = column
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < currentQueenCol; col++) {
        // col free?
        if (board[row][col] == board[row][currentQueenCol]) {
          System.out.println("DEBUG: place | " + board[row][currentQueenCol]);
          return false;
        }
        // same diag
        if ((currentQueenCol - col) == Math.abs(board[row][col] - board[row][col])) {
          return false;
        }
      }
    }
    return true;
    */
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
  private boolean addQueen (int r, int c) {}
  private void removeQueen (int r, int c) {}
    */
