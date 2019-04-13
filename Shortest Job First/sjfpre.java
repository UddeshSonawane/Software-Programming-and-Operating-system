/*  SHORTEST JOB FIRST   PREEMPTIVE ALGORITHM
    
    includes  :  arrival time of process
                 burst time 
                 completion time
                 waiting time
                 turn around time
                 sequence in which processes get execute
                 
    by Uddesh
*/

import java.util.*;

class sjfpre
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of processes : ");
		int n=sc.nextInt();
		
		int btime[]=new int[n];
		int copybtime[]=new int[n];
		int atime[]=new int[n];
		int wtime[]=new int[n];
		int tat[]=new int[n];
		int completiontime[]=new int[n];
		int flag[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter arrival time of process "+(i+1)+" : ");
			atime[i]=sc.nextInt();
			
			System.out.println("Enter burst time of process "+(i+1)+" : ");
			btime[i]=sc.nextInt();
			copybtime[i]=btime[i];
			flag[i]=0;
		}
		
		/*for(int i=0;i<n;i++)
		{
			System.out.println(" arrival time of process "+(i+1)+" : "+atime[i]);			
			System.out.println(" burst time of process "+(i+1)+" : "+btime[i]);
		}*/
		
		int completed_processes=0, clock=0;
		
		System.out.print("Execution sequence ");
		while(true)
		{
			int c=n, min=100;
			if(n==completed_processes)
			{	//all processes get executed
				break;
			}
			
			for(int i=0;i<n;i++)
			{
				if((btime[i]<min) && (flag[i]==0) && (atime[i]<=clock)) 
				{
					min=btime[i];
					c=i;
				}
			}
			
			if(c==n)
			{// no process arrived till this point of time
				clock++;
			}
			else
			{
				System.out.print("P"+(c+1)+"  ");
				btime[c]--;
				clock++;
				if(btime[c]==0)
				{
					completiontime[c]=clock;
					flag[c]=1;
					completed_processes++;
				}
			}			
		}
		
		float avgtat=0, avgwait=0;
		for(int i=0;i<n;i++)
		{
			tat[i]=completiontime[i]-atime[i];
			wtime[i]=tat[i]-copybtime[i];
			avgtat=avgtat+tat[i];
			avgwait=avgwait+wtime[i];
		}
		
		System.out.println("\nProcess\tA Time\tB Time\tC Time\tW Time\tTAT Time");
		for(int i=0;i<n;i++)
		{
			System.out.println("P"+(i+1)+"\t"+atime[i]+"\t"+copybtime[i]+"\t"+completiontime[i]+"\t"+wtime[i]+"\t"+tat[i]);
		}
		
		System.out.println("Average waiting time : "+(float)avgwait/n);
		System.out.println("Average turn around time : "+(float)avgtat/n);
		sc.close();
		
		
	}
}

/*output

captain@uddesh-System-Product-Name:~/SPOS$ javac sjfpre.java
captain@uddesh-System-Product-Name:~/SPOS$ java sjfpre
Enter number of processes : 
5
Enter arrival time of process 1 : 
0
Enter burst time of process 1 : 
3
Enter arrival time of process 2 : 
1
Enter burst time of process 2 : 
5
Enter arrival time of process 3 : 
3
Enter burst time of process 3 : 
2
Enter arrival time of process 4 : 
9
Enter burst time of process 4 : 
5
Enter arrival time of process 5 : 
12
Enter burst time of process 5 : 
5
Execution sequence P1  P1  P1  P3  P3  P2  P2  P2  P2  P2  P4  P4  P4  P4  P4  P5  P5  P5  P5  P5  
Process	A Time	B Time	C Time	W Time	TAT Time
P1	    0	      3	      3	      0	      3
P2	    1	      5	      10	    4     	9
P3	    3	      2	      5	      0	      2
P4	    9     	5	      15	    1	      6
P5	    12	    5	      20	    3	      8
Average waiting time : 1.6
Average turn around time : 5.6

*/
