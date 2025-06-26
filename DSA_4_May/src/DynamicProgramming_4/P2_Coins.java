package DynamicProgramming_4;

public class P2_Coins 
{

	public static void main(String[] args) 
	{
		int n=5;
		int a[]= {3,1,4};
		 
		int ans=noWays(n,a);
		System.out.println(ans);
		System.out.println("Dp Size----Coins Problem---->");
		int dp[]=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			dp[i]=-1;
		}
		int ans1=noWaysDp(n,a,dp);
		System.out.println(ans1);
		
	}

	private static int noWaysDp(int n, int[] a, int[] dp) 
	{
		if(n==0 || n==1)
		{
			return 1;
		}
		 if(dp[n]==-1)
		 {
			 int sum=0;
			 for(int i=0;i<a.length;i++)
			 {
				 if(n>=a[i])
				 {
					 sum=sum+noWaysDp(n-a[i],a,dp);
				 }
			 }
			 dp[n]=sum;
		 }
		 return dp[n];
	}

	private static int noWays(int n, int[] a) 
	{
		 if(n==0)
		 {
			 return 1;
		 }
		 if(n==1)
		 {
			 return 1;
		 }
		 int ans=0;
		 for(int i=0;i<a.length;i++)
		 {
			 if(n>=a[i])
			 {
			 ans=ans+noWays(n-a[i],a);
			 }
		 }
		 return ans;
		 
	}

	 

}
