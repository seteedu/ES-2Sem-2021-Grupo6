package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import GUI.MetricMenu;
import Metrics.CYCLO_Method;
import Metrics.LOC_class;
import Metrics.MethodsHandler;

public class FileHandler {
	
	private static int nomSumTotal;
	private static int locSumTotal;
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


	public static void handler (String path) throws IOException {
		File root = new File(path);
		File[] list = root.listFiles();
		App app = new App(path);
		
		for (File f: list) {
			if (f.isDirectory()) {
				handler( f.getAbsolutePath());
				package_total++;
			}
			else if (f.getPath().endsWith(".java")) {
				Main main = new Main();
				main.main(f.getAbsolutePath());
				nomSumTotal+=main.getNomSum();
				locSumTotal+=main.getLocSum();
				class_total++;
			}
		}
		
	}
	
	
	
	
}
