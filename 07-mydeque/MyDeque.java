public class MyDeque<E> {
  private E[] data;
  private int size;
  private int start;
  private int end;

  public MyDeque() {
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[10];
    data = d;
    size = 10;
    start = 0;
    end = 0;
  }

  public MyDeque (int initialCapacity) {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = initialCapacity - 1;
    start = 0;
    end = 0;
  }

  public int size() {
    return size;
  }
  public E get( int ind) {
    return data[ind];
  }
  public int getStart() {
    return start;
  }
  public int getEnd() {
    return end;
  }

  public String toString() {
    int obLeft = size;
    String toRet = "[";
    for (int i = start; i < data.length; i++) {
      if (data[i] == null) {
        if (i == end) {
          toRet += " ";
        }
        else {
          toRet += " ,";
        }
      }
      if (obLeft > 1 && data[i] != null) {
        toRet = toRet + data[i] + ", ";
        obLeft--;
      }
      else if (obLeft == 1 && data[i] != null) {
        toRet = toRet + data[i];
        obLeft--;
      }
    }
    if (obLeft > 0) {
      for (int i = 0; i <= end; i++) {
        if (obLeft > 1 && data[i] != null) {
          toRet = toRet + data[i] + ", ";
          obLeft--;
        }
        else if (obLeft == 1 && data[i] != null) {
          toRet = toRet + data[i];
          obLeft--;
        }
      }
    }
    toRet += "]";
    return toRet;
  }

  /*

  public void addFirst (E element) {
    if (start - 1 < 0) {
      data[data.length - 1] = element;
      start = data.length - 1;
    }
    else {
      data[start - 1] = element;
      start = start--;
    }
  }

  public void addLast (E element) {
    if (end + 1 > data.length - 1) {
      data[0] = element;
      end = 0;
    }
    else {
      data[end + 1] = element;
      end++;
    }
  }

  public E removeFirst() {
    E toRet;
    toRet += data[start];
    start = start++;
    return toRet;
  }

  public E removeLast() {
    E toRet;
    toRet += data[end];
    end--;
  }
*/
}
