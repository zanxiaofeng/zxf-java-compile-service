package zxf.java;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.util.ServiceLoader;

public class TestJDKCompilers {
    public static void main(String[] args) {
        JavaCompiler  compiler1 = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler1.getClass());

        ServiceLoader<JavaCompiler> javaCompilers = ServiceLoader.load(JavaCompiler.class);
        for (JavaCompiler compiler2 : javaCompilers) {
            System.out.println(compiler2.getClass());
        }
    }
}
