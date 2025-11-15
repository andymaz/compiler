package com.home;

import com.home.gen.ExprLexer;
import com.home.gen.ExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    private final static String DIR = "input/";

    public static void main(String[] args) throws IOException {
        CharStream cs_E = fromFileName(DIR + "expr02.txt");  //read the input file
        ExprLexer lexer_E = new ExprLexer(cs_E);  //create a lexer object
        ExprParser parser_E = new ExprParser(new CommonTokenStream(lexer_E));
        parser_E.addParseListener(new EvalExprListener());
        parser_E.start();

        System.out.println("-----");

        CharStream cs_P = fromFileName(DIR + "expr02.txt");  //read the input file
        ExprLexer lexer_P = new ExprLexer(cs_P);  //create a lexer object
        ExprParser parser_P = new ExprParser(new CommonTokenStream(lexer_P));
        parser_P.addParseListener(new PprintExprListener());
         parser_P.start();
    }
}
