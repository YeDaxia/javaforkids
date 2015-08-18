/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.util.Date;

public class Score {
	private String firstName;
	private String lastName;
	private int score;
	private Date playDate;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getPlayDate() {
		return playDate;
	}

	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}

	// 拼接各种属性值，并且在最后加一个换行符。
	public String toString() {
		String scoreString = firstName + " " + lastName + " " + score + " "
				+ playDate + System.getProperty("line.separator");
		return scoreString;
	}
}
