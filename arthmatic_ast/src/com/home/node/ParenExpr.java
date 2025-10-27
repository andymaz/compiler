package com.home.node;

public class ParenExpr extends Node {
    private final Node expr;

    public ParenExpr(Node expr) {
        this.expr = expr;
    }

    public Node getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        // Show parentheses explicitly in AST
        return "(" + expr.toString() + ")";
    }
}
