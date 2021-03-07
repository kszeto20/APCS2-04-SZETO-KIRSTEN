import java.util.*;
import java.io.*;
public class USACO {
  public static void main(String[] args) {
    System.out.println("hello");
  }


  public static int bronze(String filename) throws FileNotFoundException {
    File n = new File(filename);
    Scanner l = new Scanner(n);
    String line1 = "";
    int row = 0;
    int col = 0;
    int elv = 0;
    int numDir = 0;

    int cowRow = 0;
    int cowCol = 0;
    int stompDown = 0;
    line1 = l.nextLine();

    String[] parts = line1.split(" ");

    row = Integer.parseInt(parts[0]);
    col = Integer.parseInt(parts[1]);
    elv = Integer.parseInt(parts[2]);
    numDir = Integer.parseInt(parts[3]);

    int[][] farm = new int[row][col];

    for (int i = 0; i < row; i++) {
      String lineI = l.nextLine();
      String[] elvFarm = lineI.split(" ");
      for (int j = 0; j < col; j++) {
        farm[i][j] = Integer.parseInt(elvFarm[j]);
      }
    }
    // still need to implement stomp + direction reading
    /*
    for (int i = 0; i < numDir; i++) {
      String directions = l.nextLine();
      String[] indiDir = directions.split(" ");
      cowRow = Integer.parseInt(indiDir[0]);
      cowCol = Integer.parseInt(indiDir[1]);
      stompDown = Integer.parseInt(indiDir[2]);

        }
        */
        return 1;
      }
    }


//  private static void stomp
/*
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
      maze[i][j] = ' ';
    }
  }
}

for (int i = 0; i < maze.length; i++) {
  for (int j = 0; j < maze[0].length; j++) {
    if (maze[i][j] == 'S') {
      startR = i;
      startC = j;
    }
  }
}
*/
