public class DequeTest {
  public static void main(String[] args) {
    @SuppressWarnings("unchecked")
    MyDeque<Integer> test = new MyDeque<Integer>();

    //System.out.println("--------------------");
    //System.out.println(test.toString());

    //System.out.println("--------------------");
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 1000; i++) {
      if (i % 2 == 0) {
        test.addLast(i);
      }
      else {
        test.addFirst(i);
      }
      //System.out.println(test.toString() + "\n");
      //System.out.println(test.toString());
      //System.out.println(test.toString() + "\n");
      //System.out.println("This is end: " + test.getEndVal());
      //System.out.println("This is start: " + test.getStartVal());
      //System.out.println("This was added: " + i);
    }
    long endTime = System.currentTimeMillis();
    long timeElapsed = endTime - startTime;
/*
    System.out.println("DEBUG: ORIG --> " + test.toString());
    for (int i = 0; i < 100; i++) {
      test.addFirst(i);
      System.out.println(test.toString() + "\n");
      //System.out.println(test.toString());
      //System.out.println(test.toString() + "\n");
      //System.out.println("This is end: " + test.getEndVal());
      //System.out.println("This is start: " + test.getStartVal());
      //System.out.println("This was added: " + i);
    }
    */
    //System.out.println(test.toString() + "\n");
    //System.out.println("out of loop");
      //System.out.println("EndVal: " + test.getEndVal());
    //test.addLast(50000);
    System.out.println(test.toString());
    System.out.println("This is end: " + test.getEndVal());
    //System.out.println("This is start: " + test.getStartVal());
    System.out.println(test.size());
    System.out.println(test.get(test.getEndVal()));
    System.out.println("Execution time in milliseconds: " + timeElapsed);
  }
}
