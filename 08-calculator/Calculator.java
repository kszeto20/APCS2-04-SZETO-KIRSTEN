import java.util.*;
import java.lang.*;
public class Calculator {

  private static Random r = new Random();

  private static ArrayList<Character> ops = new ArrayList<Character>();

  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  */

  public static double eval(String s) throws IllegalArgumentException {
    char[] operators = {'+', '-', '*', '/', '%'};
    addOperators(operators);
    String instNoSpace = s.replace(" ", "");
    int numsC = 0;
    int opsC = 0;
    boolean opAdded = false;
    // to check for correct num of operators and operands
    String[] instArr= s.split(" ");

    for (int i = 0; i < instNoSpace.length(); i++) {
      if (ops.contains(instNoSpace.charAt(i))) {
        opsC++;
      }
      else {
        numsC++;
      }
    }





/*

      opAdded = false;
      System.out.println(instArr[i]);
      for (int j = 0; j < ops.length; j++) {
        if (instArr[i] == ops[j]) {
          opsC++;
          opAdded = true;
          System.out.println("opsAdded1: " + opAdded);
        }
        System.out.println("opsAdded2: " + opAdded);
      }
      System.out.println("opsAdded3: " + opAdded);
      if (opAdded == false) {
        numsC++;
      }
      System.out.println("NumsC: " + numsC + "\nOpsC: " + opsC);
    }
*/
    int check = numsC - opsC;

    if (check == 1) {
      return 0;
    }
    else if (check > 1) {
      throw new IllegalArgumentException ("Too many operands \n" + "Given: " + s + "\n all operators need two operands to work");
    }
    else if (check == 0) {
      throw new IllegalArgumentException ("Not enough operands \n" + "Given: " + s + "\n same number of operands and operators; one operand too few");
    }
    else if (check < 0) {
      throw new IllegalArgumentException ("Not enough operands \n" + "Given: " + s + "\n all operators need two operands to work");
    }

    Scanner instReader = new Scanner(s);
//    System.out.println(s);
    //ArrayDeque<Double> instructions = new ArrayDeque<Double>();
    int numLeft = 0;
/*

    if (instReader.next() == double) {
      instructions.addFirst(instReader.nextDouble());
      numLeft++;
    }
    else {

    }

    while (instReader.hasNextDouble()) {
    }
*/

    //System.out.println(instructions);


    return 0;
  }


  private static void addOperators(char[] o) {
    for (int i = 0; i < o.length; i++) {
      ops.add(o[i]);
    }
  }
/*
  public String toString(ArrayDeque<E> in) {
    int obLeft = in.size();
    String toRet = "{";
    for (int i = start; i < data.length; i++) {
      if (data[i] == null) {
        if (i == end) {
          toRet += "";
        }
      }
      else if (obLeft > 1) {
        toRet = toRet + data[i] + ", ";
        obLeft--;
      }
      else if (obLeft == 1) {
        toRet = toRet + data[i];
        obLeft--;
      }
    }
    if (obLeft > 0) {
      for (int i = 0; i <= end; i++) {
        if (data[i] == null) {
          if (i == end) {
            toRet += "";
          }
        }
        else if (obLeft > 1) {
          toRet = toRet + data[i] + ", ";
          obLeft--;
        }
        else if (obLeft == 1) {
          toRet = toRet + data[i];
          obLeft--;
        }
      }
    }
    toRet += "}";
    return toRet;
  }
  */
}
