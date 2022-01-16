 //name:     date:
import java.util.*;
import java.io.*;
public class MergeSort_Driver
{
   public static void main(String[] args) throws Exception
   {
      //double[] array = {1,1,3,4,2,5,6,9};    //example array from the MergeSort handout
   
      int n = (int)(Math.random()*50+10);
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random();
         	
      MergeSort.sort(array);
   
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
/////////////////////////////////////////////
// 15 Oct 07
// MergeSort Code Handout
// from Lambert & Osborne, p. 482 - 485

class MergeSort
{
   private static final int CUTOFF = 10; // for small lists, recursion isn't worth it
   public static void sort(double[] array)
   { 
      double[] copyBuffer = new double[array.length];
      mergeSortHelper(array, copyBuffer, 0, array.length - 1);
   }
   /*  array			array that is being sorted
       copyBuffer		temp space needed during the merge process
       low, high		bounds of subarray
       middle			midpoint of subarray   */
   private static void mergeSortHelper(double[] array, double[] copyBuffer,
                                                      int low, int high)
   {  
      //if ( high - low  < CUTOFF )                  //switch to selection sort  when
          //SelectionLowHigh.sort(array, low, high);        //the list gets small enough 
      if (low < high)
      {
         int middle = (low + high) / 2;
         mergeSortHelper(array, copyBuffer, low, middle);
         mergeSortHelper(array, copyBuffer, middle + 1, high);
         merge(array, copyBuffer, low, middle, high);
      }
   }
   
   /* array				array that is being sorted
      copyBuffer		temp space needed during the merge process
      low				beginning of first sorted subarray
      middle			end of first sorted subarray
      middle + 1		beginning of second sorted subarray
      high				end of second sorted subarray   */
   public static void merge(double[] array, double[] copyBuffer,
                                   int low, int middle, int high)
   
   {
      int f=low;
      int s=middle+1;
      for(int i=low;i<=high;i++)
      {
         if(f>middle)
         {
            copyBuffer[i]=array[s];
            s++;
         }
         else if(s>high)
         {
            copyBuffer[i]=array[f];
            f++;
         }
         else if(array[f]==array[s])
         {
            copyBuffer[i]=array[f];
            f++; 
         }
         else if(array[f]<array[s])
         {
            copyBuffer[i]=array[f];
            f++; 
         }
         else if(array[f]>array[s])
         {
            copyBuffer[i]=array[s];
            s++;
         }
      }
      for(int k=low;k<=high;k++)
      {
         array[k]=copyBuffer[k];
      }
         
   	
   }		
}

/***************************************************
name:   date:
***********************************************/
