package Heaps;

import java.util.ArrayList;
import java.util.List;

public class P1_Main 
{

	public static void main(String[] args) 
	{
		 // Insert Element into Given MinHeap
		 ArrayList<Integer> ar=new ArrayList<>(List.of(3,7,6,10,14,11,15,20));
		 System.out.println(ar);
		// insertMin(ar,2);
		 System.out.println(ar);
		 // Delete Element in Given MinHeap
		 //deleteMin(ar);
		// System.out.println(ar);
		// deleteMin2(ar);
		 ArrayList<Integer> ar1=new ArrayList<>(List.of(6,2,8,10,14,3,9,2,7,20,1,-3));
		 System.out.println(ar1);
		 
		 System.out.println("Hepify---Converting Array-->Min/Max Heap ");
		 minHeapify(ar1);
		 System.out.println(ar1);
		 
	}

	private static void minHeapify(ArrayList<Integer> ar1) 
	{
		 int n=ar1.size();
		 for(int ind=n-1;ind>=0;ind--)
		 {
			int i=ind;
			while(2*i+1<n)
			{
				int mindex=2*i+1;
				if((2*i+2<n)&&(ar1.get(2*i+2)<ar1.get(2*i+1)))
				{
					mindex=2*i+2;
				}
				if(ar1.get(i)<ar1.get(mindex))
				{
					break;
				}
				else
				{
					int t=ar1.get(i);
					ar1.set(i,ar1.get(mindex));
					ar1.set(mindex,t);
					
					i=mindex;
				}
			}
		 }
	}

	private static void deleteMin2(ArrayList<Integer> ar) 
	{
		 int n=ar.size();
		 int temp = ar.get(0);
		 ar.set(0, ar.get(n - 1));
		 ar.set(n - 1, temp);
		 
		 ar.remove(n-1);
		 n=n-1;
		 
		 int i=0;
		 while(2*i+1<n)
		 {
			 int mindex=2*i+1;
			 if(2*i+2<n)
			 {
				 if(ar.get(2*i+2)<ar.get(mindex))
				 {
					 mindex=2*i+2;
				 }
			 }
			 if(ar.get(i)<=ar.get(mindex))
			 {
				 break;
			 }
			 else
			 {
				 int t=ar.get(i);
				 ar.set(i,ar.get(mindex));
				 ar.set(mindex,t);
				 i=mindex;
			 }
			 
		 }
		 
	}

	private static void deleteMin(ArrayList<Integer> ar) 
	{
		 int n=ar.size();
		 
		 int temp=ar.get(0);
		 ar.set(0,ar.get(n-1));
		 ar.set(n-1,temp);
		 
		 ar.remove(n-1);
		 n=n-1;
		 int i=0;
		 while(i<n)
		 {
			 int mindex=0;
			 int l=2*i+1;
			 int r=2*i+2;
			 
			 if(l>n)
			 {
				 break;
			 }
			 if(l<n)
			 {
				mindex=l; 
			 }
			 if(r<n && ar.get(r)<ar.get(l))
			 {
				 mindex=r;
			 }
			 if(ar.get(i)<ar.get(mindex))
			 {
				 break;
			 }
			 else
			 {
				 int t=ar.get(i);
				 ar.set(i,ar.get(mindex));
				 ar.set(mindex,t);
				 
				 i=mindex;
			 }
		 }
		 
		
	}

	private static void insertMin(ArrayList<Integer> ar, int x) 
	{
		ar.add(x);
		int i=ar.size()-1;
		while(i>0)
		{
			int p=(i-1)/2;
			if(ar.get(p)>ar.get(i))
			{
				int t=ar.get(p);
				ar.set(p,ar.get(i));
				ar.set(i,t);
				i=p;
			}
			else
			{
				break;
			}
		}
	}

}
