package P7_LinkedList1;

public class P1_CloneLinkedList 
{

	public static void main(String[] args) 
	{
		Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);

        n1.next = n2;
        n2.next = n3;

        n1.rand = n3; // 10 → 30
        n2.rand= n1; // 20 → 10
        n3.rand = n2; // 30 → 20

        System.out.println("Original List:");
        System.out.println(n1);
        printList(n1);

        Node clonedHead = cloneList(n1);

        System.out.println("\nCloned List:");
        System.out.println(clonedHead);
        printList(clonedHead);
	}

	private static Node cloneList(Node h) 
	{
		// Between t & t.next create and insert node
		 Node t=h;
		 while(t!=null)
		 {
			 Node nn=new Node(t.data);
			 nn.next=t.next;
			 t.next=nn;
			 t=nn.next;
		 }
		 // Arrange Rand Links in Copy Links
		 Node t1=h,t2=h.next;
		 while(t1!=null)
		 {
			 if(t1.rand!=null)
			 {
				 t2.rand=t1.rand.next; 
			 }
			 t1=t2.next;
			 if(t1!=null)
			 {
				 t2=t1.next;
			 }
		 }
		 //Setting next in Original & Copy Linked List
		 Node T1=h;
		 Node T2=h.next;
		 Node ch=T2;
		 while(T1!=null)
		 {
			 T1.next=T2.next;
			 T1=T1.next;
			 if(T1!=null)
			 {
				 T2.next=T1.next;
			 }
			 T2=T2.next;
		 }
		 return ch;
		 
	}

	private static void printList(Node n1) 
	{
		Node t=n1;
		while(t!=null)
		{
			System.out.print(t.data+" ");
			t=t.next;
		}
	}

}
