import java.util.*;
import java.lang.*;
public class MyDeque<E> {
  private E[] data;
  private int size;
  //inclusive
  private int start;
  //exclusive
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
  public int getStartVal() {
    return start;
  }
  public int getEndVal() {
    return end;
  }

  public String toString() {
    int obLeft = (size - start) + (Math.abs(0 - end));
    String toRet = "{";
    for (int i = start; i < data.length; i++) {
      if (obLeft > 1) {
        toRet = toRet + data[i] + ", ";
        obLeft--;
      }
      else if (obLeft == 1) {
        toRet = toRet + data[i];
        obLeft--;
      }
    }
    if (obLeft > 0) {
      for (int i = 0; i <= end; i++) {
        if (obLeft > 1) {
          toRet = toRet + data[i] + ", ";
          obLeft--;
        }
        else if (obLeft == 1) {
          toRet = toRet + data[i];
          obLeft--;
        }
      }
    }
    toRet += "}";
    return toRet;
  }



  public void addFirst (E element) {
    if (start - 1 == end) {
      resize();
    }
    if (start - 1 < 0) {
      data[data.length - 1] = element;
      start = data.length - 1;
    }
    else {
      data[start - 1] = element;
      start--;
    }
  }

  public void addLast (E element) {
    if (end + 1 == start) {
      resize();
      data[end + 1] = element;
      end++;
    }
    else if (end + 1 > data.length - 1) {
      if (start == 0) {
        resize();
        data[end + 1] = element;
        end++;
      }
      data[0] = element;
      end = 0;
    }
    else {
      data[end] = element;
      end++;
    }
  }

  private void resize () {
    System.out.println("Resizing");
    @SuppressWarnings("unchecked")
    E[] toChange = (E[]) new Object[size * 2];
    int newS = 0;
    for (int i = start; i < size; i++) {
      toChange[newS] = data[i];
      newS++;
    }
    end = data.length - 1;
    start = 0;
    data = toChange;
    size = toChange.length;
  }

/*

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
