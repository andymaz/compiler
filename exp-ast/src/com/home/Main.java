package com.home;

import com.home.aux.Aux;
import com.home.gen.*;
import com.home.node.ExpNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import static org.antlr.v4.runtime.CharStreams.fromFileName;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private final static String DIR = "io/";

    public static void main(String[] args) throws Exception {
        // Create an input stream
        CharStream input = fromFileName(DIR + "ex02.txt");
        // Create the lexer and token stream
        ExpASTLexer lexer = new ExpASTLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create the parser
        ExpASTParser parser = new ExpASTParser(tokens);

        // Use the listener or visitor to build the AST
        AST_Exp visitor = new AST_Exp();
        ExpNode ast = visitor.visit(parser.expr());

        // Print or process the AST
        System.out.println(ast);
        Aux ax = new Aux(ast);
        System.out.println(ax.evaluate());
        System.out.println(ax.pretty_print());
    }
}