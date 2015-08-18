/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import javax.swing.*;
import java.awt.FlowLayout;

public class SimpleCalculator {
	public static void main(String[] args) {
		// 创建一个面板
		JPanel windowContent = new JPanel();
		// 为这个面板设置一个布局管理器
		FlowLayout fl = new FlowLayout();
		windowContent.setLayout(fl);
		// 创建有关的控件
		JLabel label1 = new JLabel("Number 1:");
		JTextField field1 = new JTextField(10);
		JLabel label2 = new JLabel("Number 2:");
		JTextField field2 = new JTextField(10);
		JLabel label3 = new JLabel("Sum:");
		JTextField result = new JTextField(10);
		JButton go = new JButton("Add");
		//把这些控件添加到面板中
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(result);
		windowContent.add(go);
		// 创建一个窗口框架，并把面板添加到上面
		JFrame frame = new JFrame("My First Calculator");
		frame.setContentPane(windowContent);
		// 设置这个窗口的大小，并显示它
		frame.setSize(400, 100);
		frame.setVisible(true);
	}
}