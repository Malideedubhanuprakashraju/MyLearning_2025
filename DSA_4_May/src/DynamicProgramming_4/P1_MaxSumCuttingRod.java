package DynamicProgramming_4;

public class P1_MaxSumCuttingRod 
{
	static int dp[][];

	public static void main(String[] args) 
	{
		 int n=5;
		 int cost[]= {1,2,4,5,6};
		 int length=10;
		 
		int ans= maxSum(n,length,cost);
		System.out.println(ans);
		System.out.println("Dp Code---> Memozation ");
		dp=new int[n+1][length+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=length;j++)
			{
				dp[i][j]=-1;
			}
		}
		
		int ans2=maxSumDp(n,length,cost,dp);
		System.out.println(ans2);
		
	}

	private static int maxSumDp(int n, int l, int[] cost, int[][] dp2) 
	{
		if(n==0)
		{
			return 0;
		}
		 if(dp[n][l]==-1)
		 {
			 int c1=0,c2=0;
			 c1=maxSumDp(n-1,l,cost,dp);
			 if(l>=n)
			 {
				 c2=maxSumDp(n,l-n,cost,dp)+cost[n-1];
			 }
			 dp[n][l]=Math.max(c1, c2);
		 }
		 return dp[n][l];
	}

	private static int maxSum(int n, int length, int[] cost) 
	{
		 if(n==0)
		 {
			 return 0;
		 }
		 if(length==0)
		 {
			 return 0;
		 }
		 int c1=0,c2=0;
		 c1=maxSum(n-1,length,cost);
		 if(length>=n)
		 {
			 c2=maxSum(n,length-n,cost)+cost[n-1];
		 }
		 return Math.max(c1, c2);
	}

}
