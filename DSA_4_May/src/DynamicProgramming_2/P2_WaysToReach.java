package DynamicProgramming_2;

public class P2_WaysToReach 
{
	static int dp[][];
	

	public static void main(String[] args) 
	{
		int n = 2, m = 2; // grid size: 3x3
        int ways = countWays(n, m);
        System.out.println(ways);
        System.out.println("Way to Reach (n-1,m-1) to (0,0)------->");
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
        	for(int j=0;j<=m;j++)
        	{
        		dp[i][j]=-1;
        	}
        }
        int ways2=CountwaysD(n,m);
        System.out.println(ways2);
        
        System.out.println("Ways to Reach (n-1,m-1 to (0,0)-------->");
        int ways3=countWaysIter(n,m);
        System.out.println(ways3);
        System.out.println("Ways to Reach--->Space Optimization");
        
        int ways4=countw(n,m);
        System.out.println(ways4);
        

	}

	private static int countw(int n, int m) 
	{
		 int dp[][]=new int[2][m+1];
		 for(int i=0;i<=n;i++)
		 {
			 for(int j=0;j<=m;j++)
			 {
				 if(i==0 || j==0)
				 {
					 dp[i%2][j]=1;
				 }
				 else
				 {
					 dp[i%2][j]=dp[(i-1)%2][j]+dp[i%2][j-1];
				 }
			 }
		 }
		 return dp[n%2][m];
	}

	private static int countWaysIter(int n, int m) 
	{
		 
		 for(int i=0;i<=m;i++)
		 {
			 for(int j=0;j<=n;j++)
			 {
				  if(i==0 || j==0)
				  {
					  dp[i][j]=1;
				  }
				  else
				  {
					  dp[i][j]=dp[i-1][j]+dp[i][j-1];
				  }
			 }
		 }
		 return dp[n][m];
	}

	private static int CountwaysD(int n, int m) 
	{ 
		if(n<0 || m<0)
		{
			return 0;
		}
		if(n==0 && m==0)
		{
			return 1;
		}
		if(dp[n][m]==-1)
		{
			dp[n][m]=CountwaysD(n-1,m)+CountwaysD(n,m-1);
		}
		
		return dp[n][m];
		
	}

	private static int countWays(int n, int m) 
	{
		 if(n<0 || m<0)
		 {
			 return 0;
		 }
		 if(m==0 && n==0)
		 {
			 return 1;
		 }
		return countWays(n-1,m)+countWays(n,m-1);
	}

	 
}
