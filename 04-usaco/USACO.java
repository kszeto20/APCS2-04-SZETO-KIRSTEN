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
//    System.out.println("DEBUG : ");
//    System.out.println(toString(farm) + "\n");
    for (int i = 0; i < numDir; i++) {
      String directions = l.nextLine();
      String[] indiDir = directions.split(" ");
      cowRow = Integer.parseInt(indiDir[0]) - 1;
      cowCol = Integer.parseInt(indiDir[1]) - 1;
      stompDown = Integer.parseInt(indiDir[2]);
//      System.out.println("DEBUG: before the stomp\n" + toString(farm));
      stomp(farm, cowRow, cowCol, stompDown);
//      System.out.println("DEBUG: after the stomp\n" + toString(farm));
//      System.out.println("------------");
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int oldVal = farm[i][j];
        if (oldVal > elv) {
          farm[i][j] = 0;
        }
        else {
          farm[i][j] = elv - oldVal;
        }
      }
    }
    return 1;
  }

  private static void stomp(int[][] farm, int row, int col, int toStomp) {
//    System.out.println(row + " | " + col);
    int largest = 0;
    for (int i = row; i < row + 3; i++) {
      for (int j = col; j < col + 3; j++) {
//        System.out.println("DEBUG:" + "row | " + i + " col | " + j);
        if (farm[i][j] > largest) {
          largest = farm[i][j];
//          System.out.println("DEBUG: " + largest);
        }
      }
    }
//    System.out.println("DEBUG: " + largest);
    int targetLevel = largest - toStomp;
    for (int i = row; i < row + 3; i++) {
      for (int j = col; j < col + 3; j++) {
        if (farm[i][j] > targetLevel) {
          farm[i][j] = targetLevel;
        }
      }
    }
  }

  public static String toString(int[][] farm){
    String toRet = "";
  //    String toRet = "====\n";
    for (int i = 0; i < farm.length - 1; i++) {
      for (int j = 0; j < farm[0].length; j++) {
        toRet += farm[i][j];
        toRet += " ";
      }
      toRet += "\n";
    }
    for (int k = 0; k < farm[0].length; k++) {
      toRet += farm[farm.length - 1][k];
      toRet += " ";
    }
    return toRet;
  }
}
