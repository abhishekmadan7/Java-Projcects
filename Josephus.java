// name:     date:  

import java.util.*;
import java.io.*;

public class Josephus
{
   private static String WINNER = "Josephus";
   public static void main(String[] args) throws FileNotFoundException
   {
   /* run it first with J_numbers.txt  */
      ListNode p = null;
      Scanner sc = new Scanner(System.in);
      System.out.print("How many names (2-20)? ");
      int n = Integer.parseInt(sc.next());
      p = readNLinesOfFile(n, new File("J_numbers.txt"));
      System.out.print("How many names to count off each time?"  );
      int countOff = Integer.parseInt(sc.next());
      p = countingOff(p, countOff, n);
      System.out.println(p.getValue() + " is the winning position."); 
      
   	/* run it next with J_names.txt  */
      System.out.println("\n ****  Now start all over. **** \n");
      p = readNLinesOfFile(n, new File("J_names.txt"));
      System.out.print("Enter the winning position:  ");
      int winPos = Integer.parseInt(sc.next());        
      replaceAt(p, WINNER, winPos);
      p = countingOff(p, countOff, n);
      System.out.println(p.getValue() + " wins!");    
   }
   /* reads the names, calls insert(), builds the linked list. 
        Notes:
            Objects should be strings.
            This method should call insert.
	  */
   public static ListNode readNLinesOfFile(int n, File f) throws FileNotFoundException
   {
      Scanner sc=new Scanner(f);
      ListNode j=null;
      for(int k=1;k<=n;k++)
      {
         j=insert(j,sc.nextLine());
      }
      return j;
   }
    /* helper method to build the list.  Creates the node, then
    inserts it at the back of the circular linked list.
        Hints: 
            What happens if p is null? What should happen?
            What happens if p has one node? What should happen?
            What happens if p has a bunch of nodes? 
                    What does it look like beforehand? 
                    What should the new list look like? Your new node should be at the BACK.
	 */
   private static ListNode insert(ListNode p, Object obj) 
   {
      if(p==null)
      {
         p=new ListNode(obj,null);
         p.setNext(p);
      }
      else if(p.getNext()==p)
      {
         p.setNext(new ListNode(obj,p));
         
      }
      else
      {
         ListNode j=p;
         while(j.getNext()!=p)
            j=j.getNext();
         ListNode k=new ListNode(obj,p);
         j.setNext(k);
   
      }
      return p;
   
   }
  /* Runs a Josephus game, counting off and removing each name. Prints after each removal.
     Ends with one remaining name, who is the winner. 
     Notes:
        Should call both remove and print
        Should actually change the inputted list
        Should return a list with only one node.
	  */
   public static ListNode countingOff(ListNode p, int count, int n)
   {
      ListNode j=p;

      for(int k=0;k<n;k++)
      {
         print(j);
         j=remove(j,count);
         
      }
      return j;
   }

   /* removes the node after counting off count-1 nodes.
        Notes:
            if you called remove with the arguments as:
                    the circular list A->B->C->D and 2,
            it should remove C, and return the circular list D->A->B
	  */
   private static ListNode remove(ListNode p, int count)
   {
        for(int k=0;k<count-2;k++)
        {
            p=p.getNext();
        }
        if(p==p.getNext().getNext())
            p.setNext(p);
        else
            p.setNext(p.getNext().getNext());
        return p.getNext();
        
   }
   /* prints the circular linked list.
        Should print with square brackets and commas.
	  */
   public static void print(ListNode p)
   {
      ListNode j=p;
      if(j==null)
      {
         System.out.println("[]");
      }
      else
      {
         System.out.print("[");
         while(j.getNext()!=p)
         {
            System.out.print(j.getValue()+",");
            j=j.getNext();
         }
         System.out.println(j.getValue()+"]");
      }
        
   }
	/* replaces the value (the string) at the winning node.
	   */
   public static void replaceAt(ListNode p, Object obj, int pos)
   {
      ListNode j=p;
      for(int k=0;k<pos-1;k++)
      {
         j=j.getNext();
      }
      j.setValue(obj);
      p=j;
   
   }
   
   /* Expected output for passing in 5 for num and 3 for counting off. 
        Note that you will need to 4 after it reads in the names.
[1, 2, 3, 4, 5]
[4, 5, 1, 2]
[2, 4, 5]
[2, 4]
[4]

 ****  Now start all over.  Enter the winning position in the JOptionPane.  *** 

[Michael, Hannah, Jacob, Josephus, Matthew]
[Josephus, Matthew, Michael, Hannah]
[Hannah, Josephus, Matthew]
[Hannah, Josephus]
[Josephus]
Josephus wins!
   */
}