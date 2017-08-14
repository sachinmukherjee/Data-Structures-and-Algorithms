// Simple Implementation of binary trees in java
// created by sachin mukherjee
// sachinmukherjee29@gmail.com

class Node
{
	int data;
	Node right;
	Node left;

	Node(int data)
	{
		this.data = data;
		right = null;
		left = null;
	}
}

class BinaryTree
{
	Node root;

	BinaryTree(int data)
	{
		// to enter data into root
		root = new Node(data);
	}

	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree(100);
		tree.root.left = new Node(120);				// to enter data into left child
		tree.root.right = new Node(150);			// to enter data into right child
		System.out.println(tree.root.data);
		System.out.println(tree.root.left.data);
		System.out.println(tree.root.right.data);
		tree.root.left.left = new Node(200);
		System.out.println(tree.root.left.left.data);

	}
}