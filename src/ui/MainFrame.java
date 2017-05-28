package ui;
import javax.swing.JFrame;
import javax.swing.JPanel;

import util.DBUtils;

public class MainFrame extends JFrame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBUtils.connectToDatabase();
		new MainFrame();
	}

	public MainFrame() {
		JPanel panel = new MyPanel();
		this.add(panel);
		this.setTitle("Car Sales System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 550);
		setVisible(true);
		
	
		
		
	}
	
	
}


