/*Priority scheduling algorithm  NONPREEMPTIVE
 
By Uddesh
*/

import java.util.*;

class priority
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of processes : ");
		int n=sc.nextInt();
		
		int priority[]=new int[n];
		int atime[]=new int[n];
		int btime[]=new int[n];
		int wtime[]=new int[n];
		int flag[]=new int[n];
		int completiontime[]=new int[n];
		int tat[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Arrival time of process "+(i+1)+" : ");
			atime[i]=sc.nextInt();
			System.out.println("Enter Burst time of process "+(i+1)+" : ");
			btime[i]=sc.nextInt();
			System.out.println("Enter Priority of process "+(i+1)+" : ");
			priority[i]=sc.nextInt();
			flag[i]=0;
		}
		
		int completed=0, max, c=n, clock=0;
		while(true)
		{
			if(completed==n)
				break;
			
			max=0;	
			for(int i=0;i<n;i++)
			{
				if(priority[i]>=max && flag[i]==0 && atime[i]<=clock)
				{
					max=priority[i];
					c=i;					
				}
			}
			
			if(c==n);
			else
			{
				clock=clock+btime[c];
				completiontime[c]=clock;
				flag[c]=1;
				completed++;
				tat[c]=completiontime[c]-atime[c];
				wtime[c]=tat[c]-btime[c];
			}
			
			System.out.println("\n\nVersion "+completed);
			System.out.println("Process\tA time\tB time\tC time\tTA time\tW time\tPriority");
			for(int i=0;i<n;i++)
			{
				System.out.println("P"+(i+1)+"\t"+atime[i]+"\t"+btime[i]+"\t"+completiontime[i]+"\t"+tat[i]+"\t"+wtime[i]+"\t"+priority[i]);
			}	
		}
		/*System.out.println("Process\tB time\tPriority\tC time");
		for(int i=0;i<n;i++)
		{
			System.out.println("P"+(i+1)+"\t"+btime[i]+"\t"+priority[i]+"\t"+completiontime[i]);
		}*/
	}

}



/*
output

captain@uddesh:~$ javac priority.java
captain@uddesh:~$ java priority
Enter number of processes : 
5
Enter Arrival time of process 1 : 
0
Enter Burst time of process 1 : 
11
Enter Priority of process 1 : 
2
Enter Arrival time of process 2 : 
5
Enter Burst time of process 2 : 
28
Enter Priority of process 2 : 
0
Enter Arrival time of process 3 : 
12
Enter Burst time of process 3 : 
2
Enter Priority of process 3 : 
3
Enter Arrival time of process 4 : 
2
Enter Burst time of process 4 : 
10
Enter Priority of process 4 : 
1
Enter Arrival time of process 5 : 
9
Enter Burst time of process 5 : 
16
Enter Priority of process 5 : 
4


Version 1
Process	A time	B time	C time	TA time	W time	Priority
P1	    0	      11	    11	    11	    0     	2
P2	    5	      28     	0     	0	      0     	0
P3	    12     	2	      0	      0	      0	      3
P4      2	      10     	0     	0	      0	      1
P5	    9	      16    	0	      0	      0	      4


Version 2
Process	A time	B time	C time	TA time	W time	Priority
P1	    0	      11	    11	    11	    0       2
P2	    5	      28      0       0	      0     	0
P3	12	2	0	0	0	3
P4	2	10	0	0	0	1
P5	9	16	27	18	2	4


Version 3
Process	A time	B time	C time	TA time	W time	Priority
P1	0	11	11	11	0	2
P2	5	28	0	0	0	0
P3	12	2	29	17	15	3
P4	2	10	0	0	0	1
P5	9	16	27	18	2	4


Version 4
Process	A time	B time	C time	TA time	W time	Priority
P1	0	11	11	11	0	2
P2	5	28	0	0	0	0
P3	12	2	29	17	15	3
P4	2	10	39	37	27	1
P5	9	16	27	18	2	4


Version 5
Process	A time	B time	C time	TA time	W time	Priority
P1	0	11	11	11	0	2
P2	5	28	67	62	34	0
P3	12	2	29	17	15	3
P4	2	10	39	37	27	1
P5	9	16	27	18	2	4
*/




