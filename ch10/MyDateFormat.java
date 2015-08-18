/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.util.Date;
import java.text.SimpleDateFormat;

public class MyDateFormat {
	public static void main(String[] args) {
		// 创建一个日期对象, 输出它的默认格式
		Date today = new Date();
		System.out.println("The date is " + today);
		// 格式化输出日期,让它像02-27-04格式一样输出
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yy");
		String formattedDate = sdf.format(today);
		System.out.println("The date(dd-mm-yy) is " + formattedDate);
		// 格式化输出日期,让它像27-02-2004格式一样输出
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		formattedDate = sdf.format(today);
		System.out.println("The date(dd-mm-yyyy) is " + formattedDate);
		// 输出日期格式为: Fri, Feb 27, ‘04
		sdf = new SimpleDateFormat("EEE, MMM d, ''yy");
		formattedDate = sdf.format(today);
		System.out.println("The date(EEE, MMM d, ''yy) is " + formattedDate);
		// 输出日期格式为: 07:18:51 AM
		sdf = new SimpleDateFormat("hh:mm:ss a");
		formattedDate = sdf.format(today);
		System.out.println("The time(hh:mm:ss a) is " + formattedDate);
	}
}
