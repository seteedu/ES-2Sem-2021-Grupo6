package CodeSmell;

public class Rule {
	
	private Threshold t1;
	private Threshold t2;
	private String id;
	private String codeSmell;
	
	
	public Rule (String id, Threshold t1, Threshold t2, String codeSmell) {
		this.t1 = t1;
		this.t2 = t2;
		this.id = id;
		this.codeSmell = codeSmell;
	}
	
	public Rule (String id, Threshold t1, String codeSmell) {
		this.t1 = t1;
		this.id = id;
		this.codeSmell = codeSmell;
	}
	
	public void setThreshold (Threshold nt1, Threshold nt2 ) {
		this.t1 = nt1;
		this.t2 = nt2;
	}
	
	@Override
	public String toString() {
		if (t2 != null)
			return codeSmell + ": " +t1.toString() + " " + t2.toString();
		else
			return codeSmell + ": " +t1.toString();
	}
	
	public String getId() {
		return id;
	}
	
	
	
}
