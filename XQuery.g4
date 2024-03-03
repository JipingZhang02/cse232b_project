grammar XQuery;
import XPath;

forClause: 'for' VAR 'in' xq (',' VAR 'in' xq)*;
letClause: 'let' VAR ':=' xq (',' VAR ':=' xq)*;
whereClause: 'where' cond;
returnClause: 'return' xq;
variables : WS? ID (WS? ',' WS? ID WS?)* ;
variableList : WS? '[' variables? ']' WS?;
joinClause: 'join' WS? '(' forClause ',' forClause ',' variableList ',' variableList ')';

 xq: VAR #VarXq
    | xq ',' xq #CommaXq
    | ap #ApXq
    | '(' xq ')' #ParaXq
    | xq pathOp rp #RpXq
    | startTag '{' xq '}' endTag #TagXq
    | forClause (letClause)? (whereClause)? returnClause #ForXq
    | letClause xq #LetXq
    | joinClause #joinXq
    | STRING #StringXq
    | WS xq WS #wsXq
    | xq xq #CommaXq2
    | startTag xq endTag #TagXq2;




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