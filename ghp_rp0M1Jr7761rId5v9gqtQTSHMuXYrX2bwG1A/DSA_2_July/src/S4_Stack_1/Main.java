package S4_Stack_1;

import java.util.Stack;

class Array
{
	int top=-1;
	int ar[]=new int[5];
	public void push(int x)
	{
		if(top==ar.length-1)
		{
			System.out.println("Stack Overflow-->");
			return;//Overflow
		}
		ar[++top]=x;
	}
	public void pop()
	{
		if(top==-1)
		{
			System.out.println("Stack Underflow-->");
			return;//Underflow
		}
		top=top-1;		
	}
	public int size()
	{
		return top+1;
	}
	public int peek()
	{
		if(top==-1)
		{
			return Integer.MIN_VALUE;//Underflow
		}
		return ar[top];
	}
}

public class Main 
{

	public static void main(String[] args) 
	{
		System.out.println("Implementation of Stacks using-->Arrays");
		Array a=new Array();
		a.push(2);
		a.push(5);
		a.push(7);
		a.pop();
		a.push(2);
		a.push(5);
		a.push(7);
		a.push(10);
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		System.out.println(a.peek());
		System.out.println(a.size());
		System.out.println("Stack Inbuilt Library---->");
		Stack<Integer> st=new Stack<>();
		st.push(10);
		System.out.println(st.peek());
		System.out.println(st.size());
		st.pop();
		System.out.println("Check if a given Seq of Paranthesis is Balanced or Not---->");
		boolean ans=isBalanced("(({}))");
		System.out.println(ans);
		System.out.println("Double Character Trouble---->");
		String s=DoubleChar("abbcbbcac*");
		System.out.println(s);
		System.out.println("Evalating Postfix Expression--->");
		String arr[]= {"5","2","*","3","-"};
		int ans1=evalEx(arr);
		System.out.println(ans1);
		
		
	}

	private static int evalEx(String[] arr) 
	{
		 Stack<Integer> st=new Stack<>();
		 int n=arr.length;
		 for(int i=0;i<n;i++)
		 {
			 String s=arr[i];
			 if(s.equals("+")|| s.equals("-")||s.equals("*")||s.equals("/"))
			 {
				 int b=st.peek();
				 st.pop();
				 int a=st.peek();
				 st.pop();
				 if(s.equals("+"))
				 {
					 st.push(a+b);
				 }
				 else if(s.equals("-"))
				 {
					 st.push(a-b);
				 }
				 else if(s.equals("*"))
				 {
					 st.push(a*b);
				 }
				 else
				 {
					 st.push(a/b);
				 }
			 }
			 else
			 {
				 st.push(Integer.parseInt(s));
			 }
		 }
		 return st.peek();
	}

	private static String DoubleChar(String s) 
	{
		 Stack<Character> st=new Stack<>();
		 int n=s.length();
		 for(int i=n-1;i>=0;i--)
		 {
			 char ch=s.charAt(i);
			 if(st.size()==0)
			 {
				 st.push(ch);
			 }
			 else if(st.peek()!=ch)
			 {
				 st.push(ch);
			 }
			 else
			 {
				 st.pop();
			 }
		 }
		 StringBuilder sb=new StringBuilder();
		 while(st.size()>0)
		 {
			 char ch=st.peek();
			 st.pop();
			 sb.append(ch);
		 }
		 return sb.toString();
	}

	private static boolean isBalanced(String s) 
	{
		 Stack<Character> st=new Stack<>();
		 int n=s.length();
		 for(int i=0;i<n;i++)
		 {
			 char ch=s.charAt(i);
			 if(ch=='(' || ch=='{'||ch=='[')
			 {
				 st.push(ch);
			 }
			 else
			 {
				 if(st.size()==0)
				 {
					 return false;
				 }
				 if(ch==')' && st.peek()=='(')
				 {
					 st.pop();
				 }
				 else if(ch=='}' && st.peek()=='{')
				 {
					 st.pop();
				 }
				 else if(ch==']' && st.peek()=='[')
				 {
					 st.pop();
				 }
				 else
				 {
					 return false;
				 }
			 }
		 }
		 if(st.size()==0)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
	}

}
