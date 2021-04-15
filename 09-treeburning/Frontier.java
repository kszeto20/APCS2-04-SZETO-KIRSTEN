import java.util.*;
import java.lang.*;
public class Frontier{
  private ArrayDeque<int[]> frontier;
  public Frontier(){
    frontier = new ArrayDeque<int[]>();
  }
  public int size(){
    return frontier.size();
  }
  public void add(int[]location){
    frontier.addLast(location);
  }
  public int[] remove(){
    int[] toRet = frontier.remove();
    return toRet;
  }

  public ArrayDeque<int[]> getIt() {
    return frontier;
  }
/*
  public String toString() {
    int[] hello = frontier.toArray();
    return Arrays.toString(hello);
  }
*/
}
