package com.home.node;

public class Expr extends Node {
    private final Node left;     // left operand
    private final String operator; // "+", "-", "*", "/"
    private final Node right;    // right operand

    public Expr(Node left, String operator, Node right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public String getOperator() {
        return operator;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        // Simple representation of the AST
        return "(" + left + " " + operator + " " + right + ")";
    }
}
