package Graphs_2;

import java.util.LinkedList;
import java.util.Queue;

class pair
{
	int i,j;
	pair(int a,int b)
	{
		i=a;
		j=b;
	}
}


public class RottenOranges 
{
	
	public static void main(String[] args) 
	{
		int[][] mat = {
			    {2, 1, 1},
			    {1, 1, 0},
			    {0, 1, 1}
			};

			int ans=solve(mat);
			System.out.println("Minimum time to rot all oranges: " + ans);

			
	}

	private static int solve(int[][] mat) 
	{
		int n=mat.length;
		int m=mat[0].length;
		int time[][]=new int[n][m];
		Queue<pair> q=new LinkedList<>();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(mat[i][j]==2)
				{
					q.add(new pair(i,j));
					time[i][j]=0;
				}
			}
		}
		int[] xp= {-1,1,0,0};
		int[] yp= {0,0,-1,1};
		while(q.size()>0)
		{
			pair p=q.poll();
			int x=p.i,y=p.j;
			for(int i=0;i<4;i++)
			{
				int nx=x+xp[i];
				int ny=y+yp[i];
				if((nx>=0) && (nx<n) && (ny>=0)&& (ny<m) && (mat[nx][ny]==1))
				{
					q.add(new pair(nx,ny));
					time[nx][ny]=time[x][y]+1;
					mat[nx][ny]=2;
				}
			}
		}
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(mat[i][j]==1)
				{
					return -1;
				}
				ans=Math.max(ans, time[i][j]);
			}
		}
		return ans;
		 
	}
}
