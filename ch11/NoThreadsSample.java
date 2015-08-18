/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoThreadsSample extends JFrame implements ActionListener {

	
	//构造方法
	NoThreadsSample() {
		// 创建一个有一个按钮和一个输入文本框的窗口
		GridLayout gl = new GridLayout(2, 1);
		this.getContentPane().setLayout(gl);
		JButton myButton = new JButton("Kill Time");
		myButton.addActionListener(this);
		this.getContentPane().add(myButton);
		this.getContentPane().add(new JTextField());
	}

	// 处理按钮点击
	public void actionPerformed(ActionEvent e) {
		// 消耗一些时间去阻塞窗口的控件
		for (int i = 0; i < 30000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			this.setTitle("i=" + i);
		}
	}

	public static void main(String[] args) {
		NoThreadsSample myWindow = new NoThreadsSample();
		myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		myWindow.setBounds(0, 0, 150, 100);
		myWindow.setVisible(true);
	}
}
