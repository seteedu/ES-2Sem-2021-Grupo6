package metrics;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class LOC_class {


	private static final String FILE_PATH = "C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles\\src\\com\\jasml\\compiler\\SourceCodeParser.java";
	private static HashMap<String, Integer> linhasMetodos = new HashMap<String, Integer>();
	
	
	private static class Visitor extends VoidVisitorAdapter<Void> {

		//Visit de métodos
		@Override
		public void visit(ClassOrInterfaceDeclaration md, Void arg) {
			super.visit(md, arg);
			if (!md.isInterface()) {
				String[] array =md.toString().split("\r\n");
				System.out.println(array.length);
				for (String s : array) {
					System.out.println(s);
				}
			}
		}
	}
	
	//conta quantos métodos e quantas linhas
		public static int countLines(String s) throws FileNotFoundException {
			CompilationUnit cu = StaticJavaParser.parse(new File(s));
			VoidVisitor<Void> methodNameVisitor = new Visitor();
			methodNameVisitor.visit(cu, null);
			return 0;
		}
		
	/*
		public static void main(String[] args) throws FileNotFoundException {
			countLines();
		}
*/
	
}
