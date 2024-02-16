grammar XQuery;
import XPath;

 xq: VAR #VarXq
    | STRING #StringXq
    | ap #ApXq
    | '(' xq ')' #ParaXq
    | xq ',' xq #CommaXq
    | xq pathOp rp #RpXq
    | startTag '{' xq '}' endTag #TagXq
    | forClause (letClause)? (whereClause)? returnClause #ForXq
    | letClause xq #LetXq
    | WS xq WS #wsXq;


forClause: 'for' VAR 'in' xq (',' VAR 'in' xq)*;
letClause: 'let' VAR ':=' xq (',' VAR ':=' xq)*;
whereClause: 'where' cond;
returnClause: 'return' xq;

cond: xq EQ xq #EqCond1 | xq EQS xq #EqCond2
    | xq IS xq #IsCond1 | xq ISS xq #IsCond2
    | 'empty(' xq ')' #EmptyCond
    | satisfy cond #SatCond
    | '(' cond ')' #ParaCond
    | cond filterOp cond #ConjunctCond
    | 'not' cond #NegCond;
satisfy: 'some' VAR 'in' xq (',' VAR 'in' xq)* 'satisfies';
startTag: '<' tagName '>';
endTag: '</' tagName '>';

VAR: '$' ID;