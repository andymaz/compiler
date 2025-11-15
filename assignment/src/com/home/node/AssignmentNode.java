package com.home.node;

public class AssignmentNode extends Node {
    private final String varName;
    private final Node expr;

    public AssignmentNode(String varName, Node expr) {
        this.varName = varName;
        this.expr = expr;
    }

    public String getVarName() {
        return varName;
    }

    public Node getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        return varName + " = " + expr.toString();
    }
}
