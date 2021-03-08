import java.util.*;
import java.io.*;
public class USACO {

  public static int bronze(String filename) throws FileNotFoundException {
    File n = new File(filename);
    Scanner l = new Scanner(n);

    //board vars
    int row = 0;
    int col = 0;
    int elv = 0;
    int numDir = 0;

    //cow pack vars
    int cowRow = 0;
    int cowCol = 0;
    int stompDown = 0;
    String line1 = l.nextLine();

    // assigning board vars
    String[] parts = line1.split(" ");
    row = Integer.parseInt(parts[0]);
    col = Integer.parseInt(parts[1]);
    elv = Integer.parseInt(parts[2]);
    numDir = Integer.parseInt(parts[3]);

    //declaring board
    int[][] farm = new int[row][col];
    // assigning board contents
    for (int i = 0; i < row; i++) {
      String lineI = l.nextLine();
      String[] elvFarm = lineI.split(" ");
      for (int j = 0; j < col; j++) {
        farm[i][j] = Integer.parseInt(elvFarm[j]);
      }
    }

    // assigning direction vars per pass
    for (int i = 0; i < numDir; i++) {
      String directions = l.nextLine();
      String[] indiDir = directions.split(" ");
      cowRow = Integer.parseInt(indiDir[0]) - 1;
      cowCol = Integer.parseInt(indiDir[1]) - 1;
      stompDown = Integer.parseInt(indiDir[2]);
      // stomping with new directions
      stomp(farm, cowRow, cowCol, stompDown);
    }

    // finding difference between dirt level and desired lake level
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

    // calculating space taken up by the lake
    int aggDepth = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        aggDepth += farm[i][j];
      }
    }
    // 72 is for 6ft by 6ft length and width
    return (aggDepth * 72 * 72);
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

  public static long silver(String filename) throws FileNotFoundException{
    File n = new File(filename);
    Scanner l = new Scanner(n);

    int row = 0;
    int col = 0;
    int time = 0;

    int startR = 0;
    int startC = 0;
    int endR = 0;
    int endC = 0;

    String boardDim = l.nextLine();
    String[] dim = boardDim.split(" ");
    row = Integer.parseInt(dim[0]);
    col = Integer.parseInt(dim[1]);
    time = Integer.parseInt(dim[2]);

    int[][] farm = new int[row][col];
    // assigning board contents
    for (int i = 0; i < row; i++) {
      String lineI = l.nextLine();
      for (int j = 0; j < col; j++) {
        if (lineI.charAt(j) == '.') {
          farm[i][j] = 0;
        }
        else if (lineI.charAt(j) == '*') {
          farm[i][j] = -1;
        }
      }
    }

    // assigning start coord and end coord
    String cowCor = l.nextLine();
    String[] cors = cowCor.split(" ");
    startR = Integer.parseInt(cors[0]) - 1;
    startC = Integer.parseInt(cors[1]) - 1;
    endR = Integer.parseInt(cors[2]) - 1;
    endC = Integer.parseInt(cors[3]) - 1;
//    System.out.println(toString(farm));

    int[][] baseClone = cloneMe(farm);
//    System.out.println("DEBUG: THIS IS THE CLONE\n" + toString(baseClone));
    baseClone[startR][startC] = 1;
//    System.out.println("initial\n" + toString(baseClone));
    for (int i = 0; i < time; i++) {
      baseClone = automate(baseClone);
//      System.out.println(i + " run\n" + toString(baseClone) + "\n");
    }

    return baseClone[endR][endC];
  }

  private static int[][] automate (int[][] curMap) {
    int[][] nextMap = cloneMe(curMap);
    for (int i = 0; i < curMap.length; i++) {
      for (int j = 0; j < curMap[0].length; j++) {
//        System.out.println("DEBUG: " + i + " " + j + " " + curMap[i][j]);
        if (curMap[i][j] != -1) {
//          System.out.println("DEBUG2: " + i + " " + j + " " + curMap[i][j]);
          nextMap[i][j] = applyRules(curMap, i, j);
        }
      }
    }
//    System.out.println("DEBUG3: \n" + toString(nextMap));
    return nextMap;
  }

  private static ArrayList<int[]> whichDir (int[][] curMap, int r, int c) {
    ArrayList<int[]> toRet = new ArrayList<>();
    int rowCount = curMap.length;
    int rowLength = curMap[0].length;

    if (r - 1 >= 0) {
      // not at top, must check top.
      int toAdd[] = new int[2];
      toAdd[0] = r - 1;
      toAdd[1] = c;
      toRet.add(toAdd);
    }
    if (r + 1 <= rowCount - 1) {
      int toAdd[] = new int[2];
      toAdd[0] = r + 1;
      toAdd[1] = c;
      toRet.add(toAdd);
    }
    if (c - 1 >= 0) {
      int toAdd[] = new int[2];
      toAdd[0] = r;
      toAdd[1] = c - 1;
      toRet.add(toAdd);
    }
    if (c + 1 <= rowLength - 1) {
      int toAdd[] = new int[2];
      toAdd[0] = r;
      toAdd[1] = c + 1;
      toRet.add(toAdd);
    }
    return toRet;
  }

  private static int applyRules(int[][] curMap, int curRow, int curCol) {
    int toRet = 0;
    // to check what dir I need to add
    ArrayList<int[]> directions = whichDir(curMap, curRow, curCol);
    for (int i = 0; i < directions.size(); i++) {
      // get the array of size 2
      int[] cors = directions.get(i);
      int row = cors[0];
      int col = cors[1];
      if (curMap[row][col] == -1) {
        toRet += 0;
      }
      else {
        toRet += curMap[row][col];
      }
    }
    return toRet;
  }

  private static int[][] cloneMe(int[][] template){
    int[][] toRet = new int[template.length][template[0].length];
    for (int i = 0; i < template.length; i++) {
      for (int j = 0; j < template[0].length; j++) {
        toRet[i][j] = template[i][j];
      }
    }
    return toRet;
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
