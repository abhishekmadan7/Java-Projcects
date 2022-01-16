import java.util.*;
public class Infix
{
   public static void main(String[] args)
   {
    
      ArrayList<String> infixExp = new ArrayList<>();
      System.out.println("Infix  -->  Postfix  -->  Evaluate");
      infixExp.add("3+4*5");
      infixExp.add("3*4+5");
      infixExp.add("(4+5)-5*3");
      infixExp.add("(3+4)*(5+6)");
      infixExp.add("(3*(4+5)-2)/5");
      infixExp.add("8+1*2-9/3");  
      
      
      for( String s : infixExp )
      {
         String pf = infixToPostfix(s);
         System.out.println(s + "       " + pf + "       " + Postfix.eval(pf));
      }
   }
   public static String infixToPostfix(String infix)
   {
      String n="0123456789";
      Stack<Character> s =new Stack<Character>();
      String postfix="";
      for(int i=0; i<infix.length(); i++)
      {
         if(n.indexOf(infix.charAt(i))!=-1)
            postfix+=infix.charAt(i);
         else
         {
            if(infix.charAt(i)=='(')
               s.push(infix.charAt(i));
            else if(infix.charAt(i)==')')
            {
               while(s.peek()!='(')
                  postfix+=s.pop();
               s.pop();
            }
            else
            {
               while(s.isEmpty()==false && s.peek()!='(' && isLower(s.peek(),infix.charAt(i))==false)
                  postfix+=s.pop();
               s.push(infix.charAt(i));
            }
         }
         
      }
      while(s.isEmpty()==false)
         postfix+=s.pop();
      return postfix;
   
   }
	//returns true if c1 has strictly lower precedence than c2
   public static boolean isLower(char c1, char c2)
   {
      if((c1== '+'||c1=='-')&&(c2=='*'||c2=='/'))
         return true;
      return false;   
   }
}
	
	/*
 Infix  -->  Postfix  -->  Evaluate
 3+4*5       345*+       23
 3*4+5       34*5+       17
 (4+5)-5*3       45+53*-       -6
 (3+4)*(5+6)       34+56+*       77
 (3*(4+5)-2)/5       345+*2-5/       5
 8+1*2-9/3       812*+93/-       7
 */