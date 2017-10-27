/* Implementation of Inorder Transversal */
/* Left--->Data--->Right */

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

class InOrder
{
	Node root;
	
	InOrder(int data)
	{
		root = new Node(data);
	}
	
	void inOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	
	public static void main(String args[])
	{
		InOrder roots = new InOrder(1000);
		roots.root.left = new Node(100);
		roots.root.right = new Node(200);
		roots.root.left.left = new Node(500);
		roots.root.left.right = new Node(400);
		
		roots.root.right.left = new Node(300);
		roots.root.right.right = new Node(900);
		
		System.out.println("Now displaying tree");
		roots.inOrder(roots.root);
		
	}
}