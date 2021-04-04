package Metrics;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class LOC_class {


	private static final String FILE_PATH = "C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles\\src\\com\\jasml\\compiler\\SourceCodeParser.java";
	private static HashMap<String, Integer> linhasMetodos = new HashMap<String, Integer>();
	private static ArrayList<String> copyArray = new ArrayList<String>();
	private static String nameClass;
	
	
	
	private static class Visitor extends VoidVisitorAdapter<Void> {

		//Visit de métodos
		@Override
		public void visit(ClassOrInterfaceDeclaration md, Void arg) {
			super.visit(md, arg);
			nameClass = md.getName().toString();
			if (!md.isInterface()) {
				String[] array =md.toString().split("\r\n");
				for (String s : array) {
					if (!s.equals("\n") || (!s.equals(""))) {
						copyArray.add(s);
					}
				}
				for(String s : copyArray) {
					System.out.println(s);
				}
				System.out.println(copyArray.size());
				
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
	
		public static ArrayList<String> getLines(){
			return copyArray;
		}
		
		public static String nameClass () {
			return nameClass;
		}
		
		
	
		public static void main(String[] args) throws FileNotFoundException {
			countLines("C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles\\src\\com\\jasml\\compiler\\GrammerException.java");
		}

	
}
