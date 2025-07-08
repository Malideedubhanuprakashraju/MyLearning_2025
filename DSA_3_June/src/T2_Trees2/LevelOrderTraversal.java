package T2_Trees2;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal 
{
	static boolean flag;
	public static void main(String[] args) 
	{
		Node r=new Node(3);
		r.left=new Node(7);
		r.right=new Node(4);
		r.left.left=new Node(9);
		r.left.right=new Node(12);
		r.right.left=new Node(15);
		r.right.right=new Node(20);
		LevelOrder(r);
		System.out.println();
		LevelOrder2(r);
		System.out.println("Left View ----->");
		LeftView(r);
		RightView(r);
		System.out.println("Height of a Tree---->");
		int ans=Height(r);
		System.out.println(ans);
		boolean ans1=isBST(r);
		System.out.println(ans1);
		
		
	}

	private static boolean isBST(Node r) 
	{
		flag=true;
		Heights(r);
		return flag;
		
		 
	}

	private static int Heights(Node r) 
	{
		 if(r==null)
		 {
			 return 0;
		 }
		 int hl=Heights(r.left);
		 int hr=Heights(r.right);
		 if(Math.abs(hl-hr)>1)
		 {
			 flag=false;
		 }
		 return Math.max(hl, hr)+1;
	}

	private static int Height(Node r) 
	{
		 if(r==null)
		 {
			 return 0;
		 }
		 int lh=Height(r.left);
		 int rh=Height(r.right);
		 return Math.max(lh,rh)+1;
	}

	private static void RightView(Node r) 
	{
		Queue<Node> q=new LinkedList<>();
		 q.add(r);
		 while(q.size()>0)
		 {
			 int n=q.size();
			 for(int i=0;i<n;i++)
			 {
				 Node t=q.poll();
				 if(i==n-1)
				 {
					System.out.println(t.data); 
				 }
				 if(t.left!=null)
				 {
					 q.add(t.left);
				 }
				 if(t.right!=null)
				 {
					 q.add(t.right);
				 }
			 }
			// System.out.println();
		 }
		 		
	}

	private static void LeftView(Node r) 
	{
		 Queue<Node> q=new LinkedList<>();
		 q.add(r);
		 while(q.size()>0)
		 {
			 int n=q.size();
			 for(int i=0;i<n;i++)
			 {
				 Node t=q.poll();
				 if(i==0)
				 {
					System.out.println(t.data); 
				 }
				 if(t.left!=null)
				 {
					 q.add(t.left);
				 }
				 if(t.right!=null)
				 {
					 q.add(t.right);
				 }
			 }
			 System.out.println();
		 }
	}

	private static void LevelOrder2(Node r) 
	{
		 Queue<Node> q=new LinkedList<>();
		 q.add(r);
		 while(q.size()>0)
		 {
			 int n=q.size();
			 for(int i=0;i<n;i++)
			 {
				 Node t=q.poll();
				 System.out.print(t.data+" ");
				 if(t.left!=null)
				 {
					 q.add(t.left);
				 }
				 if(t.right!=null)
				 {
					 q.add(t.right);
				 }
			 }
			 System.out.println();
		 }
	}

	private static void LevelOrder(Node r) 
	{
		 Queue<Node> q=new LinkedList<>();
		 q.add(r);
		 while(q.size()>0)
		 {
			 Node temp=q.poll();
			 System.out.print(temp.data+" ");
			 if(temp.left!=null)
			 {
				 q.add(temp.left);
			 }
			 if(temp.right!=null)
			 {
				 q.add(temp.right);
			 }
		 }
	}
}
