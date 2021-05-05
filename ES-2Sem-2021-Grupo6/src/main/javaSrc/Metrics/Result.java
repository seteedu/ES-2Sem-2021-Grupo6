package Metrics;

/**
 * 
 * Class to group all the metrics from each method
 *
 */
public class Result {
	private String package1;
	private String class1;
	private String method1;
	private int nom;
	private int loc;
	private int wmc;
	private int locm;
	private int cyclom;
	
	/** Constructor of the object to group all the results of the method
	 * 
	 * @param package1	name of the package it's in
	 * @param class1	name of the class it's in
	 * @param method1	name of the method
	 * @param nom		number of methods in the class that it's in
	 * @param loc		number of lines in the class that it's in
	 * @param wmc		total of cycles/complexity in the class that it's in
	 * @param locm		number of lines of this method
	 * @param cyclom	number of cycles/complexity of this method
	 */
	public Result(String package1, String class1, String method1, int nom, int loc, int wmc, int locm, int cyclom){
		this.package1=package1;
		this.class1=class1;
		this.method1=method1;
		this.nom=nom;
		this.loc=loc;
		this.wmc=wmc;
		this.locm=locm;
		this.cyclom=cyclom;
	}
	
	/**Gives the name of the package that's in
	 * 	
	 * @return name of the package
	 */
	public String getPackage1(){
		return package1;
	}
	
	/**Gives the name of the class that's in
	 * 	
	 * @return name of the class
	 */
	public String getClass1(){
		return class1;
	}
	
	/**Gives the name of the method
	 * 	  	
	 * @return name of the method
	*/
	public String getMethod1(){
		return method1;
	}
	
	/**Gives the number of methods in the class that it's in
	 * 	
	 * @return number of methods of the class
	 */
	public int getNom() {
		return nom;
	}
	
	/**Gives the number of lines in the class that it's in
	 * 	
	 * @return number of lines of the class
	 */
	public int getLoc() {
		return loc;
	}
	
	/**Gives the total of cycles/complexity in the class that it's in
	 * 	
	 * @return total of cycles/complexity
	 */
	public int getWmc() {
		return wmc;
	}
	
	/**Gives the number of lines of the method
	 * 	
	 * @return number of lines
	 */
	public int getLocm() {
		return locm;
	}
	
	/**Gives the number of cycles/complexity of the method
	 * 	
	 * @return number of cycles/complexity
	 */
	public int getCyclom() {
		return cyclom;
	}

}
