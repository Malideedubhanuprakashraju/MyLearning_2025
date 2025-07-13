package S1_Searching_1;

public class Main 
{

	public static void main(String[] args) 
	{
		 int a[]= {3,6,9,12,14,19,20,23,25,27};
		 System.out.println("Given Sorted Array search K is present or not----->TC=O(logn),Sc=O(1)--->");
		 boolean ans=search(a,12);
		 System.out.println(ans);
		 System.out.println("Given Sorted Array Find index of First Occurence of given Element---->");
		 int ar[]= {-5,-5,-3,0,0,1,1,5,5,5,5,5,5,8,10,10,15};
		 int ans1=Occurence(ar,5);
		 System.out.println(ans1);
		 System.out.println("Find Last Occurence------>");
		 int ans2=LastOccurence(ar,5);
		 System.out.println(ans2);
		 System.out.println("Given Unsorted Array return any one Local Maxima---->");
		 int arr[]= {9,10,7,3,6,4,1,5,2,10,-4};
		 int ans3=localMaxima(arr);
		 System.out.println(ans3);
		 System.out.println("Find Unique Element--> Evry Element Occurs Twice----->");
		 int arrr[]= {6,6,2,2,7,9,9,4,4,10,10};
		 int ans4=unique(arrr);
		 System.out.println(ans4);
		 
	}

	private static int unique(int[] arrr) 
	{
		 int n=arrr.length;
		 if(n==1)
		 {
			 return arrr[0];
		 }
		 if(arrr[0]!=arrr[1])
		 {
			 return arrr[0];
		 }
		 if(arrr[n-1]!=arrr[n-2])
		 {
			 return arrr[n-1];
		 }
		 int l=0,h=n-1;
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 if(m>0 && m<n-1 && arrr[m-1]!=arrr[m] && arrr[m]!=arrr[m+1])
			 {
				 return arrr[m];
			 }
			 if(arrr[m]==arrr[m-1])
			 {
				 m=m-1;
			 }
			 if(m%2==0)
			 {
				 l=m+2;
			 }
			 else
			 {
				 h=m-1;
			 }
		 }
		 return -1;
	}

	private static int localMaxima(int[] arr) 
	{
		
		int n=arr.length;
		if(n==1)
		{
			return arr[0];
		}
		if(arr[0]>arr[1])
		{
			return arr[0];
		}
		if(arr[n-1]>arr[n-2])
		{
			return arr[n-1];
		}
		int l=1,h=n-2;
		while(l<=h)
		{
			int m=(l+h)/2;
			if(arr[m-1]<arr[m]&& arr[m]>arr[m+1])
			{
				return arr[m];
			}
			else if(arr[m-1]>arr[m])
			{
				h=m-1;
			}
			else
			{
				l=m+1;
			}
		}
		return -1;
	}

	private static int LastOccurence(int[] ar, int k) 
	{
		 int n=ar.length;
		 int l=0,h=n-1,ans=-1;
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 if(ar[m]==k)
			 {
				ans=m;
				l=m+1;
			 }
			 else if(ar[m]>k)
			 {
				 h=m-1;
			 }
			 else
			 {
				 l=m+1;
			 }
		 }
		 return ans;
	}

	private static int Occurence(int[] ar, int i) 
	{
		 int n=ar.length;
		 int l=0,h=n-1;
		 int ans=-1;
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 if(ar[m]==i)
			 {
				 ans=m;
				 h=m-1;				 
			 }
			 else if(ar[m]>i)
			 {
				 h=m-1;
			 }
			 else
			 {
				 l=m+1;
			 }
		 }
		 return ans;
	}

	private static boolean search(int[] a, int k) 
	{
		int n=a.length;
		int l=0,h=n-1;
		while(l<=h)
		{
			int mid=(l+h)/2;
			if(a[mid]==k)
			{
				return true;
			}
			else if(a[mid]>k)
			{
				h=mid-1;
			}
			else
			{
				l=mid+1;
			}
		}
		return false;
	}

}
