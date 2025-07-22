package C5_CarryForward;

public class Main 
{

	public static void main(String[] args) 
	{
		//If we Have to Calculate a Same Data From L-R or R-L in multiple Times,
		//use carryforward & Calculate Data in 1shot from direction 
		// Q)Count Pairs 'ag'
		//Given Char Array Calculate No of Pairs indices=i,j
		char ch[]= {'a','d','g','a','g','a','g','f','g'};
		int ans=pairs(ch);
		System.out.println();
		System.out.println("Bruit-Force---TC=O(N2)---->"+ans);
		//Optimization Idea
		//Calculate no of g's from Right to Left in 1-Short
		int ans1=pairs1(ch);
		System.out.println(ans1);
		// Subarray:
		// Continuous Part of an Array[] is considered as Subarray
		// Total Count of Subarrays-->4--->{4,2,10,3}-->10
		// If ar[n]-->Total Subarrays=N+N-1+N-2+....1=(N)(N+1)/2
		// Given Start index & End index print Subarray
		int ar[]= {4,1,2,3,-1,6,9,8,12};
		
		// printSubarray(ar,1,6);
		// Given Array Elemnts Print All SubArrays-->O(N3)
		printAll(ar);
		// Given Array Return Length of Smaallest Subarray which contains both Min & Max of Array
		int ar1[]= {1,2,3,1,3,4,6,4,6,3};
		int ans2=minSub(ar1);
		System.out.println("MinSubArray has Both Min & Max-->");
		System.out.println(ans2);
	}

	private static int minSub(int[] a) 
	{
		 int n=a.length;
		 int min=Integer.MAX_VALUE;
		 int max=Integer.MIN_VALUE;
		 for(int i=0;i<n;i++)
		 {
			 if(a[i]>max)
			 {
				 max=a[i];
			 }
			 if(min>a[i])
			 {
				 min=a[i];
			 }
		 }
		 if(max==min)
		 {
			 return 1;
		 }
		 int minI=-1,maxI=-1,ans=n;
		 for(int i=n-1;i>=0;i--)
		 {
			 if(a[i]==max)//{maxI.....minI}
			 {
				 maxI=i;
				 if(minI!=-1)
				 {
					 ans=Math.min(ans,minI-maxI+1);
				 }
			 }
			 if(a[i]==min)
			 {
				 minI=i;//{minI.....maxI}
				 if(maxI!=-1)
				 {
					 ans=Math.min(ans, maxI-minI+1);
				 }
				 
			 }
		 }
		 return ans;
	}

	private static void printAll(int[] ar) 
	{
		 int n=ar.length;
		 for(int s=0;s<n;s++)
		 {
			 for(int e=s;e<n;e++)
			 {
				for(int i=s;i<=e;i++)
				{
					System.out.print(ar[i]+" ");
				}
				System.out.println();
			 }
		 }
	}

	private static void printSubarray(int[] ar, int s, int e) 
	{
		 for(int i=s;i<=e;i++)
		 {
			 System.out.print(ar[i]+" ");
		 }
	}

	private static int pairs1(char[] ch) 
	{
		 int n=ch.length;
		 int ans=0,cg=0;
		 for(int i=n-1;i>=0;i--)
		 {
			 if(ch[i]=='g')
			 {
				cg++; 
			 }
			 else if(ch[i]=='a')
			 {
				 ans=ans+cg;
			 }
		 }
		 return ans;
	}

	private static int pairs(char[] ch) 
	{
		 int n=ch.length,ans=0;
		 for(int i=0;i<n;i++)
		 {
			 if(ch[i]=='a')//Iterate on RIght  
			 {
				int c=0;
				for(int j=i+1;j<n;j++)
				{
					if(ch[j]=='g')
					{
						c++;
					}
				}
				ans=ans+c;
			 }
		 }
		 return ans;
	}

}
