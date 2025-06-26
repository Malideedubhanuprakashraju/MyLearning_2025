package DynamicProgramming_2;

public class P4_NofBSTs 
{

	public static void main(String[] args) 
	{
		int a[]= {10,20,30,40};
		int dp[]=new int[a.length+1];
		for(int i=0;i<=a.length;i++)
		{
			dp[i]=-1;
		}
		int ans=BST(a.length);
		System.out.println(ans);
		System.out.println("Dp Code-----> for BST");
		int ans2=BSTdp(a.length,dp);
		System.out.println(ans2);
		
		System.out.println("Dp Iterative-----> for BST");
		int ans3=BSTiter(a.length,dp);
		System.out.println(ans3);
		
	}

	private static int BSTiter(int length, int[] dp) 
	{
		 if(length==0)
		 {
			 return 1;
		 }
		 dp[0]=1;
		 
		 for(int i=1;i<=length;i++)
		 {
			 int sum=0;
			 int k=0;
			 int j=i-1;
			 while(k<i)
			 {
				 sum=sum+dp[k]*dp[j];
				 k++;
				 j--;
			 }
			 dp[i]=sum;
			 
		 }
		 return dp[length];
	}

	private static int BSTdp(int n, int[] dp) 
	{
		if(n==0)
		{
			return 1;
		}
		if(dp[n]==-1)
		{
			int i=0,j=n-1;
			int sum=0;
			while(i<n)
			{
				sum=sum+(BSTdp(i,dp)*BSTdp(j,dp));
				i++;
				j--;
			}
			dp[n]=sum;
		}
		return dp[n];
		 
	}

	private static int BST(int i) 
	{
		if(i==0)
		{
			return 1;
		}
		int k=0,l=i-1;
		int sum=0;
		while(k<i)
		{
			sum=sum+BST(k)*BST(l);
			k++;
			l--;
		}
		return sum;
		 
	}

}
