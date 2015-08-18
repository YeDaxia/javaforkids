package screens;

/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Color;
import engine.PingPongGameEngine;


/**
 *
 * 这个类负责绘制绿色的乒乓球桌，球拍和显示分数
 *
 */
public class PingPongGreenTable extends JPanel implements GameConstants {
	private JLabel label;

	private int computerRacket_Y = COMPUTER_RACKET_Y_START;
	private int kidRacket_Y = KID_RACKET_Y_START;
	private int ballX = BALL_START_X;
	private int ballY = BALL_START_Y;

	Dimension preferredSize = new Dimension(TABLE_WIDTH, TABLE_HEIGHT);

	//这个方法会被JVM调用来设置窗口框架的大小
	@Override
	public Dimension getPreferredSize() {
		return preferredSize;
	}

	// 构造方法。创建并添加各种事件
	PingPongGreenTable() {
		PingPongGameEngine gameEngine = new PingPongGameEngine(this);
		// 添加鼠标移动事件
		addMouseMotionListener(gameEngine);
		// 添加键盘事件
		addKeyListener(gameEngine);
	}

	// 把当前的面板和一个提示标签添加到窗口框架中
	void addPaneltoFrame(Container container) {
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(this);
		label = new JLabel("按下N键开始新游戏，S键开球，Q键退出。");
		container.add(label);
	}

	// 重绘窗口。当刷新屏幕或者调用repaint()的时候会被JVM调用
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.GREEN);
		// 绘制绿色的球桌
		g.fillRect(0, 0, TABLE_WIDTH, TABLE_HEIGHT);

		// 绘制右边小孩的黄色球拍
		g.setColor(Color.yellow);
		g.fillRect(KID_RACKET_X, kidRacket_Y, RACKET_WIDTH, RACKET_LENGTH);
		
		// 绘制左边电脑的蓝色球拍
		g.setColor(Color.blue);
		g.fillRect(COMPUTER_RACKET_X, computerRacket_Y, RACKET_WIDTH,RACKET_LENGTH);
		
		// 绘制小球
		g.setColor(Color.red);
		g.fillOval(ballX, ballY, 10, 10);
		
		// 绘制四周和中间的白线
		g.setColor(Color.white);
		g.drawRect(10, 10, 300, 200);
		g.drawLine(160, 10, 160, 210);
		
		// 设置面板的状态为focus, 这样键盘事件才会传递到这个面板上
		requestFocus();
	}

	/**
	 * 设置小孩球拍的Y坐标
	 * @param yCoordinate 从球桌顶部开始向下算，单位是像素
	 */
	public void setKidRacket_Y(int yCoordinate) {
		this.kidRacket_Y = yCoordinate;
		repaint();
	}

	/**
	 * 获取小孩球拍的Y坐标
	 * @return
	 */
	public int getKidRacket_Y() {
		return kidRacket_Y;
	}

	/**
	 * 设置电脑球拍的Y坐标
	 * @param yCoordinate 从球桌顶部开始向下算，单位是像素
	 */
	public void setComputerRacket_Y(int yCoordinate) {
		this.computerRacket_Y = yCoordinate;
		repaint();
	}

	/**
	 * 设置在面板下面的游戏消息提示。
	 * @param text
	 */
	public void setMessageText(String text) {
		label.setText(text);
		repaint();
	}

	/**
	 * 设置球在球桌上的坐标
	 * @param xPos 从球桌左边开始向右算，单位是像素
	 * @param yPos 从球桌顶部开始向下算，单位是像素
	 */
	public void setBallPosition(int xPos, int yPos) {
		ballX = xPos;
		ballY = yPos;
		repaint();
	}

	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {

		// 创建窗口框架实例
		JFrame f = new JFrame("乒乓球游戏");

		PingPongGreenTable table = new PingPongGreenTable();
		table.addPaneltoFrame(f.getContentPane());

		// 设置窗口大小
		f.setBounds(0, 0, TABLE_WIDTH + 5, TABLE_HEIGHT + 40);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
