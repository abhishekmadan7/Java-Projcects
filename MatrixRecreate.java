import java.util.*;
public class MatrixRecreate
{
   public static void main(String[] args)
   {
      int[][] matrix = new int[3][2];//TheMatrix.create();
      int[] rowcount = {2,1,0};//new int[matrix.length];
      int[] colcount = {2,1};//new int[matrix[0].length];
      //TheMatrix.count(matrix, rowcount, colcount);
      TheMatrix.display( matrix, rowcount, colcount );
      //int[] rowC2 = {0,3,0};
      //int[] colC2={1,1,1};
      TheMatrix.re_create( rowcount, colcount );
      int[][] new_matrix = TheMatrix.getRecreatedMatrix();
      if( new_matrix == null )
         System.out.println("Did not find a match.");
      else
         TheMatrix.display( new_matrix, rowcount, colcount );
   }
}
class TheMatrix
{
    //do not instantiate recreatedMatrix yet. Only instantiate and set that in recur.
   private static int[][] recreatedMatrix = null;
   
   public static int[][] getRecreatedMatrix()
   {
      return recreatedMatrix;
   }
   public static int[][] create()
   {
      int r=2;//(int)(Math.random()*5+2);
      int c=2;//(int)(Math.random()*5+2);
      recreatedMatrix= new int[r][c];
      for(int k=0;k<r;k++)
      {
         for(int p=0;p<c;p++)
         {
            int y=(int)(Math.random()*2);
            recreatedMatrix[k][p]=y;
         }
      }
      return recreatedMatrix;
      
   }
   public static void count(int[][] matrix, int[] rowcount, int[] colcount)
   {
      int r=matrix.length;
      int c=matrix[0].length;
      for(int k=0;k<r;k++)
      {
         for(int p=0;p<c;p++)
         {
            if(recreatedMatrix[k][p]==1)
            {
               rowcount[k]++;
            }
         }
      }
      for(int k=0;k<c;k++)
      {
         for(int p=0;p<r;p++)
         {
            if(recreatedMatrix[p][k]==1)
            {
               colcount[k]++;
            }
         }
      }
      
      
   }
   public static void display(int[][] matrix, int[] rowcount, int[] colcount)
   {
      System.out.print("   ");
      for(int k=0;k<colcount.length;k++)
      {
         System.out.print(" "+colcount[k]);
      }
      System.out.println();
      System.out.print("   ");
      String s="-";
      for(int k=0;k<colcount.length;k++)
      {
         s+="--";
      }
      System.out.println(s);
      for(int r=0;r<rowcount.length;r++)
      {
         System.out.print(rowcount[r]+" |");
         String u="";
         for(int c=0;c<colcount.length;c++)
         {
            u+=" ";
            u+=matrix[r][c];
         }
         System.out.println(u);
      }
   }
   public static void re_create(int[] orig_rowcount, int[] orig_colcount)
   {
      int[][] new_matrix = new int[orig_rowcount.length][orig_colcount.length];    
      recur(new_matrix, orig_rowcount, orig_colcount, 0, 0);
   }
   private static void recur(int[][] new_matrix, int[] orig_rowcount, int[] orig_colcount, int row, int col)
   {
      if(compare(new_matrix, orig_rowcount, orig_colcount))    //base case: if new_matrix works, then copy over to recreatedMatrix
      {
          //copy over from new_matrix to recreatedMatrix (not just references)
         recreatedMatrix = new int[new_matrix.length][];
         for(int i = 0; i < new_matrix.length; i++)
         {
            recreatedMatrix[i] = new int[new_matrix[i].length];
            for (int j = 0; j < new_matrix[i].length; j++)
            {
               recreatedMatrix[i][j] = new_matrix[i][j];
            }
         }           //we've found it!
      }
      else
      {
         if(col<orig_colcount.length && row<orig_rowcount.length)
         {
            new_matrix[row][col]=0;
            recur(new_matrix, orig_rowcount, orig_colcount, row, col+1);
            new_matrix[row][col]=1;
            recur(new_matrix, orig_rowcount, orig_colcount, row, col+1);
         }
         else if(row<orig_rowcount.length)
            recur(new_matrix, orig_rowcount, orig_colcount, row+1, 0);
      
      }
       //ENTER YOUR PERMUTATION CODE HERE            
     
   }
   private static boolean compare(int[][] new_matrix, int[] orig_rowcount, int[] orig_colcount)
   {
      boolean u=true;
      int rc[]=new int[orig_rowcount.length];
      int cc[]=new int[orig_colcount.length];
      int r=new_matrix.length;
      int c=new_matrix[0].length;
      for(int k=0;k<r;k++)
      {
         for(int p=0;p<c;p++)
         {
            if(new_matrix[k][p]==1)
            {
               rc[k]++;
            }
         }
      }
      for(int k=0;k<c;k++)
      {
         for(int p=0;p<r;p++)
         {
            if(new_matrix[p][k]==1)
            {
               cc[k]++;;
            }
         }
      } 
      for(int k=0;k<rc.length;k++)
      {
         if(rc[k]!=orig_rowcount[k])
            u = false;
      } 
      for(int k=0;k<cc.length;k++)
      {
         if(cc[k]!=orig_colcount[k])
            u = false;
      }
      return u; 
   }
}