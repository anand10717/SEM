
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigurationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JTextField folderPathField = new JTextField();
	JButton createFolder = new JButton("Create Folder");
	JButton browse = new JButton("Browse");
	JTextField folderNameField = new JTextField();
	JLabel path = new JLabel("");
	int xAdjust = 100, yAdjust = xAdjust;
	FolderDetails details = new FolderDetails();
	
	
	public ConfigurationPanel() {
		setLayout(null);
		folderPathField.setBounds(xAdjust + 100, yAdjust + 100, 300, 30);
		folderNameField.setBounds(xAdjust + 200, yAdjust + 140, 200, 30);
		browse.setBounds(xAdjust + 410, yAdjust + 100, 150, 30);
		createFolder.setBounds(xAdjust + 275, yAdjust + 190, 125, 30);

		add(folderPathField);
		add(browse);
		add(createFolder);
		add(folderNameField);

		browse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onBrowseClick();
			}

		});

		createFolder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onCreateClick();
			}

		});

		setVisible(true);
		
		try {
			details = (FolderDetails) DB.readObject(details);
			if (details != null) {
				folderPathField.setText(details.getFolderPath());
				folderNameField.setText(details.getFolderName());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void onCreateClick() {
		FolderDetails details = new FolderDetails(folderPathField.getText().toString(),
				folderNameField.getText().toString());
		DB.saveObject(details);

		File dir = new File(details.getFolderPath() + File.separator + details.getFolderName());
		if (dir.mkdirs()) {
			Dialogs.success("Folder created successfully");
		}

	}

	private void onBrowseClick() {
		FolderChooserDialog chooserDialog = new FolderChooserDialog(this);
		chooserDialog.show(new FolderCreateListener() {
			@Override
			public void onFolderCreated(String folderPath) {
				folderPathField.setText(folderPath);
			}

			@Override
			public void onFolderCreateCancelled() {

			}
		});
	}

}
