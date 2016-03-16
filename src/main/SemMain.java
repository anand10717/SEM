package main;

import javax.swing.UIManager;

public class SemMain {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BaseFrame baseFrame = new BaseFrame();
		baseFrame.setVisible(true);
	}

}
