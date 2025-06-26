package P5_Backtracking2;

import java.util.ArrayList;

public class AllWaysNthStep 
{

	public static void main(String[] args) 
	{
		int n=3;
		allPaths(n);
	}

	private static void allPaths(int n) 
	{
		ArrayList<Integer> li=new ArrayList<>();
		allPathsTracking(0,n,li);
		//System.out.println(li);
	}

	private static void allPathsTracking(int i, int n, ArrayList<Integer> li)
	{
		if(i==n)
		{
			System.out.println(li);
			return;
		}
		
		li.add(1);
		allPathsTracking(i+1,n,li);
		int s=li.size();
		li.remove(s-1);
		if(i+2<=n)
		{
		   li.add(2);
		   allPathsTracking(i+2,n,li);
		   li.remove(li.size()-1);
		}
		return;
	}

}
