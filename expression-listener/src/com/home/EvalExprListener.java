package com.home;

import java.util.Stack;

public class EvalExprListener extends ExprBaseListener {

    private final Stack <Integer> stack = new Stack<>();

    @Override
    public void exitInt(ExprParser.IntContext context)
    {
        int i = Integer.parseInt(context.INT().getText());
        stack.push(i);
    }

    @Override
    public void exitStart(ExprParser.StartContext context)
    {
        int result = stack.pop();
        System.out.println(result);
    }

    @Override
    public void exitMult(ExprParser.MultContext context)
    {
        int r = stack.pop();
        int l = stack.pop();
        String operator = context.op.getText();
        int result;
        if (operator.equals("*"))
            result = l * r;
        else
            result = l / r;
        stack.push(result);
    }

    @Override
    public void exitAdd(ExprParser.AddContext context)
    {
        int r = stack.pop();
        int l = stack.pop();
        String operator = context.op.getText();
        int result;
        if (operator.equals("+"))
            result = l + r;
        else
            result = l - r;
        stack.push(result);
    }

    @Override public void exitParen(ExprParser.ParenContext ctx) {
        int i = stack.pop();
        stack.push(i);
    }
}
