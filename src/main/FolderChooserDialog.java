package main;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FolderChooserDialog {
	
	JPanel frame;
	
	public FolderChooserDialog (JPanel frame) {
		this.frame = frame;
		frame.setEnabled(false);
	}
	
	@SuppressWarnings("deprecation")
	public void show(FolderCreateListener createListener) {
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Choose Folder");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			frame.show();
			frame.setEnabled(true);
			createListener.onFolderCreated(chooser.getSelectedFile().toString());
		} else {
			frame.show();
			frame.setEnabled(true);
			createListener.onFolderCreateCancelled();
		}
		
	}

}
