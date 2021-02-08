import java.lang.Math;
public class Recursion {
  public static void main (String[] args) {
    /*
    String test = "how much money you got?";
    System.out.println(reverse(test));
    System.out.println(reverse("a lot"));
    double myTest = (sqrt(Math.PI));
    double realAns = (Math.sqrt(Math.PI));
    myTest = sqrt(12345.0);
    realAns = (Math.sqrt(12345.0));
    System.out.println(myTest);
    System.out.println(realAns);
    System.out.println(((myTest - realAns) < (realAns * 0.00001)));
    */
    System.out.println(countNoDoubleLetterWords(2));
  }

  public static String reverse(String s){
    String test;
    if (s.length() == 2) {
      return s.substring(1) + s.substring(0, 1);
    }
    else {
      return reverse(s.substring(1)) + s.charAt(0);
    }
  }

  public static double sqrt(double n) {
    return sqrt(n, 1.0, 0.00001);
  }

  public static double sqrt(double n, double guess, double tolerance) {
    if (Math.abs(guess * guess - n) <= tolerance) {
        return guess;
    } else {
      System.out.println(guess);
        return (sqrt(n, ((n / guess + guess) / 2), tolerance));
    }
  }

  public static long countNoDoubleLetterWords(int length) {
    return countNoDoubleLetterWords(length, "");
  }
  public static long countNoDoubleLetterWords(int length,String word){
    long combos = 1;
    if(length == 0) {
      return combos;
    }
    else{
      for (int i = 0; i < 26; i++) {
        int lastChar = word.length() - 1;
        if (word.length() > 0 && word.charAt(lastChar) == (char)('a')) {}
        else {
          //combos++;
          combos += countNoDoubleLetterWords(length - 1, word + (char)('a' + i));
        }
      }
    }
    return combos;
  }
}
  /*
  public static void printAllWords(int length) {
    printAllWords(length, "");
  }

  public static void printAllWords(int length, String word) {
    if(length == 0) {
      System.out.println(word);
    }
    else{
      for (int i = 0; i < 26; i++) {
        printAllWords(length - 1, word + (char)('a' + i));
      }
    }
  }

  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"", letters);
  }

  public static void printNoDoubleLetterWords(int length, String word, char[]letters){
    if(length == 0) {
      System.out.println(word);
    }
    else {
      for (int i = 0; i < letters.length; i++) {
        int lastChar = word.length() - 1;
        if (word.length() > 0 && word.charAt(lastChar) == letters[i]) {
        }
        else {
          printNoDoubleLetterWords(length - 1 , word + letters[i], letters);
        }
      }
    }
  }
  */
