package com.home.aux;

import com.home.node.*;

public class Aux {

    public ExpNode node;

    public Aux(ExpNode node) {
        this.node = node;
    }

    public String pretty_print() {
        if (node instanceof DoubleNode) {
            return ((DoubleNode) node).value + "";
        }
        else if (node instanceof UnaryNode) {
            UnaryNode unaryNode = (UnaryNode) node;
            String body = (new Aux(unaryNode.body)).pretty_print();
            return "-" + body;
        }
        else if (node instanceof BinaryOpNode) {
            BinaryOpNode binOpNode = (BinaryOpNode) node;
            String leftValue = (new Aux(binOpNode.left)).pretty_print();
            String rightValue = (new Aux(binOpNode.right)).pretty_print();;
            switch (binOpNode.operator) {
                case "+":
                    return leftValue +" + " + rightValue;
                case "-":
                    return leftValue +" - " + rightValue;
                case "*":
                    return leftValue + " * " + rightValue;
                case "/":
                    return leftValue + " / " + rightValue;
                case "%":
                    return leftValue + " % " + rightValue;
                default:
                    throw new UnsupportedOperationException("Unknown operator " + binOpNode.operator);
            }
        }
        return "";
    }

    public double evaluate() {
        if (node instanceof DoubleNode) {
            return ((DoubleNode) node).value;
        }
        else if (node instanceof UnaryNode) {
            UnaryNode unaryNode = (UnaryNode) node;
            double body = (new Aux(unaryNode.body)).evaluate();
            return -1.0 * body;
        }
        else if (node instanceof BinaryOpNode) {
            BinaryOpNode binOpNode = (BinaryOpNode) node;
            double leftValue = (new Aux(binOpNode.left)).evaluate();
            double rightValue = (new Aux(binOpNode.right)).evaluate();;
            switch (binOpNode.operator) {
                case "+":
                    return leftValue + rightValue;
                case "-":
                    return leftValue - rightValue;
                case "*":
                    return leftValue * rightValue;
                case "/":
                    return leftValue / rightValue;
                case "%":
                    return leftValue % rightValue;
                default:
                    throw new UnsupportedOperationException("Unknown operator " + binOpNode.operator);
            }
        }
        return 0.0;
    }

}
