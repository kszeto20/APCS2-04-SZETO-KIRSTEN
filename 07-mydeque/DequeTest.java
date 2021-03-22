public class DequeTest {
  public static void main(String[] args) {
    @SuppressWarnings("unchecked")
    MyDeque<Integer> test = new MyDeque<Integer>();

    System.out.println("--------------------");
    System.out.println(test.toString());

    System.out.println("--------------------");
    for (int i = 0; i < 8; i++) {
      test.addFirst(i);
      System.out.println("This is start: " + test.getStartVal());
      System.out.println("This was added: " + i);
    }
    System.out.println("out of loop");
    test.addLast(50000);
    System.out.println(test.toString() + "\n");
    System.out.println("EndVal: " + test.getEndVal());
    System.out.println(test.get(test.getEndVal()));
  }
}
