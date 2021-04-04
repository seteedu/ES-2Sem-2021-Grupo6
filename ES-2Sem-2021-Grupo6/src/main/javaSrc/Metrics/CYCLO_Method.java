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
import com.github.javaparser.utils.Pair;

public class CYCLO_Method {

	private static int count = 1;
	
	private static ArrayList<Integer> nCycle = new ArrayList<>();

	private static class Visitor extends VoidVisitorAdapter<Void> {

		@Override
		public void visit(IfStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}

		@Override
		public void visit(ForStmt md, Void arg) {
			super.visit(md, arg);
			count++;

		}
		
		@Override 
		public void visit(SwitchStmt md, Void arg) {
			super.visit(md, arg);
			count = count + md.getEntries().size();	
		}
		
		@Override
		public void visit(WhileStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
		
		@Override
		public void visit(ForEachStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
		
		@Override
		public void visit(DoStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
	}

		// 2º visitor para o method
		private static class VisitorMethod extends VoidVisitorAdapter<Void> {

			@Override
			public void visit(MethodDeclaration md, Void arg) {
				super.visit(md, arg);
				VoidVisitor<Void> cycloVisitor = new Visitor();
				System.out.println("Method name: " +md.getName());
				cycloVisitor.visit(md, null);
				nCycle.add(count);
				System.out.println("Count : " +count);
				
			}
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

	public static void countCyclo(String s) throws FileNotFoundException {
		CompilationUnit cu = StaticJavaParser.parse(new File(s));
		VoidVisitor<Void> methodVisitor = new VisitorMethod();
		methodVisitor.visit(cu, null);

	}
	
	public static ArrayList<Integer> getNCycles(){
		return nCycle;
	}	
	
	public static void main (String[]args) {
		try {
			countCyclo("C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles\\src\\com\\jasml\\compiler\\ParsingException.java");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
