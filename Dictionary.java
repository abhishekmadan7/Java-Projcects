import java.io.*;
import java.util.*;
public class Dictionary
{
   public static void main(String[] args) 
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File("spanglish.txt"));
         System.setOut(new PrintStream(new FileOutputStream("dictionaryOutput.txt")));
      }
      catch(Exception e)
      {
      }
      
      Map<String, Set<String>> eng2spn = makeDictionary( infile );
      System.out.println("ENGLISH TO SPANISH");
      display(eng2spn);
   
      Map<String, Set<String>> spn2eng = reverse(eng2spn);
      System.out.println("SPANISH TO ENGLISH");
      display(spn2eng);
   }
   public static Map<String, Set<String>> makeDictionary(Scanner infile)
   {
      Map<String,Set<String>> eng2spn = new TreeMap<String, Set<String>>();
      while(infile.hasNext()){
         add(eng2spn,infile.next(),infile.next());
      }
      return eng2spn;  
   }
   private static void add(Map<String, Set<String>> dictionary, String word, String translation)
   { 
      if(containsKey(word)==false)
      {
         put(word,new TreeSet<String>());
      }
      get(word).add(translation);
   }
   public static void display(Map<String, Set<String>> m)
   {
        
   }
   public static Map<String, Set<String>> reverse(Map<String, Set<String>> dictionary)
   {
      Map<String,Set<String>> spn2eng = new TreeMap<String, Set<String>>();
      while(infile.hasNext())
      {
         String w=infile.next();
         String t=infile.next();
         add(spn2eng,t,w);
      }
      return spn2eng;
   }
}