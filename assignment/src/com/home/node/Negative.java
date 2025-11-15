package com.home.node;

public class Negative extends Node {
    private final Node expr;

    public Negative(Node expr) {
        this.expr = expr;
    }

    public Node getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        // Unary minus binds tightly, just prefix "-"
        return "-" + expr.toString();
    }
}
