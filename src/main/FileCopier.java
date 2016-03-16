package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopier {

	public static void copy(String sourceFilePath, String dest) {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		File destFile =  new File(dest);
		
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
				System.out.println("Destination file doesn't exist. Creating one!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		try {
			in = new FileInputStream(sourceFilePath);
			out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];
	        int length;
	        while ((length = in.read(buffer)) > 0) {
	            out.write(buffer, 0, length);
	        }
			
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}