/* Parser generator for "SIMPLE FOR LOOP "

30TH jANUARY, 2019

*/

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
