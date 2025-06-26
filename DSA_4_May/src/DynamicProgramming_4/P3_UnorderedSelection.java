package DynamicProgramming_4;

public class P3_UnorderedSelection {

	public static void main(String[] args) 
	{
		 int s=6;
		 int a[]= {3,1,4};
		 int ans=ways(a.length-1,s,a);
		 System.out.println(ans);
	}

	private static int ways(int n, int s, int[] a) 
	{
		 if(s==0)
		 {
			 return 1;
		 }
		 if(n<0)
		 {
			 return 0;
		 }
		 int c1=0,c2=0;
		 c1=ways(n-1,s,a);
		 if(s>=a[n])
		 {
			 c2=ways(n,s-a[n],a);
		 }
		 return c1+c2;
	}

}
