package ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6;


import java.io.IOException;

import metrics.*;


public class Main {
	
	private static final String JAVA_PATH = "C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles\\src\\com\\jasml\\compiler\\GrammerException.java";
	private static final String FILE_PATH = "C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles";
	
	
	private static void main (String[] args) {
		try {
			App app = new App(FILE_PATH);
			CYCLO_Method cm = new CYCLO_Method();
			cm.countCyclo(JAVA_PATH);
			LOC_class lc = new LOC_class();
			lc.countLines(JAVA_PATH);
			MethodsHandler mh = new MethodsHandler();
			mh.countMethods(JAVA_PATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
