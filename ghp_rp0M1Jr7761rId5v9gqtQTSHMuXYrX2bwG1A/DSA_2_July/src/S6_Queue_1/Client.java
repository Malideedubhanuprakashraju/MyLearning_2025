package S6_Queue_1;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Client 
{

	public static void main(String[] args) 
	{
		 System.out.println("Queue Data Structure---> FIFO");
		 Queue<Integer> q=new LinkedList<>();
		 q.add(10);
		 q.add(20);
		 q.add(30);
		 q.add(40);
		 q.add(50);
		 System.out.println(q);
		 int del=q.poll();
		 System.out.println(del);
		 System.out.println(q.poll());
		 System.out.println(q);
		 int peek=q.peek();
		 System.out.println(peek);
		 System.out.println(q.size());
	}

}
