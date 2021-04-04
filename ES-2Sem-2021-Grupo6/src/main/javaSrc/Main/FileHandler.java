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
	private static int locmSumTotal; //MUDAR PARA NUMERO DE PACKAGES
	private static int cycloSumTotal; //MUDAR PARA NUMERO DE CLASSES

	
	public static int getNomSumTotal() {
		return nomSumTotal;
	}


	public static int getLocSumTotal() {
		return locSumTotal;
	}


	public static int getLocmSumTotal() {
		return locmSumTotal;
	}


	public static int getCycloSumTotal() {
		return cycloSumTotal;
	}


	public static void handler (String path) throws IOException {
		File root = new File(path);
		File[] list = root.listFiles();
		App app = new App(path);
		
		for (File f: list) {
			if (f.isDirectory()) {
				handler( f.getAbsolutePath());
			}
			else if (f.getPath().endsWith(".java")) {
				Main main = new Main();
				main.main(f.getAbsolutePath());
				nomSumTotal+=main.getNomSum();
				locSumTotal+=main.getLocSum();
				
				
			}
		}
		
	}
	
	
	
	
}
