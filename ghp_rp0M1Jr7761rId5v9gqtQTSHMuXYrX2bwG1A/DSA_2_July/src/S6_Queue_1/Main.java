package S6_Queue_1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main 
{

	public static void main(String[] args) 
	{
		 System.out.println("Double Ended Queue---->");
		 Deque<Integer> d=new ArrayDeque<>();
		 d.addFirst(10);
		 d.addFirst(20);
		 d.addFirst(30);
		 d.addFirst(40);
		 d.addFirst(50);
		 System.out.println("Add_First");
		 System.out.println(d);
		 d.addLast(60);
		 d.addLast(70);
		 d.addLast(80);
		 d.addLast(90);
		 d.addLast(100);
		 System.out.println("Add_Last");
		 System.out.println(d);
		 System.out.println("Get_First"+d.getFirst());
		 System.out.println("Get_Last"+d.getLast());
		 System.out.println(d);
		 System.out.println("Remove_last"+d.removeFirst());
		 System.out.println("Remove-First"+d.removeLast());
		 System.out.println(d);
		 System.out.println("Find Max Element in Evry Subarray of Size=k---->");
		 int ar[]= {10,1,9,3,7,6,5,11,8};
		 int ans[]=WindowMax(ar,5);
		 for(int x: ans)
		 {
			 System.out.print(x+" ");
		 }
		 System.out.println();
		 System.out.println("Find Min Element in Evry Subarray of Size=k---->");
		 int ar1[]= {4, 3, 5, 2, 1, 6, 7};
		 int ans1[]=WindowMin(ar1,3);
		 for(int i=0;i<ans1.length;i++)
		 {
			 System.out.print(ans1[i]+" ");
		 }
	}

	

	private static int[] WindowMin(int[] ar, int k) 
	{
		int n=ar.length;
		int ans[]=new int[n-k+1];
		Deque<Integer> dq=new ArrayDeque<>();
		for(int i=0;i<k;i++)
		{
			while(dq.size()>0 && ar[i]<dq.getLast())
			{
				dq.removeLast();
			}
			dq.addLast(ar[i]);
		}
		ans[0]=dq.getFirst();
		int s=1,e=k;
		while(e<n)
		{
			while(dq.size()>0 && ar[s-1]==dq.getFirst())
			{
				dq.removeFirst();
			}
			
			while(dq.size()>0 && ar[e]<dq.getLast())
			{
				dq.removeLast();
			}
			dq.addLast(ar[e]);
			ans[s]=dq.getFirst();
			s++;
			e++;
		}
		return ans;
	}



	private static int[] WindowMax(int[] ar, int k) 
	{
		 int n=ar.length;
		 int ans[]=new int[n-k+1];
		 if(k>n)
		 {
			 return new int[0];
		 }
		 Deque<Integer> dq=new ArrayDeque<>();
		 for(int i=0;i<k;i++)
		 {
			 while(dq.size()>0 && ar[i]>dq.getLast())
			 {
				 dq.removeLast();
			 }
			 dq.addLast(ar[i]);
		 }
		 ans[0]=dq.getFirst();
		 int s=1,e=k;
		 while(e<n)
		 {
			 if(dq.size()>0 && dq.getFirst()==ar[s-1])
			 {
				dq.removeFirst(); 
			 }
			 while(dq.size()>0 && ar[e]>dq.getLast())
			 {
				 dq.removeLast();
			 }
			 dq.addLast(ar[e]);
			 ans[s]=dq.getFirst();
			 s++;
			 e++;
			 
		 }
		 return ans;
		 
	}

	 

}
