package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Metrics.Result;

public class FileHandler {

	private static int nomSumTotal;
	private static int locSumTotal;
	private static int package_total = 0;
	private static int class_total;
	private static ArrayList<Result> result = new ArrayList<Result>();
	private static ArrayList<String> lastpkg = new ArrayList<String>();

	public FileHandler(String path) {
		try {
			App app = new App(path, handler(path));
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
		}
	}

	// directory explorer
	public static ArrayList<Result> handler(String path)
			throws IOException, EncryptedDocumentException, InvalidFormatException {
		File root = new File(path);
		File[] list = root.listFiles();

		for (File f : list) {
			if (f.isDirectory()) { // opens a new handler for new directory
				handler(f.getAbsolutePath());
			} else if (f.getPath().endsWith(".java")) { // only searches for .java files and starts a main for each
														// class
				Main main = new Main();
				main.main(f.getAbsolutePath());
				nomSumTotal += main.getNomSum();
				locSumTotal += main.getLocSum();
				if (!lastpkg.contains(main.getPackage()) && main.getPackage()!=(null)) {
					lastpkg.add(main.getPackage());
					package_total++;
					System.out.println("###################### CLASSE: " +main.getClassName());
					System.out.println("###################### PACKAGE: " + main.getPackage());
					System.out.println("##################### NUMORO: " + package_total);
				}
				result.addAll(main.getResults());
			}
		}
		return result;

	}

	// get total of methods in a file
	public static int getNomSumTotal() {
		return nomSumTotal;
	}

	// get total of lines in a file
	public static int getLocSumTotal() {
		return locSumTotal;
	}

	// get total of packages in a file
	public static int getPackageTotal() {
		return package_total;
	}

	// get total of classes in a file
	public static int getClassTotal() {
		return class_total;
	}
}
