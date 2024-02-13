grammar XPath;


//abspath: 'doc("' FileNameString '")//' relpath #AbsPath2
//        |'doc("' FileNameString '")/'  relpath #AbsPath1;
//
//relpath: '(' relpath ')' #BracketRelPath
//        |NameString #TagName
//        |'*' #AllChildren
//        |'.' #CurrTag
//        |'..' #Parent
//        |'text()' #GetText
//        |'@' NameString #AttrName
//        |relpath '//' relpath #RelPath2
//        |relpath '/' relpath  #RelPath1
//        |relpath ',' relpath  #RelPathTuple
//        |relpath'['filter']'      #FilteredRelpath;
//
//filter: relpath '=' NameString; // todo
//
//Separator2 : '//' ;
//Separator1 : '/' ;
//NameString: [0-9a-zA-Z]+;
//FileNameString: [0-9a-zA-Z.]+;
//ContentString: [0-9a-zA-Z._-]+;
//NEWLINE:'\r'? '\n' ;
//WS  :   [ \t]+ -> skip ;


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
AT ID;

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
AT: '@';
DOC: [dD][oO][cC];
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