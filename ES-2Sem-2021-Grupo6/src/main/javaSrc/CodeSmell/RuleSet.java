package CodeSmell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class RuleSet {
	
	private HashMap<String, Rule> rules = new HashMap<>();
	
	//showing rules in GUI list
	public ArrayList<String> showRules () {
		ArrayList<String> a = new ArrayList<>();
		for (HashMap.Entry mapElement : rules.entrySet()) {
            //String key = (String)mapElement.getKey();
            String s = mapElement.getKey() + ": " + mapElement.getValue().toString();
            System.out.println(s);
            a.add(s);
        }
	    return a;
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
				       Rule rule;
				       if( r1.length < 6) {
				    	   rule = new Rule(r1[0], new Threshold(r1[2], r1[3], Integer.parseInt(r1[4])), r1[1]);
				    	   rules.put(rule.getId(), rule);
				       }else {
				    	   rule = new Rule(r1[0], new Threshold(r1[2], r1[3], Integer.parseInt(r1[4]), r1[5]),new Threshold(r1[6], r1[7], Integer.parseInt(r1[8])) , r1[1]);
				    	   rules.put(rule.getId(), rule);
				       }
				    	   
				      }
				      s.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void writeFile(File f) {
		try {
		      FileWriter myWriter = new FileWriter(f);
		      for (HashMap.Entry mapElement : rules.entrySet()) {
		            //String key = (String)mapElement.getKey();
		            String s = mapElement.getKey() + ": " + mapElement.getValue().toString();
		            myWriter.write(s);
		      }
		      myWriter.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
	
	public static void main(String[] args) {
		RuleSet r = new RuleSet();
		r.initializeMap("C:\\Users\\35196\\Desktop\\teste.txt");
		Threshold t1 = new Threshold("ola",  "<",2, "and");
		Threshold t2 = new Threshold("ola", "<", 2);
		Rule a1 = new Rule ("um", t1, t2, "God_class");
		r.addRule(a1);
		r.showRules();
	}
}

	