/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator {
	
	// 声明并创建所有的窗口控件
	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton buttonPoint = new JButton(".");
	JButton buttonEqual = new JButton("=");
	JButton buttonPlus = new JButton("+");
	JButton buttonMinus = new JButton("-");
	JButton buttonDivide = new JButton("/");
	JButton buttonMultiply = new JButton("*");
	JPanel windowContent = new JPanel();
	JTextField displayField = new JTextField(30);

	// 构造方法
	Calculator() {
		
		//为这个面板设置边框布局
		BorderLayout bl = new BorderLayout();
		windowContent.setLayout(bl);

		//把文本框放到窗口的顶部
		windowContent.add(BorderLayout.NORTH, displayField);

		//创建一个布局为GridLayout的面板, 它可以容纳12个按钮: 10个数字，一个小数点和一个等号
		JPanel p1 = new JPanel();
		GridLayout gl = new GridLayout(4, 3);
		p1.setLayout(gl);

		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(button4);
		p1.add(button5);
		p1.add(button6);
		p1.add(button7);
		p1.add(button8);
		p1.add(button9);
		p1.add(button0);
		p1.add(buttonPoint);
		p1.add(buttonEqual);

		//把面板p1添加到窗口的中间区域。
		windowContent.add(BorderLayout.CENTER, p1);
		
		//创建同样GridLayout布局的面板p2, 把加减乘除四个按钮添加到上面
		JPanel p2 = new JPanel();
		GridLayout gl2 = new GridLayout(4, 1);
		p2.setLayout(gl2);
		p2.add(buttonPlus);
		p2.add(buttonMinus);
		p2.add(buttonMultiply);
		p2.add(buttonDivide);

		//把面板p2添加到窗口的右边
		windowContent.add(BorderLayout.EAST, p2);

		//创建窗口框架，把内容面板添加到上面
		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(windowContent);

		// 设置窗口自适应大小
		frame.pack();

		// 显示它
		frame.setVisible(true);

		// 初始化按钮的点击事件监听器，并把它添加到每个按钮上面
		CalculatorEngine calcEngine = new CalculatorEngine(this);

		button0.addActionListener(calcEngine);
		button1.addActionListener(calcEngine);
		button2.addActionListener(calcEngine);
		button3.addActionListener(calcEngine);
		button4.addActionListener(calcEngine);
		button5.addActionListener(calcEngine);
		button6.addActionListener(calcEngine);
		button7.addActionListener(calcEngine);
		button8.addActionListener(calcEngine);
		button9.addActionListener(calcEngine);

		buttonPoint.addActionListener(calcEngine);
		buttonPlus.addActionListener(calcEngine);
		buttonMinus.addActionListener(calcEngine);
		buttonDivide.addActionListener(calcEngine);
		buttonMultiply.addActionListener(calcEngine);
		buttonEqual.addActionListener(calcEngine);
	}

	public static void main(String[] args) {
		//初始化Calculator这个类
		Calculator calc = new Calculator();
	}
}
