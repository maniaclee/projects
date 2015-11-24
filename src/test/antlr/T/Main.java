package antlr.T;

import antlr.T.gen.TLexer;
import antlr.T.gen.TParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
 
  public static void main(String[] args) throws Exception {
//    ANTLRInputStream input = new ANTLRInputStream(System.in);
    ANTLRInputStream input = new ANTLRInputStream("fuck sdf \n  shit ");
    TLexer lexer = new TLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    TParser parser = new TParser(tokens);
    parser.r();
  }
} 
