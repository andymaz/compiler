package com.home.node;

public class SmpleStmtNode extends Node {
    private final Node statement;

    public SmpleStmtNode(Node statement) {
        this.statement = statement;
    }

    public Node getStatement() {
        return statement;
    }

    @Override
    public String toString() {
        return statement.toString();
    }
}
