//  name:        date: 
//  implements the List interface with a backing array of Objects. 
//	 also overrides toString().
    
public class SASArrayList_Driver
{  
   public static void main(String [] args)
   {
      SASArrayList myList = new SASArrayList();	
   
      myList.add("Apple");
      myList.add("Banana");
      myList.add("Fig");
      myList.add(2, "Cucumber");
      myList.add(3, "Dates");
      System.out.println(myList);
      System.out.println("Size is " + myList.size());
      try
      {
         myList.add(12, "Peach");
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println(e);
      }
      System.out.println("Get 2: " + myList.get(2));
      System.out.print("Set at 2: ");
      myList.set(2, "Cherry");
      System.out.println(myList);
      Object obj = myList.remove(2);
      System.out.println("Removed " + obj+ " from " + myList);
      System.out.println("Size is " + myList.size());
      System.out.print("Add too many items: ");
      for(int i = 3; i <= 10; i++)
         myList.add(i);
      System.out.println(myList);
      System.out.println("Size is " + myList.size());   	
      System.out.println("Contains \"Breadfruit\"?  " + myList.contains("Breadfruit"));
      System.out.println("Contains \"Banana\"?  " + myList.contains("Banana"));
   }
}
   
class SASArrayList
{
   private int size;							//stores the number of objects
   private Object[] myArray;
   public SASArrayList()                //default constructor makes 10 cells
   {
      myArray = new Object[10];
      size=0;
   }
   public int size()
   {
      return size;
   }
 	/* appends obj to end of list; increases size;
         must be an O(1) operation when size < array.length, 
            and O(n) when it doubles the length of the array.
	      @return true  */
   public boolean add(Object obj)
   {
      //if the array is full (if size == myArray.length)
         //build a new array double the size
         //copy everything over
         //update myArray's reference
      
      
      if(size==myArray.length)
      {
         Object[] temp=myArray;
         myArray = new Object[myArray.length*2];
         for(int j=0;j<temp.length;j++)
         {
            myArray[j]=temp[j];
         }
      }
      myArray[size] = obj;
      size++;
      return true;
   }
      /* inserts obj at position index.  increments size. 
   		*/
   public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real ArrayList is coded
   {
      if(index > size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      else if(index!=size)
      {
         Object[] temp=myArray;
         int k=0;
         for(int j=index;j<size;j++)
         {
               
               myArray[j+1]=temp[j];
            
         }
         
         myArray[index]=obj;
         size++;
      }
      else
      {
               Object[] temp=myArray;
         myArray = new Object[myArray.length*2];
         for(int j=0;j<temp.length;j++)
         {
            myArray[j]=temp[j];
         }
         myArray[temp.length+1]=obj;
         size++;
      }   
   }
      /* return obj at position index.  
   		*/
   public Object get(int index)
   {
      return myArray[index];
   }
    /* replaces obj at position index.  
   		*/
   public void set(int index, Object obj)
   {
      myArray[index]=obj;
      
   }
    /*  removes the node from position index. shifts elements 
        to the left.   Decrements size.
   	  @return the object at position index.
   	  */
   public Object remove(int index)
   {
      Object j=myArray[index];
      for(int k=index;k<size-1;k++)
      {
         myArray[k]=myArray[k+1];
      }
      myArray[size-1]=null;
      size--;
      return j;
      
   }
	 /*
      this method compares objects and should use .equals(), not ==
     	*/
   public boolean contains(Object obj)
   {
      for(int k=0;k<size;k++)
      {
         if(myArray[k]==obj)
            return true;
      }
      return false;
      
   }
      /*returns a String of Objects in the array with square brackets and commas
        	*/
   public String toString()
   {
      String p="["+myArray[0];
      for(int k=1;k<size;k++)
         p+=","+myArray[k];
      p+="]";
      return p;  
   }
}