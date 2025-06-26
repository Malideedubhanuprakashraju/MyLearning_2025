package DynamicProgramming_2;

public class P1_MaxSum 
{

	public static void main(String[] args) 
	{
		  // 2-Adjacent Elements Cannot be Picked
		  // We can avoid picking any element : Sum=0
		
		 int a[]= {5,1,1,5};
		 int ans=MaxSumRec(a,a.length-1);
		 System.out.println(ans);
		 System.out.println("Max Sum Dynamic---->");
		 int dp[]=new int[a.length+1];
		 
		 for(int i=0;i<a.length;i++)
		 {
			 dp[i]=-1;
		 }
		 int ans1=MaxSumDynamic(a,a.length-1,dp);
		 System.out.println(ans1);
		 
		 System.out.println("Max Sum Iterative Bottom Up--->");
		 
		 int ans2=MaxSumIterative(a,a.length-1,dp);
		 System.out.println(ans2);
		 
		 
		
	}

	private static int MaxSumIterative(int[] a, int n, int[] dp) 
	{
		dp[0]=0;
		for(int i=1;i<=a.length;i++)
		{
			dp[n]=Math.max(dp[n-1],dp[n-2]+a[n]); 
		}
		
		return dp[n];
		 
	}

	private static int MaxSumDynamic( int[] a,int n, int[] dp) 
	{
		if(n<0)
		{
			return 0;
		}
		
		if(dp[n]==-1)
		{
			dp[n]=Math.max(MaxSumDynamic(a,n-1,dp),MaxSumDynamic(a,n-2,dp)+a[n]);
		}
		
		return dp[n];
		 
	}

	private static int MaxSumRec(int[] a, int n) 
	{
		if(n<0)
		{
			return 0;
		}
		return Math.max(MaxSumRec(a,n-1),MaxSumRec(a,n-2)+a[n]);
	}

}
