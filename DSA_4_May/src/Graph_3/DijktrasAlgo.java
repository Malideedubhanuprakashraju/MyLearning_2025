package Graph_3;

import java.util.ArrayList;
import java.util.PriorityQueue;

import GreedyPrograms.pair;

public class DijktrasAlgo 
{

	public static void main(String[] args) 
	{
		int n = 5;
		int e = 6;

		int[] u = {0, 0, 1, 1, 2, 3};
		int[] v = {1, 2, 2, 3, 4, 4};
		int[] w = {2, 4, 1, 7, 3, 1};

		int s = 0;
		int ans[]=Dijktras(n,e,u,v,w,s);
		for(int x:ans)
		{
			System.out.print(x+" ");
		}
		
	}

	private static int[] Dijktras(int n, int e, int[] u, int[] v, int[] w, int s) 
	{
		 ArrayList<ArrayList<pair>> g=new ArrayList<>();
		 for(int i=0;i<n;i++)
		 {
			 ArrayList<pair> temp=new ArrayList<>();
			 g.add(temp);
		 }
		 for(int i=0;i<e;i++)
		 {
			 g.get(u[i]).add(new pair(v[i],w[i]));
			 g.get(v[i]).add(new pair(u[i],w[i]));
		 }
		 int dist[]=new int[n];
		 for(int i=0;i<n;i++)
		 {
			dist[i]=Integer.MAX_VALUE; 
		 }
		 
		 dist[s]=0;
		 PriorityQueue<pair> pq=new PriorityQueue<>(new sortown());
		 pq.add(new pair(s,0));
		 
		 while(pq.size()>0)
		 {
			 pair p=pq.poll();
			 int u1=p.d;
			 if(p.a>dist[u1])
			 {
				 continue;
			 }
			 for(int i=0;i<g.get(u1).size();i++)
			 {
				 pair t=g.get(u1).get(i);
				 int v1=t.d,w1=t.a;
				 if(dist[u1]+w1<dist[v1])
				 {
					 dist[v1]=dist[u1]+w1;
					 pq.add(new pair(v1,dist[v1]));
				 }
			 }
			 
		 }
		 return dist;
	}

}
