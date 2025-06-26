package GreedyPrograms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;



public class P1_Main 
{

	public static void main(String[] args) 
	{
		// 1) Max Tasks which can be done
		int s[]= {4,5,3,9,2};
		int e[]= {7,7,5,10,8};
		//	int s[] = {1, 3, 0, 5, 8, 5};
		//	int e[] = {2, 4, 6, 7, 9, 9};
		//int ans=maxJobs(s,e);
		//System.out.println(ans);
		// 2) Job Scheduling
		
		int d[]= {3,1,2,1,3};
		int p[]= {100,19,27,25,30};
		int ans1=maxjob(d,p);
		System.out.println(ans1);
		
		// 3)Max Chacolates Distribution or Candles
		int a[]= {1,5,2,1};
		int ans=maxChacolates(a);
		System.out.println(ans);
		

	}

	private static int maxChacolates(int[] marks) 
	{
		 int n=marks.length;
		 int left[]=new int[n];
		 int right[]=new int[n];
		 
		 for(int i=0;i<n;i++)
		 {
			 left[i]=1;
			 right[i]=1;
		 }
		 
		 for(int i=1;i<n;i++)
		 {
			 if(marks[i]>marks[i-1])
			 {
				 left[i]=left[i-1]+1;
			 }
		 }
		 for(int i=n-2;i>=0;i--)
		 {
			 if(marks[i]>marks[i+1])
			 {
				 right[i]=right[i+1]+1;
			 }
		 }
		 int ans=0;
		 for(int i=0;i<n;i++)
		 {
			 ans=ans+Math.max(left[i],right[i]);
		 }
		 return ans; 
	}

	private static int maxjob(int[] d, int[] p) 
	{
		 ArrayList<pair> ar=new ArrayList<>();
		 for(int i=0;i<d.length;i++)
		 {
			 ar.add(new pair(d[i],p[i]));
		 }
		 Collections.sort(ar,new paircomprator());
		 
		 PriorityQueue<Integer> pq=new PriorityQueue<>();
		 int ans=0;
		 for(int i=0;i<d.length;i++)
		 {
			 if(ar.get(i).d>pq.size())
			 {
				 pq.add(ar.get(i).a);
				 ans+=ar.get(i).a;
			 }
			 else
			 {
				 if(ar.get(i).a>pq.peek())
				 {
					ans=ans-pq.peek();
					pq.remove();
					pq.add(ar.get(i).a);
					ans=ans+ar.get(i).a;
				 }
			 }
		 }
		 
		 return ans;
		 
	}

//	private static int maxJobs(int[] s, int[] e) 
//	{
//		 ArrayList<pair> ar=new ArrayList<>();
//		 for(int i=0;i<s.length;i++)
//		 {
//			 ar.add(new pair(s[i],e[i]));
//		 }
//		 Collections.sort(ar,new paircomprator());
//		 int c=1;
//		 int end=ar.get(0).e;
//		 for(int i=1;i<s.length;i++)
//		 {
//			 if(ar.get(i).s>=end)
//			 {
//				 c++;
//				 end=ar.get(i).e;
//			 }
//		 }
//		 return c;
//	}

}
