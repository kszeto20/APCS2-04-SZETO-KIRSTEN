public class Recursion {
  public static void main (String[] args) {
    String test = "how much money you got?";
    System.out.println(reverse(test));
    System.out.println(reverse("a lot"));
    //countNoDoubleLetterWords(2);
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

}


  /*

  public static void countNoDoubleLetterWords (int length) {
    System.out.println(countNoDoubleLetterWords(length, ""));
  }

  public static long countNoDoubleLetterWords(int length,String word) {
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


  /*
    long combos = 0;
    if(length == 0) {
      return combos;
    }
    else if (length == 1) {
      combos += (long)('z' - 'a' + 1);
      return combos;
    }
    else {
      for (int i = 'a'; i <= 'z'; i++) {
        int lastChar = word.length() - 1;
        if (word.length() > 0 && word.charAt(lastChar) == (char)(i)) {
        }
        else {
          countNoDoubleLetterWords(length - 1);
        }
      }
    }
    return combos;
  }
  */
    /*
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
    */
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
