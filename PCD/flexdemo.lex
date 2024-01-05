%{
int count=0;
int notsmall=0;
%}
%%
[a-z] {printf("%s  is a small letter\n", yytext);count++;};
[A-Z] {printf("%s is a capital letter\n", yytext);notsmall++; };
[1-9] {printf("%s is number\n", yytext); notsmall++;}
. {printf("%s is not a letter\n", yytext); notsmall++;}
\n {return 0;}
%%
int yywrap(){return 0;}
int main(){
 printf("Enter string: \n");
yylex();
printf("we have %d small letters and %d other characters\n", count,notsmall);
return 0;
}
