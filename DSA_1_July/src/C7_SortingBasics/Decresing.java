package C7_SortingBasics;

import java.util.Comparator;

public class Decresing implements Comparator<Integer>{

	@Override
	public int compare(Integer a, Integer b) 
	{
		if(a > b)
		{
			return -1;
		}
		else if(a < b)
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
	}

}
