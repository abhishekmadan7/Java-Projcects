import java.util.*;
import java.io.*;

public class SetsOfLetters
{
   public static void main(String[] args) throws FileNotFoundException
   {
      //Scanner sc = new Scanner(System.in);
      //System.out.print("Enter the file name: ");
      //String fileName = sc.next();
      String fileName = "declarationLast.txt";
      fillTheSets(fileName);
   }
   public static void fillTheSets(String fn) throws FileNotFoundException
   {
         Scanner sc = new Scanner(new File(fn));
         String c="";
         while(sc.hasNextLine())
         {
               c=sc.nextLine();
               Set<String> Lw= new TreeSet<>();
               Set<String> Up= new TreeSet<>();
               Set<String> Ot= new TreeSet<>();
               for(int i=0;i<c.length();i++)
               {
                  String s=c.substring(i,i+1);
                  if("abcdefghijklmnopqrstuvwxyz".indexOf(s)!=-1)
                     Lw.add(s);
                  else if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(s)!=-1)
                     Up.add(s);
                  else
                     Ot.add(s);
               }
               System.out.println(c);
               System.out.println("Lower Case:"+Lw);
               System.out.println("Upper Case:"+Up);
               System.out.println("Other"+Ot);
         }
   }
}