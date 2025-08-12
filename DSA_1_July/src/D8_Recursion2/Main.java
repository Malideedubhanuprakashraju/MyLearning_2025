package D8_Recursion2;

public class Main 
{

	public static void main(String[] args) 
	{
		//Recursion : 3-Steps
		//1)Assumption
		//2)Main Logic
		//3)Base Condition
		//T.C=Total Function Calls * Time Taken for Each Function Call
		//S.C=Max Stack Size at any given Point
		
		//Given pow(a,n) return a(n) using Recursion
		//Pow(3,4) =3*3*3*3=81
		//Pow(a,n) =a*a*a*......n times
		//Pow(a,n) =Pow(a,n-1)*a
		
		//Assum : Given a,n : Calculate & return a(n)
		int ans=pow(3,4);
		System.out.println(ans);
		
		//Idea-2:
		//Pow(3,8)  =Pow(3,7)*3
		//EvenCase: =Pow(3,4)*Pow(3,4)
		//OddCase: Pow(4,11) =Pow(4,5)*Pow(4,5)*4
		//Pow(a,n) = if N is even :
		//					Pow(a,n/2)*Pow(a,n/2)
		//			 else
		//					Pow(a,n/2)*Pow(a,n/2)*a
		//Optimization : Same Subproblem Twice , Solve Once Store it & Re-use
		//Pow(a,n): p=pow(a,n/2)
		//			if n is even
		//				return p*p
		//			else
		//				return p*p*a
		int ans1=powOpt(2,3);
		System.out.println(ans1);
		
		//Print Array Using Recursion
		int ar[]= {3,7,8,2,9};
		printArray(ar,0);
		System.out.println();
		
		//Sum Of Elemnts Using Recursion
		int ans2=ArraySum(ar,0);
		System.out.println(ans2);
		
		//Given Array and Target=B, Task is count all occurances in Array
		int arr[]= {4,5,3,1,5,4,5};
		int B=5;
		int ans3=search(arr,B,0);
		System.out.println(ans3);
		
		//Q) Given N Return Reverse of N
		int ans4=Rev(123,0);
		System.out.println(ans4);
	}
	

	private static int Rev(int N,int rev) 
	{
		if(N==0)
		{
			return rev;
		}
		return Rev(N/10,rev*10+N%10);//rev_new=rev_old×10+last digit of N
	}


	private static int search(int[] arr, int b, int i) 
	{
		 if(i==arr.length)
		 {
			 return 0;
		 }
		 int c=search(arr,b,i+1);
		 if(arr[i]==b)
		 {
			 c=c+1;
		 }
		 
		 return c;
	}


	private static int ArraySum(int[] ar, int i)// T.C=O(N), S.C=O(N) 
	{
		 if(i==ar.length)
		 {
			 return 0;
		 }
		 return ar[i]+ArraySum(ar,i+1);
	}

	private static void printArray(int[] ar, int i)//T.C= O(N), S.C= O(N)
	{
		 if(i==ar.length)
		 {
			 return;
		 }
		 System.out.print(ar[i]+" ");
		 printArray(ar,i+1);
	}

	private static int powOpt(int a, int n)// T.C= O(logN), S.C= O(logN) 
	{
		if(n==0)
		{
			return 1;
		}
		int p=powOpt(a,n/2);
		if(n%2==0)
		{
			return p*p;
		}
		else
		{
			return p*p*a;
		}
	}

	private static int pow(int a, int n)//T.C= O(N),S.C= O(N) 
	{
		 if(n==0)
		 {
			 return 1;
		 }
		 return pow(a,n-1)*a;
	}

}
