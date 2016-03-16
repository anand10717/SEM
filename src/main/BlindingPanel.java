package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlindingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JTextField filePathField = new JTextField();
	JButton copyFile = new JButton("Copy file");
	JButton browse = new JButton("Browse");
	JLabel path = new JLabel("");
	int xAdjust = 100, yAdjust = xAdjust;

	public BlindingPanel() {
		setLayout(null);
		filePathField.setBounds(xAdjust + 100, yAdjust + 100, 300, 30);
		browse.setBounds(xAdjust + 410, yAdjust + 100, 150, 30);
		copyFile.setBounds(xAdjust + 275, yAdjust + 190, 125, 30);

		add(filePathField);
		add(browse);
		add(copyFile);

		browse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onBrowseClick();
			}

		});

		copyFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onCopyFileClick();
			}

		});

		setVisible(true);
	}

	private void onCopyFileClick() {
		String sourceFile = filePathField.getText().toString();

		// below is to copy file as it is (with same name and format)
		// File file = new File(sourceFile);
		// String dest = ( (FolderDetails) DB.readObject(new
		// FolderDetails())).getDestinationFileFullPath() + file.getName();

		// below line uses file name message.txt

		String dest = ((FolderDetails) DB.readObject(new FolderDetails())).getDestinationFileFullPath()
				+ Constants.BLIND_FILE_NAME;

		FileCopier.copy(sourceFile, dest);
	}

	private void onBrowseClick() {
		FileChooserDialog chooserDialog = new FileChooserDialog(this);
		chooserDialog.show(new FolderCreateListener() {
			@Override
			public void onFolderCreated(String folderPath) {
				filePathField.setText(folderPath);
			}

			@Override
			public void onFolderCreateCancelled() {

			}
		});
	}

}
