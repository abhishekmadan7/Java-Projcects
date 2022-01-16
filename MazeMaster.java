//name:    date:
import java.util.*;
import java.io.*;
public class MazeMaster
{
   public static void main(String[] args)throws FileNotFoundException

   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the maze's filename: ");
      char[][] retArr = buildCharArr(sc.next());
      Maze m = new Maze(retArr);
      m.display();
      System.out.println("Options: ");
      System.out.println("1: Mark all paths.");
      System.out.println("2: Mark all paths, and display the count of all STEPs.");
      System.out.println("3: Mark only the correct path.");
      System.out.println("4: Mark only the correct path. If no path exists, display 'No path exists'.");
      System.out.println("5: Mark only the correct path, and display the count of STEPs.");
      System.out.print("Please make a selection: ");
      m.solve(sc.nextInt());
      m.display();  
   } 
   //take in a filename (without .txt), and return a char[][]
   public static char[][] buildCharArr(String fileName) throws FileNotFoundException
   {
      File f = new File(fileName);
      Scanner sc = new Scanner(f);
      int x = sc.nextInt();
      int y = sc.nextInt();
      char[][] g = new char[x][y];
      for(int k=0;k<x;k++)
      {
         String a=sc.next();
         for(int j=0;j<y;j++)
         {
            
            g[k][j]=a.charAt(j);
         }
         
      }
      
      return g; 
   }     
}


class Maze
{
   //Constants
   private final char WALL = 'W';
   private final char DOT = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char STEP = '*';
   //fields
   private char[][] maze;
   private int startRow, startCol;
   private boolean S_Exists=false, E_Exists=false;
   //constructor initializes all the fields
   public Maze(char[][] inCharArr)    
   {
      maze=inCharArr;
      for(int r=0;r<maze.length;r++)
      {
         for(int c=0;c<maze[0].length;c++)
         {
            if(maze[r][c]==START)
            {
               S_Exists=true;
               startRow=r;
               startCol=c;
            }
            if(maze[r][c]==EXIT)
            {
               E_Exists=true;
            }
         }
         
      }
   }
   public void display()
   {
      if(maze==null) 
         return;
      for(int a = 0; a<maze.length; a++)
      {
         for(int b = 0; b<maze[0].length; b++)
         {
            System.out.print(maze[a][b]);
         }
         System.out.println("");
      }
      System.out.println("");
   }
   public void solve(int n)
   {
      if(n==1)
      {
         markAllPaths(startRow, startCol);
      }
      else if(n==2)
      {
         int count = markAllPathsAndCountStars(startRow, startCol);
         System.out.println("Number of steps = " + count);
      }
      else if(n==3)
      {
         markTheCorrectPath(startRow, startCol);
      }
      else if(n==4)   //use mazeNoPath.txt 
      {
         if( !markTheCorrectPath(startRow, startCol) )
         {
            System.out.println("No path exists."); 
         }
         else
            markTheCorrectPath(startRow, startCol) ;   
      }     
      else if(n==5)
      {
         markCorrectPathAndCountStars(startRow, startCol, 0);
      }
      else System.out.println("invalid submission");
      
   }
   
    /*  1  just like AreaFill*/
   private void markAllPaths(int r, int c)
   {  
      if(!S_Exists && !E_Exists)
      {
         System.out.println("No E Or S");
      }
      else
      {
         char ch=DOT;   
          if(maze[r][c]!=START&&maze[r][c]!=ch)
         {
            return;
         }
         if(maze[r][c]==START)
         {
            maze[r][c]=STEP;
         }
         maze[r][c]=STEP;
         if(r!=maze.length-1 && maze[r+1][c]==ch) 
               {
                   markAllPaths(r+1,c);
               }
         if(r!=0 && maze[r-1][c]==ch) 
               {
                   markAllPaths(r-1,c);
               }
         if(c!=maze[0].length-1 && maze[r][c+1]==ch) 
               {
                   markAllPaths(r,c+1);
               }
         if(c!=0 && maze[r][c-1]==ch) 
               {
                   markAllPaths(r,c-1);
               }
            return;
      }
   }
   
    /*  2  just like AreaFill's counting without a static variable */  
   private int markAllPathsAndCountStars(int r, int c)
   {
      if(!S_Exists && !E_Exists)
      {
         System.out.println("No E Or S");
         return 0;
      }
      else
      {
         if((r<0||c<0)||(r>=maze.length||c>=maze[0].length))
         {
            return 0;
         }
         else if(maze[r][c]!=DOT&&maze[r][c]!=START)
         {
            return 0;
         }
         else
         {
            maze[r][c]=STEP;
            return 1+markAllPathsAndCountStars(r,c+1)+markAllPathsAndCountStars(r,c-1)+markAllPathsAndCountStars(r+1,c)+markAllPathsAndCountStars(r-1,c);
         }
      }
   }

   /*  3   recur until you find E, then mark the True path */
   private boolean markTheCorrectPath(int r, int c)
   {  
      if(!S_Exists && !E_Exists)
      {
         System.out.println("No E Or S");
         return false;
      }
         else
         {
         boolean u=false;
         boolean d=false;
         boolean l=false;
         boolean ri=false;
         if((r<0||c<0)||(r>=maze.length||c>=maze[0].length))
         {
            return false;
         }
         else if(maze[r][c]==EXIT)
         {
            return true;
         }
         else if(maze[r][c]!=DOT&&maze[r][c]!=START)
         {
            return false;
         }
         else
         {
            maze[r][c]=STEP;
            u=markTheCorrectPath(r+1,c);
            d=markTheCorrectPath(r-1,c);
            ri=markTheCorrectPath(r,c+1);
            l=markTheCorrectPath(r,c-1);
            if(u||d||ri||l)
            {
               return true;
            }
            else
            {
               maze[r][c]=DOT;
               return false;
            }
         }
      }
   }
   private boolean markCorrectPathAndCountStars(int r, int c, int count)
   {
      if(!S_Exists && !E_Exists)
      {
         System.out.println("No E Or S");
         return false;  
      }
      else
      {
         boolean u=false;
         boolean d=false;
         boolean l=false;
         boolean ri=false;
         if((r<0||c<0)||(r>=maze.length||c>=maze[0].length))
         {
            return false;
         }
         else if(maze[r][c]==EXIT)
         {
                     
           System.out.println("Number of steps = "+count);
            return true;
         }
         else if(maze[r][c]!=DOT&&maze[r][c]!=START)
         {
            return false;
         }
         else
         {
            maze[r][c]=STEP;
            count++;
            u=markCorrectPathAndCountStars(r+1,c,count);
            d=markCorrectPathAndCountStars(r-1,c,count);
            ri=markCorrectPathAndCountStars(r,c+1,count);
            l=markCorrectPathAndCountStars(r,c-1,count);
            if(u||d||ri||l)
            {
   
               return true;
               
            }
            else
            {
               maze[r][c]=DOT;
               count--;
               return false;
            }
         }
      }
   }
}