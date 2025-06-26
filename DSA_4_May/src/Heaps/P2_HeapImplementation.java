package Heaps;

import java.util.ArrayList;

public class P2_HeapImplementation 
{
	ArrayList<Integer> ar;
	
	P2_HeapImplementation()
	{
		ar=new ArrayList<>();
	}
	public int ssize()
	{
		return ar.size();
	}
	public int getMin()
	{
		return ar.get(0);
	}
	public void insert(int x)
	{
		ar.add(x);
		int i=ar.size()-1;
		
		
		while(i>0)
		{
			int parent=(i-1)/2;
			if(ar.get(i)>=ar.get(parent))
			{
				break;
			}
			else
			{
				int t=ar.get(i);
				ar.set(i,ar.get(parent));
				ar.set(parent,t);
				i=parent;
			}
		}
		
	}
	public void delete()
	{
		int n =ar.size();
		ar.set(0,ar.get(n-1));
		ar.remove(n-1);
		n=n-1;
		int i=0;
		while(2*i+1<n)
		{
			int mindex=2*i+1;
			if(2*i+2<n && ar.get(2*i+2)<ar.get(mindex))
			{
				mindex=2*i+2;
			}
			if(ar.get(i)<=ar.get(mindex))
			{
				break;
			}
			else
			{
				int t=ar.get(i);
				ar.set(i,ar.get(mindex));
				ar.set(mindex,t);
				
				i=mindex;
			}
			
		}
		
	}
	public void heapify(ArrayList<Integer> ar)
	{
		int n=ar.size();
		
		for(int k=n-1;k>=0;k--)
		{
			int i=k;
			while(2*i+1<n)
			{
				int mindex=2*i+1;
				if((2*i+2<n)&&(ar.get(2*i+2)<ar.get(2*i+1)))
				{
					mindex=2*i+2;
				}
				if(ar.get(i)<ar.get(mindex))
				{
					break;
				}
				else
				{
					int t=ar.get(i);
					ar.set(i,ar.get(mindex));
					ar.set(mindex,t);
					
					i=mindex;
				}
			}
		}
		
		
	}
	

}







