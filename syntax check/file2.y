
// program to take for loop as input from a file

/* Parser generator for "SIMPLE FOR LOOP "

30TH jANUARY, 2019

*/

/*   ass8.l

%{
	#include "y.tab.h"
	extern int yylval;
%}

%%
"for" {return (FOR);}
"(" {return (OPBR);}
")" {return (CLBR);}
"{" {return (OPCBR);}
"}" {return (CLCBR);}
";" {return (SEMI);}
"=" {return (EQU);}
"++" {return (INC);}
"--" {return (DEC);}
"<"|">"|"<="|">=" {return (REOP);}
[a-z|A-Z] {yylval=yytext[0]; return ID;}
[0-9]+ {yylval=atof(yytext); return NUM;}    // +followed by[0-9] is to accept any combinations of 0-9

%%
*/


//  Main Program

%{
	#include<stdio.h>
	#include<string.h>
	FILE *f1;                // create file pointer
	int flag=0;   
%}

%token FOR OPBR CLBR SEMI INC DEC REOP ID NUM EQU OPCBR CLCBR  //which we have defined in ass8.l file

%%
S:FOR OPBR E1 SEMI E2 SEMI E3 CLBR OPCBR CLCBR {printf("\nAccepted ! "); flag=1;};
//FOR OPBR E1   SEMI  E2  SEMI  E3  CLBR OPCBR CLCBR
//for (    i=0   ;   i<n   ;   i++   )    {      }

E1:ID EQU NUM |  ID EQU ID  ; 
// ID EQU NUM |  ID EQU ID 
// i   =  0  or  i  =   j

E2:ID REOP NUM | ID REOP ID ;
// ID REOP NUM |   ID REOP ID 
// i   <    0  or  i   <   j          REOP maybe one of the " <, >, <=, >= "

E3:ID INC | ID DEC;
// ID INC |   ID DEC
// i  ++  or  i  --
%%

extern int yylex();   // extern for global declaration  // yylex() to scan the input left to right
extern int yyparse();  // yyparse() is used for parsing the file  (to parse tokens)
extern FILE *yyin;    // pointer of file get created

int main()
{
	f1 = fopen("for.c","r+");
	yyin=f1;
	yyparse();    // meet at the end of program
	if(flag==0)
	{
		printf("\n ??? Error in Syntax ???");
	}
	return 0;
}
   
/*

OUTPUT: 

  unix@unix-HP-280-G1-MT:~$ lex ass8.l
unix@unix-HP-280-G1-MT:~$ yacc -d ass8.y
unix@unix-HP-280-G1-MT:~$ cc lex.yy.c y.tab.c -ll -ly
y.tab.c: In function ‘yyparse’:
y.tab.c:1146:16: warning: implicit declaration of function ‘yylex’ [-Wimplicit-function-declaration]
       yychar = yylex ();
                ^
y.tab.c:1281:7: warning: implicit declaration of function ‘yyerror’ [-Wimplicit-function-declaration]
       yyerror (YY_("syntax error"));
       ^
unix@unix-HP-280-G1-MT:~$ ./a.out

Accepted ! 






*/

