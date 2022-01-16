// name:    date:
public class DLL_Driver
{
   public static void main(String args[])
   {
      DLL list = new DLL();	
   
      list.addLast("Apple");
      list.addLast("Banana");
      list.addLast("Cucumber");
      list.add("Durian");
      list.add("Eggplant");
      
      System.out.println("The list is " + list);  //calls toString
      System.out.println("Size: " + list.size());
      Object obj = list.remove(2);   
      System.out.println("Remove index 2: "+ obj);
      System.out.println("The list is " + list);
      System.out.println("Size: " + list.size());
   
      list.add(2,"Carrot");
      System.out.println("Add Carrot at index 2:   " + list);
      
      try
      {
         list.add(16,"Kiwi");    //out-of-bounds
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println(e);
      }
       
       
      System.out.println("Get values at index 0 and First: " + list.get(0)+" and " + list.getFirst());
      System.out.println("No change in list: " +list);
         
      list.removeFirst();   //fix me
      System.out.println( "Remove the First:  " + list); 
       
      list.addFirst("Artichoke");
      System.out.println("Add First:  " + list);
      System.out.println("Size: " + list.size());
       
      list.set(1, "Broccoli");
      System.out.println("Set value at index 1:  " + list);
      
      System.out.println("Get Last: " + list.get(list.size()-1));
      System.out.println(list);  
    
      System.out.println("Remove Last: " + list.remove(list.size()-1));
      System.out.println(list);  
     
      list.set(3, "Date");
      System.out.println("Set value at index 3:  " + list);
   
      list.set(0, "Avocado");
      System.out.println("Set value at index 0:  " + list);
   }
}

//////////////////////////////////////////////////////////
    
class DLL        //DoubleLinkedList
{
   private int size;    //Why do we have this? Hint: think run time.
    //dummy node--very useful--simplifies the code
    //Do not change this value! Also, Do not remove this element!
   private DLNode head = new DLNode();
   
   public int size()
   {
      return size;
   }
   
  /* appends obj to end of list; increases size;
   	  @return true  */
   public boolean add(Object obj)
   {
      addLast(obj);
      return true;   
   }
   
   /* inserts obj at position index.  increments size. 
   	*/
   public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real LinkedList is coded
   {
      if(index > size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      else if(index==0)
         {
            addFirst(obj);
            
         }
      else if(index==size)
      {
         addLast(obj);
         
      }
      else 
      {
            DLNode p=head;
            for(int i=0;i<index+1;i++)
            {
               p=p.getNext();
            }
            DLNode j=new DLNode(obj,p.getPrev(),p);
            p.getPrev().setNext(j);
            p.setPrev(j);
            size++;
      }
     
                    
   }
   
   /* return obj at position index.  
   	*/
   public Object get(int index)
   {
            DLNode p=head.getNext();
            for(int i=0;i<index;i++)
            {
               p=p.getNext();
            }
            return p.getValue(); 
   }
   
   /* replaces obj at position index.  
   		*/
   public void set(int index, Object obj)
   {
                  DLNode p=head.getNext();
            for(int i=0;i<index;i++)
            {
               p=p.getNext();
            }
            p.setValue(obj);
   }
   
   /*  removes the node from position index.  decrements size.
   	  @return the object at position index.
   	 */
   public Object remove(int index)
   {
      Object p=null;
      if(index==0)
      {
         p=head.getNext().getValue();
         head.getNext().getNext().setPrev(head);
         head.setNext(head.getNext().getNext());
         
      }
      else if(index==size-1)
      {
         p=head.getPrev().getValue();
         head.getPrev().getPrev().setNext(head);
         head.setPrev(head.getPrev().getPrev());
      }
      else
      {
            DLNode j=head;
            j=j.getNext();
            for(int i=0;i<index;i++)
            {
               j=j.getNext();
            }
            j.getNext().setPrev(j.getPrev());
            j.getPrev().setNext(j.getNext());
            p=j.getValue();
     }
            size=size-1;
            return p; 
             
   }
   
  /* inserts obj at front of list; increases size;
     */
   public void addFirst(Object obj)
   {

            DLNode j=new DLNode(obj,head,head.getNext());
            head.getNext().setPrev(j);
            head.setNext(j);
            size++;

   }
   
   /* appends obj to end of list; increases size;
       */
   //O(n) for naive solution. O(1) for clever solution.
   //naive is fine.
   public void addLast(Object obj)
   {

            DLNode j=new DLNode(obj,head.getPrev(),head);
            head.getPrev().setNext(j);
            head.setPrev(j);
            size++;  
      
   }
   //O(n) for naive solution. O(1) for clever solution.
   //naive is fine.
   public Object getFirst()
   {
      return head.getNext().getValue();
   }
   //O(n) for naive solution. O(1) for clever solution.
   //naive is fine.
   public Object getLast()
   {
      return head.getPrev().getValue();

   }
   //O(n) for naive solution. O(1) for clever solution.
   //naive is fine.
   public Object removeFirst()
   {
      return remove(0);
   }
   //O(n) for naive solution. O(1) for clever solution.
   //naive is fine.
   public Object removeLast()
   {
      return remove(size);
   }
   
   public String toString()
   {
      String j="[";
      DLNode p=head;
      p=p.getNext();
      for(int k=0;k<size-1;k++)
      {
         if(p.getValue()!=null)
         {
            j+=p.getValue()+",";
            
         }
         p=p.getNext();
      }
      j+=p.getValue()+"]";
      return j;
   }
}
	
//////////////////////////////////////

class DLNode 
{
   private Object value;
   private DLNode prev;
   private DLNode next;
   public DLNode(Object arg, DLNode p, DLNode n)
   {
      value=arg;
      prev=p;
      next=n;
   }
   public DLNode()
   {
      value=null;
      next=this;
      prev=this;
   }
   public void setValue(Object arg)
   {
      value=arg;
   }
   public void setNext(DLNode arg)
   {
      next=arg;
   }
   public void setPrev(DLNode arg)
   {
      prev=arg;
   }
   public DLNode getNext()
   {
      return next;
   }
   public DLNode getPrev()
   {
      return prev;
   }
   public Object getValue()
   {
      return value;
   }
}