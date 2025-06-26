package Graph_3;

import java.util.Comparator;

import GreedyPrograms.pair;

public class sortown implements Comparator<pair>
{

	@Override
	public int compare(pair o1, pair o2) 
	{
		 return o1.a-o2.a;
	}

}
