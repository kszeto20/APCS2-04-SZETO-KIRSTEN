import java.util.*;
import java.util.Arrays;
public class QueenTester {
  public static void main (String[] args) {
    QueenBoard test = new QueenBoard(6);
    System.out.println(test.toString());
    //System.out.println(avail(test.getBoard(), 0, 0));
    System.out.println();
    System.out.println(test.addQueen(3, 1));
    System.out.println(test.toString());
    System.out.println("\n");
    test.removeQueen(1, 0);
    System.out.println(test.toString());
  }
}
