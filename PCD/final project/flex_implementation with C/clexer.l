%{
#include <stdio.h>
%}

letter      [a-zA-Z]
digit       [0-9]
id          ({letter}|_)([a-zA-Z0-9]|_)*
num         {digit}+
ws          [ \t\n]


comment     "//".*\n*
string      \"([^\"]|\\.)*\"

%%

int         { printf("Keyword: int\n"); }
float       { printf("Keyword: float\n"); }
if          { printf("Keyword: if\n"); }
else        { printf("Keyword: else\n"); }
return      { printf("Keyword: return\n"); }
switch      { printf("Keyword: switch\n"); }
case        { printf("Keyword: case\n"); }
break       { printf("Keyword: break\n"); }
continue    { printf("Keyword: continue\n"); }
void        { printf("Keyword: void\n"); }
String      { printf("Keyword: String\n"); }

{id}        { printf("Identifier: %s\n", yytext); }
{num}       { printf("Literal: %s\n", yytext); }
{ws}        ;  // Ignore whitespace

[=+*/-]     { printf("Operator: %s\n", yytext); }
"=="        { printf("Operator: ==\n"); }
"!="        { printf("Operator: !=\n"); }
"<"         { printf("Operator: <\n"); }
"<="        { printf("Operator: <=\n"); }
">"         { printf("Operator: >\n"); }
">="        { printf("Operator: >=\n"); }
"&&"        { printf("Operator: &&\n"); }
"||"        { printf("Operator: ||\n"); }

{comment}   ;

{string}    { printf("String: %s\n", yytext); }

[{}()[\],;.] { printf("Punctuator: %s\n", yytext); }

.           { printf("Unrecognized character: %s\n", yytext); }

%%

int main(int argc, char* argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
        return 1;
    }

    FILE* fp = fopen(argv[1], "r");
    if (fp == NULL) {
        perror("Error opening file");
        return 1;
    }

    yyin = fp;
    yylex();
    fclose(fp);

    return 0;
}

int yywrap() {
    return 1;  // Indicate EOF
}
