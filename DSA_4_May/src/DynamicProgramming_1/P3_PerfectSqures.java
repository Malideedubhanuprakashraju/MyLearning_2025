package DynamicProgramming_1;

public class P3_PerfectSqures 
{

	public static void main(String[] args) 
	{
		int n=13;
		int ans=mps(n);
		System.out.println("Recursive Code--->");
		System.out.println(ans);
		System.out.println("Dynamic Code---Top Down--->");
		int dp[]=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			dp[i]=-1;
		}
		int ans1=mpsDynamic(n,dp);
		System.out.println(ans1);
		System.out.println("Dynamic code----Bottom Up--->");
		int ans2=mpsDymanicIterative(n,dp);
		System.out.println(ans2);
	}

	private static int mpsDymanicIterative(int n, int[] dp) 
	{
		  
		 dp[0]=0;
		 if(dp[n]==-1)
		 {
			 int ans=Integer.MAX_VALUE;
			 for(int i=1;i*i<=n;i++)
			 {
				 ans=Math.min(ans,dp[n-i*i]);
			 }
			 dp[n]=ans+1;
		 }
		 return dp[n];
		 
	}

	private static int mpsDynamic(int n, int[] dp) 
	{
		 if(n==0)
		 {
			 return 0;
		 }
		 if(dp[n]==-1)
		 {
			 int ans=Integer.MAX_VALUE;
			 for(int i=1;i*i<=n;i++)
			 {
				 ans=Math.min(ans,1+mpsDynamic(n-i*i,dp));
			 }
			 dp[n]=ans;
		 }
		 return dp[n];
		 
	}

	private static int mps(int n) 
	{
		 if(n==0)
		 {
			 return 0;
		 }
		 int ans=Integer.MAX_VALUE;
		 for(int i=1;i*i<=n;i++)
		 {
			 ans=Math.min(ans,1+mps(n-i*i));
		 }
		 return ans;
	}
		 

}
