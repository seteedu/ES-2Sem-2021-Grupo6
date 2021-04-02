package metrics;

import java.io.File;
import java.io.FileNotFoundException;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
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

	private static final String FILE_PATH = "C:\\Users\\samum\\eclipse-workspace\\Teste\\testFiles\\src\\com\\jasml\\compiler\\SourceCodeParser.java";
	private static int count = 1;

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
		
		public void visit(SwitchStmt md, Void arg) {
			super.visit(md, arg);
			count = count + md.getEntries().size();
			
		}
		
		public void visit(WhileStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
		
		public void visit(ForEachStmt md, Void arg) {
			super.visit(md, arg);
			count++;
		}
		
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
				System.out.println("Count : " +count);
				
			}
		}


	public static void countCyclo(String s) throws FileNotFoundException {
		CompilationUnit cu = StaticJavaParser.parse(new File(s));
		VoidVisitor<Void> methodVisitor = new VisitorMethod();
		methodVisitor.visit(cu, null);
		//System.out.println("Total: " + count);

	}
	/*
	public static void main(String[] args) throws FileNotFoundException {
		countCyclo();
	}
	*/
}
