package CodeSmell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.DefaultListModel;

public class RuleSet {

	private HashMap<String, Rule> rules = new HashMap<>();

	/**	Showing rules in GUI list
	 * 			
	 * @return specific type of list to use in a JList with all the rules 
	 */
	@SuppressWarnings("rawtypes")
	public DefaultListModel<String> showRules () {
		DefaultListModel<String> a = new DefaultListModel<>();
		for (HashMap.Entry mapElement : rules.entrySet()) {
			String s = mapElement.getKey().toString();
			a.addElement(s);
		}
		return a;
	}
	
	/** Showing specfic type of rules ("is_God_Class" or "is_Long_Method")
	 * 
	 * @param codesmell identifies the specificc type of code smell
	 * @return	specific type of list to use in a JList with the rules that use the code smell specified
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<String> showRulesFiltered(String codesmell) {
        ArrayList<String> str = new ArrayList<>();
        Iterator it = rules.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if( (rules.get(pair.getKey()).getCodeSmell()).equals(codesmell)) {
            String s = pair.getKey().toString();
            str.add(s);
            }
        }
        return str;
    }
	
	

	/**	Adding new rule to hashMap
	 * 	
	 * @param rule
	 */
	public void addRule (Rule rule) {
		rules.put(rule.getId(), rule);
	}

	/**	Creating HashMap as the application starts based on a text file with the rules written
	 * 	if the file deosn't exist then creates one with two default rules
	 * 	HashMap use the rule's id as keys and the rule object as value
	 * 
	 * @param fs	Path of the text file with the rules
	 */
	public void initializeMap(String fs) {
		File f = new File(fs);
		if (f.exists()) {
			try {
				Scanner s = new Scanner(f);
				while (s.hasNextLine()) {
					String r = s.nextLine();
					String[] r1 = r.split(", ");
					ArrayList<Threshold> ts = new ArrayList<>();
					Rule rule = rule(r1, ts);
					rules.put(rule.getId(),rule);
				}
				s.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				if (f.createNewFile()) {
			    	String path = f.getAbsolutePath();
			    	@SuppressWarnings("unused")
					String fileLocation = path.substring(0, path.length() - 1) + f.getName() + ".txt";
					FileWriter myWriter = new FileWriter(f);
					String defClassRule = "default1, is_God_Class, LOC_Class, <, 100";
					String defMethodRule = "default2, is_Long_Method, LOC_Method, <, 20";
					myWriter.write(defClassRule + "\n");
					myWriter.write(defMethodRule + "\n");
					Threshold cr = new Threshold("LOC_Class", "<", 100);
					Threshold mr = new Threshold("LOC_Method", "<", 20);
					ArrayList<Threshold> mrl = new ArrayList<Threshold>();
					ArrayList<Threshold> crl = new ArrayList<Threshold>();
					crl.add(cr);
					mrl.add(mr);
					Rule defClassRule1 = new Rule("default1", "is_God_Class",crl);
					Rule defMethodRule1 = new Rule("default2", "is_Long_Method", mrl);
					rules.put(defClassRule1.getId(), defClassRule1);
					rules.put(defMethodRule1.getId(), defMethodRule1);
					myWriter.close();
				} 
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}

	/** Creates a rule based on an arrayList of thresholds gotten from the file
	 * 
	 * @param r1	Gives the rule's id
	 * @param ts	ArrayList of thresholds to add to the rule
	 * @return		Rule created from a line of the text file
	 * @throws NumberFormatException
	 */
	private Rule rule(String[] r1, ArrayList<Threshold> ts) throws NumberFormatException {
		for (int i = 1; i <= r1.length; i += 4) {
			if (i == r1.length) {
				Threshold t = new Threshold(r1[i - 3], r1[i - 2], Integer.parseInt(r1[i - 1]));
				ts.add(t);
			} else if (i != 1) {
				Threshold t = new Threshold(r1[i - 3], r1[i - 2], Integer.parseInt(r1[i - 1]), r1[i]);
				ts.add(t);
			}
		}
		Rule rule = new Rule(r1[0], r1[1], ts);
		return rule;
	}
	
	/** Writes all the rules that the HashMap rules has in the text file at the end of the program 
	 * 
	 * @param fs	Path of the text file to write the rules
	 */
	@SuppressWarnings("rawtypes")
	public void writeFile(String fs) {
		File f = new File(fs);
		if(f.exists()) {
			try {
				FileWriter myWriter = new FileWriter(f);
				for (HashMap.Entry mapElement : rules.entrySet()) {
					String s = ((Rule) mapElement.getValue()).toFile() + "\n";
					myWriter.write(s);
				}
				myWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**	When the user changes the rule this has to be replaced in the HashMap in order to it stays updated
	 * 
	 * @param oldRule	Rule's id to identify the key to remove from the HashMap
	 * @param newRule	New rule to replace the changed one
	 */
	public void replaceRule(String oldRule, Rule newRule) {
		rules.remove(oldRule);
		addRule(newRule);
	}
	
	
	/**	Returns the initialized HashMap with rules  
	 * 
	 * @return	HashMap with rules
	 */
	public HashMap<String, Rule> getHashMap(){
		return rules;
	}
}

