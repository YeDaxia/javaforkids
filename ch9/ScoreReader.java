/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ScoreReader {
	
	public static void main(String[] args) {
		FileReader myFile = null;
		BufferedReader buff = null;
		try {
			myFile = new FileReader("c:\\scores.txt");
			buff = new BufferedReader(myFile);
			while (true) {
				// 从scores.txt中读取一行
				String line = buff.readLine();
				// 检查是否到了文件尾
				if (line == null)
					break;
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buff.close();
				myFile.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
