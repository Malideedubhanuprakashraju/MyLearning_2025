package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class P5_KthLargestElement 
{

	public static void main(String[] args) 
	{
		int A[]= {8,-3,10,5,11,2,7,9,14,-1};
		int ans=LargeK(A,4);
		System.out.println(ans);
		ArrayList<Integer> ar=LargeKk(A,4);
		System.out.println(ar);
		int ans1=SmallK(A,4);
		System.out.println(ans1);
	}

	private static ArrayList<Integer> LargeKk(int[] a, int k) 
	{
		int n=a.length;
		 PriorityQueue<Integer> pq=new PriorityQueue<>();
		 
		 for(int i=0;i<k;i++)
		 {
			 pq.add(a[i]);
		 }
		 for(int i=k;i<n;i++)
		 {
			 if(a[i]>pq.peek())
			 {
				 pq.remove();
				 pq.add(a[i]);
				// ar.add(a[i]);
				 
			 }
		 }
		 ArrayList<Integer> ar=new ArrayList<>(pq);
		 Collections.sort(ar);
		 return ar;
		 
	}

	private static int SmallK(int[] a, int k) 
	{
		int n=a.length;
		PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);
		
		for(int i=0;i<k;i++)
		{
			pq.add(a[i]);
		}
		for(int i=k;i<n;i++)
		{
			if(a[i]<pq.peek())
			{
				pq.remove();
				pq.add(a[i]);
			}
		}
		return pq.peek();
	}

	private static int LargeK(int[] a, int k) 
	{
		 int n=a.length;
		 PriorityQueue<Integer> pq=new PriorityQueue<>();
		 for(int i=0;i<k;i++)
		 {
			 pq.add(a[i]);
		 }
		 for(int i=k;i<n;i++)
		 {
			 if(a[i]>pq.peek())
			 {
				 pq.remove();
				 pq.add(a[i]);
			 }
		 }
		 return pq.peek();
	}

}
