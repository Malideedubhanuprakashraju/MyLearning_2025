package D9_ModulerArithematic_GCD;

public class Main 
{

	public static void main(String[] args) 
	{
		//Modular Arithmetic Introduction 
		//x%4={0,1,2,3}
		//x%5={0,1,2,3,4}
		//Range=[0.....M-1]
		//Why do we need % : It can Limit Your Output
		//Rules for % Arithmetic :
		//1) (a+b)%m=(a%m+b%m)%m
		//2) (a*b)%m=(a%m*b%m)%m
		//3) (a+m)%m=(a%m+m%m)%m
		//			=(a%m+0)%m
		//			=(a%m)%m-->a%m
		//3) (a+m)%m=a%m
		//4) (a-b)%m=(a%m-b%m+m)%m
		//5) (a2)%m=(a*a)%m= (a%m * a%m)%m= (a%m)(b)%m
		
		//Q) Given Array Find Count of Pairs Such That (ar[i]+ar[j])%m=0
		//Note i!=j and Pair(i,j) same as Pair(j,i)
		int ar[]= {4,3,6,3,8,12};
		int M=6;
		int ans=pairs(ar,M);
		System.out.println(ans);
		
		//GCD=Gretest Common Devider
		//GCD(A,B)=HCF(A,B)
		
		//Property :
		//1) GCD(A,B)=GCD(B,A)
		//2) GCD(0,A)=A
		//3) GCD(A,B,C)=GCD(GCD(A,B),C)
		//				GCD(GCD(B,C),A)
		//				GCD(GCD(A,C),B)
		//Note : When more than 2 numbers are there, Take gcd for 2numbers at once
		//4) GCD(A,B)=GCD(A-B,B)
		//5) GCD(A,B)=GCD(A%B,B)-->Issue With Above Relation
		//						-->We Can do it with Recursion
		//						-->Recusrion Stops : if A<B
		//Optimi :GCD(A,B)=GCD(B,A%B)
		
		
		//Q) Given A,B Calculate GCD(A,B)
		int ans1=gcd(24,10);
		System.out.println(ans1);
		
		//Given Array Calculate GCD of Array
		int arr[]= {12,24,6,15};
		int ans2=gcdArr(arr);
		System.out.println(ans2);
	}

	private static int gcdArr(int[] arr) //T.C= O(n*log(max-no)), S.C=log(Max_No)
	{
		 int n=arr.length;
		 int ans=arr[0];
		 for(int i=1;i<n;i++)
		 {
			 ans=gcd(ans,arr[i]);
		 }
		 return ans;
	}

	private static int gcd(int A, int B) //TC=O(log(max(A,B))) same as S.C also	
	{
		 if(B==0)
		 {
			 return A;
		 }
		 return gcd(B,A%B);
	}

	private static int pairs(int[] ar, int m)//T.C=O(N), S.C=O(M) 
	{
		 int n=ar.length;
		 for(int i=0;i<n;i++)//Convert all numbers to Their remainders mod m
		 {
			 ar[i]=ar[i]%m;
		 }
		 int cnt[]=new int[m];//Create a frequnecy array for remainders
		 int ans=0;//Count vaild pairs
		 for(int i=0;i<n;i++)
		 {
			 int k=ar[i];//current Remainder
			 int target=m-k;//Remainder we need for(CurrentRemainder + neededRemainder)%m==0
			 
			 if(k==0)
			 {
				 target=0;
			 }
			 ans=ans+cnt[target];
			 cnt[ar[i]]++;
		 }
		 return ans;
	}

}
