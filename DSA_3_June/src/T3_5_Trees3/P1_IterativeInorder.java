package T3_5_Trees3;

import java.util.Stack;

import T3_Trees3.Node;

public class P1_IterativeInorder 
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
		 System.out.println("Iterative Inorder----->");
		 inOrder(r);
		 System.out.println("Iterative Preorder---->");
		 preOrder(r);
		 System.out.println("Given Pre-Order & In-order of BT print Post OrderTraversal---->");
		 int pre[]= {8,6,2,11,16,10,12,4,14,9,18,15};
		 int in[]= {11,2,16,6,10,12,8,14,4,18,9,15};
		 Node nr=solve(pre,in);
		 preOrder(nr);
		 System.out.println("Construct BBST from Sorted array---->");
		 int a[]= {-1,2,3,4,6,7,8,10,13,14};
		 Node nrr=solve(a);
		 inOrder(nrr);
	}

	private static Node solve(int[] a) 
	{
		 return converBBST(a,0,a.length-1);
	}

	private static Node converBBST(int[] a, int l, int h) 
	{
		if(l>h)
		{
			return null;
		}
		int m=(l+h)/2;
		Node root=new Node(a[m]);
		root.left=converBBST(a,l,m-1);
		root.right=converBBST(a,m+1,h);
		
		return root;
	}

	private static Node solve(int[] pre, int[] in) 
	{
		 int n=pre.length;
		 return construct(pre,0,n-1,in,0,n-1);
	}

	private static Node construct(int[] pre, int s1, int e1, int[] in, int s2, int e2) 
	{
		if(s1>e1)
		{
			return null;
		}
		 Node root=new Node(pre[s1]);
		 int ri=-1;
		 for(int i=s2;i<=e2;i++)
		 {
			 if(root.data==in[i])
			 {
				 ri=i;
				 break;
			 }
		 }
		 int cl=ri-s2;
		 root.left=construct(pre,s1+1,s1+cl,in,s2,ri-1);
		 root.right=construct(pre,s1+cl+1,e1,in,ri+1,e2);
		 return root;
	}

	private static void preOrder(Node r) 
	{
		 Node curr=r;
		 Stack<Node> st=new Stack<>();
		 st.push(curr);
		 while(st.size()>0)
		 {
			  Node cur=st.pop();
			  System.out.println(cur.data);
			  if(cur.right!=null)
			  {
				  st.push(cur.right);
			  }
			  if(cur.left!=null)
			  {
				  st.push(cur.left);
			  }
		 }
		
	}

	private static void inOrder(Node r) 
	{
		 	Node curr=r;
		 	Stack<Node> st=new Stack<>();
		 	while(curr !=null || st.size()>0)
		 	{
		 		if(curr!=null)
		 		{
		 			st.push(curr);
		 			curr=curr.left;
		 		}
		 		else
		 		{
		 			curr=st.peek();
		 			st.pop();
		 			System.out.println(curr.data);
		 			curr=curr.right;
		 		}
		 	}
	}

}
