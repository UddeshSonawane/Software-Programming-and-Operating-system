/* SHORTEST JOB FIRST NON PREEMPTIVE

	includes  :  arrival time of process
                 burst time 
                 completion time
                 waiting time
                 turn around time
By Uddesh
*/

import java.util.*;

class sjfnp
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of processes : ");
		int n=sc.nextInt();
		int btime[]=new int[n];
		int atime[]=new int[n];
		int flag[] = new int[n];
		int wtime[] = new int[n];
		int completiontime[] = new int[n];
		int tat[] = new int[n];
		float avgwt=0, avgtat=0;
		
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter arrival time for process "+(i+1)+" : ");
			atime[i]=sc.nextInt();
			System.out.println("Enter burst time for process "+(i+1)+" : ");
			btime[i]=sc.nextInt();
			flag[i]=0;
		}
		
		int process_completed=0, clock=0;    // clock the system clock time
		
				
		boolean a = true;
		while(true)
		{
			int c=n, min=100;
			
			if(process_completed==n)
			{
				System.out.println("----  All processes get executed   ----");
				break;
			}
			
			// check minimum burst time value here
			for(int i=0;i<n;i++)
			{
				if((atime[i]<=clock) && (flag[i]==0) && (btime[i]<min))
				{
					min=btime[i];
					c=i;
				}
			}
				
			if(c==n)   // c not get updated
			{
				// means no process arrived at that clock time 
				clock++; // so increment clock time
			}
			else
			{
				completiontime[c]=btime[c]+clock;
				clock=clock+btime[c];
				tat[c]=completiontime[c]-atime[c];
				wtime[c]=tat[c]-btime[c];
				flag[c]=1;
				process_completed++;
			}
		}
		
		System.out.println("Process\tA Time\tB Time\tC Time\tTA Time\tW Time");
		for(int i=0;i<n;i++)
		{
			avgwt=avgwt+wtime[i];
			avgtat=avgtat+tat[i];	
			System.out.println("  "+(i+1)+"\t"+atime[i]+"\t"+btime[i]+"\t"+completiontime[i]+"\t"+tat[i]+"\t"+wtime[i]);
		}
		System.out.println("Average Waiting Time : "+(float)avgwt/n);
		System.out.println("Average Turn Around Time : "+(float)avgtat/n);
		sc.close();
	}
}


/*

output

captain@uddesh-System-Product-Name:~/SPOS$ javac sjfnp.java
captain@uddesh-System-Product-Name:~/SPOS$ java sjfnp
Enter number of processes : 
4
Enter arrival time for process 1 : 
0
Enter burst time for process 1 : 
8
Enter arrival time for process 2 : 
1
Enter burst time for process 2 : 
4
Enter arrival time for process 3 : 
2
Enter burst time for process 3 : 
9
Enter arrival time for process 4 : 
3
Enter burst time for process 4 : 
5
----  All processes get executed   ----
Process	A Time	B Time	C Time	TA Time	W Time
  1	    0	      8	      8	      8	      0
  2	    1	      4	      12	    11	    7
  3	    2     	9	      26	    24	    15
  4	    3	      5	      17	    14	    9
Average Waiting Time : 7.75
Average Turn Around Time : 14.25

*/
