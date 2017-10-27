/* Implementation of PostOrder Traversal */
/* Left--->Right--->Data */

class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}
class PostOrder
{
	Node root;
	
	PostOrder(int data)
	{
		root = new Node(data);
	}
	
	void postOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}
	
	public static void main(String args[])
	{
		PostOrder roots = new PostOrder(1000);
		roots.root.left = new Node(500);
		roots.root.right = new Node(600);
		roots.root.left.left = new Node(400);
		roots.root.left.right = new Node(300);
		roots.root.right.left = new Node(50);
		roots.root.right.right = new Node(90);
		System.out.println("Now Displaying tree");
		roots.postOrder(roots.root);
	}
}
