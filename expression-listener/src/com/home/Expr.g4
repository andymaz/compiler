grammar Expr;

start : expr ;
expr    :
            left=expr op=('*'|'/') right=expr     # Mult
        |   left=expr op=('+'|'-') right=expr     # Add
        |   INT                                   # Int
        |   '(' expr ')'                          # Paren
        ;

INT    : [0-9]+ ;
WS     : [ \t\r\n]+ -> skip;
