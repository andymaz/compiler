package com.home.node;

public class ExpressionStatementNode extends Node {
    private final Node expr;

    public ExpressionStatementNode(Node expr) {
        this.expr = expr;
    }

    public Node getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        return expr.toString();
    }
}
