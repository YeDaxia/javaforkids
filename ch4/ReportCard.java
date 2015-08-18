/**
 * @author Yakov Fain (www.smartdataprocessing.com)
 * 
 *         This is a code sample from the book Java Programming for Kids,
 *         Parents and Grandparents.
 */
public class ReportCard {

	/**
	 *这个方法带了一个int类型的参数testResult：该方法返回的字母是A、B、C还是D取决于这个参数的值。
	*/
	public char convertGrades(int testResult) {
		char grade;

		if (testResult >= 90) {
			grade = 'A';
		} else if (testResult >= 80 && testResult < 90) {
			grade = 'B';
		} else if (testResult >= 70 && testResult < 80) {
			grade = 'C';
		} else {
			grade = 'D';
		}
		return grade;
	}

	public static void main(String[] args) {

		ReportCard rc = new ReportCard();

		char yourGrade = rc.convertGrades(88);
		System.out.println("Your first grade is " + yourGrade);

		yourGrade = rc.convertGrades(79);
		System.out.println("Your second grade is " + yourGrade);
	}
}
