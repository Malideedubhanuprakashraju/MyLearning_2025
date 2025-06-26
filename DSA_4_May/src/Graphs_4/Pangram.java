package Graphs_4;

import java.util.HashSet;

public class Pangram {

	public static void main(String[] args) 
	{
		String[] str = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        int result = isPangram(str);
        System.out.println(result);
	}

	private static int isPangram(String[] A) 
	{
		 int n=A.length;
		 HashSet<Character> hs=new HashSet<>();
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<A[i].length();j++)
			 {
				 hs.add(Character.toLowerCase(A[i].charAt(j)));
				  
			 }
		 }
		 if(hs.size()==26)
		 {
			 return 1;
		 }
		 
		 return 0;
	}

}
