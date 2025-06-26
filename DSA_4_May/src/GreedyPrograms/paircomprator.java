package GreedyPrograms;

import java.util.Comparator;

public class paircomprator implements Comparator<pair> 
{
    @Override
    public int compare(pair o1, pair o2) {
        return Integer.compare(o1.d, o2.a);  // sort by end time (ascending) or 
    }
}
