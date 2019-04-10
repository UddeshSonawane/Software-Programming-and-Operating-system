//  program to takr input from command line and print on console
/*
import java.io.*;     //   basic input output
import java.util.Scanner;     // for input

class btp
{
  public static void main(String[] args)
  {
    for(int i=0;i< args.length;i++)
    {
    	System.out.println(args[i]);
    }
  }
}


//output

//unix@unix-HP-280-G1-MT:~$ javac btp.java
//unix@unix-HP-280-G1-MT:~$ java btp 10 20 30
//10
//20
//30



*/
//---------------------------------------------------------------------------------
/*

//store the command line input in an array.  And print that array

import java.io.*;     //   basic input output
import java.util.Scanner;     // for input

class btp
{
  public static void main(String[] args)
  {
    String arr[] = new String[3];
    for(int i=0;i< args.length;i++)
    {
	arr[i] = args[i];
    }

    for(int i=0; i<args.length; i++)
    {
       System.out.println(arr[i]);
    }

  }
}

//output

//unix@unix-HP-280-G1-MT:~$ javac btp.java
//unix@unix-HP-280-G1-MT:~$ java btp mov rax,rbx
//mov
//rax,rbx
*/
//-------------------------------------------------------------------------------

//program to create tokens of the input from command line and store them in an 2d array

import java.io.*;     //   basic input output
import java.util.Scanner;     // for input

class btp
{
  public static void main(String[] args)
  {
    String arr[][] = new String[5][3];
   for(int j=0;j<((args.length/3)+1);j++)
   {
        for(int k=0;k<3;k++)
        {
              for(int i=0;i< args.length;i++)
              {
                  arr[j][k] = args[i];
              }
        }
   }

    for(int j=0;j<((args.length/3)+1);j++)
   {
        //for(int i=0;i< args.length;i++)
    //    {
              for(int k=0;k<3;k++)
              {
                  System.out.println(arr[j][k]);
              }
             
       //}
   }
  }
}
