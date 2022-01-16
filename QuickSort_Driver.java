//name:    date:  
import java.util.*;
import java.io.*;
public class QuickSort_Driver
{
   public static void main(String[] args) throws Exception
   {
      int n = (int)(Math.random()*50 + 10);
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random();
         	
      QuickSort.sort(array);
      print(array);
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("oops!");
   }
   public static void print(double[] a)   
   {
      for(double number : a)    //doing something to each element
         System.out.print(number+" ");
      System.out.println();
   }
   public static boolean isAscending(double[] a)
   {
            boolean k=true;
      for(int j=0;j<a.length-1;j++)
      {
         if(a[j]>a[j+1])
            k=false;
         
      }
      return k;
   }
}
/************************************************
name:    date:
copy the code from the handout
************************************************/
class QuickSort
{
   public static void sort(double[] array)
   {
      int first=0;
      int last=array.length-1;
      helper(array,first,last);
   }
   private static void helper(double[] array, int start, int end)
   {
      int splitP=0;
      if(start<end)
      {
         splitP=split(array,start,end);
         helper(array,start,splitP-1);
         helper(array,splitP+1,end);
      }
      
   }
   private static int split(double[] array, int start, int end)
   {
         int splitPt = start;       
         double pivot = array[start];
         
         while (start <= end)
            { 
             if (array[start] <= pivot)       //if on correct side, 
                 start++;                       //   update		// increment first until elemetn > pivot
             else if (array[end] >= pivot)  //if on correct side,	
                 end--;                        //   update		// decrement last until elemtn < pivot
             else                               //if on the wrong side,  
              {  
                 swap (array, start, end);      //    then swap them,
                 start++;                       //    update both
                 end--;
              }
            }
         swap (array, end, splitPt); 	// swap pivot with element at splitPt
         splitPt = end;			// set splitPt to place where the halves meet
         return splitPt;  
   }
   private static void swap(double[] array, int a, int b)
   {
      double temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
}
