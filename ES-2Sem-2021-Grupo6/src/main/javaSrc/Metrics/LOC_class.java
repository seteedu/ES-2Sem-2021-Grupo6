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

/** 
 * Used to parse any java file an then to count the number of lines in a class
 */
public class LOC_class {

	private static ArrayList<String> copyArray;	//transforms the String[] returned from visitor to ArrayList in order to ease the text format 
	private static String nameClass;	//stores the class name
	private static String namePackage;	//stores the package name
	
	/** 
	 * Visitor class to search for classes or interfaces in a parsed file
	 */
	private static class Visitor extends VoidVisitorAdapter<Void> {

		/**Visits each "class" or "interface" declaration in a parsed file 
		 * for each "class" or "interface" it stores its name, the package it's in and the number of lines
		 * 
		 * @param md	for the superclass visit this "class" or "interface" declaration
		 * @param arg	to continue its procedure for the rest of method
		 */
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
			}
		}
	}
	
	/**Method that starts the visitor in the java file received
	 * 
	 * @param s		path of the java file to be parsed 
	 * @return		the number of lines in the java file
	 * @throws FileNotFoundException	if it doesn't found the java file
	 */
	public int countLines(String s) throws FileNotFoundException {
			copyArray = new ArrayList<String>();
			try {
			CompilationUnit cu = StaticJavaParser.parse(new File(s));
			namePackage = cu.getPackageDeclaration().toString();
			VoidVisitor<Void> methodNameVisitor = new Visitor();
			methodNameVisitor.visit(cu, null);
			} catch (ParseProblemException e) {
				System.out.println("PARSE EXCEPTION");
			}
			return copyArray.size();
	}
	
	/**Used in main to get the number of lines from each "class" or "interface"
	 * 
	 * @return 	the size of the array that has the lines of each class/interface
	 */
	public int getLines(){
			return copyArray.size();
	}
		
	/**Gives the name of the class 
	 * 
	 * @return the name of the class 
	 */
	public String getNameClass () {
			return nameClass;
	}
	
	/**Gives the name of the package which the class is in 
	 * 
	 * @return	the name of the package
	 */
	public String getNamePackage() {
		String[] array = namePackage.split(" ");
		String[] array2 = array[array.length-1].split(";");
		return array2[0];
	}

	
}
