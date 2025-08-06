package zxf.java;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.stmt.Statement;

import java.util.Optional;

public class TestJavaParsers {
    public static void main(String[] args) {
        Statement statement = StaticJavaParser.parseStatement("final int answer = 42;");

        CompilationUnit compilationUnit =  StaticJavaParser.parse("public class Test {}");

        NodeList<ImportDeclaration> imports = compilationUnit.getImports();
        Optional<ClassOrInterfaceDeclaration>  cls = compilationUnit.getClassByName("Test");

        //https://baeldung.com/java-parser
    }
}
