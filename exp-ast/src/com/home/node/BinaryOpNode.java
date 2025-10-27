package com.home.node;

public class BinaryOpNode extends ExpNode {
    public String operator;
    public ExpNode left, right;

    public BinaryOpNode(String operator, ExpNode left, ExpNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return '<' +  operator + ", "+ left+ ", " + right + '>';
    }
}
