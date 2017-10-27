/* Implementation of PreOrder Transversal */ 
// Data--->LeftChild--->RightChild  // 

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

class PreOrder
{
	Node root;
	
	PreOrder(int data)
	{
		root = new Node(data);
	}
	
	void preOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void main(String args[])
	{
		PreOrder roots = new PreOrder(100);
		roots.root.left = new Node(20);
		roots.root.right = new Node(30);
		roots.root.left.left = new Node(110);
		roots.root.left.right = new Node(200);
		roots.root.right.left = new Node(50);
		roots.root.right.right = new Node(90);
		System.out.println("Displaying Nodes");
		roots.preOrder(roots.root);
	}
}