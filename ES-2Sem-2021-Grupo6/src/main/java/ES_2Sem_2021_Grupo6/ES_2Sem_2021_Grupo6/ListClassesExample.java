package ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ListClassesExample {

    public static void listClasses(File projectDir) {
        new dirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            try {
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
                        super.visit(n, arg);
                        String[] array = n.findCompilationUnit().get().getPackageDeclaration().toString().split(" ");
                        String[] nomedopackage = array[array.length-1].split(";");
                        System.out.println(nomedopackage[0] + "." + n.getNameAsString());
                        methodsCount.listMethods(nomedopackage[0] + "."+ n.getNameAsString());
                    }
                }.visit(StaticJavaParser.parse(file), null);
                System.out.println(); // empty line
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).explore(projectDir);
    }

    public static void main(String[] args) {
        File projectDir = new File("C:\\Users\\hugof\\git\\ES-2Sem-2021-Grupo6");
        listClasses(projectDir);
    }
}