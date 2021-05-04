package CodeSmell;

import java.util.ArrayList;

public class Rule {

	private String id;
	private String codeSmell;
	private ArrayList<Threshold> t_list = new ArrayList<Threshold>();


	public Rule (String id, String codeSmell, ArrayList<Threshold> t_list) {
		this.id = id;
		this.codeSmell = codeSmell;
		this.t_list = t_list;
	}

	public void add_threshold(Threshold t){
		t_list.add(t);
	}

	@Override
	public String toString() {
		String rule = codeSmell + ": ";
		for(Threshold t: t_list){
			rule = rule + " " + t.toString();
		}
		return rule;
	}


	public String toFile() {
		String rule = id + ", " + codeSmell;

		for(Threshold t: t_list){
			rule = rule + ", " + t.toFile();
		}
		System.out.println("RULE: " + rule);
		return rule;
	}	


	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id=id;
	}

	
	public ArrayList<Threshold> getThresholds(){
		return t_list;
	}
	
	public String getCodeSmell() {
		return codeSmell;
	}



}
