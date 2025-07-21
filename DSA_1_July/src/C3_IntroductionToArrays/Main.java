package C3_IntroductionToArrays;

import java.util.ArrayList;
import java.util.Collections;

public class Main 
{

	public static void main(String[] args) 
	{
		System.out.println("Given Array Print Max Element--->");
		int A[]= {30,40,10,25,68,564};
		int ans=MaxArr(A);
		System.out.println(ans);
		System.out.println("Array Basics--->");
		System.out.println("Array Declaration--->int[] ar=new int[5]");
		System.out.println("Array Initialization---->ar[0]=40,ar[1]=30.....ar[n-1]=20");
		System.out.println("First & Last indices are---->ar[0],ar[n-1");
		System.out.println("Printing Array Elements---->");
		printArray(A);
		System.out.println();
		System.out.println("Given Array--> Reverse Entire Array[]-->");
		reverse(A);
		printArray(A);
		System.out.println();
		System.out.println(A[0]);
		System.out.println("Given Array,left,right--->Reverse Entire Array from l...r--->");
		int ans2[]=reverseRange(A,1,4);
		printArray(ans2);
		System.out.println();
		System.out.println("Given Array Rotate it by k-Times by Right->Left--->Bruit Force");
		int ar1[]= {10,20,30,40,50,60,70,80,90};
		int k=3;
		//rotate(ar,k);
		printArray(ar1);
		System.out.println();
		System.out.println("Rotate Array Optimized Approach---->O(N)--->");
		RotateOpt(ar1,4);
		printArray(ar1);
		System.out.println("Dynamic Arrays--->ArrayList");
		Dynamic();
		
	}

	private static void Dynamic() 
	{
		 ArrayList<Integer> al=new ArrayList<>();
		 System.out.println("Inbuilt-Functions");
		 // add(element)-->Adding an Element to End of ArrayList al:{...}
		 al.add(100);
		 al.add(20);
		 al.add(10);
		 al.add(32);
		 System.out.println(al);
		 //size()--->It will return total no of elements
		 System.out.println(al.size());
		 //get(index)--->To acccess ith index element of ArrayList
		 System.out.println(al.get(2));
		 //set(index,value)--->Update value to a particular index
		 al.set(0, 500);
		 //remove(index)--->We can remove that index element
		 al.remove(0);
		 //Collections.sort(al)--->It will sort Arraylist in incresing order
		 Collections.sort(al);
		 System.out.println(al);
		 
		
	}

	private static void RotateOpt(int[] ar, int k)
	{
		int n=ar.length;
		k=k%n;// Rotating k is same as Rotating k%N
		reverseRange(ar,0,n-1);
		reverseRange(ar,0,k-1);
		reverseRange(ar,k,n-1);
	}

	private static void rotate(int[] ar, int k) 
	{
		
		for(int i=1;i<=k;i++)
		{
			int n=ar.length;
			int temp=ar[n-1];
			for(int j=n-1;j>=1;j--)
			{
				ar[j]=ar[j-1];
			}
			ar[0]=temp;
		}
					
	}

	private static int[] reverseRange(int[] a, int l, int r) 
	{
		 int n=a.length;
		 int p1=l,p2=r;
		 while(p1<p2)
			{
				//Swapping 2 elements
				int t=a[p1];
				a[p1]=a[p2];
				a[p2]=t;
				p1++;
				p2--;
			}
		 return a;
		 
	}

	private static void reverse(int[] a) 
	{
		int n=a.length;
		int p1=0,p2=n-1;
		while(p1<p2)
		{
			//Swapping 2 elements
			int t=a[p1];
			a[p1]=a[p2];
			a[p2]=t;
			p1++;
			p2--;
		}
	}

	private static void printArray(int[] a) 
	{
		 int n=a.length;
		 for(int i=0;i<n;i++)
		 {
			 System.out.print(a[i]+" ");
		 }
	}

	private static int MaxArr(int[] a) 
	{
		 int n=a.length;
		 int max=Integer.MIN_VALUE;
		 for(int i=0;i<n;i++)
		 {
			 if(a[i]>max)
			 {
				 max=a[i];
			 }
		 }
		 return max;
	}

}
