import java.util.*;
public class McRonald
{
   public static void main(String[] args)
   {
      Queue<Customer> q = new LinkedList<>();
      ArrayList<Integer> wT = new ArrayList<>();
      int oT = 0;
      int cT = 1080;
      int mL = 0;
      for(int i = oT; i < cT || q.isEmpty()==false ; i++)
      {
         if(i<cT && (int)(Math.random()*5+1)==5)
         {
            q.add(new Customer(i));
         }
         if(q.isEmpty()==true)
         {
         }
         else if(q.peek().getWaitTime()==0)
         {
            wT.add(i-q.remove().getName());
         }
         else
         {
            q.peek().decreaseTime();
         }
         System.out.println( i +":" + q);
         
         if(q.size() > mL)
            mL = q.size(); 
      }
      Collections.sort(wT);
      double wTotal = 0;
      for(int i = 0; i < wT.size(); i++)
      {
         wTotal += wT.get(i);
      }
      System.out.println("Mean Time: " + wTotal/wT.size());
      System.out.println("Max Line: " + mL);
      System.out.println("Max Time: " + wT.get(wT.size()-1));
      
   }
}
class Customer
{
   int name;
   int waitTime = ((int)(Math.random() * 5)) + 2;
   public Customer(int name){
      this.name = name;
   }
   public int getWaitTime(){
      return waitTime;
   }
   public void decreaseTime(){
      waitTime--;
   }
   public int getName(){
      return name;
   }
   @Override
   public String toString(){
      return name + "";
   }
}