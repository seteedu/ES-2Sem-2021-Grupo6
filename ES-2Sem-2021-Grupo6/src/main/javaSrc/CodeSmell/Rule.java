package CodeSmell;

import java.util.ArrayList;

public class Rule {

	private String id;
	private String codeSmell;
	private ArrayList<Threshold> t_list;


	public Rule (String id, String codeSmell) {
		t_list = new ArrayList<Threshold>();
		this.id = id;
		this.codeSmell = codeSmell;
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

		return rule;
	}	


	public String getId() {
		return id;
	}



}
