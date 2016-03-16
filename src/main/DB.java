package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DB {

	static String path = "D:\\ComputerScience\\Java\\Workspace\\SEM Client\\";
	
	public static void saveObject(Object object) {
		try {
			
			File file = new File(path);
			
			if (!file.exists()) {
				file.mkdirs();
			}
			
			FileOutputStream fout = new FileOutputStream(path + object.getClass().getSimpleName() + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(object);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object readObject(Object object) {
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(path + object.getClass().getSimpleName() + ".ser"));
			Object object2 = in.readObject();
			in.close();
			return object2;
		} catch (Exception e) {
		}
		return null;
	}

}
