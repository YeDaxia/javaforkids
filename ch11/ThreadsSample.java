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

public class ThreadsSample extends JFrame implements ActionListener, Runnable {

	ThreadsSample() {
		GridLayout gl = new GridLayout(2, 1);
		this.getContentPane().setLayout(gl);
		JButton myButton = new JButton("Kill Time");
		myButton.addActionListener(this);
		this.getContentPane().add(myButton);
		this.getContentPane().add(new JTextField());
	}

	public void actionPerformed(ActionEvent e) {
		//创建一个线程去执行消耗时间的代码，让窗口处于可活动状态
		Thread worker = new Thread(this);
		worker.start(); // 开启线程，它会执行run里面的代码
	}

	public void run() {
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

		ThreadsSample myWindow = new ThreadsSample();
		myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		myWindow.setBounds(0, 0, 150, 100);
		myWindow.setVisible(true);
	}
}
