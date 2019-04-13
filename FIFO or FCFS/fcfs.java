/* Scheduling algorithm    FCFS  (non preemptive)    in Java

Included : Arrival Time
           Burst Time
           Waiting Time
           Average Waiting Time of System
           Turn Around Time
           
By Uddesh
*/

import java.util.*;
class fcfs
{
	public static void main(String[] args) 
	{
		int atime[]=new int[20];
		int btime[] = new int[20];
		int wtime[]= new int[20];
		int tat[]= new int[20];
		int total=0;
		float avg;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of processes : ");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Arrival Time of process "+(i+1)+" : ");
			atime[i]=sc.nextInt();
			System.out.println("Enter Burst Time of process "+(i+1)+" : ");
			btime[i]=sc.nextInt();
		}
		
		wtime[0]=0;
		for(int i=1;i<n;i++)
		{
			wtime[i]=wtime[i-1]+btime[i-1]-(atime[i]-atime[i-1]);
			total =total+wtime[i];
		}
		
		for(int i=0;i<n;i++)
		{
			tat[i]=btime[i]+wtime[i];
		}
				
		avg=(float)total/n;
		System.out.println("Process_No\tArrival Time\tBurst Time\tWaiting Time\tTurn Around Time");
		for(int i=0;i<n;i++)
		{
			System.out.println((i+1)+"\t\t"+atime[i]+"\t\t"+btime[i]+"\t\t"+wtime[i]+"\t\t"+tat[i]);
		}
			
		System.out.println("Total witing time : "+total+"\nAverage waiting time : "+avg);
	}
}


/*

output :

captain@uddesh-System-Product-Name:~/SPOS$ javac cfs.java
captain@uddesh-System-Product-Name:~/SPOS$ java fcfs
Enter number of processes : 
5
Enter Arrival Time of process 1 : 
0
Enter Burst Time of process 1 : 
3
Enter Arrival Time of process 2 : 
1
Enter Burst Time of process 2 : 
5
Enter Arrival Time of process 3 : 
3
Enter Burst Time of process 3 : 
2
Enter Arrival Time of process 4 : 
9
Enter Burst Time of process 4 : 
5
Enter Arrival Time of process 5 : 
12
Enter Burst Time of process 5 : 
5
Process_No	Arrival Time	Burst Time	Waiting Time	Turn Around Time
1		0		3		0		3
2		1		5		2		7
3		3		2		5		7
4		9		5		1		6
5		12		5		3		8
Total witing time : 11
Average waiting time : 2.2

*/
