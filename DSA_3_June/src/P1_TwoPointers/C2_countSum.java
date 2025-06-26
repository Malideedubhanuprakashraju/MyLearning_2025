package P1_TwoPointers;

public class C2_countSum 
{

	public static void main(String[] args) 
	{
		 int a[]= {3,5,5,5,8,8,8,8,11,11,11,11,17};
		 int k=16;
		 int ans=CountSum(a,k);
		 System.out.println(ans);
	}

	private static int CountSum(int[] a, int k) 
	{
		 int ans=0;
		 int p1=0;
		 int p2=a.length-1;
		 while(p1<p2)
		 {
			 int s=a[p1]+a[p2];
			 if(s>k)
			 {
				 p2--;
			 }
			 else if(s<k)
			 {
				 p1++;
			 }
			 else
			 {
				 if(a[p1]!=a[p2])
				 {
					int c1=0;
					for(int i=p1;i<a.length;i++)
					{
						if(a[i]==a[p1])
						{
							c1++;
						}
						else
						{
							break;
						}
					}
					int c2=0;
					for(int i=p2;i>=p1;i--)
					{
						if(a[i]==a[p2])
						{
							c2++;
						}
						else
						{
							break;
						}
					}
					ans=ans+(c1*c2);
					p1=p1+c1;
					p2=p2-c2;
					
				 }
				 else
				 {
					 int p=p2-p1+1;
					 ans=ans+((p)*(p-1))/2;
					 break;
				 }
			 }
			 
		 }
		 return ans;
	}

}
