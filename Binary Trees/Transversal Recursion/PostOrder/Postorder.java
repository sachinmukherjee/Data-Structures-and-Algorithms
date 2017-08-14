// Implementation of Post order transversal in java 
// created by sachin mukherjee
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

class Postorder
{
	static Node root;

	Postorder(int data)
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
		Postorder tree = new Postorder(100);
		tree.root.left = new Node(80);
		tree.root.right = new Node(120);
		tree.root.left.left = new Node(60);
		tree.root.left.right = new Node(90);
		tree.root.right.left = new Node(110);
		tree.root.right.right = new Node(150);

		tree.postOrder(root);
	}
}