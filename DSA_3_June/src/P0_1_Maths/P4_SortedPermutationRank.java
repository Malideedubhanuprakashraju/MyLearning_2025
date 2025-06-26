package P0_1_Maths;

public class P4_SortedPermutationRank 
{

	public static void main(String[] args) 
	{
		String s="NEDOAC";
		int ans=rank(s);
		System.out.println(ans);
	}

	private static int rank(String s) 
	{
		int n=s.length();
		int rank=0;
		for(int i=0;i<n;i++)
		{
			char ch=s.charAt(i);
			int c=0;
			for(int j=i+1;j<n;j++)
			{
				if(s.charAt(j)<ch)
				{
					c++;
				}
			}
			int per=fact(n-i-1)*c;
			rank=rank+per;
		}
		return rank+1;
	}

	private static int fact(int n) 
	{
		 int ans=1;
		 for(int i=1;i<=n;i++)
		 {
			 ans=(ans*i);
		 }
		 return ans;
	}

}
