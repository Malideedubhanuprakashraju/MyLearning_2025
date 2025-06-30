package P7_LinkedList1;

public class P2_MedianOfTwoArrays 
{

	public static void main(String[] args) 
	{
		 int A[]= {3,5,8,11,15,18};
		 int B[]= {2,7,10,13,19,23,25};
		 int ans=median(A,B);
		 System.out.println(ans);
	}

	private static int median(int[] a, int[] b) 
	{
		if (a.length > b.length) 
			return median(b, a);
		 int ans=0;
		 int n=a.length;
		 int m=b.length;
		 int nL=(n+m+1)/2;
		 int l=0;
		 int h=n;
		 while(l<=h)
		 {
			 int M=(l+h)/2;
			 int nLA=M;
			 int nLB=nL-nLA;
			 
			 int dLA=Integer.MIN_VALUE;
			 int dLB=Integer.MIN_VALUE;
			 
			 int dRA=Integer.MAX_VALUE;
			 int dRB=Integer.MAX_VALUE;
			 
			 if(nLA>0)
			 {
				 dLA=a[nLA-1];
			 }
			 if(nLB>0)
			 {
				 dLB=b[nLB-1];
			 }
			 if(nLA<n)
			 {
				 dRA=a[nLA];
			 }
			 if(nLB<m)
			 {
				 dRB=b[nLB];
			 }
			 
			 if(dLA>dRB)
			 {
				h=M-1; 
			 }
			 else if(dLB>dRA)
			 {
				 l=M+1;
			 }
			 else
			 {
				 if((n+m)%2==1)
				 {
					 ans=Math.max(dLA,dLB);
				 }
				 else
				 {
					 ans=(Math.max(dLA,dLB)+Math.min(dRA, dRB))/2;
				 }
				 break;
			 }
		 }
		 return ans;
	}

}
