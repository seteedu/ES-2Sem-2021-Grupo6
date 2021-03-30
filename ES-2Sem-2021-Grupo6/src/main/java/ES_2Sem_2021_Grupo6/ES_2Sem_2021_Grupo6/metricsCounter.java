package ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6;

import java.lang.reflect.Method;
import java.io.File;

public class metricsCounter {
	
	public static void main(String args[]) {
		
		 File dir = new File("C:\\Users\\hugof\\git\\ES-2Sem-2021-Grupo6");
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {
		    	if(child.getPath().endsWith(".java"))
		    	System.out.println(child.getName());
		    }
		
		try {
			Class cls = Class.forName("ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6.App");
			int Mcount=0,MthdLen=0;
			System.out.println(cls.getName());
			 Method methlist[]= cls.getDeclaredMethods();
			 
			 for (int i = 0; i < methlist.length;i++){  
	               Method m = methlist[i];
	               Mcount = Mcount + 1;
	               System.out.println("Name = " + m.getName());
	            }
			 System.out.println("Mcount = " + Mcount);
		        
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		  }
		  }
}
		
