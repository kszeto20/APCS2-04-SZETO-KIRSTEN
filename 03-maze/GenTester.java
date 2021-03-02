public class GenTester {
  public static void main(String[] args) {
    char[][] test = new char[15][35];
    for (int i = 0; i < test.length; i++) {
      for (int j = 0; j < test[0].length; j++) {
        test[i][j] = '#';
      }
    }
    MazeGenerator.generate(test, 0, 0, 3, 3);
    System.out.println(MazeGenerator.toString(test));
  }
}
