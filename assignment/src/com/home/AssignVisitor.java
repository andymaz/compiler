package com.home;

import com.home.gen.AssignParser;
import com.home.node.*;
import com.home.gen.AssignBaseVisitor;
import java.util.ArrayList;
import java.util.List;

// @SuppressWarnings("CheckReturnValue")
public class AssignVisitor extends AssignBaseVisitor<Node> {

    // prog: stmt* EOF
    @Override
    public Node visitProg(AssignParser.ProgContext ctx) {
        List<Node> stmts = new ArrayList<>();
        for (AssignParser.StmtContext sctx : ctx.stmt()) {
            stmts.add(visit(sctx));
        }
        return new ProgNode(stmts);
    }

    // stmt: smple_stmt SEMI_COL | LBRKT stmt+ RBRKT
    @Override
    public Node visitSimpleStmt(AssignParser.SimpleStmtContext ctx) {
        Node stmtNode = visit(ctx.smple_stmt());
        return new SimpleStmtNode(stmtNode);
    }

    @Override
    public Node visitCompStmt(AssignParser.CompStmtContext ctx) {
        List<Node> stmts = new ArrayList<>();
        for (AssignParser.StmtContext sctx : ctx.stmt()) {
            stmts.add(visit(sctx));
        }
        return new CompStmtNode(stmts);
    }

    // smple_stmt: assign
    @Override
    public Node visitSmple_stmt(AssignParser.Smple_stmtContext ctx) {
        Node stmtNode = visit(ctx.assign());
        return new SmpleStmtNode(stmtNode);
    }

    // assign: ID '=' expr | expr
    @Override
    public Node visitAssignment(AssignParser.AssignmentContext ctx) {
        if (ctx.ID() != null && ctx.expr() != null) {
            String varName = ctx.ID().getText();
            Node exprNode = visit(ctx.expr());
            return new AssignmentNode(varName, exprNode);
        } else {
            return visit(ctx.expr()); // expressionStatement
        }
    }

    @Override
    public Node visitExpressionStatement(AssignParser.ExpressionStatementContext ctx) {
        Node exprNode = visit(ctx.expr());
        return new ExpressionStatementNode(exprNode);
    }

    // Expressions
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

    @Override
    public Node visitVariable(AssignParser.VariableContext ctx) {
        return new Variable(ctx.ID().getText());
    }

    @Override
    public Node visitMultiplicative(AssignParser.MultiplicativeContext ctx) {
        Node left = visit(ctx.left);
        Node right = visit(ctx.right);
        String op = ctx.op.getText();
        return new Expr(left, op, right);
    }

    @Override
    public Node visitAdditive(AssignParser.AdditiveContext ctx) {
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
}
