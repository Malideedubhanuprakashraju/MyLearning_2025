package P8_LinkedList2;

public class MergeTwoSortedLists 
{

	public static void main(String[] args) 
	{		//First Sorted List
		    Node headA = new Node(2);
	        headA.next = new Node(5);
	        headA.next.next = new Node(8);
	        headA.next.next.next = new Node(12);
	        headA.next.next.next.next = new Node(16);
	        
	        //Second Sorted List
	        Node headB = new Node(3);
	        headB.next = new Node(6);
	        headB.next.next = new Node(9);
	        headB.next.next.next = new Node(14);
	        headB.next.next.next.next = new Node(18);
	        System.out.println("Merging of Two Sorted Linked List----->");
	        Node f=merge(headA,headB);
	        print(f);
	        System.out.println();
	        System.out.println("Given Head,Sort Linked List------>");
	        Node A =  new Node(16);
	        A.next = new Node(12);
	        A.next.next = new Node(8);
	        A.next.next.next = new Node(5);
	        A.next.next.next.next = new Node(2);
	        print(A);
	        System.out.println();
	        Node sortt=Sort(A);
	        print(sortt);
	        
	        

	}

	private static Node Sort(Node a) 
	{
		if(a==null)
		{
			return a;
		}
		if(a.next==null)
		{
			return a;
		}
		Node m=mid(a);
		Node b=m.next;
		m.next=null;
		
		Node l=Sort(a);
		Node r=Sort(b);
		return merge(l,r);
	}

	private static Node mid(Node a) 
	{
		if(a==null)
		{
			return a;
		}
		 Node s=a;
		 Node f=a;
		 //Node prev=null;
		 while(f.next!=null && f.next.next!=null)
		 {
			// prev=s;
			 s=s.next;
			 f=f.next.next;
		 }
		 return s;
	}

	private static void print(Node f) 
	{
		Node t=f;
		while(t!=null)
		{
			System.out.print(t.data+" ");
			t=t.next;
		}
		
	}

	private static Node merge(Node headA, Node headB) 
	{
		 if(headA==null)
		 {
			 return headB;
		 }
		 if(headB==null)
		 {
			 return headA;
		 }
		 Node h=null,t=null;
		 if(headA.data<headB.data)
		 {
			 h=headA;
			 t=headA;
			 headA=headA.next;
		 }
		 else
		 {
			 h=headB;
			 t=headB;
			 headB=headB.next;
		 }
		 while(headA!=null && headB!=null)
		 {
			 if(headA.data<headB.data)
			 {
				 t.next=headA;
				 t=headA;
				 headA=headA.next;
			 }
			 else
			 {
				 t.next=headB;
				 t=headB;
				 headB=headB.next;
			 }
		 }
		 if(headA!=null)
		 {
			 t.next=headA;
		 }
		 else if(headB!=null)
		 {
			 t.next=headB;
		 }
		  
			 return h;
		 
		 
		 
	}

}
