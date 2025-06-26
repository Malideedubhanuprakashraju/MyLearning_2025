package Graph_3;

public class Minimum_Jumps 
{

	public static void main(String[] args) 
	{
		int a[]= {3,3,1,2,2,4,3,3,1,2,2,3};
		int ans=jumps(a);
		System.out.println(ans);

	}

	private static int jumps(int[] a) 
	{
		 if(a.length==1)
		 {
			 return 0;
		 }
		 int n=a.length;
		 int j=a[0],c=1;
		 int i=1;
		 while(j<n-1)
		 {
			 int m=0;
			 while(i<=j)
			 {
				m=Math.max(m,a[i]+i);
				i++;
			 }
			 if(m==0)
			 {
				 return -1;
			 }
			 j=m;
			 c++;
		 }
		 return c;
	}

}
