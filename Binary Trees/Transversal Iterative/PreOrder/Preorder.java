// Implementation of preorder transversal algorithm using iterative approach 
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
		return top == stackArray.length-1;
	}
}

class Preorder
{
	Node root;

	Preorder(int data)
	{
		root = new Node(data);
	}

	void preOrder() throws ArrayIndexOutOfBoundsException
	
	{
		Stack thestack = new Stack();
		while(true)
		{
			
			while(root!=null)
			{
				System.out.println(root.data);
				thestack.push(root);
				root = root.left;
			}
			if(thestack.isEmpty())
				break;
			 root = thestack.pop();
			 root = root.right;

		}

	}

	public static void main(String args[])
	{
		Preorder tree = new Preorder(100);
		tree.root.left = new Node(80);
		tree.root.right = new Node(120);
		tree.root.left.left = new Node(60);
		tree.root.left. right = new Node(150);

		tree.preOrder();
	}
}