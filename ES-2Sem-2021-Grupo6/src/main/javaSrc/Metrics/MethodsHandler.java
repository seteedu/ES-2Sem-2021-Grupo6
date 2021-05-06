package Metrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.utils.Pair;

/**
 * 
 * Used in "Main" to give the number of methods/constructors and each number of lines in a class
 *
 */
public class MethodsHandler {

	private static ArrayList<Pair<String,Integer>> list; //ArrayList of tuples to store the name of the method/constructor and the number of lines
	
	private static class Visitor extends VoidVisitorAdapter<Void> {

		/**Visits each "method" declaration in a class and instantiate the Visitor class to
		 * start the counter of lines in a method
		 * when the visitor reaches the end of the method it adds a tuple with the name of the method and the number of lines
		 * 
		 * @param md 	for the super class visit this "method" declaration
		 * @param arg 	to continue its procedure for the rest of the class
		 */
		@Override
		public void visit(MethodDeclaration md, Void arg) {
			super.visit(md, arg);
			String[] array =md.getBody().toString().split("\n");
			Pair<String,Integer> tuplo = new Pair<String,Integer>(md.getName().toString(),array.length);
			list.add(tuplo);
		}
		
		/**Visits each "constructor" declaration in a class and instantiate the Visitor class to
		 * start the counter of lines in a constructor
		 * when the visitor reaches the end of the constructor it adds a tuple with the name of the constructor and the number of lines
		 * 
		 * @param md 	for the super class visit this "method" declaration
		 * @param arg 	to continue its procedure for the rest of the class
		 */
		@Override
		public void visit(ConstructorDeclaration md, Void arg) {
			super.visit(md, arg);
			String[] array =md.getBody().toString().split("\n");
			Pair<String,Integer> tuplo = new Pair<String,Integer>(md.getName().toString(),array.length);
			list.add(tuplo);
		}
		
		
	}
	
	/**Method that starts the visitor in a parsed file to get the number of methods/constructors and 
	 * the number of lines of each
	 * 
	 * @param s		path of the file to be parsed
	 * @return		returns the number of methods in a java file
	 * @throws FileNotFoundException	if it doesn't find the file
	 */
	public int countMethods(String s) throws FileNotFoundException {
		list = new ArrayList<>(); 
		try {
		CompilationUnit cu = StaticJavaParser.parse(new File(s));
		VoidVisitor<Void> methodNameVisitor = new Visitor();
		methodNameVisitor.visit(cu, null);
		return list.size();
		
		} catch (ParseProblemException e) {
			System.out.println("PARSE EXCEPTION");
			return 0;
		}
	
	}
	
	/**Returns the list of results of this Visitor
	 * 
	 * @return	ArrayList with the tuples of methods/constructors and each number of lines
	 */
	public ArrayList<Pair<String, Integer>> getPair(){
		return list;
	}
}
