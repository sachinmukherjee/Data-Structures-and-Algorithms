/* Intro to Binary Tree */

class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
		this.data = data;
		left=null;
		right=null;
	}
}

class BinaryTree
{
	Node root;
	
	BinaryTree(int data)
	{
		// entering data directly into root
		root = new Node(data);
	}
	
	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree(1000);
		// tree.root.something.something -- these are the name of the node
		tree.root.left = new Node(100);
		tree.root.right = new Node(200);
		tree.root.left.left = new Node(50);
		tree.root.left.right = new Node(90);
		tree.root.right.left = new Node(10);
		tree.root.right.right = new Node(20);
		System.out.println("Displaying few Node");
		System.out.println(tree.root.data);
		System.out.println(tree.root.left.left.data);
		System.out.println(tree.root.right.left.data);
		
		
	}
}