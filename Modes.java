import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Modes {
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] tally = new int[num];
    for(int k=0; k<num; k++)
      tally[k]=sc.nextInt();
    display(tally);
    int[] modes = calculateModes(tally);
    display(modes);
    int sum = 0;
    for(int k = 0; k < tally.length; k++)
      sum += tally[k];
    System.out.println("kth \tindex"); 
    for(int k = 1; k <= sum; k++)
      System.out.println(k + "\t\t" + kthDataValue(tally, k));

  }
  public static int findMax(int[] nums)
   {
      int pos = 0;
      for(int k = 1; k < nums.length; k++)
         if(nums[k] > nums[pos])
            pos = k;
      return nums[pos];
   }
   public static int[] calculateModes(int[] tally)
   {
      int j = findMax(tally);
      int count=0;
      for(int k=0;k<tally.length;k++)
      {
         if(j==tally[k])
         {
            count++; 
         }
      }
      int[] w = new int[count];
   
      for(int k=0;k<w.length;k++)
      {
         w[k]=-1;
      }
      for(int k=0;k<tally.length;k++)
      {
         if(j==tally[k])
         {
            for(int p=0;p<w.length;p++)
            {
               if(w[p]==-1)
               {
                  w[p]=k;
                  break;
               }
            } 
         }
      }
      return w;
   }
   public static int kthDataValue(int[] tally, int k)
   {
      List<Integer> intlist = new ArrayList<Integer>();
      intlist.add(1);
      for(int j=0;j<tally.length;j++)
      {
         for(int u=0;u<tally[j];u++)
         {
            intlist.add(j);
         } 
      }
      int p = intlist.get(k);
      return p;     
   }
   public static void display(int[] args)
   {
      for(int k = 0; k < args.length; k++)
         System.out.print(args[k] + " ");
      System.out.println();
      System.out.println();
   }
}