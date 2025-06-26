package Graphs_1;

import java.util.ArrayList;

/* public class P1_DFS 
{
	static ArrayList<ArrayList<Integer>> ar;
	static boolean[] vis;
	
	public static void main(String[] args) 
	{
		int n = 5; // number of nodes
        int[] u = {0, 0, 1, 1, 1, 2, 3};
        int[] v = {1, 4, 2, 3, 4, 3, 4};
        int source = 4;
        int destination = 3;
        
        boolean ans=solve(n,u,v,source,destination);
        System.out.println(ans);
		 
	}

	private static boolean solve(int n, int[] u, int[] v, int source, int destination) 
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
			ar.get(v[i]).add(u[i]);
		}
		vis=new boolean[n+1];
		DFS(source);
		
		
		return vis[destination];
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

} */

public class P1_DFS
{
	static ArrayList<ArrayList<Integer>> ar;
	static boolean vis[];
	
	public static void main(String[] args) 
	{
		int u[]= {1,1,2,2,3,5,4};
		int v[]= {2,4,4,3,5,6,5};
		int source=1;
		int Desti=6;
		int n=6;
		boolean ans=solve(n,u,v,source,Desti);
		System.out.println(ans);
		
		
	}

	private static boolean solve(int n, int[] u, int[] v, int s, int d) 
	{
		 if(s > n || d > n) 
			return false; // <-- add this line

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
		 DFS(s);
		 
		 return vis[d];
	}

	private static void DFS(int s) 
	{
		 vis[s]=true;
		 for(int i=0;i<ar.get(s).size();i++)
		 {
			 int un=ar.get(s).get(i);
			 if(vis[un]==false)
			 {
				 DFS(un);
			 }
		 }
	}
}
