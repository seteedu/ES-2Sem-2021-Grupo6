package metrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.utils.Pair;

public class MethodsHandler {

	private static final String FILE_PATH = "C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles\\src\\com\\jasml\\compiler\\GrammerException.java";
	private static ArrayList<Pair<String,Integer>> list = new ArrayList<>(); 
	
	private static class Visitor extends VoidVisitorAdapter<Void> {

		//Visit de métodos
		@Override
		public void visit(MethodDeclaration md, Void arg) {
			super.visit(md, arg);
			String[] array =md.getBody().toString().split("\n");
			Pair<String,Integer> tuplo = new Pair<String,Integer>(md.getName().toString(),array.length);
			list.add(tuplo);
		}
		
		//Visit de construtor
		@Override
		public void visit(ConstructorDeclaration md, Void arg) {
			super.visit(md, arg);
			String[] array =md.getBody().toString().split("\n");
			Pair<String,Integer> tuplo = new Pair<String,Integer>(md.getName().toString(),array.length);
			list.add(tuplo);
		}
		
		
	}
	
	//conta quantos métodos e quantas linhas
	public static int countMethods(String s) throws FileNotFoundException {
		CompilationUnit cu = StaticJavaParser.parse(new File(s));
		VoidVisitor<Void> methodNameVisitor = new Visitor();
		methodNameVisitor.visit(cu, null);
		System.out.println("Foram encontrados: " + list.size() + " métodos.");
		System.out.println(list);
		return list.size();
	
	}
	
	
	/*
	public static void main(String[] args) throws FileNotFoundException {
		countMethods();
	}
	*/

}
