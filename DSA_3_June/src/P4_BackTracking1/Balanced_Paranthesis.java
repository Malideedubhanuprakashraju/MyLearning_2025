package P4_BackTracking1;

public class Balanced_Paranthesis 
{

	public static void main(String[] args) 
	{
		 String s="";
		 printAll(s,0,0,3);
	}

	private static void printAll(String s, int co, int cc, int n) 
	{
		if(co+cc==2*n)
		{
			System.out.println(s);
			return;
		}
		if(co<n)
		{
			printAll(s+"(",co+1,cc,n);
		}
		if(co>cc)
		{
			printAll(s+")",co,cc+1,n);
		}
		return;
	}

}
