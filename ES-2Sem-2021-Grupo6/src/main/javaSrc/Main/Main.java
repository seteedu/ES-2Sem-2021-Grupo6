package Main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Metrics.*;

/**Used in "FileHandler"
 *
 */
public class Main {

	private ArrayList<Result> results = new ArrayList<>(); // array that transports the lines for excel
	@SuppressWarnings("unused")
	private int nomSum; // total of methods in a class
	private int locSum; // total of lines in a class
	private int wmcSum; // total of complexity in a class

	/**Extracts the metrics from a class 
	 * 	
	 * @param path	path of the class to be extracted
	 */
	public void main(String path) {
		MethodsHandler mh = new MethodsHandler();
		LOC_class lc = new LOC_class();
		CYCLO_Method cm = new CYCLO_Method();
		try {
			if (lc.countLines(path) > 2) {
				results(path, mh, lc, cm);
				nomSum = mh.getPair().size();
		  }

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**Creates a Result in the condition of the class having methods or not
	 * 
	 * @param path of the file to be parsed
	 * @param mh	MethodsHandler to return the number of methods
	 * @param lc	LOC_Class to return the number of lines of the class
	 * @param cm	CYCLO_Method to return the number of cycles/complexity of each method
	 * @throws FileNotFoundException	if it doesn't find the file
	 */
	private void results(String path, MethodsHandler mh, LOC_class lc, CYCLO_Method cm) throws FileNotFoundException {
		locSum = lc.countLines(path);
		cm.countCyclo(path);
		for (Integer c : cm.getNCycles()) {
			wmcSum += c;
		}
		mh.countMethods(path);
		if (mh.getPair().size() == 0) {
			Result result = resultWOMethod(lc);
			results.add(result);
		} else {
			for (int i = 0; i < mh.getPair().size(); i++) {
				Result result = resultWMethod(mh, lc, cm, i);
				results.add(result);
			}
		}
	}

	/**Creates a Result with methods
	 * 
	 * @param mh Gives the number of methods of the class
	 * @param lc Gives the number of lines of the class
	 * @return Rule without methods
	 */
	private Result resultWMethod(MethodsHandler mh, LOC_class lc, CYCLO_Method cm, int i) {
		String namePackage = lc.getNamePackage();
		String nameClass = lc.getNameClass();
		String nameMethod = mh.getPair().get(i).a;
		int nom = mh.getPair().size();
		int loc = lc.getLines();
		int locm = mh.getPair().get(i).b;
		int cyclo = cm.getNCycles().get(i);
		Result result = new Result(namePackage, nameClass, nameMethod, nom, loc, locm, wmcSum, cyclo);
		return result;
	}

	/**Creates a Result without methods
	 * 
	 * @param lc Gives the number of lines of the class
	 * @return Rule without methods
	 */
	private Result resultWOMethod(LOC_class lc) {
		String namePackage = lc.getNamePackage();
		String nameClass = lc.getNameClass();
		String nameMethod = null;
		int nom = 0;
		int loc = locSum;
		int locm = 0;
		int cyclo = 0;
		Result result = new Result(namePackage, nameClass, nameMethod, nom, loc, locm, wmcSum, cyclo);
		return result;
	}


	/**Gives the list of results of each class
	 * 
	 * @return	an ArrayList of results
	 */
	public ArrayList<Result> getResults() {
		return results;
	}
}
