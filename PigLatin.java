//name:      date:  
import java.util.*;
import java.io.*;
public class PigLatin
{
   public static void main(String[] args) 
   {
      //part_1_using_pig();
     part_2_using_piglatenizeFile();
   }
   public static void part_2_using_piglatenizeFile() 
   {
         Scanner sc = new Scanner(System.in);
         System.out.print("Input Filename (Including .txt)? Example: PigLatin.txt:");
         String filename = sc.next();
         Scanner infile = null;
         try
         {
            infile = new Scanner(new File(filename));  //PigLatin.txt
         }
            catch(IOException e)
            {
               System.out.println("oops");
            }
         System.out.print("Output Filename (Including .txt)? Example: PigLatinOut.txt:");
         String filenameOut = sc.next();
         piglatenizeFile( infile, filenameOut );
         System.out.println("Piglatin done!");
         sc.close();
   }
   public static void piglatenizeFile(Scanner infile, String filename) 
   {
      try
         {
         PrintStream k=System.out;
         PrintStream f = new PrintStream(filename);
         System.setOut(f); 
         while(infile.hasNextLine())
            {
               StringTokenizer g = new StringTokenizer(infile.nextLine());
               while (g.hasMoreTokens()) 
               {
                  System.out.print(pig(g.nextToken()));
               }
            }
        System.setOut(k);
       }
      catch(Exception e)
      {
      }
   }
   
	public static String pig(String s)
   {
      String j="aiuoeyAIUOEY";
      String start="";
      String end="";
      String ay="ay";
      String f="";
      boolean w=true;
      boolean cap=false;
      String puncstart="";
      String puncend="";
      String punc="1234567890~`!@#$%%^&*()_+-={}[]|\":;'<>,.?//";
      boolean puncTF=false;
      
      if(punc.indexOf(s.charAt(0))!=-1)
      {
         
         int z=0;
         for(int k=0;k<s.length();k++)
         {
            if(punc.indexOf(s.charAt(k))==-1)
            {
               z=k;
               break;
            }
            
         }
         puncstart=s.substring(0,z);
         s=s.substring(z);
         puncTF=true;
         
      }
      if(punc.indexOf(s.charAt(s.length()-1))!=-1)
      {
         int z=0;
         for(int k=s.length()-1;k>=0;k--)
         {
            if(punc.indexOf(s.charAt(k))==-1)
            {
               z=k;
               break;
            }
            
         }
         puncend=s.substring(z+1);
         s=s.substring(0,z+1);
         puncTF=true;
      }
      if(s.charAt(0)<=91&&s.charAt(0)>=41)
      {
         String p=s.substring(0,1);
         p = p.toLowerCase();
         String c=s.substring(1);
         s=p+c;
         cap=true; 
      }
      if(s.charAt(0)=='y'||s.charAt(0)=='Y')
      {
         String p=s.substring(0,1);
         String c=s.substring(1);
         s=c+p;
         w=false;

      }
      for(int k=0;k<s.length();k++)
         {
            if(j.indexOf(s.charAt(k))!=-1)
            {
              if(k==0)
                 {
                     f=s;
                     if (w==true)
                     {
                         f+="w";
                     }
                     break;
                 }
               else if(k!=0)
               {
                  w=false;
                  start=s.substring(0,k);
                  end=s.substring(k);
                  f=end+start;
                  break;
               }
               
            }

            
         }
      
      if(f.length()==0)
      {
         String q ="**** INVALID ****";
         return q;
      }
      if(f.charAt(0)=='u'&&f.charAt(f.length()-1)=='q'||f.charAt(0)=='U'&&f.charAt(f.length()-1)=='q'||f.charAt(0)=='u'&&f.charAt(f.length()-1)=='Q'||f.charAt(0)=='U'&&f.charAt(f.length()-1)=='Q')
      {
         String p=f.substring(0,1);
         String c=f.substring(1);
         f=c+p;
         
      }
      if(cap==true)
      {
         String p=f.substring(0,1);
         p=p.toUpperCase();
         String c=f.substring(1);
         f=p+c;
      }
      
      if(puncTF==true)
      {
         return puncstart+f+ay+puncend;
      }
      else
      {
         return f+ay;
      }
   }

}



