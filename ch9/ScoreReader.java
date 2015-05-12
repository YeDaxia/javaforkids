/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java. io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ScoreReader {

  public static void main(String[] args) {
	FileReader myFile = null;
	BufferedReader buff = null;

      try {
	   myFile=new FileReader("c:\\scores.txt");
	   buff = new BufferedReader(myFile);
				
	   while (true) {
	    // read a line from scores.txt
	    String line = buff.readLine();
   	    // check for the end of file
 	    if (line == null)
	        break;
  	    System.out.println(line);
        } // end while
      }catch (IOException e){
	         e.printStackTrace();
      } finally {
            try{
               buff.close();
               myFile.close();
            }catch(IOException e1){
            	e1.printStackTrace();
            }
      }
  } // end main 
}
