package T3_Trees3;

public class Main 
{

	public static void main(String[] args) 
	{
		 Node r=new Node(4);
		 r.left=new Node(0);
		 r.right=new Node(10);
		 r.left.left=new Node(-1);
		 r.left.right=new Node(3);
		 r.right.left=new Node(7);
		 r.right.right=new Node(15);
		 System.out.println("Search in Binary Search Tree----->");
		 boolean ans=search(r,-3);
		 System.out.println(ans);
		 System.out.println("Insert & Return Root Node------>");
		 Node nr=insert(r,6);
		 print(nr);
		 boolean ans1=search(nr,6);
		 System.out.println();
		 System.out.println(ans1);
		 System.out.println("Find Smallest Element---->");
		 int ans3=small(nr);
		 System.out.println(ans3);
		 int ans4=large(nr);
		 System.out.println(ans4);
		 System.out.println("Delete K in BsT & Return Root Node---->");
		 Node nn=delete(nr,-1);
		 print(nr);
		 
		
	}

	private static Node delete(Node nr, int k) 
	{
		 if(nr==null)
		 {
			 return null;
		 }
		 if(nr.data==k)
		 {
			 if(nr.left==null && nr.right==null)
			 {
				 return null;
			 }
			 if(nr.left==null && nr.right!=null)
			 {
				 return nr.right;
			 }
			 if(nr.left!=null && nr.right==null)
			 {
				 return nr.left;
			 }
			 int max=large(nr.left);
			 nr.data=max;
			 nr.left=delete(nr.left,max);
			 return nr;
		 }
		 if(nr.data>k)
		 {
			 nr.left=delete(nr.left,k);
		 }
		 else
		 {
			 nr.right=delete(nr.right,k);
		 }
		 return nr;
	}

	private static int large(Node nr) 
	{
		 Node t=nr;
		 while(t.right!=null)
		 {
			 t=t.right;
		 }
		 return t.data;
	}

	private static int small(Node nr) 
	{
		 Node t=nr;
		 while(t.left!=null)
		 {
			 t=t.left;
		 }
		 return t.data;
	}

	private static void print(Node nr) 
	{
		 if(nr==null)
		 {
			 return;
		 }
		 print(nr.left);
		 System.out.print(nr.data+" ");
		 print(nr.right);
	}

	private static Node insert(Node r, int k) 
	{
		 Node nn=new Node(k);
		 if(r==null)
		 {
			 return nn;
		 }
		 Node t=r;
		 while(t!=null)
		 {
			 if(t.data<k)
			 {
				 if(t.right==null)
				 {
					 t.right=nn;
					 break;
				 }
				 t=t.right;
			 }
			 else
			 {
				 if(t.left==null)
				 {
					 t.left=nn;
					 break;
				 }
				 t=t.left;
			 }
		 }
		 return r;
	}

	private static boolean search(Node r, int i) 
	{
		 Node t=r;
		 while(t!=null)
		 {
			 if(t.data==i)
			 {
				 return true;
			 }
			 else if(t.data>i)
			 {
				 t=t.left;
			 }
			 else
			 {
				 t=t.right;
			 }
		 }
		 return false;
	}

}
