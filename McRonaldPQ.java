import java.util.*;
public class McRonaldPQ
{
   public static void main(String[] args)
   {
      PriorityQueue<Student> q = new PriorityQueue<>();
      ArrayList<Integer> wT = new ArrayList<>();
      int openTime = 0;
      int closeTime = 1080;
      int mL = 0;
      int nS = 0;
      int nJ = 0;
      int nSo = 0;
      int nF = 0;
      int lS = 0;
      int lJ = 0;
      int lSo = 0;
      int lF = 0;
      double wS = 0;
      double wJ = 0;
      double wSo = 0;
      double wF = 0;
      int k=openTime;
   
      while(k<closeTime || !q.isEmpty() )
      {
         if((int)(Math.random()*5) == 1 && k < closeTime)
         {
            q.add(new Student(k, ((int)(Math.random()*4)) + 9));
         }
         if(q.isEmpty())
         {
         }
         else if(q.peek().getWaitTime() == 0)
         {
            int g=q.peek().getGrade();
            if(g==12)
            {
               nS++;
               wS += k - q.peek().getName();
               if(k - q.peek().getName() > lS)
               {
                  lS = k-q.peek().getName();
               }
                  
            }   
            if(g==11)
            {
               nJ++;
               wJ += k - q.peek().getName();
               if(k - q.peek().getName() > lJ)
               {
                  lJ = k-q.peek().getName();
               }
                  
            }
                  
            if(g==10)
            {
               nSo++;
               wSo += k - q.peek().getName();
               if(k - q.peek().getName() > lSo)
               {
                  lSo = k-q.peek().getName();
               }
                  
            }     
            if(g==9)
            {
               nF++;
               wF += k - q.peek().getName();
               if(k - q.peek().getName() > lF)
               {
                  lF = k-q.peek().getName();
               }
                  
            }
            wT.add(k - q.poll().getName());
         }
         else
            q.peek().decreaseTime();
            
            
         System.out.println( k +":" + q);
         if(q.size() > mL)
         {
            mL = q.size();
         }
         
         k++;
      }
      Collections.sort(wT);
      double wTotal = 0;
      for(int i = 0; i < wT.size(); i++)
      {
         wTotal += wT.get(i);
      }
      System.out.println("Average Wait: " + wTotal/wT.size());
      System.out.println("Longest Wait: " + wT.get(wT.size()-1));
      System.out.println("Grade   Total Served   Longest Wait       Avg Wait");
      if(lS > 9)
      {
         System.out.println("Senior           " + nS + "              " + lS + "       " + wS/nS);
      }
      else
         System.out.println("Senior           " + nS + "               " + lS + "       " + wS/nS);
         
      System.out.println("Junior           " + nJ + "              "+ lJ + "       " + wJ/nJ);
      
      if(lSo > 99)
      {
         System.out.println("Sophomore        " + nSo + "             " + lSo + "       " + wSo/nSo);
      }
      else
         System.out.println("Sophomore        " + nSo + "              " + lSo + "       " + wSo/nSo);
         
      System.out.println("Freshman         " + nF + "             " + lF + "       " + wF/nF);
   }
}
class Student implements Comparable<Student>
{
   int name;
   int waitTime = ((int)(Math.random() * 5)) + 2;
   int grade;
   public Student(int name, int grade){
      this.name = name;
      this.grade = grade;
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
   public int getGrade(){
      return grade;
   }
   @Override
   public String toString(){
      return name + "";
   }
   public int compareTo(Student k){
      if(grade == k.getGrade())
      {
         return name - k.getName();
      }
      return k.getGrade() - grade;
   }
}