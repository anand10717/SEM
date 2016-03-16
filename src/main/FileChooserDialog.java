package main;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileChooserDialog {

	private JPanel frame;
	private File file = new File(".");

	public FileChooserDialog(JPanel frame) {
		this.frame = frame;
		frame.setEnabled(false);
	}

	public FileChooserDialog(JPanel frame, File file) {
		this.frame = frame;
		this.file = file;
		frame.setEnabled(false);
	}

	@SuppressWarnings("deprecation")
	public void show(FolderCreateListener createListener) {

		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(file);
		chooser.setDialogTitle("Choose Folder");
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
