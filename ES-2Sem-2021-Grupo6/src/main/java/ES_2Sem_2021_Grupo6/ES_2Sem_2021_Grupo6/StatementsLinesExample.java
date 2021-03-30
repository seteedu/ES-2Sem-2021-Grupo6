package ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.stmt.Statement;
import com.google.common.base.Strings;

import java.io.File;
import java.io.IOException;

public class StatementsLinesExample {

    public static void statementsByLine(File projectDir) {
        new dirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            try {
                StaticJavaParser.parse(file)
                        .findAll(Statement.class)
                        .forEach(statement -> System.out.println(" [Lines " + statement.getBegin().get().line
                                + " - " + statement.getEnd().get().line + " ] " + statement));
                System.out.println(); // empty line
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).explore(projectDir);
    }

    public static void main(String[] args) {
        File projectDir = new File("C:\\Users\\hugof\\git\\ES-2Sem-2021-Grupo6\\ES-2Sem-2021-Grupo6\\src\\main\\java\\ES_2Sem_2021_Grupo6\\ES_2Sem_2021_Grupo6");
        statementsByLine(projectDir);
    }
}