/* BANKERS ALGORITHM  

BY UDDESH
*/

import java.util.*;

class banker
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter number of processes : ");
		int np=sc.nextInt();
		System.out.println("Enter number of resources : ");
		int nr=sc.nextInt();
		
		int alloc[][]=new int[np][nr];
		int max[][]=new int[np][nr];
		int need[][]=new int[np][nr];
		int avail[][]=new int[1][nr];
		int flag[]=new int[np];
		
		System.out.println("Enter allocation ");                // for allocation matrix
		for(int i=0;i<np;i++)
		{
			System.out.println("Enter for process P"+(i+1)+" : ");
			for(int j=0;j<nr;j++)
			{
				System.out.println("Enter allocated resource R"+(j+1)+" : ");
				alloc[i][j]=sc.nextInt();
			}
			flag[i]=0;
		}
		
		System.out.println("Enter max need ");                // for max need matrix
		for(int i=0;i<np;i++)
		{
			System.out.println("Enter for process P"+(i+1)+" : ");
			for(int j=0;j<nr;j++)
			{
				System.out.println("Enter max required resource R"+(j+1)+" : ");
				max[i][j]=sc.nextInt();
			}
		}
		
		              
		for(int i=0;i<np;i++)                                 // for need matrix calculation
		{
			for(int j=0;j<nr;j++)
			{
				need[i][j]=max[i][j]-alloc[i][j];
			}
		}
		
		
		System.out.println("Enter available resources ");             
		for(int j=0;j<nr;j++)
		{
			System.out.println("Enter available R"+(j+1)+" : ");
			avail[0][j]=sc.nextInt();
		}
		
		
		int completed_processes=0;
		int maxiteration=20;
		int safeseq[]=new int[np];
		while(completed_processes!=np)
		{
			if(maxiteration!=0)                 // condition to come out of infinite loop
			{
					for(int i=0,k=0;i<np;i++,k++)
					{
					
						if(flag[i]==0)
						{
							int count=0;
							for(int j=0;j<nr;j++)
							{
								if(need[i][j]<=avail[0][j])
								{
									count++;
								}
							}
							if(count==nr)
							{
								for(int j=0;j<nr;j++)
								{
										avail[0][j]=avail[0][j]-need[i][j]+max[i][j];
																
								}
								flag[i]=1;
								safeseq[k]=i;
								//System.out.println("P"+(i+1));
								completed_processes++;
							}
						}
					}
				//System.out.println("--->> "+completed_processes);
				maxiteration--;
			}
			else
				break;         	
		}
		
		if(maxiteration==0)
			System.out.println("(/\) NO Safe Sequence  ");
		else
		{
			System.out.println("Safe Sequence : ");
			for(int i=0;i<np;i++)
				System.out.println("P"+(safeseq[i]+1)+"\t");
		}
	}
}

/*

output ---------------------------------------------------------------------------------------------

captain@uddesh-System-Product-Name:~/SPOS$ javac banker.java
captain@uddesh-System-Product-Name:~/SPOS$ java banker
Enter number of processes : 
5
Enter number of resources : 
3
Enter allocation 
Enter for process P1 : 
Enter allocated resource R1 : 
0
Enter allocated resource R2 : 
1
Enter allocated resource R3 : 
0
Enter for process P2 : 
Enter allocated resource R1 : 
2
Enter allocated resource R2 : 
0
Enter allocated resource R3 : 
0
Enter for process P3 : 
Enter allocated resource R1 : 
3
Enter allocated resource R2 : 
0
Enter allocated resource R3 : 
2
Enter for process P4 : 
Enter allocated resource R1 : 
2
Enter allocated resource R2 : 
1
Enter allocated resource R3 : 
1
Enter for process P5 : 
Enter allocated resource R1 : 
0
Enter allocated resource R2 : 
0
Enter allocated resource R3 : 
2
Enter max need 
Enter for process P1 : 
Enter max required resource R1 : 
7
Enter max required resource R2 : 
5
Enter max required resource R3 : 
3
Enter for process P2 : 
Enter max required resource R1 : 
3
Enter max required resource R2 : 
2
Enter max required resource R3 : 
2
Enter for process P3 : 
Enter max required resource R1 : 
9
Enter max required resource R2 : 
0
Enter max required resource R3 : 
2
Enter for process P4 : 
Enter max required resource R1 : 
2
Enter max required resource R2 : 
2
Enter max required resource R3 : 
2
Enter for process P5 : 
Enter max required resource R1 : 
4
Enter max required resource R2 : 
3
Enter max required resource R3 : 
3
Enter available resources 
Enter available R1 : 
3
Enter available R2 : 
3
Enter available R3 : 
2

Safe Sequence : 
P2	
P4	
P5	
P1	
P3

*/
