package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Metrics.Result;

/**
 * 
 * Used in "ExtrairMetricasMenu" window to explore the folder given by the user
 *
 */
public class FileHandler {

	private static ArrayList<Result> result = new ArrayList<Result>();

	/**Constructor where it creates the excel file 
	 * 
	 * @param path	of the project given by the user
	 */
	public FileHandler(String path) {
		try {
			@SuppressWarnings("unused")
			App app = new App(path, handler(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	/**Explores each file and folder in the folder given by the user
	 * 
	 * @param path	path of the folder/java file to explore
	 * @return	an ArrayList with results gotten from parsed java files
	 * @throws IOException	throws an exception if it can't read the folder/file
	 */
	public ArrayList<Result> handler(String path)
			throws IOException {
		File root = new File(path);
		File[] list = root.listFiles();

		for (File f : list) {
			if (f.isDirectory()) { // opens a new handler for new directory
				handler(f.getAbsolutePath());
			} else if (f.getPath().endsWith(".java")) { // only searches for .java files and starts a main for each
														// class
				Main main = new Main();
				main.main(f.getAbsolutePath());
				result.addAll(main.getResults());
			}
		}
		return result;

	}
}
