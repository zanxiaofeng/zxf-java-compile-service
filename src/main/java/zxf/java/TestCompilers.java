package zxf.java;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.util.ServiceLoader;

public class TestCompilers {
    public static void main(String[] args) {
        JavaCompiler  compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.getClass());

        ServiceLoader<JavaCompiler> javaCompilers = ServiceLoader.load(JavaCompiler.class);
        for (JavaCompiler compiler2 : javaCompilers) {
            System.out.println(compiler2.getClass());
        }
    }
}
