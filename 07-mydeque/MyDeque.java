public class MyDeque<E> {
  private E[] data;
  private int size;
  private int start;
  private int end;

  public MyDeque() {
    data = (E[])new Object[10];
    size = 10;
    start = 0;
    end = 9;
  }

  public MyDeque (int initialCapacity) {
    data = (E[])new Object[initialCapacity];
    size = initialCapacity - 1;
    start = 0;
    end = initialCapacity - 1;
  }


}
