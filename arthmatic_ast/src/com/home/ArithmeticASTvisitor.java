package com.home;

import com.home.gen.ArithmeticParser;
import com.home.gen.ArithmeticBaseVisitor;
import com.home.node.*;


public class ArithmeticASTvisitor extends ArithmeticBaseVisitor<Node> {

        @Override
        public Node visitNumber(ArithmeticParser.NumberContext ctx) {
            int value = Integer.parseInt(ctx.NUM().getText());
            return new Num(value);
        }

        @Override
        public Node visitNegative(ArithmeticParser.NegativeContext ctx) {
            Node expr = visit(ctx.expr());
            return new Negative(expr);
        }

        @Override
        public Node visitAdditive(ArithmeticParser.AdditiveContext ctx) {
            Node left = visit(ctx.left);
            Node right = visit(ctx.right);
            String op = ctx.op.getText();
            return new Expr(left, op, right);
        }

        @Override
        public Node visitMultiplicative(ArithmeticParser.MultiplicativeContext ctx) {
            Node left = visit(ctx.left);
            Node right = visit(ctx.right);
            String op = ctx.op.getText();
            return new Expr(left, op, right);
        }

        @Override
        public Node visitBracketed(ArithmeticParser.BracketedContext ctx) {
            Node expr = visit(ctx.expr());
            return new ParenExpr(expr);
        }
    }


