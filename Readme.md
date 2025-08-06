# Core Classes of JDK Compiler
- javax.tools.JavaCompiler
- com.sun.tools.javac.api.JavacTool(Legacy API)

# Core Classes of Plexus Compiler
## plexus-compiler-api: The API to use compilers
- org.codehaus.plexus.compiler.Compiler
- org.codehaus.plexus.compiler.AbstractCompiler
- org.codehaus.plexus.compiler.CompilerConfiguration
- org.codehaus.plexus.compiler.CompilerResult
## plexus-compiler-manager: A manager to choose a compiler
- org.codehaus.plexus.compiler.manager.CompilerManager
- org.codehaus.plexus.compiler.manager.DefaultCompilerManager
## plexus-compiler-javac: javac compiler requires JDK 8+
- org.codehaus.plexus.compiler.javac.JavacCompiler(Default compiler, support in-process and out-process compile)
- org.codehaus.plexus.compiler.javac.InProcessCompiler
- org.codehaus.plexus.compiler.javac.JavaxToolsCompiler implements InProcessCompiler

# Eclipse Sisu
- Eclipse Sisu 是Plexus的轻量级依赖注入实现，可以用来加载Plexus组件（如CompilerManager和Compiler）