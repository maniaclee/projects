grammar T;
options {
    language=Java;    // Set target language
}
@members {
    String s;
}
r : ID {s = $ID.text; System.out.println("found "+s);} ;
ID: ('a'..'z'|'A'..'Z') + ;
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace