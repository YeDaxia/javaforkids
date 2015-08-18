package engine;

/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import screens.*;

public class PingPongGameEngine1 implements MouseListener, MouseMotionListener,
		GameConstants1 {

	PingPongGreenTable1 table;
	public int kidRacket_Y = KID_RACKET_Y_START;

	public PingPongGameEngine1(PingPongGreenTable1 greenTable) {
		table = greenTable;
	}

	/**
	 * 按下鼠标的是否JVM会回调这个方法
	 */
	public void mousePressed(MouseEvent e) {
		// 获取鼠标按下时的坐标，并设置到table对象中，对应的就是table中的白点。
		table.point.x = e.getX();
		table.point.y = e.getY();
		// 调用这个方法会触发table的paintComponent()去刷新窗口
		table.repaint();
	}

	public void mouseReleased(MouseEvent e) {
	};

	public void mouseEntered(MouseEvent e) {
	};

	public void mouseExited(MouseEvent e) {
	};

	public void mouseClicked(MouseEvent e) {
	};

	// Methods required by the MouseMotionListener interface
	public void mouseDragged(MouseEvent e) {
	}

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
		table.repaint();
	}
}
