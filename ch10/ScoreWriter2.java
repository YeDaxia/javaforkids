/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

public class ScoreWriter2 {

	/**
	 * 这个main方法执行了一下的动作: 1. 创建了一个数组实例 2. 创建各个Score对象并填入数组 3. 把数组中的数据写入文件中
	 */
	public static void main(String[] args) {

		FileWriter myFile = null;
		BufferedWriter buff = null;

		Date today = new Date();
		Score scores[] = new Score[3];

		// 玩家 #1
		scores[0] = new Score();
		scores[0].setFirstName("John");
		scores[0].setLastName("Smith");
		scores[0].setScore(250);
		scores[0].setPlayDate(today);

		// 玩家 #2
		scores[1] = new Score();
		scores[1].setFirstName("Anna");
		scores[1].setLastName("Lee");
		scores[1].setScore(300);
		scores[1].setPlayDate(today);

		// 玩家 #3
		scores[2] = new Score();
		scores[2].setFirstName("David");
		scores[2].setLastName("Dolittle");
		scores[2].setScore(190);
		scores[2].setPlayDate(today);
		try {
			myFile = new FileWriter("c:\\scores2.txt");
			buff = new BufferedWriter(myFile);

			for (int i = 0; i < scores.length; i++) {
				// 通过toString()方法来输出对象的有关信息，并输出到文件中
				buff.write(scores[i].toString());
				System.out.println("Writing  " + scores[i].getLastName());
			}
			System.out.println("File writing is complete");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buff.flush();
				buff.close();
				myFile.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
