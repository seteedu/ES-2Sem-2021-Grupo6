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

	//showing rules in GUI list
	@SuppressWarnings("rawtypes")
	public DefaultListModel<String> showRules () {
		DefaultListModel<String> a = new DefaultListModel<>();
		for (HashMap.Entry mapElement : rules.entrySet()) {
			String s = mapElement.getKey().toString();
			System.out.println("MAPA: " + mapElement.getKey());
			a.addElement(s);
		}
		return a;
	}
	
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
	
	

	//adding new rule to hashMap
	public void addRule (Rule rule) {
		rules.put(rule.getId(), rule);
	}

	//creating HashMap as the application starts
	public void initializeMap(String fs) {
		File f = new File(fs);
		if (f.exists()) {
			try {
				Scanner s = new Scanner(f);
				while (s.hasNextLine()) {
					String r = s.nextLine();
					String[] r1 = r.split(", ");

					ArrayList<Threshold> ts = new ArrayList<>();
					for(int i = 1; i<=r1.length; i+=4){
						if(i==r1.length){
							Threshold t = new Threshold(r1[i-3],r1[i-2],Integer.parseInt(r1[i-1]));
							ts.add(t);
						}else if(i!=1){
							Threshold t = new Threshold(r1[i-3],r1[i-2],Integer.parseInt(r1[i-1]),r1[i]);
							ts.add(t);
						}
					}
					Rule rule = new Rule(r1[0],r1[1], ts);
					
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
					System.out.println("File created: " + f.getName());
			    	String path = f.getAbsolutePath();
			    	@SuppressWarnings("unused")
					String fileLocation = path.substring(0, path.length() - 1) + f.getName() + ".txt";
					FileWriter myWriter = new FileWriter(f);
					String defClassRule = "default1, is_God_Class, LOC_Class, <, 100";
					String defMethodRule = "default2, is_Long_Method, LOC_Method, <, 20";
					myWriter.write(defClassRule + "\n");
					myWriter.write(defMethodRule + "\n");
					Threshold cr = new Threshold("LOC_Class", "<", 100);
					ArrayList<Threshold> crl = new ArrayList<Threshold>();
					crl.add(cr);
					Rule defClassRule1 = new Rule("default1", "is_God_Class",crl);
					Threshold mr = new Threshold("LOC_Method", "<", 20);
					ArrayList<Threshold> mrl = new ArrayList<Threshold>();
					mrl.add(mr);
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
	
	
	
	public void replaceRule(String oldRule, Rule newRule) {
		rules.remove(oldRule);
		addRule(newRule);
	}
	
	public void changeRule(String id, String codeSmell, ArrayList<Threshold> ts){
		Rule r = new Rule(id,codeSmell, ts);		
		rules.replace(id, r);
	}
	
	public HashMap<String, Rule> getHashMap(){
		return rules;
	}
}

