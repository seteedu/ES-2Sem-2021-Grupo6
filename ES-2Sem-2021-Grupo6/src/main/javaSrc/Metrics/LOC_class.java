package Metrics;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class LOC_class {

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
						copyArray.add(s);
					}
				for(int i=0; i<copyArray.size(); i++) {
					if(copyArray.get(i).equals(""))
						copyArray.remove(i);
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
			return copyArray.size();
		}
	
		public static ArrayList<String> getLines(){
			return copyArray;
		}
		
		public static String nameClass () {
			return nameClass;
		}
	
		public static void main(String[] args) throws FileNotFoundException {
			countLines("C:\\Users\\hugof\\OneDrive - ISCTE-IUL\\3ºAno\\2º Semestre\\ES\\Projeto\\Teste\\testFiles\\src\\com\\jasml\\compiler\\ParsingException.java");
		}

	
}
