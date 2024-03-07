grammar XPath;

@header {
package edu.ucsd.cse232b.autogen;
}

/*Rules*/
ap: docName pathOp rp;
rp: tagName         #TagnameRp
    | attName       #AttrRp
    | 'text()'      #TextRp
    | '*'           #StarRp
    | '..'          #ParentRp
    | '.'           #SelfRp
    | rp pathOp rp  #BinaryRp
    | rp ',' rp     #CommaRp
    | '(' rp ')'    #BracketRp
    | rp'['filter']'#FilterRp;
filter: 'not' filter   #NegFt
    | rp boolOp rp   #BinaryFt
    | rp #UnaryFta
    | rp EQS stringCondition #StrEqFt
    | '(' filter ')' #BracketFt
    | filter filterOp filter #CompoundFt;

pathOp:
'//'|'/';

docName: 'doc(' fileName ')';

fileName: STRING;

tagName:
ID;

attName:
'@' ID;

boolOp:
EQS | EQ | ISS | IS;

filterOp:
'and' | 'or';

stringCondition:
STRING;

EQS: '=';
EQ: 'eq';
ISS: '==';
IS: 'is';
ID: [a-zA-Z][a-zA-Z_0-9]*;
WS: [ \t\n\r]+ -> skip;
STRING
:
   '"'
   (
      ESCAPE
      | ~["\\]
   )* '"'
   | '\''
   (
      ESCAPE
      | ~['\\]
   )* '\''
;
ESCAPE
:
   '\\'
   (
      ['"\\]
   )
;