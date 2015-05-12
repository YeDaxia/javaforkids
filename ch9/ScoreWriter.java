/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class ScoreWriter {

	public static void main(String[] args) {
		
	FileWriter myFile = null;
	BufferedWriter buff = null;
	String[] scores = new String[3];
	 
	// Populate array with scores
	scores[0] = "Mr. Smith 240";
	scores[1] = "Ms. Lee 300";
	scores[2] = "Mr. Dolittle 190";
	
	try {
 	  myFile = new    
        FileWriter("c:\\scores2.txt");
	  buff = new BufferedWriter(myFile);
			
	  for (int i=0; i < scores.length; i++) {
	   // write strings array into scores2.txt 
	   buff.write(scores[i]);
			          
	   System.out.println("Writing  " + scores[i] );
	  }
       System.out.println("File writing is complete");
		    			    
      }catch (IOException e){
	         e.printStackTrace();
      } finally {
            try{
               buff.flush(); 
               buff.close();
               myFile.close();
            }catch(IOException e1){
            	e1.printStackTrace();
            }
      }
  } // end of main
}
