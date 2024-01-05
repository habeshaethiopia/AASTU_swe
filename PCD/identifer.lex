%{


%}
%%
[0-9]+{10} {printf("%s a phone number\n",yytext);return 0;}
[0-9]+{0,9}|[0-9]+{11} {printf("%s invalid phone\n",yytext);return 0;}
%%
int yywrap(){return 0;}
int main(){
 printf("Enter string: \n");
yylex();
//printf("we have %d small letters and %d other characters\n", count,notsmall);
return 0;
}
