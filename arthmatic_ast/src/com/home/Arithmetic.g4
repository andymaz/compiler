grammar Arithmetic;

expr
    :  MINUS expr                               # negative
    |  left=expr op=(MULT | DIV) right=expr     # multiplicative
    |  left=expr op=(PLUS | MINUS) right=expr   # additive
    | LPAREN expr RPAREN                        # bracketed
    | NUM                                       # number
    ;





PLUS:   '+' ;
MINUS:  '-' ;
MULT:    '*' ;
DIV:    '/' ;
LPAREN: '(' ;
RPAREN: ')' ;
NUM:    [0-9]+ ;
WS:     [ \t\r\n]+ -> skip ;
