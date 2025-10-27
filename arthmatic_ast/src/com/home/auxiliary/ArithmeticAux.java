package com.home.auxiliary;

import com.home.node.*;

public class ArithmeticAux {

    private final Node node;

    public ArithmeticAux(Node node) {
        this.node = node;
    }

    /** Pretty-print the AST back into readable infix notation. */
    public String prettyPrint() {
        if (node instanceof Num) {
            return Integer.toString(((Num) node).getValue());
        }
        else if (node instanceof Negative) {
            Negative neg = (Negative) node;
            String inner = new ArithmeticAux(neg.getExpr()).prettyPrint();
            return "-" + inner;
        }
        else if (node instanceof ParenExpr) {
            ParenExpr paren = (ParenExpr) node;
            String inner = new ArithmeticAux(paren.getExpr()).prettyPrint();
            return "(" + inner + ")";
        }
        else if (node instanceof Expr) {
            Expr expr = (Expr) node;
            String left = new ArithmeticAux(expr.getLeft()).prettyPrint();
            String right = new ArithmeticAux(expr.getRight()).prettyPrint();
            String op = expr.getOperator();
            return left + " " + op + " " + right;
        }
        else {
            throw new UnsupportedOperationException("Unknown node type: " + node.getClass().getSimpleName());
        }
    }

    /** Evaluate the AST recursively. */
    public double evaluate() {
        if (node instanceof Num) {
            return ((Num) node).getValue();
        }
        else if (node instanceof Negative) {
            Negative neg = (Negative) node;
            return -new ArithmeticAux(neg.getExpr()).evaluate();
        }
        else if (node instanceof ParenExpr) {
            ParenExpr paren = (ParenExpr) node;
            return new ArithmeticAux(paren.getExpr()).evaluate();
        }
        else if (node instanceof Expr) {
            Expr expr = (Expr) node;
            double left = new ArithmeticAux(expr.getLeft()).evaluate();
            double right = new ArithmeticAux(expr.getRight()).evaluate();
            String op = expr.getOperator();
            switch (op) {
                case "+": return left + right;
                case "-": return left - right;
                case "*": return left * right;
                case "/": return left / right;
                default:
                    throw new UnsupportedOperationException("Unknown operator: " + op);
            }
        }
        else {
            throw new UnsupportedOperationException("Unknown node type: " + node.getClass().getSimpleName());
        }
    }
}
