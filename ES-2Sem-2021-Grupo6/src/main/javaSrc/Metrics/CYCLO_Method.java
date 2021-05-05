package Metrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.DoStmt;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.stmt.WhileStmt;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/** 
 * Used to parse any java file an then to count the number of cycles/complexity in a method
 */
public class CYCLO_Method {

	private static int count = 1; //count of complexity always starts at one
	private static ArrayList<Integer> nCycle;	//store the number of complexity in each method

	/**
	 * 
	 *Visitor class to search for any of the following statements in a parsed file
	 *Extends VoidVisitorAdapter in order to find each type of statement
	 *Will be created one Visitor for each method or constructor declaration
	 *
	 */
	private static class Visitor extends VoidVisitorAdapter<Void> {

		/**Visits each "if" statement in a class 
		 * for each "if" it iterates the counter of cycles/complexity
		 * 
		 * @param md	for the superclass visit this "if" statement
		 * @param arg	to continue its procedure for the rest of method
		 */
		@Override
		public void visit(IfStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
		
		/**Visits each "for" statement in a class 
		 * for each "for" it iterates the counter of cycles/complexity
		 * 
		 * @param md	for the superclass visit this "for" statement
		 * @param arg	to continue its procedure for the rest of method
		 */
		@Override
		public void visit(ForStmt md, Void arg) {
			super.visit(md, arg);
			count++;

		}
		
		/**Visits each "switch" statement in a class 
		 * for each "switch" it iterates the counter of cycles/complexity
		 * 
		 * @param md	for the superclass visit this "switch" statement
		 * @param arg	to continue its procedure for the rest of method
		 */
		@Override 
		public void visit(SwitchStmt md, Void arg) {
			super.visit(md, arg);
			count = count + md.getEntries().size();	
		}
		
		/**Visits each "while" statement in a class 
		 * for each "while" it iterates the counter of cycles/complexity
		 * 
		 * @param md	for the superclass visit this "while" statement
		 * @param arg	to continue its procedure for the rest of method
		 */
		@Override
		public void visit(WhileStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
		
		/**Visits each "for each" statement in a class 
		 * for each "for each" it iterates the counter of cycles/complexity
		 * 
		 * @param md	for the superclass visit this "for each" statement
		 * @param arg	to continue its procedure for the rest of method
		 */
		@Override
		public void visit(ForEachStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
		
		/**Visits each "do" statement in a class 
		 * for each "do" it iterates the counter of cycles/complexity
		 * 
		 * @param md	for the super class visit this "do" statement
		 * @param arg	to continue its procedure for the rest of method 
		 */
		@Override
		public void visit(DoStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
	}

		/**
		 * 
		 * Searches for each method declarations existent in a class to start the search for the above statements
		 *	Extends VoidVisitorAdapter in order to find each type of method
		 */
		private static class VisitorMethod extends VoidVisitorAdapter<Void> {

			/**Visits each "method" declaration in a class and instantiate the Visitor class to
			 * start the counter of cycles/complexity in that method
			 * when the visitor reaches the end of the constructor it adds the counter to an arrayList with the results
			 * 
			 * @param md 	for the super class visit this "method" declaration
			 * @param arg 	to continue its procedure for the rest of the class
			 */
			@Override
			public void visit(MethodDeclaration md, Void arg) {
				super.visit(md, arg);
				VoidVisitor<Void> cycloVisitor = new Visitor();
				cycloVisitor.visit(md, null);
				nCycle.add(count);				
			}
			
			/**Visits each "constructor" declaration in a class and instantiate the Visitor class to
			 * start the counter of cycles/complexity in that method
			 * when the visitor reaches the end of the constructor it adds the counter to an arrayList with the results
			 * 
			 * @param md 	for the super class visit this "constructor" declaration
			 * @param arg 	to continue its procedure for the rest of the class
			 */
			@Override
			public void visit(ConstructorDeclaration md, Void arg) {
				super.visit(md, arg);
				VoidVisitor<Void> cycloVisitor = new Visitor();
				cycloVisitor.visit(md, null);
				nCycle.add(count);
			}
		}

	/** This method starts the VisitorMethod to do its search of methods in a class 
	 * 
	 *  
	 * @param s		path of the file to be parsed 
	 * @throws FileNotFoundException	if the file is not found
	 */
	public void countCyclo(String s) throws FileNotFoundException {
		nCycle= new ArrayList<>();
		try {
		CompilationUnit cu = StaticJavaParser.parse(new File(s));
		VoidVisitor<Void> methodVisitor = new VisitorMethod();
		methodVisitor.visit(cu, null);
		} catch (ParseProblemException e) {
			System.out.println("PARSE EXCEPTION");
		}
	}
	
	/**Where are the results from each method
	 * Used in "Main" to create the object "Result" for each method/constructor
	 * 
	 * @return	ArrayList with the list of counters
	 */
	public ArrayList<Integer> getNCycles(){
		return nCycle;
	}	
}
