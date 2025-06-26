package P0_1_Maths;

public class PrintAllFactors 
{

	public static void main(String[] args) 
	{
		 int n=10;
		 int[] ans=PrintFactors(n);
		 for(int x:ans)
		 {
			  if(x>0)
			  {
				  System.out.print(x+" ");
			  }
		 }
	}

	private static int[] PrintFactors(int n) 
	{
		int f[]=new int[n+1];
		
		for(int i=1;i<=n;i++)
		{
			f[i]=1;
		}
		for(int i=2;i<=n;i++)
		{
			int j=1;
			while(j*i<=n)
			{
				f[j*i]++;
				j++;
			}
		}
		return f;
				
	}

}
