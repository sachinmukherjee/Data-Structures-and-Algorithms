// Implementation of Inorder algorithm in java
// created by sachinmukherjee
// sachinmukherjee29@gmail.com

class Node
{
	Node left;
	Node right;
	int data;

	Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}

class Inorder
{
	static Node root;

	Inorder(int data)
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
		Inorder tree = new Inorder(100);
		tree.root.left = new Node(80);
		tree.root.right = new Node(120);
		tree.root.left.left = new Node(60);
		tree.root.left.right = new Node(90);

		tree.root.right.left = new Node(110);
		tree.root.right.right = new Node(150);

		tree.inOrder(root);
	}
}