package P8_LinkedList2;
class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data=d;
		next=null;
	}
}
public class Main {

	public static void main(String[] args) 
	{
		 Node h=new Node(1);
		 Node t=h;
		 t.next=new Node(2);
		 t=t.next;
		 t.next=new Node(3);
		 t=t.next;
		 t.next=new Node(4);
		 t=t.next;
		 t.next=new Node(5);
		 t=t.next;
		 t.next=new Node(6);
		 t=t.next;
		 t.next=new Node(7);
		 t=t.next;
		 //System.out.println(h.data);
		 
		 System.out.println("Given Head Node find mid of LinkedList---->");
		 Node mid=mid(h);
		 System.out.println(mid.data);
		 	 	  
	}

	private static Node mid(Node h) 
	{
		if(h==null)
		{
			return h;
		}
		 Node s=h;
		 Node f=h;
		 while(f!=null && f.next!=null)
		 {
			 s=s.next;
			 f=f.next.next;
		 }
		 return s;
	}

}
