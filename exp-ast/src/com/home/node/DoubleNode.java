package com.home.node;

public class DoubleNode extends ExpNode {
    public double value;

    public DoubleNode(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value +"";
    }
}
