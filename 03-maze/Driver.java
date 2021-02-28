import java.io.*;
public class Driver{
  public static void main(String[]args){
    String filename = "data1.dat";
    try{
      Maze f;
      f = new Maze(filename); //true animates the maze.
      f.setAnimate(true); //comment this if you are using windows cmd/powershell
      System.out.println(f.solve());
      System.out.println(f.solve()+" steps");

      }
      catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+filename);
      }
    }
  }
