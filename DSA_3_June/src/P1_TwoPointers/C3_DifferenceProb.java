package P1_TwoPointers;

public class C3_DifferenceProb 
{

	public static void main(String[] args) 
	{
		 int a[]= {-1,0,1,3,6,8,11,14,21,25};
		 int k=5;
		 boolean ans=dif(a,k);//diff(a,k);
		 System.out.println(ans);
	}

	private static boolean dif(int[] a, int k) 
	{
		 int n=a.length;
		 int p2=n-1;
		 int p1=n-2;
		 
		 while(p1>0)
		 {
			 if(p1==p2)
			 {
				 p1--;
			 }
			 if(a[p2]-a[p1]==k)
			 {
				 return true;
			 }
			 else if(a[p2]-a[p1]<k)
			 {
				 p1--;
			 }
			 else
			 {
				 p2--;
			 }
		 }
		 return false;
	}

	private static boolean diff(int[] a, int k) 
	{
		k=Math.abs(k);
		int p1=0;
		int p2=1;
		while(p2<a.length)
		{
//			if(a[p2]-a[p1]==k)
//			{
//				return true;
//			}
//			else if(a[p2]-a[p1]>k)
//			{
//				p1++;
//				if(p1==p2)
//				{
//					p2++;
//				}
//				
//			}
//			else
//			{
//				p2++;
//			}
			if(p1==p2)
			{
				p2++;
			}
			else if(a[p2]-a[p1]==k)
			{
				return true;
			}
			else if(a[p2]-a[p1]<k)
			{
				p2++;
			}
			else
			{
				p1++;
			}
		}
		return false;
	}

}
