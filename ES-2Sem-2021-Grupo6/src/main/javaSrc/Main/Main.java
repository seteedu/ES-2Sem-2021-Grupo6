package Main;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import Metrics.*;


public class Main {
	
	private ArrayList<Result> results = new ArrayList<>(); //array that transports the lines for excel
	private int nomSum;	//total of methods in a class
	private int locSum;	//total of lines in a class
	private int wmcSum;	//total of complexity in a class
	

	
	public void main (String path) {
		MethodsHandler mh = new MethodsHandler();
		LOC_class lc = new LOC_class();
		CYCLO_Method cm = new CYCLO_Method();
		try {
			cm.countCyclo(path);
			lc.countLines(path);
			mh.countMethods(path);
			for ( Integer c : CYCLO_Method.getNCycles() )
				wmcSum += c;
			for(int i = 0; i < mh.getPair().size(); i++) {
				String namePackage =LOC_class.getNamePackage();
				String nameClass = LOC_class.getNameClass();
				String nameMethod = mh.getPair().get(i).a;
				int nom = mh.getPair().size();
				int loc = LOC_class.getLines();
				int locm = mh.getPair().get(i).b;
				int cyclo = CYCLO_Method.getNCycles().get(i);
				nomSum=nom;
				locSum=loc;
				Result result = new Result(namePackage, nameClass, nameMethod, nom, loc, locm, wmcSum ,cyclo);	//creating the result for each method
				results.add(result);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//used in FileHandler to get the results from each class
	 public ArrayList<Result> getResults(){
	  		return results;
	 }
	 
	//used in FileHandler to get the total of methods in each class
	public int getNomSum() {
			return nomSum;
	}
	 
	//used in FileHandler to get the total of lines in each class
	public int getLocSum() {
			return locSum;
	}
	
}
