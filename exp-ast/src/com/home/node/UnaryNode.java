package com.home.node;

public class UnaryNode extends ExpNode {
    public ExpNode body;

    public UnaryNode(ExpNode body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "-" + body;
    }
}
