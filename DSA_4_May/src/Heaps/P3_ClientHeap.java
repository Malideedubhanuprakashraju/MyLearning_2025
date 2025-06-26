package Heaps;

import java.util.ArrayList;
import java.util.List;

public class P3_ClientHeap {

	public static void main(String[] args) 
	{
		P2_HeapImplementation h=new P2_HeapImplementation();
		h.insert(10);
		h.insert(4);
		h.insert(2);
		h.insert(4);
        h.insert(15);
        h.insert(1);
        
        System.out.println(h.ssize());
        System.out.println("Min: " + h.getMin()); // 1
        h.delete();
        System.out.println("New Min: " + h.getMin()); // 4
        
       ArrayList<Integer> ar1=new ArrayList<>(List.of(6,2,8,10,14,3,9,2,7,20,1,-3));
        
        h.ar = ar1;
        h.heapify(h.ar);
        System.out.println(h.ar);        // should be a valid min-heap
        System.out.println(h.ssize());   
	}

}
//-3, 1, 3, 2, 2, 6, 9, 10, 7, 20, 14, 8]
 
