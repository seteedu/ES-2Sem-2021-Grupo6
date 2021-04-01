package metrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class MethodsHandler {

	private static final String FILE_PATH = "C:\\Users\\hugof\\git\\ES-2Sem-2021-Grupo6\\ES-2Sem-2021-Grupo6\\src\\test\\java\\ES_2Sem_2021_Grupo6\\ES_2Sem_2021_Grupo6\\Teste.java";
	private static HashMap<String, Integer> linhasMetodos = new HashMap<String, Integer>();
	
	
	private static class Visitor extends VoidVisitorAdapter<Void> {

		//Visit de métodos
		@Override
		public void visit(MethodDeclaration md, Void arg) {
			super.visit(md, arg);
			String[] array =md.getBody().toString().split("\n");
			linhasMetodos.put(md.getName().toString(),array.length-2);
		}
		
		//Visit de construtor
		@Override
		public void visit(ConstructorDeclaration md, Void arg) {
			super.visit(md, arg);
			String[] array =md.getBody().toString().split("\n");
			linhasMetodos.put(md.getName().toString(),array.length-2);
		}
		
		
	}
	
	//conta quantos métodos e quantas linhas
	public static int countMethods() throws FileNotFoundException {
		CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));
		VoidVisitor<Void> methodNameVisitor = new Visitor();
		methodNameVisitor.visit(cu, null);
		System.out.println("Foram encontrados: " + linhasMetodos.size() + " métodos.");
		System.out.println(linhasMetodos);
		return linhasMetodos.size();
	}

	public static void main(String[] args) throws FileNotFoundException {
		countMethods();
	}

}
