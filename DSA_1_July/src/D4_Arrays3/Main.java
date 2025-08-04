package D4_Arrays3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main 
{

	public static void main(String[] args) 
	{
		//Given Collection of Intervals in a @D Array Format,Which are Sorted-Based on Their Start Time
		//Merge All Overlapping intervals & Return Set of Non-Overlapping Intervals
		//Non Overlapping Case :
		//Given 2 Intervals(s1,e1)(s2,e2) & S2 comes After S1
		//When we say they are not overlapping
		//S1......e1..S2.....e2
		//If S2>e1 : Not Overlapping
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(0, 2)));
        list.add(new ArrayList<>(Arrays.asList(1, 4)));
        list.add(new ArrayList<>(Arrays.asList(5, 6)));
        list.add(new ArrayList<>(Arrays.asList(6, 8)));
        list.add(new ArrayList<>(Arrays.asList(7, 10)));
        list.add(new ArrayList<>(Arrays.asList(8, 9)));
        list.add(new ArrayList<>(Arrays.asList(12, 14)));
		ArrayList<ArrayList<Integer>> ans=mergeAll(list);
		System.out.println(ans);
		//First Missing Natural/Positive Number
		//Given Array -->Print First +ve Number Not in Array
		int ar[]= {4,2,1,3};
		//Idea-1 : For Every Element from 1...N,Iterate on Array & Search if it's there or not
		//T.C=O(N2)
		//Idea-2 : Sort Array in Incresing Order : By Iteration We can tell First Missing Number
		//T.C=O(NlogN+N)=O(logN)
		//index  {0,1,2,3,4}--->i Correct Data i+1
		//Element{1,2,3,4,5}--->x correct in x-1
		//Idea-3 :
		int ans1=FirstMissing(ar);
		System.out.println(ans1);
		
		
	}

	private static int FirstMissing(int[] ar)//T.C=At Max N Swaps:-->Total Loop=N+N iterations
	{
		 int n=ar.length;
		 for(int i=0;i<n;i++)//Bring Ele to Correct Position
		 {
			while(ar[i]!=i+1)//Till Incorrect Keep Swapping
			{
				int ele=ar[i];
				int ind=ele-1;
				if(ind<0 && ind>=n)//To avoid out of bounds
				{
					break;
				}
				if(ar[i]==ar[ind])//To avoid infinity loops
				{
					break;
				}
				int temp=ar[i];// Swap ar[i] & ar[ind]
				ar[i]=ar[ind];// Until Element Will Come to it's Correct Position
				ar[ind]=temp;
			}
		 }
		 for(int i=0;i<n;i++)
		 {
			 if(ar[i]!=i+1)//Incorrect Data
			 {
				 return i+1;
			 }
		 }
		 return n+1;
	}

	private static ArrayList<ArrayList<Integer>> mergeAll(ArrayList<ArrayList<Integer>> interval)//T.C=O(N) 
	{
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		int cs=interval.get(0).get(0);
		int ce=interval.get(0).get(1);
		int n=interval.size();
		for(int i=1;i<n;i++)
		{
			int ns=interval.get(i).get(0);
			int ne=interval.get(i).get(1);
			if(ns>ce)
			{
				ArrayList<Integer> temp=new ArrayList<>();
				temp.add(cs);
				temp.add(ce);
				ans.add(temp);
				cs=ns;
				ce=ne;
			}
			else
			{
				cs=Math.min(cs,ns);
				ce=Math.max(ce, ne);
			}
		}
		ArrayList<Integer> temp=new ArrayList<>();
		temp.add(cs);
		temp.add(ce);
		ans.add(temp);
		
		return ans;
	}

}
