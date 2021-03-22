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
      System.out.println(Arrays.toString(data));
      System.out.println("This is start: " + start);
      System.out.println("This is end: " + end);
      resize();
      data[data.length - 1] = element;
      start = data.length - 1;
    }
    else if (start - 1 < 0) {
      if (end == data.length - 1) {
        System.out.println("initialized");
        System.out.println(Arrays.toString(data));
        System.out.println("This is start: " + start);
        System.out.println("This is end: " + end);
        resize();
        data[data.length - 1] = element;
        start = data.length - 1;
      }
      else {
        System.out.println("initialized2");
        data[data.length - 1] = element;
        start = data.length - 1;
      }
    }
    else {
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
      System.out.println(Arrays.toString(data));
      System.out.println("This is start: " + start);
      System.out.println("This is end: " + end);
      resize();
      data[end + 1] = element;
      end++;
    }
    else if (end + 1 > data.length - 1) {
      if (start == 0) {
        System.out.println(Arrays.toString(data));
        System.out.println("This is start: " + start);
        System.out.println("This is end: " + end);
        resize();
        data[end + 1] = element;
        end++;
      }
      else {
        data[0] = element;
        end = 0;
      }
    }
    else {
      data[end + 1] = element;
      end++;
    }
    int uhh = 0;
    for (int i = 0; i < data.length; i++) {
      if (data[i] != null) {
        uhh++;
      }
    }
    if (uhh <= 1) {
      start = end;
    }
  }

  public String toString() {
    System.out.println(Arrays.toString(data) + "\n");
    int obLeft = 0;
    for (int i = 0; i < data.length; i++) {
      if (data[i] != null) {
        obLeft++;
      }
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

  private void resize () {
    System.out.println("resizing");
    int nSize = 10;
    if (data.length != 0) {
      nSize = size * 2;
    }
    @SuppressWarnings("unchecked")
    E[] toChange = (E[]) new Object[nSize];
    int obLeft = 0;
    for (int i = 0; i < data.length; i++) {
      if (data[i] != null) {
        obLeft++;
      }
    }
    System.out.println(obLeft);
    int newS = 0;
    for (int i = start; i < data.length; i++) {
      if (obLeft < 0) {}
      if (obLeft > 0) {
        toChange[newS] = data[i];
        newS++;
        obLeft--;
      }
    }
    if (obLeft > 0) {
      for (int i = 0; i <= end; i++) {
        toChange[newS] = data[i];
        newS++;
        obLeft--;
      }
    }
    System.out.println(Arrays.toString(toChange));
    System.out.println("DEBUG: " + obLeft);
    start = 0;
    end = data.length - 1 + start;
    data = toChange;
    size = toChange.length;
    System.out.println("This is start: " + start);
    System.out.println("This is end: " + end);
    System.out.println("This is end val: " + data[end]);
    System.out.println("This is size: " + size);
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
