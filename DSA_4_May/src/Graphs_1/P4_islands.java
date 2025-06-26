package Graphs_1;

public class P4_islands 
{

	public static void main(String[] args) 
	{
		int[][] mat = {
				{1,1,0,0,1},
				{0,1,0,1,0},
				{1,0,0,1,1},
				{1,1,0,0,0},
				{1,0,1,1,1}
			    
			};
		int ans=islands(mat);
		System.out.println(ans);

	}

	private static int islands(int[][] mat) 
	{
		 int n=mat.length;
		 int m=mat[0].length;
		 int c=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 if(mat[i][j]==1)
				 {
					 DFS(mat,i,j);
					 c++;
				 }
			 }
		 }
		 return c;
	}

	private static void DFS(int[][] mat, int i, int j) 
	{
		mat[i][j]=0;
		int n=mat.length;
		int m=mat[0].length;
		
		if(i-1>=0 && mat[i-1][j]==1)
		{
			DFS(mat,i-1,j);
		}
		if(i+1<n && mat[i+1][j]==1)
		{
			DFS(mat,i+1,j);
		}
		if(j-1>=0 && mat[i][j-1]==1)
		{
			DFS(mat,i,j-1);
		}
		if(j+1<m && mat[i][j+1]==1)
		{
			DFS(mat,i,j+1);
		}
			
	}

}
