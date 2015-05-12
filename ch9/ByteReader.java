/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.io.FileInputStream;
import java.io.IOException;
 
public class ByteReader {
 
  public static void main(String[] args) {
	
   FileInputStream myFile = null;

   try {
 	// Open a byte stream pointing at the file
	 myFile = new   
              FileInputStream("c:\\temp\\abc.gif");

	 while (true) {
	   int intValueOfByte = myFile.read();
	   System.out.print(" " + intValueOfByte);
		   
	     if (intValueOfByte  == -1){
            // we've reached the end of file
	      // let's exit out of the loop
		  break;
           }  
	   } // end of while loop
         // myFile.close(); don’t do it here
     } catch (IOException e) {
		  System.out.println("Could not read file: "        
                                        + e.toString());
     } finally{
 	   try{
		  myFile.close();
	   } catch (Exception e1){
			 e1.printStackTrace();
	   }
	   System.out.println(
                  " Finished reading the file");	           
       }
  }
}
