package C7_SortingBasics;

import java.util.Arrays;
import java.util.Collections;

public class Main 
{

	public static void main(String[] args) 
	{
		//Q) Minimize cost to Empty Array
		//The Cost of Removing an Element is defined as Sum of all Remaining Elemnts in The Array at 
		//The Time of Removal
		//ar[]={2,1,4}
		//Remove : Cost--> Change Array To ecresing Order{4,2,1}
		//  4	 : (4+2+1)=7
		//  2    : (2+1)=3
		//  1    : (1)=1
		// Idea :
		// Remove : Cost
		//   a    : a+b+c+d
		//   b    : b+c+d
		//   c    : c+d
		//   d    : d
		// Min : We need a>b>c>d---> Elements in Decresing Order
		int ar[]= {2,1,4};
		int ans=calculateCost(ar);
		System.out.println(ans);
		// Noble Integers :
		// Given an Array of Distinct Elemnts Find COunt of Noble Integers.
		// An Array is Nobel if Count of elemnst smaller Than Array is equal to Array
		int a[]= {1,-5,3,5,-10,4};
		int ans1=NobleIntegers(a);
		System.out.println("Without Repeation Nobles--->"+ans1);
		//Noble Elemenst Can Repeat
		int arr[]= {-10,1,1,3,100};
		int ans2=NobelIntegers2(arr);
		System.out.println("With Repetition No's--->"+ans2);
		// Sorting Algorithm
		// Selection Sort
		//Iterate an Array & Bring Elemnts to it's Correct Position
		//For Every Index from 0...n-1: Get Correct Elemnt to it's Position
		int sel[]= {7,12,6,4,9,10};
		int s[]=SelectionSort(sel);//TC=O(n2)
		for(int x:s)
		{
			System.out.print(x+" ");
		}
		//Given Array of +integers Return min(ar[i]*ar[j]*ar[k]Triplet Product
		int ab[]= {2,7,4,3,1,6};
		//3-Smallest numbers will give Smallest Triplet Product.
		//Idea 1:Sort array *Multiply first 3 elements-->O(NlogN)
		//Idea 2:In Selection Sort, Iterate 3-times & get 3 Smallest Elements--->O(3*N)
		int ans3=TrippletSmaller(ab);
		System.out.println();
		System.out.println("Tripplet--->"+ans3);
		
		
		
	}

	private static int TrippletSmaller(int[] ar) 
	{
		int n=ar.length;
		
		for(int i=0;i<n;i++)
		{
			int min=Integer.MAX_VALUE,mini=i;
			for(int j=i;j<n;j++)
			{
				if(ar[j]<min) {
					min=ar[j];
					mini=j;
				}
			}
			int t=ar[mini];
			ar[mini]=ar[i];
			ar[i]=t;
		}
		return ar[0]*ar[1]*ar[2];
	}

	private static int[] SelectionSort(int[] ar) 
	{
		int n=ar.length;
		for(int i=0;i<n;i++)
		{
			int minv=Integer.MAX_VALUE,mini=i;
			for(int j=i;j<n;j++)
			{
				if(ar[j]<minv)
				{
					minv=ar[j];
					mini=j;
				}
			}
			// Swap ar[minindex] with ar[i]
			int t=ar[mini];
			ar[mini]=ar[i];
			ar[i]=t;
		}
		return ar;
	}

	private static int NobelIntegers2(int[] arr) 
	{
		 int n=arr.length,c=0,ans=0;
		 if(arr[0]==0)
		 {
			 ans++;
		 }
		 Arrays.sort(arr);
		 for(int i=1;i<n;i++)
		 {
			 if(arr[i]!=arr[i-1])//Ar[i] is 1st Occurence
			 {
				 c=i;
			 }
			 if(arr[i]==c)
			 {
				 ans++;
			 }
		 }
		 return ans;
	}

	private static int NobleIntegers(int[] a) 
	{
		 int n=a.length;
		 int c=0;
		 Arrays.sort(a);
		 for(int i=0;i<n;i++)
		 {
			 if(a[i]==i)
			 {
				 c++;
			 }
		 }
		 return c;
		 
	}

	private static int calculateCost(int[] ar) 
	{
		 int n=ar.length;
		 int c=0;
		 Arrays.sort(ar);
		 reverArray(ar);
		 for(int i=0;i<n;i++)
		 {
			 c=c+ar[i]*(i+1);
		 }
		 return c;
	}

	private static void reverArray(int[] ar) 
	{
		 int l=0,r=ar.length-1;
		 while(l<r)
		 {
			 int t=ar[l];
			 ar[l]=ar[r];
			 ar[r]=t;
			 l++;
			 r--;
		 }
		
	}

}
