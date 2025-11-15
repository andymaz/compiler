package com.home;

import com.home.gen.AssignParser;
import com.home.node.*;
import com.home.gen.AssignBaseVisitor;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;


@SuppressWarnings("CheckReturnValue")
public class AssignVisitor extends AssignBaseVisitor<Node> {

    @Override public Node visitProg(AssignParser.ProgContext ctx) { return visitChildren(ctx); }

    @Override public Node visitSimpleStmt(AssignParser.SimpleStmtContext ctx) { return visitChildren(ctx); }

    @Override public Node visitCompStmt(AssignParser.CompStmtContext ctx) { return visitChildren(ctx); }

    @Override public Node visitSmple_stmt(AssignParser.Smple_stmtContext ctx) { return visitChildren(ctx); }

    @Override public Node visitAssignment(AssignParser.AssignmentContext ctx) { return visitChildren(ctx); }

    @Override public Node visitExpressionStatement(AssignParser.ExpressionStatementContext ctx) { return visitChildren(ctx); }

    @Override
    public Node visitNumber(AssignParser.NumberContext ctx) {
        int value = Integer.parseInt(ctx.NUM().getText());
        return new Num(value);
    }

    @Override
    public Node visitNegative(AssignParser.NegativeContext ctx) {
        Node expr = visit(ctx.expr());
        return new Negative(expr);
    }

    @Override public Node visitVariable(AssignParser.VariableContext ctx) { return visitChildren(ctx); }

    @Override
    public Node visitMultiplicative(AssignParser.MultiplicativeContext ctx) {
        Node left = visit(ctx.left);
        Node right = visit(ctx.right);
        String op = ctx.op.getText();
        return new Expr(left, op, right);
    }

    @Override
    public Node visitBracketed(AssignParser.BracketedContext ctx) {
        Node expr = visit(ctx.expr());
        return new ParenExpr(expr);
    }
    @Override
    public Node visitAdditive(AssignParser.AdditiveContext ctx) {
        Node left = visit(ctx.left);
        Node right = visit(ctx.right);
        String op = ctx.op.getText();
        return new Expr(left, op, right);
    }
}