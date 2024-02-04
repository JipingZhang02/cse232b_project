grammar XPath;

//prog:   (expr NEWLINE)* ;
//expr:   expr ('*'|'/') expr
//      | expr ('+'|'-') expr
//      | INT
//      | '(' expr ')' ;
//
//INT :   [0-9]+ ;
//NEWLINE:'\r'? '\n' ;
//WS  :   [ \t]+ -> skip ;

//docspecifier: 'doc("' FileName '")' # Doc;
abspath: 'doc("' FileNameString '")//' relpath #AbsPath2
        |'doc("' FileNameString '")/'  relpath #AbsPath1;

relpath: '(' relpath ')' #BracketRelPath
        |NameString #TagName
        |'*' #AllChildren
        |'.' #CurrTag
        |'..' #Parent
        |'text()' #GetText
        |'@' NameString #AttrName
        |relpath '//' relpath #RelPath2
        |relpath '/' relpath  #RelPath1
        |relpath ',' relpath  #RelPathTuple
        |relpath'['filter']'      #FilteredRelpath;

filter: relpath '=' NameString; // todo

Separator2 : '//' ;
Separator1 : '/' ;
NameString: [0-9a-zA-Z]+;
FileNameString: [0-9a-zA-Z.]+;
ContentString: [0-9a-zA-Z._-]+;
NEWLINE:'\r'? '\n' ;
WS  :   [ \t]+ -> skip ;