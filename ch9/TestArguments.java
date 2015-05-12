/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
public class TestArguments {

	public static void main(String[] args) {

        // How many arguments we've got?
 	  int numberOfArgs = args.length;

	  for (int i=0; i<numberOfArgs; i++){
	    System.out.println("I've got " + args[i]);
  	  }
	}
}
