public class DequeTest {
  public static void main(String[] args) {
    @SuppressWarnings("unchecked")
    MyDeque<Integer> test = new MyDeque<Integer>(100);
    System.out.println(test.size());
    for (int i = 0; i < 100; i++) {
      test.addLast(i);
    }
    System.out.println(test.toString());
    System.out.println("SIZE: " + test.size());
    System.out.println(test.getFirst());
    System.out.println(test.getLast());
    System.out.println("SIZE: " + test.size());
    test.removeFirst();
    System.out.println("SIZE: " + test.size());
    test.removeLast();
    System.out.println("SIZE: " + test.size());
    System.out.println(test.getFirst());
    System.out.println(test.getLast());
    System.out.println(test.toString());
  }
}
