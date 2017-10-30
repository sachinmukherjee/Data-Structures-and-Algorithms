/* Implementation of PostOrder Traversal */
/* Not using Dynamic arrays for Queue */

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

class PostOrder
{
	Node root;
	PostOrder(int data)
	{
		root = new Node(data);
	}
	
	void postOrder()
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
			else if(root.right!=null)
			{
				root = root.right;
				stack.push(root);
			}
			else
			{
				root = stack.pop();
				System.out.println(root.data);
			}
		}
	}
	
	public static void main(String args[])
	{
		PostOrder postorder = new PostOrder(1);
		postorder.root.left = new Node(2);
		postorder.root.right = new Node(3);
		postorder.root.left.left = new Node(4);
		postorder.root.left.right = new Node(5);
		postorder.root.right.left = new Node(6);
		postorder.root.right.right = new Node(7);
		postorder.postOrder();
	}
}