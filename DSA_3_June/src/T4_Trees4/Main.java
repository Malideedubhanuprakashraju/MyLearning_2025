package T4_Trees4;

import java.util.ArrayList;
import java.util.Collections;

import T3_Trees3.Node;

public class Main 
{
	public static void main(String[] args) 
	{
		Node r = new Node(4);
		r.left = new Node(0);
		r.right = new Node(10);
		r.left.left = new Node(-1);
		r.left.left.left = new Node(80);
		r.left.left.right = new Node(90);
		r.left.right = new Node(3);
		r.right.left = new Node(7);
		r.right.right = new Node(15);

		System.out.println("Given a BT Search if there exists a d in Binary Tree");
		boolean ans = check(r, 309);
		System.out.println(ans);

		System.out.println("Given Node find path from node to root");
		ArrayList<Node> ans1 = getPath(r, 15);
		for (Node x : ans1) {
			System.out.print(x.data + " ");
		}
		System.out.println();

		System.out.println("Find Lowest Common Ancestor ----> LCA");
		Node ans2 = LCA(r, -1, 3);
		if (ans2 != null)
			System.out.println(ans2.data);
		else
			System.out.println("LCA not found");

		System.out.println("Given a Node, how many nodes are exactly at distance K downward:");
		int ans3 = below(r, 2);
		System.out.println(ans3);

		System.out.println("Calculate number of nodes at Distance K from Source Node ---->");
		int ans4 = countNodes(r, 3, 2); // e.g., source = 3, distance = 2
		System.out.println(ans4);
	}

	// ✅ Count nodes at distance d from source node s
	private static int countNodes(Node r, int s, int d) 
	{
		ArrayList<Node> p = getPath1(r, s);
		//Collections.reverse(p);

		int ans = 0;
		ans += below(p.get(0), d);  // nodes downward from source

		for (int i = 1; i < p.size(); i++) {
			int dist = d - i;

			if (dist == 0) {
				ans += 1; // ancestor node at exact distance
				break;
			}

			if (p.get(i).left == p.get(i - 1)) {
				ans += below(p.get(i).right, dist - 1);
			} else {
				ans += below(p.get(i).left, dist - 1);
			}
		}
		return ans;
	}

	// ✅ Count nodes k levels below given node
	private static int below(Node r, int k) 
	{
		if (r == null) return 0;
		if (k == 0) return 1;

		return below(r.left, k - 1) + below(r.right, k - 1);
	}

	// ✅ Find lowest common ancestor using paths
	private static Node LCA(Node r, int p, int q) 
	{
		ArrayList<Node> ll = getPath(r, p);
		ArrayList<Node> rr = getPath(r, q);
		Collections.reverse(ll);
		Collections.reverse(rr);

		Node lca = null;
		int i = 0;
		while (i < ll.size() && i < rr.size()) {
			if (ll.get(i) == rr.get(i)) {
				lca = ll.get(i);
			} else {
				break;
			}
			i++;
		}
		return lca;
	}

	// ✅ Path from node to root
	private static ArrayList<Node> getPath(Node r, int s) 
	{
		ArrayList<Node> al = new ArrayList<>();
		getPathHelper(r, s, al);
		return al;
	}

	private static boolean getPathHelper(Node r, int s, ArrayList<Node> al) 
	{
		if (r == null) return false;
		if (r.data == s) {
			al.add(r);
			return true;
		}
		if (getPathHelper(r.left, s, al) || getPathHelper(r.right, s, al)) {
			al.add(r);
			return true;
		}
		return false;
	}

	// ✅ Alternate path method for countNodes (same as getPath)
	private static ArrayList<Node> getPath1(Node r, int s) 
	{
		ArrayList<Node> path = new ArrayList<>();
		getPathHelper(r, s, path);
		return path;
	}

	// ✅ Check if value exists
	private static boolean check(Node r, int d) 
	{
		if (r == null) return false;
		if (r.data == d) return true;
		return check(r.left, d) || check(r.right, d);
	}
}
