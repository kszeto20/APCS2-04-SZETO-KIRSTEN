import java.util.*;
import java.io.*;
public class Maze{

  private char[][]maze;
  private boolean animate; //false by default

  /*
  Constructor loads a maze text file, and sets animate to false by default.
  When the file is not found then:
  throw a FileNotFoundException

  You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal (exactly 1 per file)
  'S' - the location of the start(exactly 1 per file)

  You may also assume the maze has a border of '#' around the edges.
  So you don't have to check for out of bounds!
  */

  public Maze(String filename) throws FileNotFoundException{

    File n = new File(filename);
    Scanner l = new Scanner(n);
    int rowCount = 0;
    String line = "";

    while (l.hasNextLine()) {
      line = l.nextLine();
      rowCount++;
    }
    maze = new char[rowCount][];

    Scanner sec = new Scanner(n);

    for (int i = 0; i < maze.length; i++) {
      String toAdd = sec.nextLine();
      maze[i] = toAdd.toCharArray();
    }

    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[0].length; j++) {
        if (!(maze[i][j] == 'S' || maze[i][j] == 'E' || maze[i][j] == '#')) {
          maze[i][j] = 0;
        }
      }
    }

  }


  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b){
    animate = b;
  }

  public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
  }

  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }

  /*Return the string that represents the maze.
  It should look like the text file with some characters replaced.
  */

  public String toString(){
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

  /*Wrapper Solve Function returns the helper function
  Note the helper function has the same name, but different parameters.
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */

  public int solve(){
    //only clear the terminal if you are running animation
    if(animate){
      clearTerminal();
    }
    //return solve(0, 0);
    //start solving at the location of the s.
    //return solve(???,???);
    if (safe(5,1)) {
      return 123;
    }
    return 456;
  }

  /*
  Recursive Solve function:

  A solved maze has a path marked with '@' from S to E.

  Returns the number of @ symbols from S to E when the maze is solved,
  Returns -1 when the maze has no solution.

  Postcondition:
  The 'S' is replaced with '@'
  The 'E' remain the same
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
/*
  private int solve(int row, int col){ //you can add more parameters since this is private
  //automatic animation! You are welcome.
  if(animate){
    gotoTop();
    System.out.println(this);
    wait(50);
  }

  int stepCount;

  int sRow = row;
  int sCol = col;

  for (int i = 0; i < maze.length; i++) {
    for (int j = 0; j < maze[0].length; j++) {
      if (maze[i][j] == 'S') {
        sRow = i;
        sCol = j;
      }
    }
  }

  int cRow = sRow;
  int cCol = sCol;

  int tRow = cRow;
  int tCol = cCol;

  if (maze[cRow][cCol] == 'E') {
    return stepCount;
  }
  else {
    if (maze[cRow + 1][cCol] == '0') {

    }
  }

  //char startPoint = maze[][]

    //COMPLETE SOLVE
    return -1; //so it compiles
    }
  }
  */

  private boolean safe(int row, int col) {

    if (maze[row][col] != 'S' && maze[row][col] != 'E') {
      if (maze[row][col] != 0) {
        return false;
      }
    }
    return true;
  }
}

// note fix is safe "if statement"
  /*
  Parts to Code:
   - constructor       DONE
   - toString          DONE
   - solve (wrapper)   DONE
   - solve (helper)



  */
