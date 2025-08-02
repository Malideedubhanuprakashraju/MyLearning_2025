package D1_InterviewProblems;

public class Main 
{

	public static void main(String[] args) 
	{
		//Q) Given Binary Array, We can atmax replace a Single 0 with 1
		//Find Max Consecutive 1's we can get in Array[]
		int ar[]= {1,1,0,1,1,0,1,1,1};
		//Ans=6
		//Idea : For Evry 0:
		//Iterate & Calculate Consecutive 1's on left=l
		//Iterate & Calculate Consecutive 1's on right=r
		//count=l+r+1
		int ans=ConsecutiveOnes(ar);
		System.out.println(ans);
		//Q) Given a Binary Array, We can atmax a single 0 with 1
		//Find Max Consecutive 1's we can get in Array[]
		int a[]= {1,1,0,1,1,1};
		int ans1=Consecutive1swap(a);
		System.out.println(ans1);
		//Q) Majority Element : Moore's Voting Algorithm
		// Given Array elements, Return Majority element
		// An Elemnt is Said to be Majority(Occurences >N/2)
		// If No Majority Element Return -1
		int arr[]= {3,4,3,6,1,3,2,5,3,3,3};
		int ans2=Majority(arr);
		System.out.println(ans2);
		// Moore's Voting Algorithm : 
		//1.Keep Deleting 2 Different Elements, Till a Same Element Left out
		//Check if left out elemnt is Majority or Not..?
		//Note : At any point freq==0-->Elemnt is deleted
		//Note : When we Removed 2 Different, Things Majority Element will Remain
		//Note : When we Removed 2 Same Things Majority we Might loose Majority
		
	}

	private static int Majority(int[] arr)// T.C=O(N),S.C=O(1)
	{
		 int n=arr.length;
		 int ele=arr[0];
		 int freq=1;
		 for(int i=1;i<n;i++)
		 {
			 if(freq==0)
			 {
				 ele=arr[i];
				 freq=1;
			 }
			 else if(ele==arr[i])
			 {
				 freq++;
			 }
			 else
			 {
				 freq--;
			 }
		 }
		 int c=0;
		 for(int i=0;i<n;i++)
		 {
			 if(arr[i]==ele)
			 {
				 c++;
			 }
		 }
		 if(c>n/2)
		 {
			 return ele;
		 }
		 else
		 {
			 return -1;
		 }
	}

	private static int Consecutive1swap(int[] a)// T.C=O(N), S.C=O(1)
	{
		 int n=a.length;
		 int ans=0,ones=0;
		 for(int i=0;i<n;i++)
		 {
			 if(a[i]==1)
			 {
				 ones++;
			 }
		 }
		 if(ones==n)
		 {
			 return n;
		 }
		 for(int i=0;i<n;i++)
		 {
			 if(a[i]==0)
				  // Get Consective 1's Count on Left & Right
		 		  // 0,1,2.....i-2,i-1,i,i+1,i+2......N-1
			 {
				 int l=0;
				 for(int j=i-1;j>=0;j++)
				 {
					 if(a[j]==1)
					 {
						 l++;
					 }
					 else
					 {
						 break;
					 }
				 }
				 int r=0;
				 for(int j=i+1;j<n;j++)
				 {
					 if(a[j]==1)
					 {
						r++;
					 }
					 else
					 {
						 break;
					 }
				 }
				 int c=l+r;
				 if(ones>l+r)
				 {
					 c=c+1;
				 }
				 ans=Math.max(ans, c);
				 
			 }
		 }
		 return ans;
	}

	private static int ConsecutiveOnes(int[] ar) //T.C=O(N), S.C=O(1)
	{
		 int n=ar.length;
		 int ans=0;
		 int ones=0;
		 for(int i=0;i<n;i++)
		 {
			 if(ar[i]==1)
			 {
				 ones++;
			 }
		 }
		 if(ones==n)
		 {
			 return n;
		 }
		 for(int i=0;i<n;i++)
		 {
			 if(ar[i]==0)// Get Consective 1's Count on Left & Right
				 		 // 0,1,2.....i-2,i-1,i,i+1,i+2......N-1
			 {
				 int l=0;
				 for(int j=i-1;j>=0;j--)
				 {
					 if(ar[j]==1)
					 {
						 l++;
					 }
					 else
					 {
						 break;
					 }
				 }
				 int r=0;
				 for(int j=i+1;j<n;j++)
				 {
					 if(ar[j]==1)
					 {
						 r++;
					 }
					 else
					 {
						 break;
					 }
				 }
				 int c=l+r+1;
				 ans=Math.max(ans, c);
			 }
		 }
		 return ans;
	}

}
