package D2_Arrays1;

public class Main 
{

	public static void main(String[] args) 
	{
		 //Max Subarray Sum
		 //Given Array Return Max Subarray Sum
		 int ar[]= {-2,3,4,-1,5,-10,7};
		 // Way-1 :For All Subarrays iterate & Calculate Sum & get Overall Max
		 //T.C=O(n3)
		 // Way-2 :Create Prefix Sum Array and return MaxSum
		 //T.C=O(N2), S.C=O(N)
		 //Optimization :Kadane's Algorithm : Max Subarray Sum
		 //Case-1 : If All The Elemnts in the array are positive-->Return Sum of All Elements
		 //Case-2 : If All The Elemnets int the array are negative-->Return Max one
		 //Case-3 : If Positives are present Between--->add pos ele
		 //Case-4 : Say we have Max Subarray Sum
		 //Idea : +ve Sum Take it Forward, -ve Sum reset to 0 -->Return Max Element
		 int ans=maxSubkadanes(ar);
		 System.out.println(ans);
		 //Zero Queries 
		 //Given Array -->All Zeros & Q Queries
		 //For Each Query :Given (s,v) Add v to all index elemnts from index{s...N-1}
		 //Once All Queries are Done Return final Array
		 int arr[]= {0,0,0,0,0,0,0};
		 int Q[][]= {{1,3},{4,-2},{3,1}};
		 //Idea-1 : For Every Query(s,v)
		 //Add Value V from index S.....N-1
		 //T.C=O(Q*N), S.C=O(1)
		 //Idea-2 : 
		 // Step1:For Every query(S,V) :Update Array: Ar[s]+=v;
		 // Step2:Calculate Cummulative Sum or psum[]
		 int ans1[]=ZeroQueries(7,Q);
		 for(int x:ans1)
		 {
			 System.out.print(x+" ");
		 }
		 //Zero Queries-2
		 //Given Array Initially All Ele 0 & Q queries
		 //For Each Query : Given(s,e,v) add elemnt v to all indices from{s...e}
		 //Once all queries are done return final Array
		 //Idea-1 : For Every Query From (s,e,v)
		 //Add v to All Elemnts from[S.....e]
		 //T.C=O(Q*N),S.C=O(1)
		 //In Previus : We add v from s to n-1
		 //In Current : We add v from s to e
		 int q[][]= {{1,4,3},{0,5,-1},{2,2,4},{4,6,3}};
		 //Hint :
		 //New Question Query-->Split into two old Question Queries
		 //Adding V from S to N-1 :prev Question :ar[s]+=v
		 //Adding -V from e+1 to N-1 :prev Question :ar[e+1]+=-V
		 int ans2[]=zeroQueries2(7,q);
		 System.out.println();
		 for(int x:ans2)
		 {
			 System.out.print(x+" ");
		 }
		 
		 
		 
	}

	private static int[] zeroQueries2(int n, int[][] que)//T.C=O(Q+N),S.C=O(1) 
	{
		 int ans[]=new int[n];
		 int Q=que.length;
		 for(int i=0;i<Q;i++)
		 {
			 //For each Q :We Have (S,E,V)
			 int s=que[i][0],e=que[i][1],v=que[i][2];
			 ans[s]=ans[s]+v;//update
			 if(e+1<n)
			 {
				 ans[e+1]=ans[e+1]-v;
			 }
			 
		 }
		 int sum=0;
			int psum[]=new int[n];
			for(int i=0;i<n;i++)
			{
				sum=sum+ans[i];
				psum[i]=sum;
			}
			return psum;
	}

	private static int[] ZeroQueries(int n, int[][] q) //T.C=O(Q+N), S.C=O(1)
	{
		int ans[]=new int[n];//Initilized to 0
		int Q=q.length;//Rows=>No.of Queries
		for(int i=0;i<Q;i++)//---->Q
		{
			//For Each Q:we have (s,v)
			int s=q[i][0],v=q[i][1];
			ans[s]=ans[s]+v;
		}
		int sum=0;
		int psum[]=new int[n];
		for(int i=0;i<n;i++)
		{
			sum=sum+ans[i];
			psum[i]=sum;
		}
		return psum;
	}

	private static int maxSubkadanes(int[] ar)//T.C=O(N), S.C=O(1) 
	{
		 int n=ar.length;
		 int sum=0;
		 int ans=Integer.MIN_VALUE;
		 for(int i=0;i<n;i++)
		 {
			 sum=sum+ar[i];
			 if(sum>ans)
			 {
				 ans=sum;
			 }
			 if(sum<0)
			 {
				 sum=0;//Don't Take it Forward
			 }
		 }
		 return ans;
	}

}
