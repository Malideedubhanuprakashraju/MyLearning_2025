package Graphs_2;

import java.util.LinkedList;
import java.util.Queue;
class pair1
{
	int i,j;
	pair1(int a,int b)
	{
		i=a;
		j=b;
	}
}

public class Rotten 
{
	

	public static void main(String[] args) 
	{
		int[][] mat = 
			{
			    {2, 1, 1},
			    {1, 1, 0},
			    {0, 1, 1}
			 };
		int ans=solve(mat);
		System.out.println(ans);
	}

	private static int solve(int[][] mat) 
	{
		 int n=mat.length;
		 int m=mat[0].length;
		 Queue<pair1> q=new LinkedList<>();
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 if(mat[i][j]==2)
				 {
					 q.add(new pair1(i,j));
				 }
			 }
		 }
		 int l=-1;
		 while(q.size()>0)
		 {
			 int n1=q.size();
			 l=l+1;
			 for(int i=0;i<n1;i++)
			 {
				 pair1 ele=q.poll();
				 int x=ele.i;
				 int y=ele.j;
				 if(x-1>=0 &&mat[x-1][y]==1)
				 {
					 mat[x-1][y]=2;
					 q.add(new pair1(x-1,y));
				 }
				 if(x+1<n && mat[x+1][y]==1)
				 {
					 mat[x+1][y]=2;
					 q.add(new pair1(x+1,y));
				 }
				 if(y-1>=0 && mat[x][y-1]==1)
				 {
					 mat[x][y-1]=2;
					 q.add(new pair1(x,y-1));
				 }
				 if(y+1<m && mat[x][y+1]==1)
				 {
					 mat[x][y+1]=2;
					 q.add(new pair1(x,y+1));
				 }
			 }
		 }
			 
			
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 if(mat[i][j]==1)
				 {
					 return -1;
				 }
			 }
		 }
		 return l;
	}

}
