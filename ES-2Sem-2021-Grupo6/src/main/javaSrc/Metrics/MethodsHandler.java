package Metrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.utils.Pair;

public class MethodsHandler {

	private static ArrayList<Pair<String,Integer>> list;
	
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
	public int countMethods(String s) throws FileNotFoundException {
		list = new ArrayList<>(); 
		try {
		CompilationUnit cu = StaticJavaParser.parse(new File(s));
		VoidVisitor<Void> methodNameVisitor = new Visitor();
		methodNameVisitor.visit(cu, null);
		System.out.println("Foram encontrados: " + list.size() + " métodos.");
		System.out.println(list);
		return list.size();
		
		} catch (ParseProblemException e) {
			System.out.println("PARSE EXCEPTION");
			return 0;
		}
	
	}
	
	
	public ArrayList<Pair<String, Integer>> getPair(){
		return list;
	}
}
