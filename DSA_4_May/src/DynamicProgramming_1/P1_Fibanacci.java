package DynamicProgramming_1;

public class P1_Fibanacci 
{
	public static void main(String[] args) 
	{
		int n=10;
		System.out.println("Recursive--> Fibanaacci Number ");
		int ans=fibRecursive(n);
		System.out.println(ans);
		System.out.println("Dynamic Programming----> Fibnaci Number ");
		int dp[]=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			dp[i]=-1;
		}
		int ans1=fibDynamic(dp,n);
		System.out.println(ans1);
		
		System.out.println("Dp-->Iterative--Bottom-Up Apparoch ");
		int ans2=fibIterative(n,dp);
		System.out.println(ans2);
		
		
		
		
		
	}

	private static int fibIterative(int n, int[] dp) 
	{
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++)
		{
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		return dp[n];
		 
	}

	private static int fibDynamic(int[] dp, int n) 
	{
		
		if(n<=1)
		{
			return n;
		}
		if(dp[n]==-1)
		{
			dp[n]=fibDynamic(dp,n-1)+fibDynamic(dp,n-2);
		}
		 
		return dp[n];
	}

	private static int fibRecursive(int n) 
	{
		 if(n<=1)
		 {
			 return n;
		 }
		 
		 return fibRecursive(n-1)+fibRecursive(n-2);
	}

}
