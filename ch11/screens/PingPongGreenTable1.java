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
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Color;
import engine.PingPongGameEngine1;

/**
 * 
 * 这个类负责绘制绿色的乒乓球桌，球拍，鼠标点击会显示坐标
 * 
 */
public class PingPongGreenTable1 extends JPanel implements GameConstants1 {
	JLabel label;
	public Point point = new Point(0, 0);

	public int ComputerRacket_X = 15;
	private int kidRacket_Y = KID_RACKET_Y_START;

	Dimension preferredSize = new Dimension(TABLE_WIDTH, TABLE_HEIGHT);

	// 这个方法会被JVM调用来设置窗口框架的大小
	public Dimension getPreferredSize() {
		return preferredSize;
	}

	// 构造方法。创建并添加各种事件
	PingPongGreenTable1() {

		PingPongGameEngine1 gameEngine = new PingPongGameEngine1(this);
		// 监听鼠标的点击并显示点击坐标
		addMouseListener(gameEngine);
		// 监听鼠标移动，让球拍随之移动
		addMouseMotionListener(gameEngine);
	}

	// 把当前的面板和一个提示标签添加到窗口框架中
	void addPaneltoFrame(Container container) {
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(this);
		label = new JLabel("点击显示该点坐标");
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
		g.fillRect(KID_RACKET_X_START, kidRacket_Y, 5, 30);

		// 绘制左边电脑的蓝色球拍
		g.setColor(Color.blue);
		g.fillRect(ComputerRacket_X, 100, 5, 30);

		// 绘制红色小球
		g.setColor(Color.red);
		g.fillOval(25, 110, 10, 10);

		// 绘制四周和中间的白线
		g.setColor(Color.white);
		g.drawRect(10, 10, 300, 200);
		g.drawLine(160, 10, 160, 210);

		// 显示一点2×2像素大小的矩形小点
		if (point != null) {
			label.setText("Coordinates (x,y): " + point.x + ", " + point.y);
			g.fillRect(point.x, point.y, 2, 2);
		}
	}

	/**
	 * 设置小孩球拍的Y坐标
	 * 
	 * @param yCoordinate
	 *            从球桌顶部开始向下算，单位是像素
	 */
	public void setKidRacket_Y(int xCoordinate) {
		this.kidRacket_Y = xCoordinate;
	}

	/**
	 * 获取小孩球拍的Y坐标
	 * 
	 * @return
	 */
	public int getKidRacket_Y(int xCoordinate) {
		return kidRacket_Y;
	}

	public static void main(String[] args) {
		// 创建窗口框架实例
		JFrame f = new JFrame("乒乓球游戏");
		// 设置点击窗口右上角的关闭按钮可退出
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		PingPongGreenTable1 table = new PingPongGreenTable1();
		table.addPaneltoFrame(f.getContentPane());

		// 自适应尺寸和显示窗口
		f.pack();
		f.setVisible(true);
	}
}
