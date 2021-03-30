package ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6;
import java.io.File;
import java.io.IOException;

public class FileExplorer {
	
	public static void main(String... args) throws IOException {
        File dir = new File("C:\\Users\\hugof\\git\\ES-2Sem-2021-Grupo6");
        showFiles(dir.listFiles());
    }
	
	public static void showFiles(File[] files) throws IOException {
        for (File file : files) {
            if (file.isDirectory()) {
            	 System.out.println("Directory: " + file.getName());
                //System.out.println("Directory: " + file.getAbsolutePath());
                showFiles(file.listFiles()); // Calls same method again.
            } else {
            	if(file.getPath().endsWith(".java"))
                System.out.println("File: " + file.getName());
            }
        }
	}

}
