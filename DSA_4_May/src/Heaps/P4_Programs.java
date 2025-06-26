package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class P4_Programs 
{

	public static void main(String[] args) 
	{
		PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);
		pq.add(19);
		pq.add(10);
		pq.add(15);
		pq.add(18);
		System.out.println(pq.peek());
		System.out.println(pq);
		System.out.println(pq.remove());
		System.out.println(pq.size());
		System.out.println("Connecting Ropes--->Find Minimum Cost of connecting 2 ropes");
		int a[]= {2,3,6,5,7,11,15,20,10,4};
		int ans=minCost(a);
		System.out.println(ans+"--OlogN");
		System.out.println("Connecting Ropes--->Find Maximum Cost of connecting 2 ropes");
		int ans1=maxCost(a);
		System.out.println(ans1+"--OlogN");
		System.out.println("HeapSort----->");
		heapSort(a);
		for(int x:a)
		{
			System.out.print(x+" ");
		}
		
	}
	private static void heapSort(int[] a) 
	{
		//Hepify
		int n=a.length;
		for(int l=a.length-1;l>=0;l--)
		{
			int i=l;
			while(2*i+1<a.length)
			{
				int mindex=2*i+1;
				if(2*i+2<n)
				{
					if(a[2*i+2]<a[2*i+1])
					{
						mindex=2*i+2;
					}
				}
				if(a[i]<a[mindex])
				{
					break;
				}
				else
				{
					int t=a[i];
					a[i]=a[mindex];
					a[mindex]=t;
					i=mindex;
				}
			}
		}
		
		int n1=a.length;
		while(n1>1)
		{
			int t=a[0];
			a[0]=a[n1-1];
			a[n1-1]=t;
			n1=n1-1;
			int i=0;
			while(2*i+1<n1)
			{
				int mindex=2*i+1;
				if(2*i+2<n1)
				{
					if(a[2*i+2]<a[2*i+1])
					{
						mindex=2*i+2;
					}
				}
				if(a[i]<=a[mindex])
				{
					break;
				}
				else
				{
					int t1=a[i];
					a[i]=a[mindex];
					a[mindex]=t1;
					i=mindex;
				}
				
			}
		}
		swap(a);
		//return a;
		
	}
	private static void swap(int[] a) 
	{
		int left = 0, right = a.length - 1;
	    while (left < right) {
	        // Swap arr[left] and arr[right]
	        int temp = a[left];
	        a[left] = a[right];
	        a[right] = temp;

	        left++;
	        right--;
	    }
		
		
	}
	private static int maxCost(int[] a) 
	{
		 PriorityQueue<Integer> p=new PriorityQueue<>((x,y)->y-x);
		 int n=a.length;
		 for(int i=0;i<n;i++)
		 {
			 p.add(a[i]);
		 }
		 int c=0;
		 while(p.size()>1)//Min one Element is needed to Add
		 {
			int a1=p.poll();
			int b1=p.poll();
			c=c+(a1+b1);
			p.add(a1+b1);			
		 }
		 return c;
	}
	private static int minCost(int[] ar) 
	{
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int n=ar.length;
		for(int i=0;i<n;i++)
		{
			pq.add(ar[i]);
		}
		int c=0;
		while(pq.size()>1)
		{
			int a=pq.poll();
			int b=pq.poll();
			c=c+(a+b);
			pq.add(a+b);
		}
		return c;
	}

}
