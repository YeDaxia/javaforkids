/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {

	Calculator parent;  // Calculator对象的引用
	char selectedAction = ' '; // +, -, /, or *

	double currentResult = 0;

	// 通过构造方法传入计算器的窗口对象，并用成员变量parent来存储这个对象。
	CalculatorEngine(Calculator parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {

		// 获取动作源
		JButton clickedButton = (JButton) e.getSource();
		String dispFieldText = parent.displayField.getText();

		double displayValue = 0;

		// 把文本框中的字符串不为空，就转化成数字
		if (!"".equals(dispFieldText)) {
			displayValue = Double.parseDouble(dispFieldText);
		}
		
		Object src = e.getSource();

		//如果点击的是运算按钮，则把文本框的值存到currentResult中，用selectedAction来存储运算的类型，并把文本框清空
		if (src == parent.buttonPlus) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMinus) {
			selectedAction = '-';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonDivide) {
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMultiply) {
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonEqual) {
			// 点击的是等号，则用上一次的值currentResult和selectedAction的运算类型进行运算，
			// 把结果存到currentResult, 并显示在文本框中。
			if (selectedAction == '+') {
				currentResult += displayValue;
				//把数字类型转化成字符串，并显示到文本框中
				parent.displayField.setText(String.valueOf(currentResult) );
			} else if (selectedAction == '-') {
				currentResult -= displayValue;
				parent.displayField.setText(String.valueOf(currentResult));
			} else if (selectedAction == '/') {
				currentResult /= displayValue;
				parent.displayField.setText(String.valueOf(currentResult));
			} else if (selectedAction == '*') {
				currentResult *= displayValue;
				parent.displayField.setText(String.valueOf(currentResult));
			}
		} else {
			// 如果点击的是数字按钮，则直接叠加显示到文本框中。
			String clickedButtonLabel = clickedButton.getText();
			parent.displayField.setText(dispFieldText + clickedButtonLabel);
		}
	}
}
