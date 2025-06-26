package Graphs_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P1_BFS 
{
	

	public static void main(String[] args) 
	{
		int u[]= {1,1,2,2,3,5,4};
		int v[]= {2,4,4,3,5,6,5};
		int s=1;
		int d=4;
		
		int n=6;
		boolean ans=solve(n,u,v,s,d);
		System.out.println(ans);
		
		
	}

	private static boolean solve(int n, int[] u, int[] v, int s, int d) 
	{
		 ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
		 for(int i=0;i<=n;i++)
		 {
			 ArrayList<Integer> temp=new ArrayList<>();
			 ar.add(temp);
			 
		 }
		 for(int i=0;i<u.length;i++)
		 {
			 ar.get(u[i]).add(v[i]);
			 ar.get(v[i]).add(u[i]);
		 }
		 Queue<Integer> q=new LinkedList<>();
		 boolean vis[]=new boolean[n+1];
		 q.add(s);
		 vis[s]=true;
		 while(q.size()>0)
		 {
			 int ad=q.poll();
			 for(int i=0;i<ar.get(ad).size();i++)
			 {
				 int nn=ar.get(ad).get(i);
				 if(vis[nn]==false)
				 {
					 q.add(nn);
					 vis[nn]=true;
				 }
			 }
		 }
		 return vis[d];
	}

}
