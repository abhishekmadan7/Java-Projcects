import java.util.*;
import static java.lang.Integer.parseInt;
//import java.*;

public class Postfix
{
   public static void main(String[] args) throws NullPointerException
   {
   

      System.out.println("Postfix  -->  Evaluate");
      ArrayList<String> postExp = new ArrayList<String>();
     
      postExp.add("45+53*-");
      
      
      
      
      for( String pf : postExp )
      {
         System.out.println(pf + "\t\t" + eval(pf));
      }
   }
   public static int eval(String postfix)
   {
      Stack<Integer> s= new Stack<Integer>();
      for(int i=0;i<postfix.length();i++)
      {
         if(isOperator(postfix.charAt(i)))
            {
               int z=s.pop();
               int x=eval(s.pop(),z,postfix.charAt(i));
               s.push(x);
            }
         else 
         {
            String z=Character.toString(postfix.charAt(i));
            int y=parseInt(z);
            s.push(y);
         }
      }
      return s.pop();
   }
   public static int eval(int a, int b, char ch)
   {
      if(ch=='*')
         return a*b;
      else if(ch=='/')
         return a/b;
      else if(ch=='+')
         return a+b;
      else
         return a-b;

   }
   public static boolean isOperator(char ch)
   {
      if("+-/*".indexOf(ch)!=-1)
         return true;
      return false;
   }
}