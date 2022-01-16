import java.io.*;
import java.util.*;

public class IndexMakerMap
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nEnter input file name: ");
      String infileName = keyboard.nextLine().trim();
      Scanner inputFile = new Scanner(new File(infileName));
      String outfileName = "fishIndex.txt";
      PrintWriter outputFile = new PrintWriter(new FileWriter(outfileName));
      indexDocument(inputFile, outputFile);
      inputFile.close(); 						
      outputFile.close();
      System.out.println("Done.");
   }

   public static void indexDocument(Scanner inputFile, PrintWriter outputFile)
   {
      DocumentIndex index = new DocumentIndex(); 	
      int lineNum = 0;
      while(inputFile.hasNextLine())
      {
         lineNum++;
         index.addAllWords(inputFile.nextLine(), lineNum);
      }
      for(String s: index.keySet())
      {
         String indices = index.get(s).toString();
         outputFile.write(s + " : " + indices.substring(1, indices.length()-1) + "\n");
      }
         
   	
   	
   
   }
}

class DocumentIndex extends TreeMap<String, ArrayList<Integer>>
{
   public void addWord(String word, int lineNum)
   {
      if(containsKey(word)==false)
      {
         put(word,new ArrayList<Integer>());
      }
      get(word).add(lineNum);       
   
   }
   
 /** extracts all the words from str, skipping punctuation and whitespace 
 and for each word calls addWord(word, num).  A good way to skip punctuation 
 and whitespace is to use String's split method, e.g., split("[., \"!?]") */
   public void addAllWords(String str, int lineNum) 
   {
      String words[] = str.split(" ");
      for(int i=0;i<words.length;i++)
      {
         if("~`!@#$%%^&*()_+-={}[]|\":;'<>,.?//".indexOf(words[i])!=-1)
         {
         }
         else
         {
            addWord(words[i],lineNum);
         }  
      }
      
      
   }
}

