package Metrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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

public class CYCLO_Method {

	private static int count = 1; //count of complexity always starts at one
	private static ArrayList<Integer> nCycle;	//store the number of complexity in each method

	private static class Visitor extends VoidVisitorAdapter<Void> {

		//visitor for each "if" statement
		@Override
		public void visit(IfStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
		
		//visitor for each "for" statement
		@Override
		public void visit(ForStmt md, Void arg) {
			super.visit(md, arg);
			count++;

		}
		
		//visitor for each "switch" statement
		@Override 
		public void visit(SwitchStmt md, Void arg) {
			super.visit(md, arg);
			count = count + md.getEntries().size();	
		}
		
		//visitor for each "while" statement
		@Override
		public void visit(WhileStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
		
		//visitor for each "for each" statement
		@Override
		public void visit(ForEachStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
		
		//visitor for each "do" statement
		@Override
		public void visit(DoStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
	}

		// 2º visitor for the method
		private static class VisitorMethod extends VoidVisitorAdapter<Void> {

			//visitor for each "Method"
			@Override
			public void visit(MethodDeclaration md, Void arg) {
				super.visit(md, arg);
				VoidVisitor<Void> cycloVisitor = new Visitor();
				System.out.println("Method name: " +md.getName());
				cycloVisitor.visit(md, null);
				nCycle.add(count);
				System.out.println("Count : " +count);
				
			}
			
			//visitor for each "Constructor"
			@Override
			public void visit(ConstructorDeclaration md, Void arg) {
				super.visit(md, arg);
				VoidVisitor<Void> cycloVisitor = new Visitor();
				System.out.println("Method name: " +md.getName());
				cycloVisitor.visit(md, null);
				nCycle.add(count);
				System.out.println("Count : " +count);
			}
		}

	//method that starts the visitors 
	public void countCyclo(String s) throws FileNotFoundException {
		nCycle= new ArrayList<>();
		CompilationUnit cu = StaticJavaParser.parse(new File(s));
		VoidVisitor<Void> methodVisitor = new VisitorMethod();
		methodVisitor.visit(cu, null);
	}
	
	//used in Main to get the total of complexity in each class
	public static ArrayList<Integer> getNCycles(){
		return nCycle;
	}	
}
