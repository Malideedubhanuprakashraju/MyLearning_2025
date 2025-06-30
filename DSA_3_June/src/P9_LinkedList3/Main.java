package P9_LinkedList3;

public class Main 
{

	public static void main(String[] args) 
	{
		Node h=new Node(10);
		Node t=h;
		t.next=new Node(20);
		t.next.prev=t;
		t=t.next;
		t.next=new Node(30);
		t.next.prev=t;
		t=t.next;
		t.next=new Node(40);
		t.next.prev=t;
		t=t.next;
		t.next=new Node(60);
		t.next.prev=t;
		t=t.next;
		System.out.println(t.prev.data);
		print(h);
		System.out.println();
		System.out.println("Insert New Node Just Before Trail in DLL----->");
		insertBeforeTail(new Node(50),t);
		print(h);
		System.out.println();
		System.out.println("Delete a Given Node from DLL----->");
		deleteNode(t.prev.prev.prev);
		print(h);
		System.out.println();
		System.out.println("Given head node of LL,Check if Palindrome or Not");
		Node head = new Node(10);
        Node t1=head;
        t1.next=new Node(20);
        t1=t1.next;
        t1.next=new Node(30);
        t1=t1.next;
        t1.next=new Node(20);
        t1=t1.next;
        t1.next=new Node(10);
        t1=t1.next;
        
        
        boolean ans=isPalindrom(head);
        System.out.println(ans);
	}

	private static boolean isPalindrom(Node head) 
	{
		 Node M=mid(head);
		 Node h2=M.next;
		 M.next=null;
		 h2=reverse(h2);
		 while(head!=null && h2!=null)
		 {
			 if(head.data==h2.data)
			 {
				 head=head.next;
				 h2=h2.next;
			 }
			 else
			 {
				 return false;
			 }
		 }
		 return true;
		 
	}

	private static Node reverse(Node h) 
	{
		 
		 Node rh=null;
		 while(h!=null)
		 {
			 
			 Node t=h;
			 h=h.next;
			 t.next=rh;
			 rh=t;
			 
		 }
		 return rh;
	}

	private static Node mid(Node head) 
	{
		 Node s=head,f=head;
		 while(f.next!=null && f.next.next!=null)
		 {
			 s=s.next;
			 f=f.next.next;
		 }
		 return s;
	}

	private static void deleteNode(Node temp) 
	{
		Node t1=temp.prev;
		Node t2=temp.next;
		t1.next=t2;
		t2.prev=t1;
		temp.next=null;
		temp.prev=null;
	}

	private static void insertBeforeTail(Node node, Node tail) 
	{
		Node temp=tail.prev;
		tail.prev=node;
		temp.next=node;
		node.next=tail;
		node.prev=temp;
	}

	private static void print(Node h) 
	{
		Node t=h;
		while(t!=null)
		{
			System.out.print(t.data+" ");
			t=t.next;
		}
	}

}
