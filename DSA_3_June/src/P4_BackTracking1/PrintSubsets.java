package P4_BackTracking1;

import java.util.ArrayList;

public class PrintSubsets 
{
	static ArrayList<ArrayList<Integer>> ans;

	public static void main(String[] args) 
	{
		int a[]= {5,7,2};
		solve(a);
	}

	private static void solve(int[] ar) 
	{
		 ans=new ArrayList<>();
		 ArrayList<Integer> subset=new ArrayList<>();
		 generateSub(subset,ar,0,ar.length);
		    System.out.println("All subsets:");
	        for (ArrayList<Integer> sub : ans) {
	            System.out.println(sub);
	        }
	}

	private static void generateSub(ArrayList<Integer> subset, int[] ar, int i, int n)
	{
		if(i==n)
		{
			ArrayList<Integer> cp=new ArrayList<>(subset);
			ans.add(cp);
			return;
		}
		subset.add(ar[i]);
		generateSub(subset,ar,i+1,n);
		int s=subset.size();
		subset.remove(s-1);
		generateSub(subset,ar,i+1,n);
		return;
	}

}
