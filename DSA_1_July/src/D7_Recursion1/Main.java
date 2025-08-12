package D7_Recursion1;

public class Main 
{

	public static void main(String[] args) 
	{
		//Recursive Code 
		//Recursion : Function Calling Itself
		//Solving Problem With Subproblems is Called Recursion
		//Steps :
		//		1)Assumption :Question itself-->Decide What ur Function & Assume it WOrks
		//	    2)Main Logic :Solving Assumption by Break Problem in Subproblems & Solve it using Subproblems
		
		// 		3)Base Condition :Input for which we ant to Stop Recursion
		//Note :Don't Use Post Increment Operations, While Writing Recursion
		//Q) Sum of Natural Numbers Using Recursion
		int n=5;
		int ans=Sum(n);
		System.out.println(ans);
		//Base Always at Top
		//Q) Factorial of a given Number
		int ans1=fact(n);
		System.out.println(ans1);
		//Q) Given N Print All Numbers from 1 to N in increasing Order
		printNo(n);
		System.out.println();
		//Q) Given N Print All Numbers from N to 1 in Decresing Order
		printDec(n);
		//Fibanacci No :Fib(N)=Fib(N-1)+Fib(N-2)
		int ans2=Fib(n);
		System.out.println();
		System.out.println(ans2);
		System.out.println();
		boolean ans3=isPal("aba",0,2);
		System.out.println(ans3);
		/*  Short and Clean Code */
		/* private static boolean isPal(String st, int s, int e) 
		 * {
    			if (s >= e) return true;
    			return st.charAt(s) == st.charAt(e) && isPal(st, s + 1, e - 1);
		   }
		*/
		
		
	}

	private static boolean isPal(String st, int s, int e) 
	{
		if(s>=e)
		{
			return true;
		}
		if(st.charAt(s)==st.charAt(e) && isPal(st,s+1,e-1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static int Fib(int n) //T.C=O(2N)
	{
		if(n<=1)		//if(N==0){return 0;}
						//if(N==1){return 1;}
		{
			return n;
		}
		 return Fib(n-1)+Fib(n-2);
	}

	private static void printDec(int n)//T.C=O(N), S.C=O(N)
	{	
		 if(n==0)
		 {
			return; 
		 }
		 System.out.print(n+" ");
		 printDec(n-1);
	}

	private static void printNo(int n) //T.C=O(N), S.C=O(N)
	{
		if(n==0)
		{
			return;//Even if function return type is void we can still return
		}
		 printNo(n-1);
		 System.out.print(n+" ");
	}

	private static int fact(int n)//T.C=O(N), S.C=O(N)
	{
		if(n==0)
		{
			return 1;
		}
		 return fact(n-1)*n;
	}

	private static int Sum(int n)//T.C=O(N), S.C=O(N)
	{
		if(n==0)
		{
			return 0;
		}
		 return Sum(n-1)+n;
	}

}
