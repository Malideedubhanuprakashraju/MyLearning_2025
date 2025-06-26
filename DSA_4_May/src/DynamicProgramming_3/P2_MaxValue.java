package DynamicProgramming_3;

public class P2_MaxValue 
{

	public static void main(String[] args) 
	{
		 int n=4;
		 int k=50;
		 int w[]= {20,10,30,40};
		 int v[]= {100,60,120,150};
		 int ans=MaxValue(n-1,w,v,k);
		 System.out.println(ans);
		 System.out.println("Dp 0/1 Knapsack Problem----->");
		 int dp[][]=new int[n][k+1];
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<=k;j++)
			 {
				 dp[i][j]=-1;
			 }
		 }
		 int ans1=MaxValue(n-1,w,v,k,dp);
		 System.out.println(ans1);
		 System.out.println("Dp 0/infinity knapsak problem----->");
		 int ans2=MaxValueIn(n-1,w,v,k,dp);
		 System.out.println(ans2);
		 
	}

	private static int MaxValueIn(int i, int[] w, int[] v, int k, int[][] dp) 
	{
		if(i<0)
		{
			return 0;
		}
		 if(dp[i][k]==-1)
		 {
			 int f1=0,f2=0;
			 f1=MaxValueIn(i-1,w,v,k,dp);
			 if(k>=w[i])
			 {
				 f2=MaxValueIn(i,w,v,k-w[i],dp)+v[i];
			 }
			 dp[i][k]=Math.max(f1, f2);
		 }
		 return dp[i][k];
	}

	private static int MaxValue(int i, int[] w, int[] v, int k, int[][] dp) 
	{
		if(i<0)
		{
			return 0;
		}
		 if(dp[i][k]==-1)
		 {
			 int f1=0;
			 int f2=0;
			 f1=MaxValue(i-1,w,v,k,dp);
			 
			 if(k>=w[i])
			 {
				 f2=MaxValue(i-1,w,v,k-w[i],dp)+v[i];
			 }
			 dp[i][k]=Math.max(f1, f2);
		 }
		 return dp[i][k];
	}

	private static int MaxValue(int i, int[] w, int[] v, int k) 
	{
		if(i<0)
		{
			return 0;
		}
		 int v1=0;
		 int v2=0;
		 v1=MaxValue(i-1,w,v,k);
		 if(k>=w[i])
		 {
			v2=MaxValue(i-1,w,v,k-w[i])+v[i]; 
		 }
		 return Math.max(v1, v2);
	}

}
