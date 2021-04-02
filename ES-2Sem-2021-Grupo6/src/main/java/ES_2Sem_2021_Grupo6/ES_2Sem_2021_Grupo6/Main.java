package ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import metrics.*;


public class Main {
	
	private static final String JAVA_PATH = "C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles\\src\\com\\jasml\\compiler\\GrammerException.java";
	private static final String FILE_PATH = "C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles";
	
	//private static ArrayList<Result> results = new ArrayList<>();
	
	

	
	static void main (String path) {
		CYCLO_Method cm = new CYCLO_Method();
		LOC_class lc = new LOC_class();
		MethodsHandler mh = new MethodsHandler();
		try {
			cm.countCyclo(path);
			lc.countLines(path);
			mh.countMethods(path);
			for(int i = 0; i < mh.getPair().size(); i++) {
				//String namePackage = 
				String nameCLass = lc.nameClass();
				String nameMethod = mh.getPair().get(i).a;
				int nom = mh.getPair().size();
				int loc = lc.getLines().size();
				int locm = mh.getPair().get(i).b;
				int cyclo = cm.getNCycles().get(i);
				//Result result = new Result(namePackage, nameClass, nameMethod, nom, loc, locm, cyclo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * public static ArrayList<Result> getResults(){
	 * 		return results;
	 * }
	 * 
	 * 
	 * 
	 * 
	 * */
	 
	
}
