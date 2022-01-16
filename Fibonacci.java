  public class Fibonacci
   {
      public static void main(String[] args)
      {
         long start, end, fib;
         int[] fibNumber = {1, 5, 10, 20, 30, 40, 41, 42};
         System.out.println("\tFibonacci\tBy Iteration\tTime\tby Recursion\t Time");
         for(int n = fibNumber[0]; n <= fibNumber[fibNumber.length - 1]; n++)
         { 
            start = System.nanoTime();
            fib = fibIterate(n);
            end = System.nanoTime();
            System.out.print("\t\t" + n + "\t\t" + fib + "\t" + (end-start)/1000.);
            start = System.nanoTime();   	
            fib = fibRecur(n);      
            end = System.nanoTime();
            System.out.println("\t" + fib + "\t\t" + (end-start)/1000.);
         }
      }
      public static long fibIterate(int n)
      {
         int x=0;
         int p=1;
         int z=0;
         int k=0;
         while(x!=n)
         {
            k=p+z;
            z=p;
            p=k;
            x++;
         }
         return k; 
  
      }

      public static long fibRecur(int n)
      {
         if(n==0)
         {
            return 0;
         }
         else if(n==1)
         {
            return 1;
         }
         else
         {
            return fibRecur(n-1)+fibRecur(n-2);
         } 
      }
   }