import java.util.*;
import java.lang.*;
public class Calculator {

  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  */

  public static double eval(String s) throws IllegalArgumentException {
    String[] instArr= s.split(" ");

    // deque for numbers; using for evaluation portion
    ArrayDeque<Double> instructions = new ArrayDeque<Double>();

    //////// start of checking if the instuction set is valid
    int numsC = 0;
    int opsC = 0;
    int check = 0;
    // to check for correct num of operators and operands
//    System.out.println("LENGTH: " + instArr.length);
    for (int i = 0; i < instArr.length; i++) {
      String comp = instArr[i];
      if (comp.equals("+") || comp.equals("-") || comp.equals("*") || comp.equals("/") || comp.equals("%")) {
        opsC++;
      }
      else {
        numsC++;
      }
//      System.out.println("DEBUG: \n" + "NumsC: " + numsC + "\nOpsC: " + opsC);
    }
      check = numsC - opsC;
//      System.out.println("CHECK: " + check);
      if (check == 1) {
      }
      else if (check > 1) {
        throw new IllegalArgumentException ("Too many operands \n" + "Given: " + s + "\n all operators need two operands to work");
      }
      else if (check == 0) {
        throw new IllegalArgumentException ("One operand too few \n" + "Given: " + s + "\n same number of operands and operators");
      }
      else if (check < 0) {
        throw new IllegalArgumentException ("Not enough operands \n" + "Given: " + s + "\n all operators need two operands to work");
      }

    ////////// end of check portion

    //// checking portion

    for (int i = 0; i < instArr.length; i++) {
      double toRet = 0.0;
      double sec = 0.0;
//      System.out.println("WHAT ARE WE WORKING WITH: " + instArr[i]);
      if (instArr[i].equals("+")) {
        toRet = instructions.removeLast() + instructions.removeLast();
//         System.out.println("TORET: " + toRet);
        instructions.offer(toRet);
      }
      else if (instArr[i].equals("-")) {
        sec = instructions.removeLast();
        toRet = instructions.removeLast() - sec;
//         System.out.println("TORET: " + toRet);
        instructions.offer(toRet);
      }
      else if (instArr[i].equals("*")) {
        toRet = instructions.removeLast() * instructions.removeLast();
//         System.out.println("TORET: " + toRet);
        instructions.offer(toRet);
      }
      else if (instArr[i].equals("/")) {
        sec = instructions.removeLast();
        toRet = instructions.removeLast() / sec;
//         System.out.println("TORET: " + toRet);
        instructions.offer(toRet);
      }
      else if (instArr[i].equals("%")){
        sec = instructions.removeLast();
        toRet = instructions.removeLast() % sec;
//         System.out.println("hello");
//         System.out.println("TORET: " + toRet);
        instructions.offer(toRet);
      }
      else {
//       System.out.println("adding................. "  + Double.parseDouble(instArr[i]));
        instructions.offer(Double.parseDouble(instArr[i]));
      }
//     System.out.println(instructions);
    }
  //System.out.println(instructions);
    return instructions.remove();
  }

  /*
  private static void addOperators(String[] o) {
    for (int i = 0; i < o.length; i++) {
      ops.add(o[i]);
    }
  }
  */
}
