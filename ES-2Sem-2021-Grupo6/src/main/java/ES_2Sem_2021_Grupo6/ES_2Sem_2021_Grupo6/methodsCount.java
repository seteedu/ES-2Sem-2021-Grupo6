package ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6;

import java.io.File;
import java.lang.reflect.Method;

import com.google.common.base.Strings;

public class methodsCount {
	
	public static void listMethods(File projectDir) {
            try {
    			Class cls = Class.forName("ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6.App");
    			int Mcount=0;
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
	
	 public static void main(String[] args) {
	        File projectDir = new File("C:\\Users\\hugof\\git\\ES-2Sem-2021-Grupo6\\ES-2Sem-2021-Grupo6\\src\\main\\java\\ES_2Sem_2021_Grupo6\\ES_2Sem_2021_Grupo6");
	        listMethods(projectDir);
	    }

}
