package com.home.auxiliary;

import com.home.node.*;
import java.util.List;

public class AssignmentAux {

    private final Node node;

    public AssignmentAux(Node node) {
        this.node = node;
    }

    /** Pretty-print the AST back into readable code. */
    public String prettyPrint() {
        if (node instanceof Num) {
            return Integer.toString(((Num) node).getValue());
        }
        else if (node instanceof Negative) {
            Negative neg = (Negative) node;
            String inner = new AssignmentAux(neg.getExpr()).prettyPrint();
            return "-" + inner;
        }
        else if (node instanceof ParenExpr) {
            ParenExpr paren = (ParenExpr) node;
            String inner = new AssignmentAux(paren.getExpr()).prettyPrint();
            return "(" + inner + ")";
        }
        else if (node instanceof Expr) {
            Expr expr = (Expr) node;
            String left = new AssignmentAux(expr.getLeft()).prettyPrint();
            String right = new AssignmentAux(expr.getRight()).prettyPrint();
            String op = expr.getOperator();
            return left + " " + op + " " + right;
        }
        else if (node instanceof Variable) {
            return ((Variable) node).getName();
        }
        else if (node instanceof AssignmentNode) {
            AssignmentNode assign = (AssignmentNode) node;
            String varName = assign.getVarName();
            String value = new AssignmentAux(assign.getExpr()).prettyPrint();
            return varName + " = " + value;
        }
        else if (node instanceof ExpressionStatementNode) {
            ExpressionStatementNode exprStmt = (ExpressionStatementNode) node;
            return new AssignmentAux(exprStmt.getExpr()).prettyPrint();
        }
        else if (node instanceof SimpleStmtNode) {
            SimpleStmtNode simple = (SimpleStmtNode) node;
            return new AssignmentAux(simple.getStatement()).prettyPrint() + ";";
        }
        else if (node instanceof SmpleStmtNode) {
            SmpleStmtNode smple = (SmpleStmtNode) node;
            return new AssignmentAux(smple.getStatement()).prettyPrint();
        }
        else if (node instanceof CompStmtNode) {
            CompStmtNode block = (CompStmtNode) node;
            List<Node> stmts = block.getStatements();
            StringBuilder sb = new StringBuilder("{ ");
            for (Node stmt : stmts) {
                sb.append(new AssignmentAux(stmt).prettyPrint()).append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        else if (node instanceof ProgNode) {
            ProgNode prog = (ProgNode) node;
            List<Node> stmts = prog.getStatements();
            StringBuilder sb = new StringBuilder();
            for (Node stmt : stmts) {
                sb.append(new AssignmentAux(stmt).prettyPrint()).append("\n");
            }
            return sb.toString();
        }
        else {
            throw new UnsupportedOperationException("Unknown node type: " + node.getClass().getSimpleName());
        }
    }
}
