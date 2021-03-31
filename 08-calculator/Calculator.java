import java.util.*;
import java.lang.*;
public class Calculator {

  private static Random r = new Random();

  private static ArrayList<String> ops = new ArrayList<String>();

  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  */

  public static double eval(String s) throws IllegalArgumentException {
    String[] operators = {"+", "-", "*", "/", "%"};
    //char[] operators = {'+', '-', '*', '/', '%'};
    addOperators(operators);
    System.out.println(ops.toString());
    boolean opAdded = false;
    int numsC = 0;
    int opsC = 0;
    // to check for correct num of operators and operands
    String[] instArr= s.split(" ");
    for (int i = 0; i < instArr.length; i++) {
      if (ops.contains(instArr[i])) {
        opsC++;
      }
      else {
        numsC++;
      }
      System.out.println("DEBUG: \n" + "NumsC: " + numsC + "\nOpsC: " + opsC);
    }
    int check = numsC - opsC;
    System.out.println("CHECK: " + check);

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

    //System.out.println(instructions);


    return 0;
  }


  private static void addOperators(String[] o) {
    for (int i = 0; i < o.length; i++) {
      ops.add(o[i]);
    }
  }
}
