package main;

import java.io.File;
import java.io.Serializable;

public class FolderDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private String folderPath;
	private String folderName;

	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public FolderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FolderDetails(String folderPath, String folderName) {
		super();
		this.folderPath = folderPath;
		this.folderName = folderName;
	}

	public String getDestinationFileFullPath() {
		return folderPath + File.separator + folderName + File.separator ;
	}

}
