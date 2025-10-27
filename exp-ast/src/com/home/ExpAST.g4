grammar ExpAST;

start : expr ;

expr : '-' expr                                  # UMINUS
     | left=expr multiplicative_op right=expr    # MULOPGRP
     | left=expr additive_op right=expr          # ADDOPGRP
     | '(' expr ')'                              # PARENGRP
     | NUMBER                                    # DOUBLE
     ;

additive_op       : '+' | '-' ;

multiplicative_op : '*' | '/' | '%' ;

// lexer

NUMBER : ('0' .. '9') + ('.' ('0' .. '9') +)? ;

WS : [ \r\n\t] + -> skip ;