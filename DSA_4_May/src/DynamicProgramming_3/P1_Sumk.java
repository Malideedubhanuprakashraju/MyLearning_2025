package DynamicProgramming_3;

public class P1_Sumk 
{

	public static void main(String[] args) 
	{
		int a[]={3,4,5,7,2};
		int k=10;
		
		boolean ans=sum(a,a.length-1,k);
		System.out.println(ans);
		System.out.println("Dp code for Sum ------>");
		int dp[][]=new int[a.length][k+1];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<=k;j++)
			{
				dp[i][j]=-1;
			}
		}
		int ans1=sumD(a,a.length-1,k,dp);
		System.out.println(ans1);
	}

	private static int sumD(int[] a, int i, int k, int[][] dp) 
	{
		if(i<0)
		{
			if(k==0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		
		if(dp[i][k]==-1)
		{
			int f1=0,f2=0;
			f1=sumD(a,i-1,k,dp);
			if(k>=a[i])
			{
				f2=sumD(a,i-1,k-a[i],dp);
			}
			dp[i][k]=f1|f2;
		}
		 
		return dp[i][k];
	}

	private static boolean sum(int[] a, int i, int k) 
	{
		if(i<0)
		{
			return k==0;
		}
		 boolean f1=false;
		 boolean f2=false;
		 f1=sum(a,i-1,k);
		 if(k>=a[i])
		 {
			 f2=sum(a,i-1,k-a[i]);
		 }
		 return f1 || f2;
	}

}
