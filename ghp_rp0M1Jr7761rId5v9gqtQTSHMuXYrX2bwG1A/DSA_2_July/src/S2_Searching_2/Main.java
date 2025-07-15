package S2_Searching_2;

public class Main 
{

	public static void main(String[] args) 
	{
		int A[]= {10,11,12,13,14,16,17,18,20,23,25,26,1,3,5,6,8,9};
		int ele=26;
		System.out.println("Search Array by Rotating a Distinct Sorted Array-->Return index in the Given Array---->");
		int ans=searchRotated(A,ele);
		System.out.println(ans);
		System.out.println("Given +ve Find SqureRoot(N)---->");
		int ans1=sqrt(500);
		System.out.println(ans1);
		System.out.println("Find the Kth Magical Number---->");
		int ans2=magical(5,7,4);
		System.out.println(ans2);
	}

	private static int magical(int A, int B, int k) 
	{
		 int l=1,h=Math.min(A, B)*k;
		 int lcmab=(A*B)/GCD(A,B),ans=h;
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 int c=m/A+m/B-m/lcmab;
			 if(c<k)
			 {
				 l=m+1;
			 }
			 else if(c>k)
			 {
				 h=m-1;
			 }
			 else
			 {
				 ans=m;
				 h=m-1;
			 }
		 }
		 return ans;
	}

	private static int GCD(int a, int b) 
	{
		if(b==0)
		{
			return a;
		}
		 return GCD(b,a%b);
	}

	private static int sqrt(int n) 
	{
		 int l=1,h=n;
		 int ans=-1;
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 if(m*m<=n)
			 {
				 ans=m;
				 l=m+1;
			 }
			 else
			 {
				 h=m-1;
			 }
		 }
		 return ans;
	}

	private static int searchRotated(int[] a, int k) 
	{
		 int n=a.length;
		 int l=0,h=n-1;
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 if(a[m]==k)
			 {
				 return m;
			 }
			 if(a[m]>=a[0])//1st Half [l.....m]is Sorted
			 {
				if(k>=a[l] && k<=a[m])
				{
					h=m-1;
				}
				else
				{
					l=m+1;
				}
			 }
			 else//2nd Half [m......h]is Sorted
			 {
				 if(k>=a[m] && k<=a[h])
				 {
					 l=m+1;
				 }
				 else
				 {
					 h=m-1;
				 }
			 }
		 }
		 return -1;
	}

}
