package ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import metrics.CYCLO_Method;
import metrics.LOC_class;
import metrics.MethodsHandler;

public class FileHandler {

	
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
				
			}
		}
	}
	
	
	
	
}
