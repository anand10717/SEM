package main;

public abstract class FolderCreateListener {
	public abstract void onFolderCreated(String folderPath);
	public abstract void onFolderCreateCancelled();
}