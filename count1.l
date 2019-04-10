%{
	#include<stdio.h>
	FILE *fp;
	int tspace=0,tword=0,tdigit=0;
%}


digit [0-9]
character [a-zA-Z]+   
space [" "]
%%

{space} {tspace++;}
{character} {tword++;}
{digit} {tdigit++;}
%%


int main(int argc,char *argv[])
{
	fp=fopen(argv[1],"r");
	yyin=fp;
	yylex();
	printf("Number of spaces::%d\nNumber of Words::%d\nNumber of Digits::%d",tspace,tword+1,tdigit);
	return 0;
}



/*
find words give + after character declaration    eg  [a-zA-Z]+

to find characters do not give + after character declaration    eg  [a-zA-Z]

use square bracket for declaration so that file contents will not be displayed on output screen


*/
to 
