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
rp: tagName #UnaryRp1 | attName #UnaryRp2| TEXT #UnaryRp3| STAR #UnaryRp4| SELF #UnaryRp5| PENT #UnaryRp6
    | rp pathOp rp #BinaryRp1| rp COMMA rp #BinaryRp2
    | LPR rp RPR  #ParaRp
    | rp LSB filter RSB #FilterRp;
filter: rp #UnaryFta
    | rp compOp rp #BinaryFt1 | rp EQS stringCondition #BinaryFt2
    | LPR filter RPR #ParaFt
    | filter CONJ filter #CompoundFt
    | NEG filter #NegFt;

pathOp:
SL | DSL;

docName:
DOC LPR fileName RPR; //https://canvas.ucsd.edu/courses/32790/discussion_topics/406595

fileName: STRING;

tagName:
ID;

attName:
AT ID;

compOp:
EQS | EQ | ISS | IS;

stringCondition:
STRING;

/*Tokens*/
SL: '/';
DSL: '//';
SELF: '.';
PENT: '..';
STAR: '*';
LPR: '(';
RPR: ')';
LSB: '[';
RSB: ']';
COMMA: ',';
EQS: '=';
EQ: 'eq';
ISS: '==';
IS: 'is';
NEG: 'not';
CONJ: ('and' | 'or');
TEXT: 'text()';
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