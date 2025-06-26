package P1_TwoPointers;

public class C1_CheckSum 
{

	public static void main(String[] args) 
	{
		 int a[]= {-3,0,1,3,6,8,11,14,18,25};
		 int k=17;
		 boolean ans=checkSum(a,k);
		 System.out.println(ans);
	}

	private static boolean checkSum(int[] a, int k) 
	{
		 int n=a.length;
		 int p1=0;
		 int p2=n-1;
		 while(p1<p2)
		 {
			 if(a[p1]+a[p2]==k)
			 {
				 return true;
			 }
			 else if(a[p1]+a[p2]>k)
			 {
				 p2--;
			 }
			 else
			 {
				 p1++;
			 }
		 }
		 return false;
	}

}
