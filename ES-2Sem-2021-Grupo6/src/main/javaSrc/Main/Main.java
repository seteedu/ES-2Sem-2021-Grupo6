package Main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Metrics.*;

public class Main {

	private ArrayList<Result> results = new ArrayList<>(); // array that transports the lines for excel
	private int nomSum; // total of methods in a class
	private int locSum; // total of lines in a class
	private int wmcSum; // total of complexity in a class
	private int total_class;
	private String pkg;
	private String classe;

	public void main(String path) {
		MethodsHandler mh = new MethodsHandler();
		LOC_class lc = new LOC_class();
		CYCLO_Method cm = new CYCLO_Method();
		try {
			if (lc.countLines(path) > 0) {
				System.out.println("%%%%%%%%%%%%%%% : " +lc.getNameClass());
				classe = lc.getNameClass();
				pkg = lc.getNamePackage();
				locSum = lc.countLines(path);
				cm.countCyclo(path);
				for (Integer c : cm.getNCycles()) {
					wmcSum += c;
				}
				mh.countMethods(path);
				nomSum = mh.getPair().size();
				
				if (mh.getPair().size() == 0) { // exceção caso a classe não contenha métodos
				String namePackage = lc.getNamePackage();
				String nameClass = lc.getNameClass();
				String nameMethod = null;
				int nom = mh.getPair().size();
				int loc = locSum;
				int locm = 0;
				int cyclo = 0;
				Result result = new Result(namePackage, nameClass, nameMethod, nom, loc, locm, wmcSum, cyclo); // creating the result for each method
				
				results.add(result);
																												
			} else {
				
				
				for (int i = 0; i < mh.getPair().size(); i++) {
					String namePackage = lc.getNamePackage();
					String nameClass = lc.getNameClass();
					String nameMethod = mh.getPair().get(i).a;
					int nom = mh.getPair().size();
					int loc = lc.getLines();
					int locm = mh.getPair().get(i).b;
					int cyclo = cm.getNCycles().get(i);
					Result result = new Result(namePackage, nameClass, nameMethod, nom, loc, locm, wmcSum, cyclo); // creating the result for each method
																													
					results.add(result);
				}
			}
				total_class++;

		  }

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	// used in FileHandler to get the results from each class
	public ArrayList<Result> getResults() {
		return results;
	}

	// used in FileHandler to get the total of methods in each class
	public int getNomSum() {
		return nomSum;
	}

	// used in FileHandler to get the total of lines in each class
	public int getLocSum() {
		return locSum;
	}
	
	public int getTotalClass() {
		return total_class;
	}

	public String getPackage() {
		return pkg;
	}
	
	public String getClassName() {
		return classe;
	}

}
