/* Implementation of InOrder Transversal */
/* Using Non Dynamic arrays */

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

class Stack
{
	Node array[] = new Node[20];
	int top = -1;
	
	void push(Node object)
	{
		array[++top] = object;
	}
	
	Node pop()
	{
		return array[top--];
		
	}
	
	boolean isEmpty()
	{
		return top == -1;
	}
}
class InOrder
{
	Node root;
	
	InOrder(int data)
	{
		root = new Node(data);
	}
	
	void inOrder()
	{
		Stack stack = new Stack();
		while(true)
		{
			while(root!=null)
			{
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty())
				break;
			else
			{
				root = stack.pop();
				System.out.println(root.data);
				root = root.right;
			}
		}
	}
	
	public static void main(String args[])
	{
		InOrder inorder = new InOrder(1);
		inorder.root.left = new Node(2);
		inorder.root.right = new Node(3);
		inorder.root.left.left = new Node(4);
		inorder.root.left.right = new Node(5);
		inorder.root.right.left = new Node(6);
		inorder.root.right.right = new Node(7);
		inorder.inOrder();
	}
}