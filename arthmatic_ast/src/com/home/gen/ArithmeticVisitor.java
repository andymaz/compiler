// Generated from /home/andrei/IdeaProjects/arthmatic_ast/src/com/home/Arithmetic.g4 by ANTLR 4.13.2
package com.home.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArithmeticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArithmeticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ArithmeticParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negative}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative(ArithmeticParser.NegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicative}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative(ArithmeticParser.MultiplicativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketed}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketed(ArithmeticParser.BracketedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additive}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive(ArithmeticParser.AdditiveContext ctx);
}