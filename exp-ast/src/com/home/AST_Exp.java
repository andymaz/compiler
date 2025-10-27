package com.home;

import com.home.gen.*;
import com.home.node.*;

public class AST_Exp extends ExpASTBaseVisitor<ExpNode>{
    @Override public ExpNode visitStart(ExpASTParser.StartContext ctx) { return visitChildren(ctx); }

    @Override public ExpNode visitUMINUS(ExpASTParser.UMINUSContext ctx) {
        ExpNode body = visit(ctx.expr());
        return new UnaryNode(body);
    }

    @Override public ExpNode visitPARENGRP(ExpASTParser.PARENGRPContext ctx) {
        return visit(ctx.expr());
    }

    @Override public ExpNode visitDOUBLE(ExpASTParser.DOUBLEContext ctx) {
        double number = Double.parseDouble(ctx.NUMBER().getText());
        return new DoubleNode(number);
    }

    @Override public ExpNode visitMULOPGRP(ExpASTParser.MULOPGRPContext ctx) {
        ExpNode left = visit(ctx.expr(0));
        String operation = ctx.mulop().getText();
        ExpNode right = visit(ctx.expr(1));
        return new BinaryOpNode(operation, left, right);
    }

    @Override public ExpNode visitADDOPGRP(ExpASTParser.ADDOPGRPContext ctx) {
        ExpNode left = visit(ctx.expr(0));
        String operation = ctx.addop().getText();
        ExpNode right = visit(ctx.expr(1));
        return new BinaryOpNode(operation, left, right);
    }

    @Override public ExpNode visitAddop(ExpASTParser.AddopContext ctx) { return visitChildren(ctx); }

    @Override public ExpNode visitMulop(ExpASTParser.MulopContext ctx) { return visitChildren(ctx); }
}
