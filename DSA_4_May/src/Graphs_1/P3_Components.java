package Graphs_1;

import java.util.ArrayList;

public class P3_Components 
{
	static ArrayList<ArrayList<Integer>> ar;
	static boolean vis[];
	public static void main(String[] args) 
	{
		int n = 16;
		int[] u = {0, 0, 1, 4, 5, 9, 12, 13};
		int[] v = {1, 2, 2, 5, 6, 10, 14, 15};
		
		int ans=solve(n,u,v);
		System.out.println(ans);

	}

	private static int solve(int n, int[] u, int[] v) 
	{
		 ar=new ArrayList<>();
		 for(int i=0;i<=n;i++)
		 {
			 ArrayList<Integer> temp=new ArrayList<>();
			 ar.add(temp);
		 }
		 vis=new boolean[n+1];
		 
		 for(int i=0;i<u.length;i++)
		 {
			 ar.get(u[i]).add(v[i]);
			 ar.get(v[i]).add(u[i]);
		 }
		 int c=0;
		 for(int i=0;i<=n;i++)
		 {
			 if(vis[i]==false)
			 {
				 DFS(i);
				 c++;
			 }
		 }
		 return c;
		 
	}

	private static void DFS(int u) 
	{
		 vis[u]=true;
		 for(int i=0;i<ar.get(u).size();i++)
		 {
			 int v=ar.get(u).get(i);
			 if(vis[v]==false)
			 {
				 DFS(v);
			 }
		 }
		return;
	}

}
