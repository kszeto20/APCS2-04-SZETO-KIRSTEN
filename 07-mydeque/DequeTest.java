import java.util.*;
import java.lang.*;
public class DequeTest {
  public static void main(String[] args) {
    /*
    @SuppressWarnings("unchecked")
    MyDeque<Integer> test = new MyDeque<Integer>(100);
    //System.out.println(test.size());
    for (int i = 0; i < 100000; i++) {
      if (i % 2 == 0) {
        test.addFirst(i);
      }
      else {
        test.addLast(i);
      }
    }
    //System.out.println(test.toString());
    //System.out.println("SIZE: " + test.size());
    //System.out.println(test.getFirst());
    //System.out.println(test.getLast());
    //System.out.println("SIZE: " + test.size());
    //System.out.println(test.getFirst());
    //System.out.println(test.getLast());
    //System.out.println(test.toString());
    test.removeFirst();
    //System.out.println("SIZE: " + test.size());
    test.removeLast();
    //System.out.println("SIZE: " + test.size());
    //System.out.println(test.getFirst());
    //System.out.println(test.getLast());
    System.out.println(test.toString());
    */
    System.out.println("\n\n\n\n\n\n\n" + test6(500000));
  }

  public static boolean equals(MyDeque<Integer>a, ArrayDeque<Integer>b){
    if(a==null && b==null)
      return true;
    if(a==null || b==null)
        return false;
    if(a.size()!=b.size())
      return false;
    if(a.size()==0 && b.size()==0)
      return true;

    try{
      while(b.size()>0){
        if(!a.removeFirst().equals(b.removeFirst())){
          return false;
        }
      }
    }catch(NoSuchElementException e){
      return false;
    }
    return b.size()==0;
  }

  public static int test6(int max){
    MyDeque<Integer> a = new MyDeque<Integer>();
    ArrayDeque<Integer>b = new ArrayDeque<Integer>();

    for(int i = 0; i < max; i++){
      int op = (int)(Math.random()*4);
      if(op == 0){
        a.addLast(i);
        b.addLast(i);
        //System.out.println(a.toString());
        //System.out.println(b.toString());
      }
      if(op == 1){
        a.addFirst(i);
        b.addFirst(i);
      }
      if(op == 2){
        if(b.size()>0){
          if(! a.getLast().equals(b.getLast())){
            System.out.println("Fail test6a "+a.getLast()+" vs "+b.getLast());
            return 0;
          }
          a.removeLast();
          b.removeLast();
        }
      }
      if(op == 3){
        if(b.size()>0){
          if(! a.getFirst().equals(b.getFirst())){
            System.out.println("Fail test6a "+a.getFirst()+" vs "+b.getFirst());
            return 0;
          }
          a.removeFirst();
          b.removeFirst();
        }
      }
    }
    if( equals(a,b) ){
      return 1;
    }
    System.out.println("Fail test6 end");
    return 0;
  }

}
