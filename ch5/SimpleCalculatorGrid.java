/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import javax.swing.*;
import java.awt.GridLayout;

public class SimpleCalculatorGrid {
	public static void main(String[] args) {
		// 创建一个面板
		JPanel windowContent = new JPanel();
		// 为这个面板指定一个布局管理器
		GridLayout gl = new GridLayout(4, 2);
		windowContent.setLayout(gl);
		// 创建各种控件
		JLabel label1 = new JLabel("Number 1:");
		JTextField field1 = new JTextField(10);
		JLabel label2 = new JLabel("Number 2:");
		JTextField field2 = new JTextField(10);
		JLabel label3 = new JLabel("Sum:");
		JTextField result = new JTextField(10);
		JButton go = new JButton("Add");
		// 把控件们添加到面板中
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(result);
		windowContent.add(go);
		// 创建窗口框架并把面板添加到上面
		JFrame frame = new JFrame("My First Calculator");
		frame.setContentPane(windowContent);
		// 设置窗口的大小并显示它
		// frame.pack();
		frame.setSize(400, 100);
		frame.setVisible(true);
	}
}