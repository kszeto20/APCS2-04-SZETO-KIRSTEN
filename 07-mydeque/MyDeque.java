import java.util.*;
import java.lang.*;
public class MyDeque<E> {
  private E[] data;
  private int size;
  //inclusive
  private int start;
  //inclusive
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
    size = initialCapacity;
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



  public void addFirst (E element) {
    if (start - 1 == end) {
      System.out.println("in01");
      resize();
      data[data.length - 1] = element;
      start = data.length - 1;
    }
    else if (start - 1 < 0) {
      if (end == data.length - 1) {
        System.out.println("in02");
        resize();
        data[data.length - 1] = element;
        start = data.length - 1;
      }
      else {
        System.out.println("in03");
        data[data.length - 1] = element;
        start = data.length - 1;
      }
    }
    else {
      System.out.println("in04");
      data[start - 1] = element;
      start--;
    }
    int uhh = 0;
    for (int i = 0; i < data.length; i++) {
      if (data[i] != null) {
        uhh++;
      }
    }
    if (uhh <= 1) {
      end = start;
    }
  }

  public void addLast (E element) {
    if (end + 1 == start) {
      System.out.println("in01");
      resize();
      data[end + 1] = element;
      end++;
    }
    else if (end + 1 > data.length - 1) {
      if (start == 0) {
        System.out.println("in02");
        resize();
        data[end + 1] = element;
        end++;
      }
      else {
        System.out.println("in03");
        data[0] = element;
        end = 0;
      }
    }
    else {
      System.out.println("in04");
      data[end + 1] = element;
      end++;
    }
  }

  private void resize () {
    System.out.println("Resizing");
    int length = data.length;
    @SuppressWarnings("unchecked")
    E[] toChange = (E[]) new Object[size * 2];
    int newS = 0;
    for (int i = start; i < size; i++) {
      toChange[newS] = data[i];
      newS++;
    }
    end = length - 1;
    start = 0;
    data = toChange;
    size = toChange.length;
  }

  public String toString() {
    int obLeft = 0;
    if (start == 0) {
      obLeft = end + 1;
    }
    else {
      obLeft = (size - start) + (Math.abs(0 - end));
    }
    String toRet = "{";
    for (int i = start; i < data.length; i++) {
      if (data[i] == null) {
        if (i == end) {
          toRet += "";
        }
      }
      else if (obLeft > 1) {
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
        if (data[i] == null) {
          if (i == end) {
            toRet += "";
          }
        }
        else if (obLeft > 1) {
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
