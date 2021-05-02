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

					Rule rule = new Rule(r1[0],r1[1]);

					for(int i = 1; i<=r1.length; i+=4){
						if(i==r1.length){
							Threshold t = new Threshold(r1[i-3],r1[i-2],Integer.parseInt(r1[i-1]));
							rule.add_threshold(t);
						}else if(i!=1){
							Threshold t = new Threshold(r1[i-3],r1[i-2],Integer.parseInt(r1[i-1]),r1[i]);
							rule.add_threshold(t);
						}
					}
					
					rules.put(rule.getId(),rule);
					
				}
				s.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void writeFile(String fs) {
		File f = new File(fs);
		if(f.exists()) {
			try {
				FileWriter myWriter = new FileWriter(f);
				for (HashMap.Entry mapElement : rules.entrySet()) {
					//String key = (String)mapElement.getKey();
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
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RuleSet r = new RuleSet();
		r.initializeMap("C:\\Users\\joaom\\Desktop\\teste.txt");
		Threshold t1 = new Threshold("ola",  "<",2, "and");
		Threshold t2 = new Threshold("ola", "<", 2);
		Rule a1 = new Rule ("um", "God_class");
		a1.add_threshold(t1);
		a1.add_threshold(t2);
		r.addRule(a1);
		r.showRules();
		r.writeFile("C:\\Users\\joaom\\Desktop\\teste.txt");
	}
}

