package com.home.test;

import com.home.ArithmeticASTvisitor;
import com.home.gen.*;
import com.home.node.*;
import org.antlr.v4.runtime.*;

public class ASTTest {
    public static void main(String[] args) throws Exception {
        String[] tests = {
                "2*3+4",
                "4*(5+6)",
                "-2*3+4"
        };

        for (String expr : tests) {
            System.out.println("Input: " + expr);

            // Create lexer and parser
            ArithmeticLexer lexer = new ArithmeticLexer(CharStreams.fromString(expr));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ArithmeticParser parser = new ArithmeticParser(tokens);

            // Parse
            ArithmeticParser.ExprContext tree = parser.expr();

            // Build AST using your visitor
            ArithmeticASTvisitor visitor = new ArithmeticASTvisitor();
            Node ast = visitor.visit(tree);  // must return a folded AST

            // Print the AST
            System.out.println("AST: " + ast);
            System.out.println("-----------");
        }
    }
}
