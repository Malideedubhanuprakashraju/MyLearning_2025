package P0_1_Maths;

public class P3_PrintAllPrimes 
{

	public static void main(String[] args) 
	{
		 int n=50;
		 printAll(n);
	}

	private static void printAll(int n) 
	{
		 boolean[] p=new boolean[n+1];
		 for(int i=1;i<=n;i++)
		 {
			 p[i]=true;
		 }
		 p[1]=false;
		 for(int i=2;i<=n;i++)
		 {
			 if(p[i]==true)
			 {
				 System.out.println(i);
				 int j=2;
				 while(j*i<=n)
				 {
					 p[j*i]=false;
					 j++;
				 }
			 }
		 }
	}

}
