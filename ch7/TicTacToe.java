/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 * 
 * A tic-tac-toe game on the 3x3 board
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JApplet implements ActionListener {

	JButton squares[];
	JButton newGameButton;
	JLabel score;
	int emptySquaresLeft = 9;

	/**
	 * applet 的init方法，相当于构造方法
	 */
	@Override
	public void init() {

		// 获取这个applet的窗口面板
		Container appletContent = this.getContentPane();

		//设置这个面板的布局管理器，背景颜色
		appletContent.setLayout(new BorderLayout());
		appletContent.setBackground(Color.CYAN);

		// 创建新游戏的按钮，并给它注册点击事件的监听器
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);

		JPanel topPanel = new JPanel();
		topPanel.add(newGameButton);

		appletContent.add(topPanel, BorderLayout.NORTH);

		//中间的面板是个3*3的网格布局类型,当你往上面添加按钮时，就会从左往右，从上往下依次添加到面板中
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 3));
		appletContent.add(centerPanel, BorderLayout.CENTER);

		score = new JLabel("Your turn!");
		appletContent.add(score, BorderLayout.SOUTH);

		//创建JButton类型的数组，它负责存放各个按钮的引用
		squares = new JButton[9];

		// 创建游戏面板上那9个按钮，设置他们的背景为橙色，为它们注册事件，依次添加到面板上。
		for (int i = 0; i < 9; i++) {
			squares[i] = new JButton();
			squares[i].addActionListener(this);
			squares[i].setBackground(Color.ORANGE);
			centerPanel.add(squares[i]);
		}
	}

	/**
	 * 这个方法会处理所有的点击事件
	 * 
	 * @param ActionEvent
	 *            object
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton theButton = (JButton) e.getSource();
		
		//点击的是新游戏按钮
		if (theButton == newGameButton) {
			for (int i = 0; i < 9; i++) {
				squares[i].setEnabled(true);
				squares[i].setText("");
				squares[i].setBackground(Color.ORANGE);
			}

			emptySquaresLeft = 9;
			score.setText("Your turn!");
			newGameButton.setEnabled(false);

			return; //退出这个方法
		}

		String winner = "";
		//点击的是中间的方格按钮
		for (int i = 0; i < 9; i++) {
			if (theButton == squares[i]) {
				squares[i].setText("X");

				winner = lookForWinner();

				if (!"".equals(winner)) {
					endTheGame();
				} else {
					computerMove();
					winner = lookForWinner();
					if (!"".equals(winner)) {
						endTheGame();
					}
				}
				break;
			}
		} //循环结束

		
		if (winner.equals("X")) {
			score.setText("You won!");
		} else if (winner.equals("O")) {
			score.setText("You lost!");
		} else if (winner.equals("T")) {
			score.setText("It's a tie!"); //平局
		}
	} 

	/**
	 * 这个方法走一步之后都会被调用，它用于检查每行，每列，每个对角线是否出现相同的'O'或者'X'符号。如果有则表示一方赢了，然后高亮显示赢的结果。
	 * 
	 * @return "X", "O", "T" for tie or "" for no winner ‘X’代表玩家赢了，'O'代表计算机赢了，'T' 代表平局，""代表还没结束
	 */
	String lookForWinner() {

		String theWinner = "";
		emptySquaresLeft--;

		//没有空白格子了，平局
		if (emptySquaresLeft == 0) {
			return "T"; 
		}

		//检查第1行是否是相同的符号
		if (!squares[0].getText().equals("")
				&& squares[0].getText().equals(squares[1].getText())
				&& squares[0].getText().equals(squares[2].getText())) {

			theWinner = squares[0].getText();
			highlightWinner(0, 1, 2);
			
		//检查第2行
		} else if (!squares[3].getText().equals("")
				&& squares[3].getText().equals(squares[4].getText())
				&& squares[3].getText().equals(squares[5].getText())) {

			theWinner = squares[3].getText();
			highlightWinner(3, 4, 5);
			
		//检查第3行
		} else if (!squares[6].getText().equals("")
				&& squares[6].getText().equals(squares[7].getText())
				&& squares[6].getText().equals(squares[8].getText())) {

			theWinner = squares[6].getText();
			highlightWinner(6, 7, 8);
			
		//检查第1列
		} else if (!squares[0].getText().equals("")
				&& squares[0].getText().equals(squares[3].getText())
				&& squares[0].getText().equals(squares[6].getText())) {

			theWinner = squares[0].getText();
			highlightWinner(0, 3, 6);
			
		//检查第2列
		} else if (!squares[1].getText().equals("")
				&& squares[1].getText().equals(squares[4].getText())
				&& squares[1].getText().equals(squares[7].getText())) {

			theWinner = squares[1].getText();
			highlightWinner(1, 4, 7);
			
		//检查第3列
		} else if (!squares[2].getText().equals("")
				&& squares[2].getText().equals(squares[5].getText())
				&& squares[2].getText().equals(squares[8].getText())) {
			theWinner = squares[2].getText();
			highlightWinner(2, 5, 8);
			
		//检查对角线
		} else if (!squares[0].getText().equals("")
				&& squares[0].getText().equals(squares[4].getText())
				&& squares[0].getText().equals(squares[8].getText())) {

			theWinner = squares[0].getText();
			highlightWinner(0, 4, 8);
			
		} else if (!squares[2].getText().equals("")
				&& squares[2].getText().equals(squares[4].getText())
				&& squares[2].getText().equals(squares[6].getText())) {

			theWinner = squares[2].getText();
			highlightWinner(2, 4, 6);
		}
		return theWinner;
	}

	/**
	 * 这个方法负责用设定好的规则去找出最合适计算机的一步，如果没有找到，就随机选一个
	 */
	void computerMove() {

		int selectedSquare;

		// 第一步，试图找到同一条线上是否存在一个空方格连着两个'O'，如果有就意味着你输了
		selectedSquare = findEmptySquare("O");

		// 第二步，如果不存在连个相连的'O',，则找是否有空格之间存在两个连着的'X'，有的话就计算机就要去阻止它了。
		if (selectedSquare == -1)
			selectedSquare = findEmptySquare("X");

		//第三步，如果都没有，则看看中间是不是空的，是的话就填这个吧。
		if ((selectedSquare == -1) && (squares[4].getText().equals("")))
			selectedSquare = 4;

		//好吧，中间已经被占领了，那就随便选一个吧。
		if (selectedSquare == -1)
			selectedSquare = getRandomSquare();

		squares[selectedSquare].setText("O");
	}


	/**
	 *  这个方法会检查每行，每列，每一条对角线是否存在一个空格在两个和参数player相同符号间，如果有则返回这个空格的位置。
	 * @param player X是玩家，O是计算机
	 * @return  返回这个空格的位置，如果不存在，则返回-1
	 */
	int findEmptySquare(String player) {

		int weight[] = new int[9];
		
		//'O'的格子填-1, 'X'的格子填1,其他为0
		for (int i = 0; i < 9; i++) {
			if (squares[i].getText().equals("O"))
				weight[i] = -1;
			else if (squares[i].getText().equals("X"))
				weight[i] = 1;
			else
				weight[i] = 0;
		}

		//如果一条线上的值为2则表示有两个'O'在这条直线上，如果有两个'X'，则是-2
		int twoWeights = player.equals("O") ? -2 : 2;

		// 看看第1行是否存在空格连着两个相同符号的
		if (weight[0] + weight[1] + weight[2] == twoWeights) {
			if (weight[0] == 0)
				return 0;
			else if (weight[1] == 0)
				return 1;
			else
				return 2;
		}
		
		// 看看第2行
		if (weight[3] + weight[4] + weight[5] == twoWeights) {
			if (weight[3] == 0)
				return 3;
			else if (weight[4] == 0)
				return 4;
			else
				return 5;
		}
		
		// 看看第3行
		if (weight[6] + weight[7] + weight[8] == twoWeights) {
			if (weight[6] == 0)
				return 6;
			else if (weight[7] == 0)
				return 7;
			else
				return 8;
		}
		
		// 看看第1列
		if (weight[0] + weight[3] + weight[6] == twoWeights) {
			if (weight[0] == 0)
				return 0;
			else if (weight[3] == 0)
				return 3;
			else
				return 6;
		}
		
		// 看看第2列
		if (weight[1] + weight[4] + weight[7] == twoWeights) {
			if (weight[1] == 0)
				return 1;
			else if (weight[4] == 0)
				return 4;
			else
				return 7;
		}
		
		// 看看第3列
		if (weight[2] + weight[5] + weight[8] == twoWeights) {
			if (weight[2] == 0)
				return 2;
			else if (weight[5] == 0)
				return 5;
			else
				return 8;
		}
		
		//看看左上角到右下角的对角线
		if (weight[0] + weight[4] + weight[8] == twoWeights) {
			if (weight[0] == 0)
				return 0;
			else if (weight[4] == 0)
				return 4;
			else
				return 8;
		}
		
		//看看右上角到左下角的对角线
		if (weight[2] + weight[4] + weight[6] == twoWeights) {
			if (weight[2] == 0)
				return 2;
			else if (weight[4] == 0)
				return 4;
			else
				return 6;
		}
		
		// 没有就返回-1
		return -1;
	} 

	/**
	 *  随机产生0到9之间的数字, 而且这个数字所对应的方格还必须是空的
	 */
	int getRandomSquare() {
		boolean gotEmptySquare = false;
		int selectedSquare = -1;

		do {
			selectedSquare = (int) (Math.random() * 9);
			if (squares[selectedSquare].getText().equals("")) {
				gotEmptySquare = true; // 循环结束
			}
		} while (!gotEmptySquare);

		return selectedSquare;
	} 

	
	/**
	 *  这个方法负责高亮显示赢的那条路径
	 */
	void highlightWinner(int win1, int win2, int win3) {
		squares[win1].setBackground(Color.CYAN);
		squares[win2].setBackground(Color.CYAN);
		squares[win3].setBackground(Color.CYAN);
	}

	/**
	 * 禁用方格的所有按钮(点击无效)，让新游戏的按钮生效(可以点击)
	 */
	void endTheGame() {
		for (int i = 0; i < 9; i++) {
			squares[i].setEnabled(false);
		}

		newGameButton.setEnabled(true);
	}
}