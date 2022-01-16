import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Permutations
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("\nHow many digits? ");
      int n = sc.nextInt();
      //leftRight("", n);
      //oddDigits("", n);
      superprime(n);
   }
   public static void leftRight(String s, int n)
   {
         if(n==0)
         {
            System.out.println(s);
         }
         else 
         {
            leftRight(s+"L",n-1);
            leftRight(s+"R",n-1);
         }

   }
   public static void oddDigits(String s, int n)
   {
      if(n==0)
      {
         System.out.println(s);
      }
      else
      {
           oddDigits(s+"1",n-1);
            oddDigits(s+"3",n-1);
            oddDigits(s+"5",n-1);
            oddDigits(s+"7",n-1);
            oddDigits(s+"9",n-1);         
      }
      

   }
   //Hint on how to do this: build up from a nonexistant number (similar to the other two problems)
  public static void superprime(int n)
   {
      //try leading 2, 3, 5, 7, i.e. all the single-digit primes. 
      //A massive hint for this problem: Why these numbers?
      recur(2, n-1);
      recur(3, n-1); 
      recur(5, n-1);
      recur(7, n-1);
   }
   //Look at the examples. What numbers should you recur on? Why???
   private static void recur(int k, int n)
   {
      
      if(n==0)
      {
         if(isPrime(k))
         {
            System.out.println(k);
         }
      }
      else if(isPrime(k)==true)
      {
            recur(k*10+1,n-1);
            recur(k*10+3,n-1);
            recur(k*10+5,n-1);
            recur(k*10+7,n-1);
            recur(k*10+9,n-1);         
      }

   }
   //You need to write this one.

   private static boolean isPrime(int n)
   {
      boolean z=true;
      double p=n;
      for(int k=n-1;k>1;k--)
      {
         double u=(n/k);
         if((p/k)==u)
            {
               z=false;
            }
      }
      
      return z;
   }
}