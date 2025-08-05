package zxf.java;

import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;
import org.eclipse.sisu.plexus.PlexusContainerAdapter;
import org.eclipse.sisu.plexus.PlexusLifecycleManager;

public class TestPlexusCompilers {
    public static void main(String[] args) throws Exception {
        // Initialize Plexus container with Sisu support
        PlexusContainer container = new DefaultPlexusContainer();
        try {
            // Add Sisu lifecycle manager to enable annotation scanning
            container.addComponent(new PlexusLifecycleManager());
            container.addComponent(new PlexusContainerAdapter(container));

            // Step 2: Retrieve CompilerManager from the container
            CompilerManager compilerManager = container.lookup(CompilerManager.class);

            // Step 3: Get the desired compiler (e.g., "javac" for Java compiler)
            Compiler compiler = compilerManager.getCompiler("javac");
            System.out.println("Using compiler: " + compiler.getClass().getSimpleName());

            // Step 4: Configure compilation parameters using CompilerConfiguration
            CompilerConfiguration config = new CompilerConfiguration();
            config.setSourceFiles(Set.of(Paths.get("input/zxf/MySourceFile.java").toFile()));
            config.setClasspathEntries(Arrays.asList(System.getProperty("java.class.path").split(File.pathSeparator)));
            config.setOutputLocation("output/classes");
            config.setDebug(true);
            config.setOptimize(true);
            config.setSourceVersion("11");
            config.setReleaseVersion("11");
            config.setTargetVersion("11");

            // Step 5: Perform compilation with the configuration object
            CompilerResult result = compiler.performCompile(config);

            // Step 5: Check compilation result
            if (result.isSuccess()) {
                System.out.println("Compilation succeeded!");
            } else {
                System.out.println("Compilation failed with " + result.getCompilerMessages().size() + " errors:");
                result.getCompilerMessages().forEach(error -> System.out.println(error));
            }
        } finally {
            container.dispose();
        }
    }
}