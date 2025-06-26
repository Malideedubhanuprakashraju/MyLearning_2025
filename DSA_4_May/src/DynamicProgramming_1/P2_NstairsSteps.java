package DynamicProgramming_1;

public class P2_NstairsSteps 
{

	public static void main(String[] args) 
	{
		int n=0;
		int ans=ways(n);
		System.out.println(ans);
		int dp[]=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			dp[i]=-1;
		}
		int ans2=waysTop(n,dp);
		System.out.println(ans2);
		
		int ans3=waysDown(n,dp);
		System.out.println(ans3);

	}

	private static int waysDown(int n, int[] dp) 
	{
		 dp[0]=1;
		 //dp[1]=1;
		 if (n >= 1) {
	            dp[1] = 1;  // 1 way to reach step 1
	        }
		 for(int i=2;i<=n;i++)
		 {
			 dp[i]=dp[i-2]+dp[i-1];
		 }
		 return dp[n];
	}

	private static int waysTop(int n, int[] dp) 
	{
		 if(n<=1)
		 {
			 return 1;
		 }
		 if(dp[n]==-1)
		 {
			 dp[n]=waysTop(n-1,dp)+waysTop(n-2,dp);
		 }
		 return dp[n];
	}

	private static int ways(int n) 
	{
		 if(n<=1)
		 {
			 return 1;
		 }
		 return ways(n-1)+ways(n-2);
	}

}
