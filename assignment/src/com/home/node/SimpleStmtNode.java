package com.home.node;

public class SimpleStmtNode extends Node {
    private final Node statement;

    public SimpleStmtNode(Node statement) {
        this.statement = statement;
    }

    public Node getStatement() {
        return statement;
    }

    @Override
    public String toString() {
        return statement.toString() + ";";
    }
}
