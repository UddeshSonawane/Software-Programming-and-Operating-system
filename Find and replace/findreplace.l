
%{
	#include<stdio.h>
	#include<string.h>
	FILE *f1,*f2;
	char find[20],replace[20],fname[20];
%}

word [a-zA-Z]+
eol  '\n'
dot [.]

%%
{word} {  if(strcmp(find,yytext)==0)
			fprintf(f2,replace);
		else
			fprintf(f2,yytext);		
}
{dot} { fprintf(f2,yytext);}
{eol} { fprintf(f2,yytext);}
%%

int main(int argc, char *argv[])
{
	strcpy(fname,argv[1]);
	strcpy(find,argv[2]);
	strcpy(replace,argv[3]);
	f1 = fopen(fname,"r+");
	f2= fopen("rep.txt","w+");
	yyin = f1;
	yylex();
	return (0);
}
/*
output

finding.txt file:
hi
hello
no

rep.txt file:
hihellobye

unix@unix-HP-280-G1-MT:~/Desktop/TEB45$ ./a.out finding.txt no bye
unix@unix-HP-280-G1-MT:~/Desktop/TEB45$ cat rep.txt
cat: rep.txt: No such file or directory

*/
