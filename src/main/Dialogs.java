package main;

import javax.swing.JOptionPane;

public class Dialogs {

	public static void success(String message) {
		JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
