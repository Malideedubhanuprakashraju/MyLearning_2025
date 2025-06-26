package P5_Backtracking2;

public class GenerateSubsequenceSumK 
{

	public static void main(String[] args) 
	{
		int a[]= {3,0,3};
		int k=3;
		solve(a,k);

	}

	private static void solve(int[] a, int k) 
	{
		int ans=subSum(0,0,k,a,a.length);
		System.out.println(ans);
	}

	private static int subSum(int i, int s, int k, int[] a, int n) 
	{
		if(i==n)
		{
			if(s==k)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		int cl=subSum(i+1,s+a[i],k,a,n);
		int cr=subSum(i+1,s,k,a,n);
		return cl+cr;
		
	}

}
