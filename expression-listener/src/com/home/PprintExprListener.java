package com.home;

import java.util.Stack;

public class PprintExprListener extends ExprBaseListener {

    private Stack<String> stack = new Stack<>();

    @Override
    public void exitInt(ExprParser.IntContext context)
    {
        String i = context.INT().getText();
        stack.push(i);
    }

    @Override
    public void exitStart(ExprParser.StartContext context)
    {
        String result = stack.pop();
        System.out.println(result);
    }

    @Override
    public void exitMult(ExprParser.MultContext context)
    {
        String r = stack.pop();
        String l = stack.pop();
        String operator = context.op.getText();
        String result;
        if (operator.equals("*"))
            result = l + " * " + r;
        else
            result = l + " / " + r;
        stack.push(result);
    }

    @Override
    public void exitAdd(ExprParser.AddContext context)
    {
        String r = stack.pop();
        String l = stack.pop();
        String operator = context.op.getText();
        String result;
        if (operator.equals("+"))
            result = l + " + " + r;
        else
            result = l + " - " + r;
        stack.push(result);
    }

    @Override public void exitParen(ExprParser.ParenContext ctx) {
        String p = stack.pop();
        stack.push("("+ p +")");
    }
}

