package P6_LinkedList;

public class Main 
{

	public static void main(String[] args) 
	{
		 Node h=new Node(10);
		 System.out.println(h);
		 System.out.println(h.data);
		 System.out.println(h.next);
		 System.out.println("----->");
		 Node t=h;
		 System.out.println(t);
		 System.out.println(t.data);
		 System.out.println(t.next);
		 
		 t.next=new Node(20);
		 t=t.next;
		 System.out.println(t);
		 System.out.println(t.data);
		 System.out.println(t.next);
		 t.next=new Node(30);
		 t=t.next;
		 t.next=new Node(40);
		 t=t.next;
		 t.next=new Node(50);
		 t=t.next;
		 System.out.println("Given Head Node return Size of Linked List");
		 int ans=size(h);
		 System.out.println(ans);
		 int ans1=size1(h);
		 System.out.println("Not Recommended----->"+ans1);
		 System.out.println();
		 System.out.println("Search for a Node----->Given Head_LinkedList");
		 boolean s=search(h,30);
		 System.out.println(s);
		 System.out.println();
		 System.out.println("Insert in a LinkedList----->Index=0-->Given B & C create Node with B and insert at index C");
		 int B=10,C=9;
		 Node h1=insert(h,B,C);
		 System.out.println("Printing Linked List---->");
		 print(h);
		 System.out.println();
		 System.out.println("Given Head Node of Linked List & B----> Delete Node at index B");
		 Node h2=delete(h1,2);
		 print(h2);
		 System.out.println();
		 System.out.println("Reverse of a LinkedlIst---->");
		 Node h3=reverse(h);
		 print(h3);
		 print(h1);
		 System.out.println();
		 print(h);
		 System.out.println();
		 System.out.println("Delete All Occureneces of X:----->");
		 Node h4=deleteAll(h3,10);
		 print(h4);
		 
		 
	}

	private static Node deleteAll(Node h1, int k) 
	{
		if(h1==null)
		{
			return h1;
		}
		Node t=deleteAll(h1.next,k);
		if(h1.data==k)
		{
			return t;
		}
		else
		{
			h1.next=t;
			return h1;
		}
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

	private static Node delete(Node h1, int B) 
	{
		  if(h1==null)
		  {
			  return h1;
		  }
		  if(B==0)
		  {
			  h1=h1.next;
			  return h1;
		  }
		  Node t=h1;
		  for(int i=0;i<B-1;i++)
		  {
			  t=t.next;
		  }
		  t.next=t.next.next;
		  return h1;
	}

	private static void print(Node h1) 
	{
		 Node t=h1;
		 while(t!=null)
		 {
			 System.out.print(t.data+" ");
			 t=t.next;
		 }
	}

	private static Node insert(Node h, int b, int c) 
	{
		 Node t=h;
		 Node nn=new Node(b);
		 if(c==0 || h==null)
		 {
			nn.next=h;
			h=nn;
			return h;
		 }
		 
		 for(int i=0;i<c-1;i++)
		 {
			 if(t.next==null)
			 {
				 break;
			 }
			 t=t.next;
		 }
		 nn.next=t.next;
		 t.next=nn;
		 
		 return h;
	}

	private static boolean search(Node h, int x) 
	{
		 Node t=h;
		 while(t!=null)
		 {
			 if(t.data==x)
			 {
				 System.out.println(t);
				return true;
			 }
			 t=t.next;
			 
		 }
		 return false;
	}

	private static int size1(Node h) 
	{
		 int c=1;
		 Node t=h;
		 while(t.next!=null)
		 {
			 c++;
			 t=t.next;
		 }
		 return c;
	}

	private static int size(Node h) 
	{
		 Node t=h;
		 int c=0;
		 while(t!=null)
		 {
			 c=c+1;
			 t=t.next;
		 }
		 return c;
	}

}
