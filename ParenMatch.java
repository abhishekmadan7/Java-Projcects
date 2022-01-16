import java.util.*;
public class ParenMatch
{
   public static final String left  = "([{<";
   public static final String right = ")]}>";
   public static void main(String[] args)
   {
      System.out.println("Parentheses Match");
      ArrayList<String> parenExp = new ArrayList<String>();
      parenExp.add("5+7");
      parenExp.add("(5+7)");
      parenExp.add(")5+7(");
      parenExp.add("((5+7)*3)");
      parenExp.add("<{5+7}*3>");
      parenExp.add("[(5+7)*]3");
      parenExp.add("(5+7)*3");
      parenExp.add("5+(7*3)");
      parenExp.add("((5+7)*3");
      parenExp.add("[(5+7]*3)");
      parenExp.add("[(5+7)*3])");
      parenExp.add("([(5+7)*3]");
      
                  
      for( String s : parenExp )
      {
         boolean good = checkParen(s);
         if(good)
            System.out.println(s + "\t good!");
         else
            System.out.println(s + "\t BAD");
      }
   }
   public static boolean checkParen(String exp)
   {
      
      Stack<String> l= new Stack<String>();
      for(int i=0;i<exp.length();i++)
      {
         String s=exp.substring(i,i+1);
         if(left.indexOf(s)>=0)
         {
            l.push(s);
         }
         if(right.indexOf(s)>=0)
         {
            if(l.isEmpty())
               return false;
            if(right.indexOf(s)==left.indexOf(l.peek()))
               l.pop();
            else
               return false;
         }
      }
      if(l.isEmpty())
         return true;
      else
         return false;
      
      
   }
}
