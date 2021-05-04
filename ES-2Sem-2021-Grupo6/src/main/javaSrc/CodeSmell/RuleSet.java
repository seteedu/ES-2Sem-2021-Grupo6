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

public class RuleSet {

	private HashMap<String, Rule> rules = new HashMap<>();

	//showing rules in GUI list
	@SuppressWarnings("rawtypes")
	public ArrayList<String> showRules () {
		ArrayList<String> a = new ArrayList<>();
		for (HashMap.Entry mapElement : rules.entrySet()) {
			//String key = (String)mapElement.getKey();
			String s = mapElement.getKey() + ": " + mapElement.getValue().toString();
			System.out.println("MAPA: " + s);
			a.add(s);
		}
		return a;
	}
	
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
		showRules();
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
		else {
			try {
				if (f.createNewFile()) {
					System.out.println("File created: " + f.getName());
					FileWriter myWriter = new FileWriter(f);
					for (HashMap.Entry mapElement : rules.entrySet()) {
						//String key = (String)mapElement.getKey();
						String s = ((Rule) mapElement.getValue()).toFile() + "\n";
						myWriter.write(s);
					}
					myWriter.close();
				} 
			} catch (IOException e) {
				System.out.println("An error occurred.");
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
//	public static void main(String[] args) {
//		RuleSet r = new RuleSet();
//		r.initializeMap("C:\\Users\\35196\\Desktopteste.txt");
//		Threshold t1 = new Threshold("ola",  "<",2, "and");
//		Threshold t2 = new Threshold("ola", "<", 2);
//		Rule a1 = new Rule ("um", "God_class");
//		a1.add_threshold(t1);
//		a1.add_threshold(t2);
//		r.addRule(a1);
//		r.showRules();
//		r.writeFile("C:\\Users\\35196\\Desktopteste.txt");
//	}
}

