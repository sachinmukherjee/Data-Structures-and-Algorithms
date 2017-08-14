// Implementaion of pre order transversal of binary tree using recursive techinque
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
		left = null; 
		right = null;
	}
}

class Preorder
{
	static Node root;

	Preorder(int data)
	{
		root = new Node(data);
	}

	void preorder(Node root)
	{
		if(root==null)
			return;
		else
		{
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String args[])
	{
		Preorder roots = new Preorder(100);
		roots.root.left = new Node(120);
		roots.root.right = new Node(150);
		roots.root.left.left = new Node(80);
		roots.root.left.right = new Node(120);

		roots.root.right.left = new Node(130);
		roots.root.right.right = new Node(170);

		System.out.println("Calling Preorder Transversal");
		roots.preorder(root);


	}
}