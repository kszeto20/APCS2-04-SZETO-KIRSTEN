public class Recursion {
  public static void main (String[] args) {
    char[] test = {'a', 'j', 'k', 'l'};
    printNoDoubleLetterWords(3, test);
  }

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
}
