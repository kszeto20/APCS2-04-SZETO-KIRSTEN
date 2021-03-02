import java.io.*;
import java.util.*;
public class MazeGenerator {

  public static void generate(char[][] maze, int x, int y, int row, int column) {
    // place
    maze[row][column] = ' ';

    //random gen
    int[] poss = {0, 1, 2, 3};
    for(int i = 0; i < poss.length; i++) {
      Random r = new Random();
      int j = (r.nextInt(4));
      //switch
      int hold = poss[i];
      poss[i] = poss[j];
      poss[j] = hold;
    }

    //check + recursion
    for(int i = 0; i < poss.length; i++) {
      int random = poss[i];
      if (random == 0){
        if(safe(maze, row - 1, column)) {
          generate(maze, 0, 0, row - 1, column);
        }
      }
      if(random == 1) {
        if(safe(maze, row, column + 1)) {
          generate(maze, 0, 0, row, column + 1);
        }
      }
      if(random == 3) {
        if(safe(maze, row, column - 1)) {
          generate(maze, 0, 0, row, column - 1);
        }
      }
      if(random == 2) {
        if(safe(maze, row + 1, column)) {
          generate(maze, 0, 0, row + 1, column);
        }
      }
    }
  }

  //safe to place?
  private static boolean safe (char[][] maze, int row, int col) {
    if (row <= 0 || row == maze.length - 1) {
      return false;
    }
    if (col <= 0 || col == maze[0].length - 1) {
      return false;
    }

    int surr = 0;

    if (maze[row + 1][col] == ' ') {
      surr++;
    }
    if (maze[row - 1][col] == ' ') {
      surr++;
    }
    if (maze[row][col + 1] == ' ') {
      surr++;
    }
    if (maze[row][col - 1] == ' ') {
      surr++;
    }

    if (surr >= 2) {
      return false;
    }
    else {
      return true;
    }
  }

  public static String toString(char[][] maze) {
    String toRet = "";
    for (int i = 0; i < maze.length - 1; i++) {
      for (int j = 0; j < maze[0].length; j++) {
        toRet += maze[i][j];
      }
      toRet += "\n";
    }
    for (int k = 0; k < maze[0].length; k++) {
      toRet += maze[maze.length - 1][k];
    }
    return toRet;
  }
}
