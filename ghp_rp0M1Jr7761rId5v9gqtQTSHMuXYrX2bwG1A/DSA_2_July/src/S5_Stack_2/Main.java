package S5_Stack_2;

import java.util.Stack;

public class Main 
{

	public static void main(String[] args) 
	{
		System.out.println("Nearest Smaller Element on Left Side---->");
		int ar[]= {4,5,2,10,3,12};
		int ans[]=smallerLeft(ar);
		System.out.println("Bruit-Force---->");
		for(int x:ans)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Optimized Version---->");
		int ans1[]=smallerLeft1(ar);
		for(int x:ans1)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Nearest Smaller Index on Left----->");
		int ans2[]=smallerLeftIndex(ar);
		for(int x:ans2)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Nearest Smaller Element on Right Side----->");
		int ans3[]=smallerRight(ar);
		for(int x:ans3)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Nearest Smaller Element on Right Index Side----->");
		int ans4[]=smallerRightIndex(ar);
		for(int x:ans4)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Nearest Greater on Left Side---->");
		int ar1[]= {11,10,6,2,10,7,4,8};
		int ans5[]=GreaterElementLeft(ar1);
		for(int x:ans5)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Nearest Greater on Right Side---->");
		int ans6[]=GreaterElementRight(ar1);
		for(int x:ans6)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Nearest Greater on Left Index Side---->");
		int ans7[]=GreaterElementLeftIndex(ar1);
		for(int x:ans7)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Nearest Greater on Right Index Side---->");
		int ans8[]=GreaterElementRightIndex(ar1);
		for(int x:ans8)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("T.C=>O(N), S.C=>O(N)");
		System.out.println("Histogram Area--> Find Max Rectangular Area----->");
		int ar2[]= {3,2,5,7,6,5,2,3,1,5,6,4,3,5,6,4,1};
		int a=Rectangular(ar2);
		System.out.println(a);
		System.out.println("T.C=>O(N), S.C=>O(N)");
		
	}

	private static int Rectangular(int[] ar) 
	{
		 int n=ar.length;
		 int p1[]=new int[n];
		 Stack<Integer> st=new Stack<>();
		 for(int i=0;i<n;i++)
		 {
			 p1[i]=-1;
			 while(st.size()>0 && ar[st.peek()]>=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 p1[i]=st.peek();
			 }
			 st.push(i);
		 }
		 int p2[]=new int[n];
		 Stack<Integer> st1=new Stack<>();
		 for(int i=n-1;i>=0;i--)
		 {
			 p2[i]=n;
			 while(st.size()>0 && ar[st.peek()]>=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 p2[i]=st.peek();
			 }
			 st.push(i);
		 }
		 
		 int ans=0;
		 for(int i=0;i<n;i++)
		 {
			 int w=p2[i]-p1[i]-1;
			 ans=Math.max(ans,w*ar[i]);
		 }
		 return ans;
	}

	private static int[] GreaterElementRightIndex(int[] ar) 
	{
		int n=ar.length;
		 int ans[]=new int[n];
		 Stack<Integer> st=new Stack<>();
		 for(int i=n-1;i>=0;i--)
		 {
			 ans[i]=-1;
			 while(st.size()>0 && ar[st.peek()]<=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(i);
		 }
		 return ans;
		 
	}

	private static int[] GreaterElementLeftIndex(int[] ar) 
	{
		int n=ar.length;
		 int ans[]=new int[n];
		 Stack<Integer> st=new Stack<>();
		 for(int i=0;i<n;i++)
		 {
			 ans[i]=-1;
			 while(st.size()>0 && ar[st.peek()]<=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(i);
		 }
		 return ans;
	}

	private static int[] GreaterElementRight(int[] ar) 
	{
		int n=ar.length;
		 int ans[]=new int[n];
		 Stack<Integer> st=new Stack<>();
		 for(int i=n-1;i>=0;i--)
		 {
			 ans[i]=-1;
			 while(st.size()>0 && st.peek()<=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(ar[i]);
		 }
		 return ans;
		 
	}

	private static int[] GreaterElementLeft(int[] ar) 
	{
		 int n=ar.length;
		 int ans[]=new int[n];
		 Stack<Integer> st=new Stack<>();
		 for(int i=0;i<n;i++)
		 {
			 ans[i]=-1;
			 while(st.size()>0 && st.peek()<=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(ar[i]);
		 }
		 return ans;
	}

	private static int[] smallerRightIndex(int[] ar) 
	{
		 int n=ar.length;
		 int ans[]=new int[n];
		 Stack<Integer> st=new Stack<>();
		 for(int i=n-1;i>=0;i--)
		 {
			 ans[i]=-1;
			 while(st.size()>0 && ar[st.peek()]>=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(i);
		 }
		 return ans;
	}

	private static int[] smallerRight(int[] ar) 
	{
		 int n=ar.length;
		 int ans[]=new int[n];
		 Stack<Integer> st=new Stack<>();
		 for(int i=n-1;i>=0;i--)
		 {
			ans[i]=-1;
			while(st.size()>0 && st.peek()>=ar[i])
			{
				st.pop();
			}
			if(st.size()>0)
			{
				ans[i]=st.peek();
			}
			st.push(ar[i]);
		 }
		 return ans;
	}

	private static int[] smallerLeftIndex(int[] ar) 
	{
		 int n=ar.length;
		 int ans[]=new int[n];
		 Stack<Integer> st=new Stack<>();
		 for(int i=0;i<n;i++)
		 {
			 ans[i]=-1;
			 while(st.size()>0 && ar[st.peek()]>ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(i);
		 }
		 return ans;
	}

	private static int[] smallerLeft1(int[] ar) 
	{
		 int ans[]=new int[ar.length];
		 Stack<Integer> st=new Stack<>();
		 for(int i=0;i<ar.length;i++)
		 {
			 ans[i]=-1;
			 while(st.size()>0 && st.peek()>=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(ar[i]);
		 }
		 return ans;
	}

	private static int[] smallerLeft(int[] ar) 
	{
		 int ans[]=new int[ar.length];
		 
		 for(int i=0;i<ar.length;i++)
		 {
			 ans[i]=-1;
			 for(int j=i-1;j>=0;j--)
			 {
				if(ar[j]<ar[i])
				{
					ans[i]=ar[j];
					break;
				}
			 }
		 }
		 return ans;
	}

}
