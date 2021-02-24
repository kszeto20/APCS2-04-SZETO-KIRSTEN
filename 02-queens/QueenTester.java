import java.util.*;
import java.util.Arrays;
public class QueenTester {
  public static void main (String[] args) {
    QueenBoard test = new QueenBoard(6);
    System.out.println(test.toString());
    System.out.println();
    System.out.println(test.countSolutions());
    /*
    System.out.println("-----------------");
    System.out.println(test.addQueen(4, 2));
    //System.out.println(test.toString());
    System.out.println("\n");
    //test.removeQueen(2, 4);
    System.out.println(test.toString());
    System.out.println(test.addQueen(4, 2));
    System.out.println(test.toString());
    */
  }
}
