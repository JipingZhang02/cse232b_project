grammar XQuery;
import XPath;

forClause: 'for' VAR 'in' xq (',' VAR 'in' xq)*;
letClause: 'let' VAR ':=' xq (',' VAR ':=' xq)*;
whereClause: 'where' cond;
returnClause: 'return' xq;

 xq: VAR #VarXq
    | STRING #StringXq
    | xq ',' xq #CommaXq
    | ap #ApXq
    | '(' xq ')' #ParaXq
    | xq pathOp rp #RpXq
    | startTag '{' xq '}' endTag #TagXq
    | forClause (letClause)? (whereClause)? returnClause #ForXq
    | letClause xq #LetXq
    | WS xq WS #wsXq;



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