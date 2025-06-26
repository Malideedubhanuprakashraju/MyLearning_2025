package DynamicProgramming_1;

public class P4_minNotes 
{
	static int amt[]= {50,20,5};

	public static void main(String[] args) 
	{
		int n=65;// 90
//		int ans=minNotes(n);
//		System.out.println(ans);
		
		System.out.println("Dynamic Min Notes---->");
		int dp[]=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			dp[i]=-1;
		}
		int ans2=minNotesD(n,dp);
		System.out.println(ans2);
		
	}

	private static int minNotesD(int n, int[] dp) 
	{
		 if(n==0)
		 {
			 return 0;
		 }
		 int notes=Integer.MAX_VALUE;
		 if(dp[n]==-1)
		 {
			 for(int i=0;i<amt.length;i++)
			 {
				 if(n>=amt[i])
				 {
					 int res=minNotesD(n-amt[i],dp);
					 
					 if(res!=Integer.MAX_VALUE)
					 {
						 notes=Math.min(notes,res+1);
					 }
				 }
				 
			 }
			 
		 }
		 dp[n]=notes;
		 return dp[n];
	}

	private static int minNotes(int n) 
	{
		 if(n==0)
		 {
			 return 0;
		 }
		 int notes=Integer.MAX_VALUE;
		 for(int i=0;i<3;i++)
		 {
			 if(n>=amt[i])
			 {
				 notes=Math.min(minNotes(n-amt[i]),notes);
			 }
		 }
		 if(notes==Integer.MAX_VALUE)
		 {
			 return Integer.MAX_VALUE;
		 }
		 else
		 {
			 return notes+1;
		 }
	}

}
