/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FishMaster {
	public static void main(String[] args) {
		Fish myFish = new Fish(20);
		String feetString = "";
		int feets;
		// 创建InputStreamReader连接System.in，并把它传递给缓冲流
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		// 接着往下潜直到用户按下'Q'键盘
		while (true) {
			System.out.println("Ready to dive.How deep?");
			try {
			    //程序暂停，等待用户输入一段文字，按回车之后结束
				feetString = stdin.readLine();
				if (feetString.equals("Q")) {
					// 退出程序
					System.out.println("Good bye!");
					System.exit(0);
				} else {
					// 把feetString转化成整数类型
					feets = Integer.parseInt(feetString);
					//鱼下潜的步数
					myFish.dive(feets);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	} 
}
