package psyco.ast;

import org.apache.commons.io.IOUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Created by lipeng on 15/9/14.
 */
public class ASTDemo {
    static final File f = new File("/Users/psyco/workspace/github/projects/src/main/java/psyco/springRMI/client/Data.java");
    CompilationUnit unit;
    List<ImportDeclaration> imports;

    @Test
    public ASTDemo parse(File file) throws Exception {
        String content = IOUtils.toString(new FileReader(file));
        ASTParser parser = ASTParser.newParser(AST.JLS3); //initialize
        parser.setKind(ASTParser.K_COMPILATION_UNIT);     //to parse compilation unit
        parser.setSource(content.toCharArray());          //content is a string which stores the java source
        parser.setResolveBindings(true);
        this.unit = (CompilationUnit) parser.createAST(null);
        this.imports = unit.imports();
        return this;
    }

    public void imports() {
    }

}
