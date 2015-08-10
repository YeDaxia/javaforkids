/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		// 创建一个存放String类型的ArrayList对象，并填充它
		ArrayList<String> friends = new ArrayList<>();
		friends.add("Mary");
		friends.add("Ann");
		friends.add("David");
		friends.add("Roy");

		// 朋友的数量
		int friendsCount = friends.size();

		// 输出ArrayList中的内容
		for (int i = 0; i < friendsCount; i++) {
			System.out.println("Friend #" + i + " is " + friends.get(i));
		}
	}
}
