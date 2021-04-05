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
	private static ArrayList<Result> result = new ArrayList<Result>();
	private static int package_total;
	private static int class_total;
	
	public static int getNomSumTotal() {
		return nomSumTotal;
	}

	public static int getLocSumTotal() {
		return locSumTotal;
	}

	public static int getPackageTotal() {
		return package_total;
	}


	public static int getClassTotal() {
		return class_total;
	}
	
	

	public static void handler(String path) throws IOException, EncryptedDocumentException, InvalidFormatException {
		File root = new File(path);
		File[] list = root.listFiles();
		App app = new App(path);

		for (File f : list) {
			if (f.isDirectory()) {
				handler(f.getAbsolutePath());
			} else if (f.getPath().endsWith(".java")) {
				Main main = new Main();
				main.main(f.getAbsolutePath());
				nomSumTotal += main.getNomSum();
				locSumTotal += main.getLocSum();
				result.addAll(main.getResults());
				System.out.println("Writing on app");
				app.ExcelHandler(main.getResults());
			}
		}

	}
}