package T1_Trees1;

public class Main 
{

	public static void main(String[] args) 
	{
		 Node r=new Node(14);
		 r.left=new Node(18);
		 r.right=new Node(19);
		 r.left.left=new Node(7);
		 r.left.right=new Node(3);
		 r.left.left.left=new Node(10);
		 r.left.right.left=new Node(11);
		 r.right.left=new Node(12);
		 r.right.right=new Node(8);
		 System.out.println("Tree Travesral------>");
		 System.out.println("Pre-Order Traversal----->DLR");
		 preOrder(r);
		 System.out.println();
		 System.out.println("In-Order Traversal------>LDR");
		 inOrder(r);
		 System.out.println();
		 System.out.println("Post-Order Traversal---->LRD");
		 postOrder(r);
		 System.out.println();
		 System.out.println("Given a Root Node Return Size--->");
		 int ans=size(r);
		 System.out.println(ans);
		 System.out.println("Given a Root Node Return Sum of Nodes---->");
		 int summ=sum(r);
		 System.out.println(summ);
		 System.out.println("Given BT & Target---> Check if There Exist a Subtree with sum=target");
		 boolean anss=solve(r,14);
		 System.out.println(anss);
		 
		 
	}
	public static boolean isPossible;
	private static boolean solve(Node r, int tar) 
	{
		 isPossible=false;
		 sumNodes(r,tar);
		 return isPossible;	 
	}

	private static int sumNodes(Node r, int tar) 
	{
		 if(r==null)
		 {
			 return 0;
		 }
		 int ll=sumNodes(r.left,tar);
		 int rr=sumNodes(r.right,tar);
		 if(ll+rr+r.data==tar)
		 {
			 isPossible=true;
		 }
		 return ll+rr+r.data;		 
	}

	private static int sum(Node r) 
	{
		if(r==null)
		{
			return 0;
		}
		 int le=sum(r.left);
		 int ri=sum(r.right);
		 
		 return le+ri+r.data;
	}

	private static int size(Node r) 
	{
		if(r==null)
		{
			return 0;
		}
		 int le=size(r.left);
		 int ri=size(r.right);
		return le+ri+1;
	}

	private static void postOrder(Node r) 
	{
		if(r==null)
		{
			return;
		}
		 postOrder(r.left);
		 postOrder(r.right);
		 System.out.print(r.data+" ");
	}

	private static void inOrder(Node r) 
	{
		if(r==null)
		{
			return;
		}
		 inOrder(r.left);
		 System.out.print(r.data+" ");
		 inOrder(r.right);
		 
	}

	private static void preOrder(Node r) 
	{
		if(r==null)
		{
			return;
		}
		 
		 System.out.print(r.data+" ");
		 preOrder(r.left);
		 preOrder(r.right);
	}

}
