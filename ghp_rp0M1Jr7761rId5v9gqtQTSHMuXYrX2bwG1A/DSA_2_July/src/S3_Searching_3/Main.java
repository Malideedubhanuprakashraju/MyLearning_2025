package S3_Searching_3;

import java.util.Arrays;

public class Main 
{

	public static void main(String[] args) 
	{
		 System.out.println(" Worker's Allocation Code-->Minimum Time Required---->");
		 int a[]= {3,5,1,7,8,2,5,3,10,1,4,7,5,4,6};
		 int w=4;
		 int n=15;
		 int ans=minTime(n,w,a);
		 System.out.println(ans);
		 System.out.println(" Worker's Allocation With B-Times--> Code---->");
		 int ans1=minBTime(n,w,a,8);
		 System.out.println(ans1);
		 System.out.println("Aggressive Cows--> Maximize min Distance---->TC=[l...h]=>O(log(h-l+1)");
		 int x[]= {2,6,11,14,19,25,30,39,43};
		 int stalls=6,cows=4;
		 int ans2=maxDist(stalls,cows,x);
		 System.out.println(ans2);
		 
	}

	private static int maxDist(int stalls, int cows, int[] x) 
	{
		 Arrays.sort(x);
		 int l=3;//Lowest Poss Dis We can Separate
		 int h=41;//Highest Poss Dis We can Separate
		 int ans=h;
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 if(check1(stalls,cows,x,m))
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

	private static boolean check1(int stalls, int cows, int[] x, int m) 
	{
		 int c=1,p=x[0];
		 for(int i=0;i<stalls;i++)
		 {
			 if(x[i]-p>=m)//CurrentState - Previous Cow State
			 {
				 c++;
				 p=x[i];
			 }
			 if(c==cows)
			 {
				 return true;
			 }
		 }
		 return false;
	}

	private static int minBTime(int n, int w, int[] a, int b) 
	{
		int l=10; //max(a);
		 int h=71; //sum(a);
		 int ans=h;
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 if(check(n,w,a,m))
			 {
				 ans=m;
				 h=m-1;
			 }
			 else
			 {
				 l=m+1;
			 }
		 }
		 return ans*b; 
	}

	private static int minTime(int n, int w, int[] a) 
	{
		 int l=10; //max(a);
		 int h=71; //sum(a);
    //	 int l = Arrays.stream(a).max().getAsInt();
	//	 int h = Arrays.stream(a).sum();

		 int ans=h;
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 if(check(n,w,a,m))
			 {
				 ans=m;
				 h=m-1;
			 }
			 else
			 {
				 l=m+1;
			 }
		 }
		 return ans;
	}

	private static boolean check(int n, int w, int[] a, int m) 
	{
		 int p=1,s=0;
		 for(int i=0;i<n;i++)
		 {
			 s=s+a[i];
			 if(s>m)
			 {
				 p++;
				 s=a[i];
			 }
			 if(p>w)
			 {
				 return false;
			 }
		 }
		 return true;
	}

}
