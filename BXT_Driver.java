//name:     date:
import java.util.*;
  
/*******************
Represents a binary expression tree.
The BXT can build itself from a postorder expression.  It can
evaluate and print itself. It also prints an inorder string and a preorder string.  
**********************/
class BXT
{
   private int count;
   private TreeNode root;
   public BXT()
   {
      count = 0;
      root = null;
   }
  /*  enter your instance methods here.  */
  public void buildTree(String s)
  {
     String[] i=s.split(" ");
     Stack<TreeNode> k= new Stack<>();
     String y="+-/*";

     

      for(int p = 0; p < i.length; p++)
      {
      
         if(y.contains(i[p]))
         {
            TreeNode t= new TreeNode(i[p]);
            t.setRight(k.pop());
            t.setLeft(k.pop());
            
            k.push(t);
         }
         else
            k.push(new TreeNode(i[p]));
      }
      root = k.pop();
     
  } 
   public double evaluateTree()
    {
     return evaluateNode(root);
    }
  private double evaluateNode(TreeNode root)      //recursive
    {
      if( root==null)
         return 0.0;   
      if(root.getValue().equals("+"))
         return(evaluateNode(root.getLeft()) + evaluateNode(root.getRight()));
      if(root.getValue().equals("-"))
         return(evaluateNode(root.getLeft()) - evaluateNode(root.getRight()));
      if(root.getValue().equals("*"))
         return(evaluateNode(root.getLeft()) * evaluateNode(root.getRight()));
      if(root.getValue().equals("/"))
         return(evaluateNode(root.getLeft()) / evaluateNode(root.getRight()));
      else 
         return Double.parseDouble(root.getValue().toString());
         
      
    }
  private double computeTerm(String s, double a, double b)
    {
      if(s.equals("+"))
         return a+b;
      else if(s.equals("-"))
         return a-b;
      else if(s.equals("*"))
         return a*b;
      else
         return a/b;

 
    }
  private boolean isOperator(String s)
    {
         String y="+ - * / ";
         if(y.indexOf(s)>0)
            return true;
         else return false;

    }
   public String display(){
      return displayHelper(root,0);
   }
   public String displayHelper(TreeNode t, int level)
   {
      String toRet = "";
      if(t == null)
         return "";
      toRet += displayHelper(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += displayHelper(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
  
   public String preorderTraverse(){
      return preorderTraversal(root);
   }
   public static String preorderTraversal(TreeNode t)
   { 
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += t.getValue() + " ";  //preorder visit
      toReturn += preorderTraversal(t.getLeft());         //recurse left
      toReturn += preorderTraversal(t.getRight());        //recurse right
      return toReturn;
   }
   public String inorderTraverse(){
      return inorderTraversal(root);
   }
   public static String inorderTraversal(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += inorderTraversal(t.getLeft());         //recurse left
      toReturn += t.getValue() + " ";  //inorder visit
      toReturn += inorderTraversal(t.getRight());        //recurse right
      return toReturn;
   }
}

/*******************
Driver for a binary expression tree class.
Input: a postfix string, each token separated by a space.
**********************/
public class BXT_Driver
{
   public static void main(String[] args)
   {
      ArrayList<String> postExp = new ArrayList<String>();
      postExp.add("14 -5 / ");
      postExp.add("20 3 -4 + * ");
      postExp.add("2 3 + 5 / 4 5 - *");

      for( String postfix : postExp )
      {
         System.out.println("Postfix Exp: "  + postfix);
         BXT tree = new BXT();
         tree.buildTree( postfix );
         System.out.println("BXT: "); 
         System.out.println( tree.display() );
         System.out.print("Infix order:  ");
         System.out.println( tree.inorderTraverse() );
         System.out.print("Prefix order:  ");
         System.out.println( tree.preorderTraverse() );
         
         System.out.print("Evaluates to " + tree.evaluateTree());
         System.out.println( "\n------------------------");
      }
   }
}

/***************************************
 Postfix Exp: 14 -5 / 
 BXT: 
 	-5
 /
 	14
 Infix order:  14 / -5 
 Prefix order:  / 14 -5 
 Evaluates to -2.8
 ------------------------
 Postfix Exp: 20 3 -4 + * 
 BXT: 
 		-4
 	+
 		3
 *
 	20
 Infix order:  20 * 3 + -4 
 Prefix order:  * 20 + 3 -4 
 Evaluates to -20.0
 ------------------------
 Postfix Exp: 2 3 + 5 / 4 5 - *
 BXT: 
 		5
 	-
 		4
 *
 		5
 	/
 			3
 		+
 			2
 Infix order:  2 + 3 / 5 * 4 - 5 
 Prefix order:  * / + 2 3 5 - 4 5 
 Evaluates to -1.0
 ------------------------
 */