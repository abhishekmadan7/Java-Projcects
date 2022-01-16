import java.util.*;
import javax.swing.*;
public class Hashing
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the size of the array:");
      int arrayLength = sc.nextInt();//20

      System.out.println("How many items?");
      int numItems = sc.nextInt();//15

      System.out.println("\nWhich collision scheme?\n"+
           "1. Linear Probing\n" +
           "2. Rehashing (optional)\n"+
           "3. Chaining");
      int scheme = sc.nextInt();
      Hashtable table = null;
      switch( scheme )
      {
         case 1:   
            table = new HashtableLinearProbe(arrayLength);
            break;
         /* uncomment if you are doing this one.
         case 2: 
            table = new HashtableRehash(arrayLength);
            break;*/
         case 3:  
            table = new HashtableChaining(arrayLength);
            break;
         default:  System.exit(0);    
      }
      for(int i = 0; i < numItems; i++)
         table.add("Item" + i);
      System.out.println("Search for:  Item0" + " to "+ "Item"+(numItems-1));
      int itemNumber = sc.nextInt();
      while( itemNumber != -1 )
      {
         String key = "Item" + itemNumber;
         int index = table.indexOf(key); 
         if( index >= 0)    //found it
            System.out.println(key + " found  at index " + index);
         else
            System.out.println(key + " not found!");
         System.out.println("Search for:  Item0" + " to "+ "Item"+(numItems-1));
         itemNumber = sc.nextInt();
      } 
      System.exit(0);
   }
}
/*********************************************/
interface Hashtable
{
   void add(Object obj);
   int indexOf(Object obj);
}
/***************************************************/ 
class HashtableLinearProbe implements Hashtable
{
   private Object[] array;
   public HashtableLinearProbe(int size)
   {
       array= new Object[size];                   //constructor
   }
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      if(array[index]==null)  //empty
      {
         array[index]=obj; 
         System.out.println(obj + "\t" + code + "\t" + index);
      }
      else //collision
      {
         System.out.println(obj + "\t" + code + "\tCollision at "+ index);
         index = linearProbe(index);
         array[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
   }  
   public int linearProbe(int index)
   {
      int i=index;
      while(array[i]!=null)
      {
         i++;
         if(i==array.length)
            i=0;
        if(i==index)
            break;
     }

      return i;
   }
   public int indexOf(Object obj)     
   {
      int index = Math.abs(obj.hashCode() % array.length);
      int i=index;
      while(array[index] != null)
      {
         if(array[index].equals(obj))  //found it
         {
            return index;  
         }
         else //search for it in a linear probe manner
         {
            if(index==array.length)
               index=-1; 
            index++;
            if(index==i-1)
               break;
            System.out.println("Looking at index " + index);
         }
         
      }
      return -1;
   }
}
/*****************************************************/
//******* OPTIONAL!!!!! ********
class HashtableChaining implements Hashtable
{
   private LinkedList[] array;
   public HashtableChaining(int size)
   {
     array=new LinkedList[size];
     for(int i=0;i<size;i++)
         array[i]=new LinkedList();
                            
   }
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      array[index].addFirst(obj);
      System.out.println(obj + "\t" + code + " " + " at " +index + ": "+ array[index]);
   }  
 public int indexOf(Object obj)
   {
      int index = Math.abs(obj.hashCode() % array.length);
      if( !array[index].isEmpty() )
      {
         if(array[index].contains(obj))  //found it
         {
            return index;  
         }
      }
      return -1;
         
          
   }
}