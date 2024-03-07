grammar XQuery;
import XPath;

joinClause: 'join' '(' xq ',' xq ',' variableList ',' variableList ')';
forClause: 'for' VAR 'in' xq (',' VAR 'in' xq)*;
letClause: 'let' VAR ':=' xq (',' VAR ':=' xq)*;
whereClause: 'where' cond;
returnClause: 'return' xq;
variables : ID ( ','  ID )* ;
variableList : '[' variables? ']';

 xq: VAR #VarXq
    | xq ',' xq #CommaXq
    | xq xq #CommaXq2
    | ap #ApXq
    | '(' xq ')' #ParaXq
    | xq pathOp rp #RpXq
    | startTag '{' xq '}' endTag #TagXq
    | startTag  xq  endTag #TagXq2
    | joinClause #JoinXq
    | forClause (letClause)? (whereClause)? returnClause #ForXq
    | letClause xq #LetXq
    | STRING #StringXq;


cond: xq EQ xq #EqCondEqStr | xq EQS xq #EqCondMathOp
    | xq IS xq #EqCondIsStr | xq ISS xq #EqCondDoubleMathOp
    | 'empty(' xq ')' #EmptyCond
    | satisfy cond #SatCond
    | '(' cond ')' #ParaCond
    | 'not' cond #NegCond
    | cond filterOp cond #ConjunctCond;
satisfy: 'some' VAR 'in' xq (',' VAR 'in' xq)* 'satisfies';
startTag: '<' tagName '>';
endTag: '</' tagName '>';

VAR: '$' ID;