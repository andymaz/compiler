package com.home.node;

import java.util.List;

public class ProgNode extends Node {
    private final List<Node> statements;

    public ProgNode(List<Node> statements) {
        this.statements = statements;
    }

    public List<Node> getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node stmt : statements) {
            sb.append(stmt.toString()).append("\n");
        }
        return sb.toString();
    }
}
