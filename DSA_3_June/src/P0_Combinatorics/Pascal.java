package P0_Combinatorics;

public class Pascal {

	public static void main(String[] args) 
	{
		 int[][] a=Pascal(10);
		 for(int i=0;i<a.length;i++)
		 {
			 for(int j=0;j<a.length;j++)
			 {
				 System.out.print(a[i][j]+"   ");
			 }
			 System.out.println();
		 }
	}

	private static int[][] Pascal(int n) 
	{
		int ans[][]=new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(j>i)
				{
					ans[i][j]=0;
				}
				else if(i==0 || j==0)
				{
					ans[i][j]=1;
				}
				else
				{
					ans[i][j]=ans[i-1][j]+ans[i-1][j-1];
				}
			}
		}
		return ans;
	}

}
