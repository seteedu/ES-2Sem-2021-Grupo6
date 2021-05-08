package CodeSmell;

import java.util.ArrayList;

public class Rule {

	private String id;
	private String codeSmell;
	private ArrayList<Threshold> t_list = new ArrayList<Threshold>();

	/**Rule constructor  
	 * 
	 * @param id		rule name used as identifier
	 * @param codeSmell	code smell identifier	
	 * @param t_list	arrayList with the thresholds defined by user
	 */
	public Rule (String id, String codeSmell, ArrayList<Threshold> t_list) {
		this.id = id;
		this.codeSmell = codeSmell;
		this.t_list = t_list;
	}

	/**Overrides the toString method from Object to specify the way it will be showed in GUI
	 * 
	 *  @return string with the code smell identified and the thresholds defined 
	 */
	@Override
	public String toString() {
		String rule = codeSmell + ": ";
		for(Threshold t: t_list){
			rule = rule + " " + t.toString();
		}
		return rule;
	}

	/** Converts the rule into a string to write in the text file
	 * 
	 * @return	string to write into the text file
	 */
	public String toFile() {
		String rule = id + ", " + codeSmell;
		for(Threshold t: t_list){
			rule = rule + ", " + t.toFile();
		}
		return rule;
	}	

	/** Gives the rule's id to identify the rule
	 * 
	 * @return	string with rule's id
	 */
	public String getId() {
		return id;
	}
			
	/**	Returns the rule's thresholds 
	 * 
	 * @return arrayList of thresholds 
	 */
	public ArrayList<Threshold> getThresholds(){
		return t_list;
	}
	
	/** Gives the type of code smell that the rule works on
	 * 
	 * @return 	a string with the type of code smell
	 */
	public String getCodeSmell() {
		return codeSmell;
	}

}
