package C4_PrefixSum;

public class Main 
{

	public static void main(String[] args) 
	{
		 System.out.println("Given Array & s,e calculate sum of all elements from s-->e");
		 int ar[]= {3,4,6,8,9,10,2,7,4,10};
		 int ans=sum(ar,2,7);
		 System.out.println(ans);
		 System.out.println("Given Array Elements & Q-queries with s,e for Every Query Calculate Sum of elements from[s...e]-->TC=O(Q*N),SC=O(1)");
		 int ar1[]= {-3,6,2,4,5,2,8,-9,3,1};
		 int Q[][]= {{4,8},{3,7},{1,3},{7,7},{3,6},{0,4}};
		 int ans1[]=RangeSum(ar1,Q);
		 for(int x:ans1)
		 {
			 System.out.print(x+" ");
		 }
		 System.out.println();
		 System.out.println("Total Runs SCored in ith-jth over :Total[j]-Total[i-1]");
		 System.out.println("Cumulative Sum-->");
		 //Cumulative: Data, from Start=Prefix data {from 0th index}
		 //Cumulative: Data, from end=suffix data {from n-1th index}
		 //Way-1 :Given Array Construct Prfix Sum Array-->O(N)
		 int ar2[]= {3,-2,4,5,6};
		 int psum[]=psum(ar2);
		 for(int x:psum)
		 {
			 System.out.print(x+" ");
		 }
		 System.out.println();
		 //Way-2 :Based on psum[i]=psum[i-1]+A[i](Prefix Sum)--->O(N)
		 int psum2[]=psum2(ar2);
		 for(int x:psum2)
		 {
			 System.out.print(x+" ");
		 }
		 System.out.println();
		 //Range Sum Using-->Prefix Array
		 int ans2[]=RangeSum2(ar1,Q);
		 for(int x:ans2)
		 {
			 System.out.print(x+" ");
		 }
		 System.out.println("TC=O(N+Q),SC=O(N)--->Prefix Sum Using-->");
		 //Given Array , Q-Queries with S,E For Every Query Calculate Sum of Even index Elemenst from range[s..e]
		 int ar3[]= {2,4,3,7,9,8,6,3,4,9};
		 int mat[][]= {{4,8},{3,9},{2,7},{0,4}};
		 // Use Prefix Sum 
		 int ans3[]=EvenIndexSum(ar3,mat);
		 for(int x:ans3)
		 {
			 System.out.print(x+" ");
		 }
		 //if(i%2==1)psum--->Gives Sum of Odd Index Elemnts In Range
		 //Equilibrium Index
		 //Given Array Elemnts, Count no of Equilibrium Index
		 //Equilibrum index= Sum of all ements on left of ith index= Sum of all elementrs on right of ith index
		 //For Evry i :
		 //Iterate & Calculating sum of left & right is Taking Time
		 //0,1,2,.......i-1,i,i+1,i+2......N-1
		 //sum[0,i-1]==sum[i+1,n-1];
		 //It Can be Optimized with Prefix Sum
		 //Lsum=sum[0...i-1],Rsum=sum[i+1,n-1]
		 //Lsum=psum[i-1],Rsum=psum[n-1]-psum[i]
		 System.out.println();
		 int ar4[]={-7,1,5,2,-4,3,0};
		 int ans4=equlibrium(ar4);
		 System.out.println("TC=O(N+N),SC=O(N)----->"+ans4);
		 //It Can be Done by Without Extra Space--->CarryForward
		 //Given Array--> Count Number of Special Index in The Array
		 //Special Index are Those After Removing That Index
		 //Sum of all Even Indices = Sum of all Odd Indices
		 int ar5[]= {4,3,2,7,6,-2};
		 		   //0,1...i-1,i,i+1,i+2.....n-1
		 //SumE in Del[]=SumE..Ar[0,i-1]+SumO..Ar[i+1,n-1]
		 //SumO in Del[]=SumO..Ar[0,i-1]+SumE..Ar[i+1,n-1]
		 int ans5=SpecialIndex(ar5);
		 System.out.println("Special Indices---->are="+ans5);
	}

	private static int SpecialIndex(int[] ar) 
	{
		int n=ar.length;
		int c=0;
		int peven[]=new int[n];
		int sum=0;
		for(int i=0;i<n;i++)//Create peven[]
		{
			if(i%2==0)
			{
				sum=sum+ar[i];
			}
			peven[i]=sum;
		}
		int podd[]=new int[n];
		int sum1=0;
		for(int i=0;i<n;i++)//Create podd[]
		{
			if(i%2==1)
			{
				sum1=sum1+ar[i];
			}
			podd[i]=sum1;
		}
		for(int i=0;i<n;i++)//Check it's Special
		{
			int leven=0,lodd=0,reven=0,rodd=0;
			if(i!=0)
			{
				leven=peven[i-1];
			}
			reven=peven[n-1]-peven[i];
			if(i!=0)
			{
				lodd=podd[i-1];
			}
			rodd=podd[n-1]-podd[i];
			if(leven+rodd==reven+lodd)
			{
				c++;
			}
		}
		return c;
	}

	private static int equlibrium(int[] ar) 
	{
		 int n=ar.length;
		 int psum[]=new int[n];
		 int sum=0,c=0;
		 for(int i=0;i<n;i++)
		 {
			 sum=sum+ar[i];
			 psum[i]=sum;
		 }
		 for(int i=0;i<n;i++)
		 {
			 int lsum=0,rsum=0;
			 if(i!=0)//if i==0 :psum[-1]*Error
			 {
				 lsum=psum[i-1];
			 }
			 rsum=psum[n-1]-psum[i];
			 if(lsum==rsum)
			 {
				 c++;
			 }
		 }
		 return c;
	}

	private static int[] EvenIndexSum(int[] ar3, int[][] mat) 
	{
		int n=ar3.length;
		 int nq=mat.length;
		 // Create psum-->N iter
		 int psum[]=new int[n];
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {
			 if(i%2==0)
			 {
				 sum=sum+ar3[i]; 
			 }
			 psum[i]=sum;		
		 }
		 // Ans Each Query Using Psum[]-->Q iterations
		 int ans[]=new int[nq];
		 for(int i=0;i<nq;i++)
		 {
			 int s=mat[i][0],e=mat[i][1];
			 if(s==0)
			 {
				 ans[i]=psum[e];
			 }
			 else
			 {
				 ans[i]=psum[e]-psum[s-1];
			 }
		 }
		 return ans;
		 
	}

	private static int[] RangeSum2(int[] ar1, int[][] q) 
	{
		 int n=ar1.length;
		 int nq=q.length;
		 // Create psum-->N iter
		 int psum[]=new int[n];
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {
			 sum=sum+ar1[i];
			 psum[i]=sum;		
		 }
		 // Ans Each Query Using Psum[]-->Q iterations
		 int ans[]=new int[nq];
		 for(int i=0;i<nq;i++)
		 {
			 int s=q[i][0],e=q[i][1];
			 if(s==0)
			 {
				 ans[i]=psum[e];
			 }
			 else
			 {
				 ans[i]=psum[e]-psum[s-1];
			 }
		 }
		 return ans;
	}

	private static int[] psum2(int[] ar2) 
	{
		 int n=ar2.length;
		 int psum[]=new int[n];
		 psum[0]=ar2[0];
		 for(int i=1;i<n;i++)
		 {
			 psum[i]=psum[i-1]+ar2[i];
		 }
		 return psum;
	}

	private static int[] psum(int[] ar2) 
	{
		 int n=ar2.length;
		 int sum=0;
		 int pf[]=new int[n];
		 for(int i=0;i<n;i++)
		 {
			 sum=sum+ar2[i];
			 pf[i]=sum;
		 }
		 return pf;
	}

	private static int[] RangeSum(int[] ar, int[][] q) 
	{
		 int n=q.length;
		 int ans[]=new int[n];
		 for(int i=0;i<n;i++)
		 {
			 int s=q[i][0],e=q[i][1];
			 int sum=0;
			 for(int j=s;j<=e;j++)
			 {
				 sum=sum+ar[j];
			 }
			 ans[i]=sum;
		 }
		 return ans;
	}

	private static int sum(int[] ar, int s, int e) 
	{
		 int sum=0;
		 for(int i=s;i<=e;i++)
		 {
			 sum=sum+ar[i];
		 }
		 return sum;
	}

}
