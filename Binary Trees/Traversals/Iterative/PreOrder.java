/* Implementation of PreOrder Transversal */
/* Using Non Dynamic arrays as */
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
		return top==-1;
	}
}

class PreOrder
{
	Node root;
	PreOrder(int data)
	{
		root = new Node(data);
	}
	
	void preOrder()
	{
		Stack stack = new Stack();
		while(true)
		{
			while(root!=null)
			{
				System.out.println(root.data);
				stack.push(root);
				root = root.left;
			}
			
			if(stack.isEmpty())
				break;
			else
			{
				root = stack.pop();
				root = root.right;
			}
		}
	}
	
	public static void main(String args[])
	{
		PreOrder preorder = new PreOrder(1);
		preorder.root.left = new Node(2);
		preorder.root.right = new Node(3);
		preorder.root.left.left = new Node(4);
		preorder.root.left.right = new Node(5);
		preorder.root.right.left = new Node(6);
		preorder.root.right.right = new Node(7);
		preorder.preOrder();
	}
}