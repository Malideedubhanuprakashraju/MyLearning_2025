package Graphs_1;

import java.util.ArrayList;

public class P2_CycleDeduction 
{
	static ArrayList<ArrayList<Integer>> ar;
	static boolean[] vis;
	static boolean[] path;
	static boolean cycle=false;

	public static void main(String[] args) 
	{
		int[] u = {0, 1, 2, 3};
		int[] v = {1, 2, 3, 1};
		int n=4;
		boolean ans=solve(n,u,v);
		System.out.println(ans);
	}

	private static boolean solve(int n, int[] u, int[] v) 
	{
		 ar=new ArrayList<>();
		 for(int i=0;i<=n;i++)
		 {
			 ArrayList<Integer> temp=new ArrayList<>();
			 ar.add(temp);
		 }
		 for(int i=0;i<u.length;i++)
		 {
			 ar.get(u[i]).add(v[i]);
			// ar.get(v[i]).add(u[i]);
		 }
		 vis=new boolean[n+1];
		 path=new boolean[n+1];
		 cycle=false;
		 for(int i=1;i<=n;i++)
		 {
			 if(vis[i]==false)
			 {
				 DFS(i);
			 }
		 }
		 return cycle;
	}

	private static void DFS(int i) 
	{
		 vis[i]=true;
		 path[i]=true;
		 for(int i1=0;i1<ar.get(i).size();i1++)
		 {
			 int v=ar.get(i).get(i1);
			 if(path[v]==true)
			 {
				 cycle=true;
			 }
			 if(vis[v]==false)
			 {
				 DFS(v);
			 }
			 path[i]=false;
			 return;
		 }
		
	}

}
