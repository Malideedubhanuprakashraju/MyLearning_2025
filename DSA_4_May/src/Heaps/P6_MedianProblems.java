package Heaps;

import java.util.PriorityQueue;

public class P6_MedianProblems {

	public static void main(String[] args) 
	{
		 int a[]= {4,6,9,2,1,10,14,7,3,5};
		// KthLargeSubbAll(a,3);
		 int ans[]=Median(a);
		 for(int x:ans)
		 {
			 System.out.print(x+" ");
		 }
	}

	private static int[] Median(int[] a) 
	{
		 int n=a.length;
		 int ans[]=new int[n];
		 PriorityQueue<Integer> b1=new PriorityQueue<>((x,y)->y-x);
		 PriorityQueue<Integer> b2=new PriorityQueue<>();
		 b1.add(a[0]);
		 ans[0]=a[0];
		 for(int i=1;i<n;i++)
		 {
			 if(a[i]>b1.peek())
			 {
				 b2.add(a[i]);
			 }
			 else
			 {
				 b1.add(a[i]);
			 }
			 if(b1.size()-b2.size()==2)
			 {
				 int ele=b1.peek();
				 b1.remove();
				 b2.add(ele);
			 }
			 if(b1.size()-b2.size()==-1)
			 {
				 int ele=b2.peek();
				 b2.remove();
				 b1.add(ele);
			 }
			 int total=b1.size()+b2.size();
			 if(total%2==1)
			 {
				 ans[i]=b1.peek();
			 }
			 else
			 {
				 ans[i]=(int) ((b1.peek()+b2.peek())/2.0);
			 }
		 }
		 return ans;
	}

	private static void KthLargeSubbAll(int[] a, int k) 
	{
		 int n=a.length;
		 PriorityQueue<Integer> pq=new PriorityQueue<>();
		 for(int i=0;i<k;i++)
		 {
			 pq.add(a[i]);
		 }
		 System.out.print(pq.peek()+" ");
		 for(int i=k;i<n;i++)
		 {
			 if(a[i]>pq.peek())
			 {
				 pq.remove();
				 pq.add(a[i]);
			 }
			 System.out.print(pq.peek()+" ");
		 }
		
	}

}
