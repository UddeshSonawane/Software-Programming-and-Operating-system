/* C++ program to perform LRU on Page Frame */

#include<iostream>
using namespace std;

int main()
{
	int list[]={7,0,1,2,0,3,0};
	int page_frame[3];
	int j;
	
	for(int i=0;i<3;i++)
	{
		page_frame[i]=-1;
	}
	
	for(int j=0,i=0;j<7;j++)  //7 is the size of list provided
	{
		int x;
		if(page_frame[i]==-1)
		{
			page_frame[i]=list[j];
			i++;
		}
		else
		{
			int distinct[3];
			//x=LRU(list[j]);
			for(int k=0,dec=1;k<3;k++,dec++)
			{
				if(list[j-dec]==page_frame[k])
				{
					cout<<"\n HIT  NO OPERATION";
					break;
				}
				
				for(int i=0;i<3;i++)
					distinct[i]=-1;
				
				for(int count=0;count!=3;j--)
				{
					for(int i=0;i<3;i++)
					{
						if(list[j-1]!=distinct[i])
						{
							distinct[count]=list[j-1];
							count++;
						}
						else if(list[j-1]!=distinct[i])
						{
							continue;
						}
					}	
				}
			} 
		}	
		page_frame[x]=list[j];
	}
return 0;
}
