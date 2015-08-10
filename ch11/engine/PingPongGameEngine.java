package engine;

/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import screens.*;

/**
 * 
 * 这个类是是鼠标和键盘的监听处理类。它负责计算球和拍的移动，改变它们的坐标。
 *
 */
public class PingPongGameEngine implements Runnable, MouseMotionListener,
		KeyListener, GameConstants {

	private PingPongGreenTable table;// 球桌对象的引用
	private int kidRacket_Y = KID_RACKET_Y_START;
	private int computerRacket_Y = COMPUTER_RACKET_Y_START;
	private int kidScore;
	private int computerScore;
	private int ballX;  // 小球的X坐标
	private int ballY;  // 小球的Y坐标
	private  boolean movingLeft = true; //true为向左移动，false为向右移动
	
	private volatile boolean ballServed = false;  

	// 球在垂直方向的移动分量
	private int verticalSlide;

	// 带参数的构造方法，参数为球桌对象
	public PingPongGameEngine(PingPongGreenTable greenTable) {
		table = greenTable;
		
		//创建和开启小球和电脑球拍的移动线程
		Thread worker = new Thread(this);
		worker.start();
	}

	//MouseMotionListener接口中的方法(接口中的方法必须覆盖，即使是个空方法)
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	//鼠标移动时会被JVM调用这个方法
	@Override
	public void mouseMoved(MouseEvent e) {

		int mouse_Y = e.getY();

		// 如果鼠标在小孩的球拍之上并且没有超过球桌的顶部，那就让球拍向上移动，反之向下
		if (mouse_Y < kidRacket_Y && kidRacket_Y > TABLE_TOP) {
			kidRacket_Y -= RACKET_INCREMENT;
		} else if (kidRacket_Y < TABLE_BOTTOM) {
			kidRacket_Y += RACKET_INCREMENT;
		}

		// 设置小孩球拍新的Y坐标
		table.setKidRacket_Y(kidRacket_Y);
	}

	 //键盘按下时会被JVM调用这个方法
	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		if ('n' == key || 'N' == key) {
			startNewGame();
		} else if ('q' == key || 'Q' == key) {
			endGame();
		} else if ('s' == key || 'S' == key) {
			kidServe();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * 重置分数，开始新游戏
	 */
	public void startNewGame() {
		computerScore = 0;
		kidScore = 0;
		table.setMessageText("Score Computer: 0  Kid: 0");
		kidServe();
	}

	
	/**
	 * 退出程序
	 */
	public void endGame() {
		System.exit(0);
	}

	/**
	 * Runnable 接口的方法，会在线程开启之后被调用
	 */
	@Override
	public void run() {

		boolean canBounce = false; //是否往回弹
		
		while (true) {

			if (ballServed) { //球是否在运动

				//第1步：球是否向左边移动
				if (movingLeft && ballX > BALL_MIN_X) {

					//是否能击中小球
					canBounce = computerRacket_Y <= ballY && ballY < (computerRacket_Y + RACKET_LENGTH) ? true: false;
					
					//加上水平移动分量
					ballX -= BALL_INCREMENT;
					
					// 加上垂直移动分量
					ballY -= verticalSlide;

					table.setBallPosition(ballX, ballY);
					
					//已经到了对面，能击中小球？
					if (ballX <= COMPUTER_RACKET_X && canBounce) {
						movingLeft = false;
					}
				}

				//第2步：球是否向右边移动
				if (!movingLeft && ballX <= BALL_MAX_X) {
					
					canBounce = ballY >= kidRacket_Y&& ballY < (kidRacket_Y + RACKET_LENGTH) ? true: false;
					
					ballX += BALL_INCREMENT;
					table.setBallPosition(ballX, ballY);
					if (ballX >= KID_RACKET_X && canBounce) {
						movingLeft = true;
					}
				}

				// 第3步：上或下移动电脑球拍去击球
				if (computerRacket_Y < ballY && computerRacket_Y < TABLE_BOTTOM) {
					computerRacket_Y += RACKET_INCREMENT;
				} else if (computerRacket_Y > TABLE_TOP) {
					computerRacket_Y -= RACKET_INCREMENT;
				}
				table.setComputerRacket_Y(computerRacket_Y);

				// 第4步: 让线程睡一下，这样小球可以移动地慢些
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// 第5步: 如果球还在球桌内，并且不再移动了，就显示分数
				if (isBallOnTheTable()) {
					if (ballX > BALL_MAX_X) {
						computerScore++;
						displayScore();
					} else if (ballX < BALL_MIN_X) {
						kidScore++;
						displayScore();
					}
				}
			} 
		} 
	}

	// 小孩发球
	private void kidServe() {

		ballServed = true;
		ballX = KID_RACKET_X - 1;
		ballY = kidRacket_Y;

		if (ballY > TABLE_HEIGHT / 2) {
			verticalSlide = -1;
		} else {
			verticalSlide = 1;
		}

		table.setBallPosition(ballX, ballY);
		table.setKidRacket_Y(kidRacket_Y);
	}

	private void displayScore() {
		ballServed = false;

		if (computerScore == WINNING_SCORE) {
			table.setMessageText("Computer won! " + computerScore + ":"+ kidScore);
		} else if (kidScore == WINNING_SCORE) {
			table.setMessageText("You won! " + kidScore + ":" + computerScore);
		} else {
			table.setMessageText("Computer: " + computerScore + " Kid: "+ kidScore);
		}
	}

	/**
	 * 检查球是否还在球桌上
	 * @return 如果还在球桌范围，返回true; 否则返回false
	 */
	private boolean isBallOnTheTable() {
		if (ballY >= BALL_MIN_Y && ballY <= BALL_MAX_Y) {
			return true;
		} else {
			return false;
		}
	}
}
