public class DequeTest {
  public static void main(String[] args) {
    MyDeque test = new MyDeque();
    System.out.println(test.size());
    System.out.println(test.get(0));
    System.out.println(test.get(1));
    System.out.println(test.get(2));
    System.out.println(test.get(3));
    System.out.println(test.get(4));
    System.out.println(test.get(5));
    System.out.println(test.get(6));
    System.out.println(test.get(7));
    System.out.println("--------------------");
    System.out.println(test.getStart());
    System.out.println(test.getEnd());
    System.out.println("--------------------");
    System.out.println(test.toString());
  }
}
