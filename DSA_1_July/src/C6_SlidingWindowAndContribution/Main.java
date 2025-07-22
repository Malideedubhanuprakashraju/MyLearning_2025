package C6_SlidingWindowAndContribution;

public class Main 
{

	public static void main(String[] args) 
	{
		// Given Array Calculate & Return Total of All Subarray Sums
		int ar[]= {3,4,2};
		int ans=SubSum(ar);
		System.out.println("Bruit-Force--->"+ans);
		//It is Bruit-Force--->TC=O(N3),SC=O(1)
		int ans1=SubSumPre(ar);
		System.out.println("Using Prefix Sum-->"+ans1);
		//It is Optimised When Comapare to Bruit--->TC=O(N2),SC=O(1)
		// In Any Question If we See Words Like Sum Of All
		//Technique : Contribution Technique=Adding Contributions of Individual Element in Final Ans
		//To Calculate Contribution for an Elemnt
		//We need to Calculate its Occurences : no of Times Elemnt Considered
		//Occurences=In no of subarrays an element is present
		//Start=[0...i]=i-0+1=i+1
		//End=[i...N-1]=N-i-i+1=N-i
		//How Many subbarrays index i is present=Start*End=(i+1)*(N-i)
		int ans2=SubSumCon(ar);
		System.out.println("Contribution Technique-->"+ans2);
		//Given Array Return No of Subbarrays of Len=k or Total no of subarrays of len=k
		//For an Array-->How many Subbarrays of len=k--->(N-K+1)
		//We Can Solve BruitForce O(N3)
		//We Can Solve PrefixSum
		//We Can Solve Sliding Window
		//In Question When Ever we See Fixed Subbarray Size Term-->Go With Sliding Window Technique
		int arr[]= {3,4,-2,5,3,-2,8,2,1,4};
		int k=6;
		int ans3=SubSumSlide(arr,k);
		System.out.println("Sliding Window--->"+ans3);
		
	}

	private static int SubSumSlide(int[] arr,int k) 
	{
		 int n=arr.length;
		 int sum=0,ans=Integer.MIN_VALUE;
		 for(int i=0;i<k;i++)
		 {
			 sum=sum+arr[i];
		 }
		 if(sum>ans)
		 {
			 ans=sum;
		 }
		 int s=1,e=k;
		 while(e<n)
		 {
			 sum=sum-arr[s-1]+arr[e];
			 if(sum>ans)
			 {
				 ans=sum;
			 }
			 s++;
			 e++;
		 }
		 return ans;
	}

	private static int SubSumCon(int[] ar) 
	{
		 int sum=0;
		 int n=ar.length;
		 for(int i=0;i<n;i++)
		 {
			 int s=i+1,e=n-i;
			 int Con=s*e;
			 sum=sum+ar[i]*Con;
		 }
		 return sum;
	}

	private static int SubSumPre(int[] ar) 
	{
		 int n=ar.length;
		 int psum[]=new int[n];
		 psum[0]=ar[0];
		 for(int i=1;i<n;i++)
		 {
			 psum[i]=psum[i-1]+ar[i];
		 }
		 int ans=0;
		 for(int s=0;s<n;s++)
		 {
			 for(int e=s;e<n;e++)
			 {
				 if(s==0)
				 {
					 ans=ans+psum[e];
				 }
				 else
				 {
					 ans=ans+psum[e]-psum[s-1];
				 }
			 }
		 }
		 return ans;
	}

	private static int SubSum(int[] ar) 
	{
		 int n=ar.length;
		 int ans=0;
		 for(int s=0;s<n;s++)
		 {
			 for(int e=s;e<n;e++)
			 {
				 int sum=0;
				 for(int i=s;i<=e;i++)
				 {
					 sum=sum+ar[i];
				 }
				 ans=ans+sum;
			 }
		 }
		 return ans;
	}

}
