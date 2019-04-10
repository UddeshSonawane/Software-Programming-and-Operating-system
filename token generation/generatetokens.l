/* 
Assignment No: 6
Write a program using Lex specifications to implement lexical analysis phase of compiler to
generate tokens of subset of ‘Java’ program

*/

%{
        #include<stdio.h>
        FILE *fp;
%}

inbuiltfun "System.out.println(".*");"
mainfunction "public static void main".*
%%

{inbuiltfun} {printf("Inbuilt Function is %s",yytext);}
{mainfunction} {printf("Main Function is %s",yytext);}
%%

int main(int argc, char *argv[])
{
	fp=fopen(argv[1],"r");
	yyin=fp;
	yylex();
	return 0;
}

/*


INPUT PROGRAM

class hello{
            public static void main(String args[])
            {
                System.out.println("Hello World");
             }
            }
            
            
            
OUTPUT

unix@unix-HP-280-G1-MT:~$ lex ass6.l
unix@unix-HP-280-G1-MT:~$ gcc lex.yy.c -ll
unix@unix-HP-280-G1-MT:~$ ./a.out hello.java


class hello{
            Main Function is public static void main(String args[])
            {
                Inbuilt Function is System.out.println("Hello World");
             }
            }

*/
