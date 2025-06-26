package P0_1_Maths;

public class CheckPrime {

	public static void main(String[] args) 
	{
		 boolean ans=isPrime(5);
		 int ans1=factors(36);
		 System.out.println();
		 System.out.println(ans1);
		 
		 System.out.println(ans);
	}

	private static int factors(int n) 
	{
		 int c=0;
		 for(int i=1;i<=n;i++)
		 {
			 if(n%i==0)
			 {
				 System.out.print(i+" ");
				 c++;
			 }
		 }
		 return c;
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
