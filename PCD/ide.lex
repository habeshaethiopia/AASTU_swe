%{


%}
%%
int|if|main|return {printf("keyword");}
[a-z_][a-zA-Z0-9_]+ {printf("%s identifer ",yytext);}
.+ {printf("%s not identifer\n",yytext);}
%%
int yywrap(){return 0;}
int main(){
 printf("Enter string: \n");
yylex();
//printf("we have %d small letters and %d other characters\n", count,notsmall);
return 0;
}

