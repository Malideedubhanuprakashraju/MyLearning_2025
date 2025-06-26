package Graph_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

	public static void main(String[] args) 
	{
		int[] u = {0,0,1,2,2,2,4};
		int[] v = {1,2,3,1,3,4,3};
		int n=5;
		int e=6;
		topological(n,e,u,v);

	}

	private static void topological(int n, int e, int[] u, int[] v) 
	{
		
		 ArrayList<ArrayList<Integer>> g=new ArrayList<>();
		 for(int i=0;i<n;i++)
		 {
			 ArrayList<Integer> temp=new ArrayList<>();
			 g.add(temp);
		 }
		 int indg[]=new int[n];
		 for(int i=0;i<e;i++)
		 {
			 g.get(u[i]).add(v[i]);
			 indg[v[i]]++;
		 }
		 Queue<Integer> q=new LinkedList<>();
		 for(int i=0;i<n;i++)
		 {
			 if(indg[i]==0)
			 {
				 q.add(i);
			 }
		 }
		 while(q.size()>0)
		 {
			 int u1=q.poll();
			 System.out.print(u1+" ");
			 for(int i=0;i<g.get(u1).size();i++)
			 {
				int v1=g.get(u1).get(i);
				indg[v1]--;
				if(indg[v1]==0)
				{
					q.add(v1);
				}
			 }
			 
		 }
		
	}

}
