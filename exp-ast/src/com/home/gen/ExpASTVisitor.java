// Generated from /home/andrei/IdeaProjects/exp-ast/src/com/home/ExpAST.g4 by ANTLR 4.13.2
package com.home.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpASTParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpASTVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpASTParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExpASTParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UMINUS}
	 * labeled alternative in {@link ExpASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUMINUS(ExpASTParser.UMINUSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PARENGRP}
	 * labeled alternative in {@link ExpASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPARENGRP(ExpASTParser.PARENGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link ExpASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLE(ExpASTParser.DOUBLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link ExpASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULOPGRP(ExpASTParser.MULOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link ExpASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDOPGRP(ExpASTParser.ADDOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpASTParser#addop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddop(ExpASTParser.AddopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpASTParser#mulop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulop(ExpASTParser.MulopContext ctx);
}