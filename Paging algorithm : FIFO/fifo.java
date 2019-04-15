/*  PAGING ALGORITHM FIFO

BY UDDESH
*/

import java.util.*;

class fifo
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of frames : ");
		int nf=sc.nextInt();
		int frames[]=new int[nf];
		
		
		for(int i=0;i<nf;i++)
		{
			frames[i]=-1;
		}
		
		System.out.println("Enter numbre of pages : ");
		int np=sc.nextInt();
		int pages[]=new int[np];
		int flag[]=new int[np];
		
		System.out.println("Enter reference pages string : ");
		for(int i=0;i<np;i++)
		{
			System.out.println("Enter ");
			pages[i]=sc.nextInt();
			flag[i]=0;
		}
		
		int count,k=0;
		
		for(int i=0;i<np;i++)
		{
				count=0;
				for(int j=0;j<nf;j++)
				{
					if(pages[i]==frames[j])
					{
						System.out.print("Frames : ");
						for(int n=0;n<nf;n++)
						{
							System.out.print("\t"+frames[n]);
						}
						System.out.print(" -- PAGE HIT\n");
						flag[i]=1;
						break;
					}
					else
					{
						count++;
						if(frames[j]==-1 )
						{
				
							frames[j]=pages[i];
							System.out.print("Frames : ");
							for(int n=0;n<nf;n++)
							{
								System.out.print("\t"+frames[n]);
							}
							System.out.print(" -- PAGE MISS\n");
							flag[i]=1;
							break;
						}	
					}
						
				}
				if(count==3 && flag[i]==0)
				{
					frames[k]=pages[i];
					k++;
					if(k==3)
					{
						k=0;
					}
					System.out.print("Frames : ");
					for(int n=0;n<nf;n++)
					{
						System.out.print("\t"+frames[n]);
					}
					System.out.print(" -- PAGE replaced\n");
				}	
			
		}
	}
}

/* output

captain@uddesh-System-Product-Name:~/SPOS$ javac fifo.java
captain@uddesh-System-Product-Name:~/SPOS$ java fifo
enter no of frames : 
3
Enter numbre of pages : 
12
Enter reference pages string : 
Enter 
2
Enter 
3
Enter 
2
Enter 
1
Enter 
5
Enter 
2
Enter 
4
Enter 
5
Enter 
3
Enter 
2
Enter 
5
Enter 
2
Frames : 	2	-1	-1 -- PAGE MISS
Frames : 	2	3	-1 -- PAGE MISS
Frames : 	2	3	-1 -- PAGE HIT
Frames : 	2	3	1 -- PAGE MISS
Frames : 	5	3	1 -- PAGE replaced
Frames : 	5	2	1 -- PAGE replaced
Frames : 	5	2	4 -- PAGE replaced
Frames : 	5	2	4 -- PAGE HIT
Frames : 	3	2	4 -- PAGE replaced
Frames : 	3	2	4 -- PAGE HIT
Frames : 	3	5	4 -- PAGE replaced
Frames : 	3	5	2 -- PAGE replaced

*/
