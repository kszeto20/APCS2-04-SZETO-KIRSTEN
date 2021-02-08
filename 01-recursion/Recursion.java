import java.lang.Math;
public class Recursion {
  public static void main (String[] args) {
    /*
    String test = "how much money you got?";
    System.out.println(reverse(test));
    System.out.println(reverse("a lot"));
    */
    ///*
    double myTest = (sqrt(Math.PI));
    double realAns = (Math.sqrt(Math.PI));

    System.out.println("my test: " + myTest);
    System.out.println("real ans: " + realAns);
    System.out.println(((myTest - realAns) < (realAns * 0.00001)));

    myTest = sqrt(12345.0);
    realAns = (Math.sqrt(12345.0));
    System.out.println(myTest);
    System.out.println(realAns);
    System.out.println(((myTest - realAns) < (realAns * 0.00001)));

    myTest = sqrt(0);
    realAns = (Math.sqrt(0));
    System.out.println(myTest);
    System.out.println(realAns);
    System.out.println(((myTest - realAns) < (realAns * 0.00001)));
    //*/
    /*
    System.out.println(countNoDoubleLetterWords(3));
    */
  }

  public static String reverse(String s){
    if (s.length() == 0) {
      return "";
    }
    String test;
    if (s.length() == 2) {
      return s.substring(1) + s.substring(0, 1);
    }
    else {
      return reverse(s.substring(1)) + s.charAt(0);
    }
  }

  public static double sqrt(double n) {
    return sqrt(n, 1.0);
  }

  public static double sqrt(double n, double guess) {
    if (n == 0) {
      return 0;
    }
    if (Math.abs((guess * guess - n)/ n) <= 0.00001) {
        return guess;
    } else {
      System.out.println(guess);
        return (sqrt(n, ((n / guess + guess) / 2)));
    }
  }

  public static long countNoDoubleLetterWords(int length) {
    return countNoDoubleLetterWords(length, "");
  }

  public static long countNoDoubleLetterWords(int length,String word){
    long combos = 0;
    if(length == 0) {
      //System.out.println(word);
      return 1;
    }
    else {
      for (int i = 0; i < 26; i++) {
        int lastChar = word.length() - 1;
        if (word.length() > 0 && (word.charAt(lastChar)) == (char)('a' + i)) {
        }
        else {
          combos += countNoDoubleLetterWords(length - 1, word + (char)('a' + i));
        }
      }
    }
    return combos;
  }
}
