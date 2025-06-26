package DynamicProgramming_2;

public class P3_CatalanNumber 
{

	public static void main(String[] args) 
	{
		int n=3;
		int sum=catalon(n);
		System.out.println(sum);

	}

	private static int catalon(int n) 
	{
		 int ans[]=new int[n+1];
		 ans[0]=ans[1]=1;
		 for(int i=2;i<=n;i++)
		 {
			 int sum=0;
			 int p1=0;
			 int p2=i-1;
			 while(p1<i)
			 {
				 sum=sum+ans[p1]*ans[p2];
				 p1++;
				 p2--;
			 }
			 ans[i]=sum;
		 }
		 return ans[n];
	}

}
