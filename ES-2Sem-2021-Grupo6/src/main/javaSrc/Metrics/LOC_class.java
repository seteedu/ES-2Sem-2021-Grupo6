package Metrics;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class LOC_class {

	private static ArrayList<String> copyArray;	//transforms the String[] returned from visitor to ArrayList in order to ease the text formatation 
	private static String nameClass;	//stores the class name
	private static String namePackage;
	
	private static class Visitor extends VoidVisitorAdapter<Void> {

		//Visitor searches for Classes or Interfaces
		@Override
		public void visit(ClassOrInterfaceDeclaration md, Void arg) {
			super.visit(md, arg);
			nameClass = md.getName().toString();
			if (!md.isInterface()) {
				String[] array =md.toString().split("\r\n");
				for (String s : array) {
						copyArray.add(s);
					}
				for(int i=0; i<copyArray.size(); i++) {
					if(copyArray.get(i).equals(""))
						copyArray.remove(i);
				}
				System.out.println(copyArray.size());
				System.out.println(nameClass);
			}
		}
	}
	
	//method that starts the visitor
	public void countLines(String s) throws FileNotFoundException {
			copyArray = new ArrayList<String>();
			try {
			CompilationUnit cu = StaticJavaParser.parse(new File(s));
			namePackage = cu.getPackageDeclaration().toString();
			VoidVisitor<Void> methodNameVisitor = new Visitor();
			methodNameVisitor.visit(cu, null);
			} catch (ParseProblemException e) {
				System.out.println("PARSE EXCEPTION");
			}
	}
	
	//used in Main to get the number of lines in each class
	public int getLines(){
			return copyArray.size();
	}
		
	
	public String getNameClass () {
			return nameClass;
	}
	
	public String getNamePackage() {
		String[] array = namePackage.split(" ");
		//System.out.println("DEBUG: " + array[array.length-1]);
		String[] array2 = array[array.length-1].split(";");
		return array2[0];
	}

	
}
