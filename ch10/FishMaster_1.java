/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
public class FishMaster_1 {

	public static void main(String[] args) {
		
		Fish myFish = new Fish(20);
		
		myFish.dive(2);
		
		myFish.dive();  // 一个新的重载方法
		
		myFish.dive(97);
		myFish.dive(3);
		
		myFish.sleep();
	}
}
