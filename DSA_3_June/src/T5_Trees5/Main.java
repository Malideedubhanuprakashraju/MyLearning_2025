package T5_Trees5;

import T1_Trees1.Node;

public class Main 
{

	public static void main(String[] args) 
	{
		 Node r=new Node(5);
		 r.left=new Node(10);
		 r.right=new Node(10);
		 r.right.left=new Node(2);
		 r.right.right=new Node(3);
		 
		 Node r1=new Node(1);
		 r1.left=new Node(2);
		 r1.right=new Node(3);
		 System.out.println("Equal Tree Partition Subtree sum=Totalsum/2---->");
		 boolean ans=solve(r);
		 System.out.println(ans);
		 System.out.println("Checkif Root to Leaf Path Sum is equals to K----->");
		 boolean ans2=pathSum(r,18);
		 System.out.println(ans2);
		 System.out.println("Diameter of a Binary Tree---->Length of Longest Path BW any 2-Nodes---->");
		 int ans3=solve3(r);
		 System.out.println(ans3);
		 System.out.println("Given a Perfect Binary Tree fill next to every node");
		 FillRight(r1);
		 System.out.println(r1.data);
		 System.out.println(r1.left.data);
		 System.out.println(r1.right.next);
	}
	private static void FillRight(Node r1) 
	{
		 Node t=r1;
		 while(t.left!=null)
		 {
			 Node s=t;
			 while(t!=null)
			 {
				 t.left.next=t.right;
				 if(t.next!=null)
				 {
					 t.right.next=t.next.left;
				 }
				 t=t.next;
			 }
			 t=s.left;
		 }
		
	}
	static int d;
	private static int solve3(Node r) 
	{
		 d=0;
		 int a=height(r);
		 System.out.println(a+"Boss");
		 return d;
	}
	
	private static int height(Node r) 
	{
		if(r==null)
		{
			return 0;
		}
		 int hl=height(r.left);
		 int hr=height(r.right);
		 d=Math.max(d,hl+hr+1);
		 
		 return Math.max(hl, hr)+1;
		 
	}

	private static boolean pathSum(Node r, int s) 
	{
		if(r==null)
		{
			return false;
		}
		if(r.data==s && r.left==null && r.right==null)
		{
			return true;
		}
		return pathSum(r.left,s-r.data)|| pathSum(r.right,s-r.data);
	}

	private static boolean solve(Node r) 
	{
		 int total=sum(r);
		 //System.out.println(total);
		 if(total%2==1)
		 {
			 return false;
		 }
		 int target=total/2;
		 solve1(r,target);
		 
		 return isPossible;
	}
	public static boolean isPossible;
	private static boolean solve1(Node r, int tar) 
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
		 int ls=sum(r.left);
		 int rs=sum(r.right);
		 return ls+rs+r.data;
	}

}
