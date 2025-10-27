package com.home.node;

public class Compound extends ExpNode {
    public ExpNode left;
    public Compound right;

    public Compound(ExpNode left, Compound right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return  left.toString()  + right.toString();
    }
}
