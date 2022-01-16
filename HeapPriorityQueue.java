import java.util.*;
public class HeapPriorityQueue<E extends Comparable<E>> 
{
   private ArrayList<E> myHeap;
   
   public HeapPriorityQueue() 
   {
        myHeap = new ArrayList<E>();
        myHeap.add(0, null);
    }
    public boolean add(E k)
    {
         myHeap.add(k);
         heapUp(myHeap.size()-1);
         return true;    
    }
    public E remove() 
    {
        if (myHeap.size() <= 1)
            return null;
        E ret = myHeap.remove(1);
        heapDown(1);
        return ret;
    }

    public boolean isEmpty() 
    {
        if (myHeap.size() <= 1) 
            return true;
        return false;
    }
    public E peek() 
    {
        if (myHeap.size() > 1)
            return myHeap.get(1);
        else
            return null;
    }

    public void heapDown(int k)
    {
       int size = myHeap.size() - 1;
       if(2*k+1>size)
         return;   
      if(myHeap.get(2*k+1).compareTo(myHeap.get(2*k))>=0 && myHeap.get(k).compareTo(myHeap.get(2*k+1))<0)
      {
         swap(k,2*k+1);
         heapDown(2*k+1);          
      }
      else if(myHeap.get(2*k+1).compareTo(myHeap.get(2*k))<0 && myHeap.get(k).compareTo(myHeap.get(2*k))<0)
      {
            swap(k,2*k);
            heapDown(2*k);
      }
      else
      {
         return;
      }
      

    }
    public void heapUp(int k) {
        if (k/2 < 1)
            return;
        if( k > myHeap.size() - 1)
            return;
            
        if (k > 1 && myHeap.get(k).compareTo(myHeap.get(k/2)) < 0)
        {
            swap(k, k/2);
            heapUp(k/2);
        }

    }

    public void swap(int a, int b)
    {
        E p = myHeap.get(a);
        myHeap.set(a, myHeap.get(b));
        myHeap.set(b, p);
    }
  
  
}