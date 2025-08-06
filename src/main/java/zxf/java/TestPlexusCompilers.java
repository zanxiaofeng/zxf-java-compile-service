package zxf.java;

import com.google.common.collect.Sets;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.compiler.Compiler;
import org.codehaus.plexus.compiler.CompilerResult;
import org.codehaus.plexus.compiler.manager.CompilerManager;
import org.codehaus.plexus.component.repository.exception.ComponentLookupException;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

import org.codehaus.plexus.compiler.CompilerConfiguration;

public class TestPlexusCompilers {
    public static void main(String[] args) throws Exception {
        PlexusContainer container = new DefaultPlexusContainer();

        try {
            CompilerManager compilerManager = container.lookup(CompilerManager.class);
            Compiler compiler = compilerManager.getCompiler("javac");
            System.out.println("Using compiler: " + compiler.getClass().getSimpleName());

            CompilerConfiguration config = new CompilerConfiguration();
            config.setSourceFiles(Sets.newHashSet(Paths.get("input/zxf/MySourceFile.java").toFile()));
            config.setClasspathEntries(Arrays.asList(System.getProperty("java.class.path").split(File.pathSeparator)));
            config.setOutputLocation("output/classes");
            config.setDebug(true);
            config.setOptimize(true);
            config.setSourceVersion("11");
            config.setReleaseVersion("11");
            config.setTargetVersion("11");

            CompilerResult result = compiler.performCompile(config);

            if (result.isSuccess()) {
                System.out.println("Compilation succeeded!");
            } else {
                System.out.println("Compilation failed with " + result.getCompilerMessages().size() + " errors:");
                result.getCompilerMessages().forEach(error -> System.out.println(error));
            }
        } catch (ComponentLookupException e) {
            System.out.println("CompilerManager not found in container");
        } finally {
            container.dispose();
        }
    }
}