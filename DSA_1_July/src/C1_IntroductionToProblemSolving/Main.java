package C1_IntroductionToProblemSolving;

public class Main 
{

	public static void main(String[] args) 
	{
		System.out.println("Given-N-->Return no of Factors of N--->");
		System.out.println("Bruit Force---->TC=O(N)--->");
		int ans=countFactors(24);
		System.out.println("Factors of 24 are-->"+ans);
		System.out.println("1-iterations=1/10pow8sec--->");
		System.out.println("If is factor of N--> N/i is also factor of N--->");
		int ans1=countFactorsOpti(24);
		System.out.println("Optimised Code-TC(Root-N)iter-->"+ans1);
		System.out.println("Prime Number-->if it has 2-Factors-->");
		boolean ans2=isPrime(5);
		System.out.println(ans2);
		System.out.println("Sum of N numbers--->n(n+1)/2");
		System.out.println("[a,b]-->inclusion-->All numbers from a,b-->Both Corners Included--->");
		System.out.println("[a,b]=b-a+1");
		System.out.println("(a,b)-->excluded-->All numbers from a,b-->Both Corners Excluded--->");
		System.out.println("(a,b)=b-a-1");
		System.out.println("It's impossible to calculate how many instructions--->");
		System.out.println("1-iterations=10-instructions--->");
		System.out.println("10pow8-iterations/sec");
	}

	private static boolean isPrime(int n) 
	{
		 return countFactorsOpti(n)==2;
	}

	private static int countFactorsOpti(int n)
	{
		int c=0;
		for(int i=1;i*i<=n;i++)
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
		return c;
	}

	private static int countFactors(int n) 
	{
		 int c=0;
		 for(int i=1;i<=n;i++)
		 {
			 if(n%i==0)
			 {
				 c++;
			 }
		 }
		 return c;
	}

}
