package com.home;

import com.home.auxiliary.ArithmeticAux;
import com.home.gen.*;
import com.home.node.Node;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    private final static String DIR = "io/";

    public static void main(String[] args) throws Exception {
        // Read expression from file
        CharStream input = fromFileName(DIR + "exp01.txt");

        // Create lexer and token stream
        ArithmeticLexer lexer = new ArithmeticLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create parser
        ArithmeticParser parser = new ArithmeticParser(tokens);

        // Build AST using the visitor
        ArithmeticASTvisitor visitor = new ArithmeticASTvisitor();
        Node ast = visitor.visit(parser.expr());

        // Print and evaluate using auxiliary class
        System.out.println("AST: " + ast);
        ArithmeticAux aux = new ArithmeticAux(ast);
        System.out.println("Pretty print: " + aux.prettyPrint());
        System.out.println("Evaluated: " + aux.evaluate());
    }
}
