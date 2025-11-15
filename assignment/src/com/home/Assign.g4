grammar Assign;

prog
    :   stmt* EOF
    ;

stmt
    : smple_stmt SEMI_COL   # simpleStmt
    | LBRKT stmt+ RBRKT     # compStmt
    ;

smple_stmt : assign ;
assign
    :   ID '=' expr              # assignment
    |   expr                     # expressionStatement
    ;

expr
    :   MINUS expr                               # negative
    |   left=expr op=(MULT | DIV) right=expr     # multiplicative
    |   left=expr op=(PLUS | MINUS) right=expr   # additive
    |   LPAREN expr RPAREN                        # bracketed
    |   NUM                                       # number
    |   ID                                        # variable
    ;

PLUS:   '+' ;
MINUS:  '-' ;
MULT:   '*' ;
DIV:    '/' ;
LPAREN: '(' ;
RPAREN: ')' ;
LBRKT:   '{' ;
RBRKT:   '}' ;
SEMI_COL: ';' ;

ID:     [a-zA-Z_][a-zA-Z_0-9]* ;
NUM:    [0-9]+ ;

WS:     [ \t\r\n]+ -> skip ;
