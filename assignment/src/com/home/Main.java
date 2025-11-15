package com.home;

import com.home.auxiliary.AssignmentAux;
import com.home.gen.*;
import com.home.node.Node;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    private final static String DIR = "io/";

    public static void main(String[] args) throws Exception {
        // Read the program from the file
        CharStream input = fromFileName(DIR + "prog01.txt");

        // Create lexer and token stream
        AssignLexer lexer = new AssignLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create parser
        AssignParser parser = new AssignParser(tokens);

        // Build AST using the visitor
        AssignVisitor visitor = new AssignVisitor();
        Node ast = visitor.visit(parser.prog());

        // Print using auxiliary class
        System.out.println("AST: " + ast);
        AssignmentAux aux = new AssignmentAux(ast);
        System.out.println("Pretty print:");
        System.out.println(aux.prettyPrint());
    }
}
