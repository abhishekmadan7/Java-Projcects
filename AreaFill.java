import java.util.*;
import java.io.*;
public class AreaFill
{
   public static char[][] grid = null;
   public static String filename = null;
      
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      while(true) 
      {
         System.out.print("Filename: ");
         filename = sc.next();
         if(filename.equals("-1"))
         {
            sc.close();
            System.out.println("Good-bye");
            return;   
         }
         grid = read(filename);
         String theGrid = display(grid);
         System.out.println( theGrid );
         System.out.print("\nEnter ROW COL to fill from: ");
         int row = sc.nextInt();
         int col = sc.nextInt(); 
         //fill(grid, row, col, grid[row][col]);
         //System.out.println( display(grid) );
      //  Extension
         int count = fillAndCount(grid, row, col, grid[row][col]);
         System.out.println( display(grid) );
         System.out.println("count = " + count);
         System.out.println();
      }
   }
   public static char[][] read(String filename) throws FileNotFoundException
   {
      File f = new File(filename);
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
   public static String display(char[][] g)
   {
      String s="";
      for(int k=0;k<g.length;k++)
      {
         for(int j=0;j<g[0].length;j++)
         {
            s+=g[k][j];
         }
         s+="\n";
      }
      return s; 
   }
   public static void fill(char[][] g, int r, int c, char ch) //recursive method
   {
      
      if(g[r][c]!=ch)
      {
         return;
      }
      g[r][c]='*';
      if(r!=g.length-1 && g[r+1][c]==ch) 
            {
                fill(g,r+1,c, ch);
            }
      if(r!=0 && g[r-1][c]==ch) 
            {
                fill(g,r-1,c, ch);
            }
      if(c!=g[0].length-1 && g[r][c+1]==ch) 
            {
                fill(g,r,c+1, ch);
            }
      if(c!=0 && g[r][c-1]==ch) 
            {
                fill(g,r,c-1, ch);
            }
         return;
      
          
      
   }
	
	// Extension-- count and return the number of asterisks
   public static int fillAndCount(char[][] g, int r, int c, char ch)
   {
      if((r<0||c<0)||(r>=g.length||c>=g[0].length))
      {
         return 0;
      }
      else if(g[r][c]!=ch)
      {
         return 0;
      }
      else
      {
         g[r][c]='*';
         return 1+fillAndCount(g,r+1,c, ch)+fillAndCount(g,r-1,c, ch)+fillAndCount(g,r,c+1, ch)+fillAndCount(g,r,c-1, ch);
      }

 
   }
}