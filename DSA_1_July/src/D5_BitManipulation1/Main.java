package D5_BitManipulation1;

public class Main 
{

	public static void main(String[] args) 
	{
	  // A & B = 1&1=1
	  // A | B = 0&0=0
	  // A ^ B = Same Same : Puppy Shame=0
	  // ~ A =  1=0 v/s 0=1
		
	  int A=10;
	  int B=14;
	  System.out.println(A&B);
	  System.out.println(A | B);
	  System.out.println(A ^ B);
	  					  // -->0 :A is Even.(If 0th Bit in A is 0
	  //Observation-1 : A&1= 
	  					  // -->1 :A is Odd.(If 0th Bit in A is 1)
	  
	  // Properties :
	  // 1) A&1 = 0:A is even, 1: A is Odd
	  // 2) A&0 = 0
	  // 3) A&A = A
	  // 4) A|A = A
	  // 5) A|0 = A
	  // 6) A^A = 0
	  // 7) A^0 = A
	  // 8) A&B = B&A : Same
	  // 9) A|N = B|A : Same
	  // 10) A^B = B^A : Same
	  // 8,9,10--->These are Cummutative Property
	  
	  // XOR Calculations
	  // 1) a^b^a^d^b= a^a^b^b^d=0^0^d=d
	  System.out.println(1^3^5^3^2^1^5);
	  
	  // Given Array Every Elemnt Repeats Twice Except 1, Return Unique Element
	  int ar[]= {1,3,5,3,2,1,5};
	  int ans=unique(ar);
	  System.out.println("Duplicate Ele---> "+ans);
	  
	  // Left Shift << It will Move Bit's to Left Side
	  // Obs : a<<n= 2n*a
	  // eg  : 1<<n= 2n*1=2n
	  // eg  : 5<<3= 2(3)*5=8*5=40
	  
	  
	  // Right Shift >> It will Move Bit's to Right Side
	  // Obs : a>>n= a/(2n)
	  // Note : If we keep Doing >> a will Become 0
	  
	  // Power of Left Shift
	  // Set: 1 & Unset:0
	  //It will set at ith position as 1
	  //1<<3 : 2(3)=8
	  //1<<2 : 2(2)=4
	  
	  
	  // Left Shift With OR (<< with |)
	  // Obs : N | (1<<i) : At ith : If it's Already Set remains Set
	  // 						   : If it's Unset it become Set.
	  
	  //Q) Given N,i : Make ith Bit of N as Set, If already Set Leave it
	  //Set ith Bit
	  //N=N|(1<<i)
	  
	  
	  // Left Shit With XOR (<< with ^)
	  // Toggle ith Bit
	  // Obs : N=N^(1<<i) : If ith Bit in N is Set,It will Unset
	  //					If ith Bit in N is Unset,It will Set
	  
	  //Q) Given N&i, Check if ith Bit in N is Set=1 or Not=0
	  int N=45,i=3;
	  boolean ans1=checkBit(N,i);
	  System.out.println(ans1);
	  
	  //Q) Given N, Return Count of Set Bits in N
	  // Idea-1 : For Every Bit in N :
	  						//	Check if it's Set or Not
	  int n=21;
	  int ans2=countSet1(n);
	  System.out.println(ans2);
	  // Idea-2 : Shift N>>1 & Check 0th Bit is Set or Not
	  int ans3=countSet2(n);
	  System.out.println(ans3);
	  
	  //Q) Given N&i, Unset ith Bit of Number N, if it's a Set
	  int ans4=unset(n,2);
	  System.out.println(ans4);
	}

	private static int unset(int n, int i) 
	{
		 if(((n>>i)&1)==1)
		 {
			 n=n^(1<<i);
		 }
		 return n;
	}

	private static int countSet2(int n) //O(logN)
	{
		 int c=0;
		 while(n>0)
		 {
			 if((n&1)==1)
			 {
				c++; 
			 }
			 n=n>>1;//N=N/2-->After Update Equate to N
		 }
		 return c;
	}

	private static int countSet1(int n) //O(N)
	{
		 int c=0;
		 for(int i=0;i<=31;i++)
		 {
			 if(((n>>i)&1)==1)
			 {
				 c++;
			 }
			
		 }
		 return c;
	}

	private static boolean checkBit(int n, int i) 
	{
		 return ((n>>i)&1)==1;
	}

	private static int unique(int[] ar) 
	{
		int ans=0;
		for(int i=0;i<ar.length;i++)
		{
			ans=ans^ar[i];
		}
		return ans;
	}

}
