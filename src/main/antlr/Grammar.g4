
grammar Grammar;

expr
    : '(' expr ')'                                     #default
    | left=expr operator=(PLUS | MINUS) right=expr     #expression
    | value                                            #defaultValue
    | func '(' expr ')'                                #defaultFunc
    ;

func
    : SIN
    | COS
    ;

value
    : INT
//    | DECIMAL
    ;

SIN: 'sin';
COS: 'cos';
PLUS: '+';
MINUS: '-';
SEMICOLON: ';';

fragment DIGIT
    : [0-9]
    ;

INT
    : DIGIT+
    ;

//DECIMAL
//    : DIGIT+ ('.' (DIGIT+)?)
//    | ('.' DIGIT+)
//    ;

WS
    : [ \r\n\t]+ -> channel(HIDDEN)
    ;