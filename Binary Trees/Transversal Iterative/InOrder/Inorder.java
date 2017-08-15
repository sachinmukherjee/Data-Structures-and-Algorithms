// Implementation of inorder transversal of binary tree using iterative approach
// created by sachin mukherjee
// sachinmukherjee29@gmail.com

class Node
{
	Node right;
	Node left;
	int data;

	Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}

class Stack
{
	int top;
	Node stackArray[] = new Node[20];

	Stack()
	{
		top = -1;
	}

	void push(Node data)
	{
		stackArray[++top] = data; 
	}

	Node pop()
	{
		return stackArray[top--];
	}

	boolean isEmpty()
	{
		return top == 19;
	}
}

class Inorder
{
	Node root;

	Inorder(int data)
	{
		root = new Node(data);
	}

	void inOrder()
	{
		Stack thestack = new Stack();
		//System.out.println("Hello world");

		while(true)
		{	
			while(root!=null)
			{
				thestack.push(root);
				root = root.left;
				
			}

			if(thestack.isEmpty())
				break;

			root = thestack.pop();
			System.out.println(root.data);
			root = root.right;
		}
	}

	public static void main(String[] args) 
	{
		Inorder tree = new Inorder(100);
		tree.root.left = new Node(80);
		tree.root.right = new Node(120);
		tree.root.left.left = new Node(60);
		tree.root.left. right = new Node(150);

		tree.inOrder();
		
	}
}