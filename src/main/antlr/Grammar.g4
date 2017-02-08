grammar Grammar;

simpleEq
    : (left=var EQ)? right=expr SEMICOLON? EOF
    ;

var
    : IDENTIFIER
    ;

expr
    : '(' expr ')'                                     #default
    | left=expr op=operator right=expr                 #defaultOperation
    | numericValue                                     #defaultValue
    | euler                                            #defaultEuler
    | name=func '(' expr ')'                           #defaultFunc
    ;

func
    : SIN
    | COS
    | TAN
    ;

numericValue
    : integerValue
    | decimalValue
    ;

integerValue
    : INT_VALUE
    ;

decimalValue
    : DECIMAL_VALUE
    ;

euler
    : 'e'
    ;

operator
    : PLUS
    | MINUS
    | TIMES
    | DIVIDED
    ;

EQ: '=';

SIN: 'sin';
COS: 'cos';
TAN: 'tan';

PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVIDED: '/';

SEMICOLON: ';';

fragment LETTER
    : [a-zA-Z]
    ;

fragment DIGIT
    : [0-9]
    ;

IDENTIFIER
    : (LETTER | '_') (LETTER | DIGIT | '_' | '@')*
    ;

INT_VALUE
    : DIGIT+
    ;

DECIMAL_VALUE
    : (DIGIT+)? '.' DIGIT+
    ;

WS
    : [ \r\n\t]+ -> channel(HIDDEN)
    ;
