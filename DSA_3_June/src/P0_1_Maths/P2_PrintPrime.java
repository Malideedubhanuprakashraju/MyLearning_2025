package P0_1_Maths;

public class P2_PrintPrime {

	public static void main(String[] args) 
	{
		int n=10;
		printPrime(n);
	}

	private static void printPrime(int n) 
	{
		 for(int i=1;i<=n;i++)
		 {
			 if(isPrime(i))
			 {
				 System.out.print(i+" ");
			 }
		 }
	}

	private static boolean isPrime(int n) 
	{
		int c=0;
		for(int i=1;i*i<n;i++)
		{
			if(n%i==0)
			{
				if(i==n/i)
				{
					c=c+1;
				}
				else
				{
					c=c+2;
				}
			}
		}
		return c==2;
	}

}
