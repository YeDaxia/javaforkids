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
			// 打开一个指向文件的字节流
			myFile = new FileInputStream("c:\\temp\\abc.gif");

			while (true) {
				int intValueOfByte = myFile.read();
				System.out.print(" " + intValueOfByte);

				if (intValueOfByte == -1) {
					// 我们已经读取到文件的末尾了，让我们结束这个循环吧
					break;
				}
			} 
			// myFile.close(); 不要在这里关闭流
		} catch (IOException e) {
			System.out.println("Could not read file: " + e.toString());
		} finally {
			try {
				myFile.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println(" Finished reading the file");
		}
	}
}
