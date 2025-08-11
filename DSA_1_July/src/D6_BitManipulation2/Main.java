package D6_BitManipulation2;

import java.util.ArrayList;

public class Main 
{

	public static void main(String[] args) 
	{
		// Check ith Bit Set in N : (N>>i)&1==1 : ith Bit in N is Set
		// Set ith Bit in N : N=N |(1<<i)
		// Flip ith Bit in N : N=N ^ (1<<i)
		// a^a=0 //Same Same Puppy Same=0
		
		//Q) Given Array Every Elemnt Repeats Twice Except 1, Return Unique Elemrnt
		int ar[]= {2,3,5,6,3,6,2};
		//Idea-1 : For Every ar[i] & itearte & get it's frequency==1
		//T.C= O(N2)
		
		//Idea-2 : Calculate XOR for All ELemnts
		int ans=unique(ar);
		System.out.println("Unique Element----->"+ans);
		//Approach: 2-->Every Elemnt Repeat Some Number of Times Except 1 Element
		//Bit Wise Problems Work on Bits
		//Let's Write Binary Representation of Every Number
		//Observation-1: Count No of Set Bit's at Each Bit Position
		//Observation-2: Without Unique Element, No of Set Bits at Each Bit Positions is Even
		int ans1=SingleNumber(ar);
		System.out.println("Unique Best Appr--->"+ans1);
		
		//Q) Given Array All The Elements Will Occurs Thrice but Once Find the unique Elemnt
		int a[]= {4,5,5,4,1,6,6,4,5,6};
		//Idea-1 : For Every Array Iterate an Array & get Frequency ==1
		//T.C=O(N2)
		//Idea-2 : Take XOR of All Ele : We are Calculating XOR of Each Individual Ele
		//Observation : For each bit : Count no of Set bits
		int ans2=SingleNumber2(a);
		System.out.println("Unique Ele Best Appr "+ans2);
		
		//Q) Given Array All The Elements Will Occur Twice but Two ELements return Two Unique Elements
		int arr[]= {4,5,4,1,6,6,5,2};
		//Idea-1 : For Every Array : Iterate on All Array Elemnts get Frequnecy==1
		//T.C=O(N2)
		//Idea-2 : Calculate XOR of All Elements
		//Issue : We Cannot Extract 2 Unique Numbers From Them
		//Idea-3 : Xor of All Ele : XOR of both unique elements
		// 		  Devide Array into 2-parts Based on Value at 1st bit position
		//Conclusion-1 :We Separate Array Based on Bit Position i which both uniq ele are different
		//Conclusion-2 :After Calculating XOR Values :
		//				1)For That Value, Get It's Set bit position ,at That position
					//	Both Unique Elemnts are Different
		ArrayList<Integer> anr=SingleNumber3(arr);
		System.out.println(anr);
 	}

	private static ArrayList<Integer> SingleNumber3(int[] arr) 
	{
		 int xor=0;
		 for(int i=0;i<arr.length;i++)
		 {
			 xor=xor^arr[i];
		 }
		 int p=-1;// Invalid Bit Position
		 for(int i=0;i<32;i++)
		 {
			 if((((xor>>i)&1)==1))
			 {
				 p=i;// At this bit, Both Unique Ele are Different
			 }
		 }
		 
		 //Separate Array Based Pth Bit Position
		 int a=0,b=0;
		 for(int i=0;i<arr.length;i++)
		 {
			if(((arr[i]>>p)&1)==1)
			{
				a=a^arr[i];//Set Side
			}
			else
			{
				b=b^arr[i];
			}
		 }
		 ArrayList<Integer> ar=new ArrayList<>();
		 if(a<b)
		 {
			 ar.add(a);
			 ar.add(b);
		 }
		 else
		 {
			 ar.add(b);
			 ar.add(a);
		 }
		 return ar;
	}

	private static int SingleNumber2(int[] a) //T.C=O(N)
	{
		 int n=a.length;
		 int ans=0;
		 //For each Bit Pos : Count how many elemnts have that bit Set
		 for(int i=0;i<32;i++)
		 {
			 int c=0;// Count no of Array Ele With ith Bit : Set
			 for(int j=0;j<n;j++)
			 {
				 if(((a[j]>>i)&1)==1)
				 {
					 c++;
				 }

			 }
			 if(c%3!=0)// ith Bit in unique number is Set
			 {
				 ans=ans|(1<<i);
			 }
		 }
		 return ans;
	}

	private static int SingleNumber(int[] ar)//T.C=O(32*N)=O(N)
	{
		 int n=ar.length,ans=0;
		 // For Each Bit Pos :Count How Many Elemnts Have That bit Set
		 for(int i=0;i<32;i++)
		 {
			 int c=0;
			 for(int j=0;j<n;j++)
			 {
				 if(((ar[j]>>i)&1)==1)
				 {
					 c++;
				 }
			 }
			 if(c%2==1)
			 {
				 ans=ans|(1<<i);
			 }
		 }
		 return ans;
	}

	private static int unique(int[] ar) //T.C=O(N)
	{
		 int n=ar.length;
		 int ans=0; // A^0=A ---> 0 Won't Effect Your XOR Value
		 for(int i=0;i<n;i++)
		 {
			 ans=ans^ar[i];
		 }
		 return ans;
	}

}
