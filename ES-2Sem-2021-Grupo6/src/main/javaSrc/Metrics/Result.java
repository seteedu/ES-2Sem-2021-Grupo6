package Metrics;

public class Result {
	private String package1;
	private String class1;
	private String method1;
	private int nom;
	private int loc;
	private int wmc;
	private int locm;
	private int cyclom;
	
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
		
	public String getPackage1(){
		return package1;
	}
	public String getClass1(){
		return class1;
	}
	public String getMethod1(){
		return method1;
	}
	public int getNom() {
		return nom;
	}
	public int getLoc() {
		return loc;
	}
	public int getWmc() {
		return wmc;
	}
	public int getLocm() {
		return locm;
	}
	public int getCyclom() {
		return cyclom;
	}

}
