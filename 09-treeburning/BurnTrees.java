import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static int TREE = 2;
  private static int FIRE = 1;
  private static int ASH = 3;
  private static int SPACE = 0;

  // my own
  private static boolean hasPrevCol;
  private static boolean hasNextCol;
  private static boolean hasUp;
  private static boolean hasDown;
  private static boolean isFire;
  private static boolean returnThat;


  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ )
      for(int c=0; c<map[r].length; c++ )
        if(Math.random() < density)
           map[r][c]=2;
    start();//set the left column on fire.
  }

  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS
    hasPrevCol = false;
    hasNextCol = false;
    hasUp = false;
    hasDown = false;
    isFire = false;
    returnThat = false;
    for (int col = 0; col < map[0].length; col++) {
      for (int row = 0; row < map.length; row++) {
        isFire = false;
        if (map[row][col] == 1) {
          isFire = true;
        }
        if (isFire) {
          // top border
          if (row == 0) {
            // under
            if (map[row + 1][col] == TREE) {
              hasDown = true;
              returnThat = true;
            }
            // left corner
            if (col == 0) {
              // right
              if (map[row][col + 1] == TREE) {
                hasNextCol = true;
                returnThat = true;
              }
            }
            // right corner
            else if (col == map[0].length - 1) {
              // left
              if (map[row][col - 1] == TREE) {
                hasPrevCol = true;
                returnThat = true;
              }
            }
            // everything else
            else {
              if (map[row][col - 1] == TREE) {
                hasPrevCol = true;
                returnThat = true;
              }
              if (map[row][col + 1] == TREE) {
                hasNextCol = true;
                returnThat = true;
              }
            }
          }

          // bottom border
          else if (row == map.length - 1) {
            // over
            if (map[row - 1][col] == TREE) {
              hasUp = true;
              returnThat = true;
            }
            // left corner
            if (col == 0) {
              // right
              if (map[row][col + 1] == TREE) {
                hasNextCol = true;
                returnThat = true;
              }
            }
            // right corner
            else if (col == map[0].length - 1) {
              // left
              if (map[row][col - 1] == TREE) {
                hasPrevCol = true;
                returnThat = true;
              }
            }
            // everything else
            else {
              if (map[row][col - 1] == TREE) {
                hasPrevCol = true;
                returnThat = true;
              }
              if (map[row][col + 1] == TREE) {
                hasNextCol = true;
                returnThat = true;
              }
            }
          }

          // left border
          else if (col == 0) {
            // right
            if (map[row][col + 1] == TREE) {
              hasNextCol = true;
              returnThat = true;
            }
            // up
            if (map[row - 1][col] == TREE) {
                hasUp = true;
                returnThat = true;
            }
            // down
            if (map[row + 1][col] == TREE) {
              hasDown = true;
              returnThat = true;
            }
          }

          // right border
          else if (col == map[0].length - 1) {
            // left
            if (map[row][col - 1] == TREE) {
              hasPrevCol = true;
              returnThat = true;
            }
            // up
            if (map[row - 1][col] == TREE) {
                hasUp = true;
                returnThat = true;
            }
            // down
            if (map[row + 1][col] == TREE) {
              hasDown = true;
              returnThat = true;
            }
          }

          // everything else
          else {
            // right
            if (map[row][col + 1] == TREE) {
              hasNextCol = true;
              returnThat = true;
            }
            // left
            if (map[row][col - 1] == TREE) {
              hasPrevCol = true;
              returnThat = true;
            }
            // up
            if (map[row - 1][col] == TREE) {
                hasUp = true;
                returnThat = true;
            }
            // down
            if (map[row + 1][col] == TREE) {
              hasDown = true;
              returnThat = true;
            }
          }
        }
        if (returnThat) {
          return false;
        }
      }
    }
    return true;
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    boolean leftAd = false;
    boolean rightAd = false;
    boolean upDown = false;
    for (int col = 0; col < map[0].length; col++) {
      for (int row = 0; row < map.length; row++) {
        isFire = false;
        if (map[row][col] == 1) {
          isFire = true;
          map[row][col] = ASH;
        }
        if (isFire) {
          // top border
          if (row == 0) {
            // under
            if (map[row + 1][col] == TREE) {
              map[row + 1][col] = FIRE;
              upDown = true;
            }
            // left corner
            if (col == 0) {
              // right
              if (map[row][col + 1] == TREE) {
                map[row][col + 1] = FIRE;
                rightAd = true;
              }
            }
            // right corner
            else if (col == map[0].length - 1) {
              // left
              if (map[row][col - 1] == TREE) {
                map[row][col - 1] = FIRE;
                leftAd = true;
              }
            }
            // everything else
            else {
              if (map[row][col - 1] == TREE) {
                map[row][col - 1] = FIRE;
                leftAd = true;
              }
              if (map[row][col + 1] == TREE) {
                map[row][col + 1] = FIRE;
                rightAd = true;
              }
            }
          }

          // bottom border
          else if (row == map.length - 1) {
            // over
            if (map[row - 1][col] == TREE) {
              map[row - 1][col] = FIRE;
              upDown = true;
            }
            // left corner
            if (col == 0) {
              // right
              if (map[row][col + 1] == TREE) {
                map[row][col + 1] = FIRE;
                rightAd = true;
              }
            }
            // right corner
            else if (col == map[0].length - 1) {
              // left
              if (map[row][col - 1] == TREE) {
                map[row][col - 1] = FIRE;
                leftAd = true;
              }
            }
            // everything else
            else {
              if (map[row][col - 1] == TREE) {
                map[row][col - 1] = FIRE;
                leftAd = true;
              }
              if (map[row][col + 1] == TREE) {
                map[row][col + 1] = FIRE;
                rightAd = true;
              }
            }
          }

          // left border
          else if (col == 0) {
            // right
            if (map[row][col + 1] == TREE) {
              map[row][col + 1] = FIRE;
              rightAd = true;
            }
            // over
            if (map[row - 1][col] == TREE) {
              map[row - 1][col] = FIRE;
              upDown = true;
            }
            // down
            if (map[row + 1][col] == TREE) {
              map[row + 1][col] = FIRE;
              upDown = true;
            }
          }

          // right border
          else if (col == map[0].length - 1) {
            // left
            if (map[row][col - 1] == TREE) {
              map[row][col - 1] = FIRE;
              rightAd = true;
            }
            // over
            if (map[row - 1][col] == TREE) {
              map[row - 1][col] = FIRE;
              upDown = true;
            }
            // down
            if (map[row + 1][col] == TREE) {
              map[row + 1][col] = FIRE;
              upDown = true;
            }
          }

          // everything else
          else {
            // right
            if (map[row][col + 1] == TREE) {
              map[row][col + 1] = FIRE;
              rightAd = true;
            }
            // left
            if (map[row][col - 1] == TREE) {
              map[row][col - 1] = FIRE;
              rightAd = true;
            }
            // over
            if (map[row - 1][col] == TREE) {
              map[row - 1][col] = FIRE;
              upDown = true;
            }
            // down
            if (map[row + 1][col] == TREE) {
              map[row + 1][col] = FIRE;
              upDown = true;
            }
          }
        }
      }
    }

    ticks++;
    //YOU MUST IMPLEMENT THIS
  }

  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
      }
    }
  }





  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }
  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }


  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      System.out.println("in the while");
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


  public static void main(String[]args)  throws InterruptedException{
    int WIDTH = 20;
    int HEIGHT = 20;
    int DELAY = 200;
    double DENSITY = .7;
    if(args.length > 1){
      WIDTH = Integer.parseInt(args[0]);
      HEIGHT = Integer.parseInt(args[1]);
      DENSITY = Double.parseDouble(args[2]);
    }
    if(args.length > 3){
      DELAY = Integer.parseInt(args[3]);
    }
    BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);


    System.out.println(b.animate(DELAY));//animate all screens and print the final answer
    //System.out.println(b.outputAll());//print all screens and the final answer
  }


}
