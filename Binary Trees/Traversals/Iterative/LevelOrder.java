/* Implementation of LevelOrder Traversal */
/* Not using Dynamic arrays */

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

class Queue
{
	Node array[] = new Node[20];
	int front = 0;
	int rear = -1;
	int nitems = 0;
	
	void enQueue(Node object)
	{
		array[++rear] = object;
		nitems++;
	}
	
	Node deQueue()
	{
		nitems--;
		return array[front++];
	}
	
	boolean isEmpty()
	{
		return nitems == 0;
	}
}

class LevelOrder
{
	Node root;
	
	LevelOrder(int data)
	{
		root = new Node(data);
	}
	
	void levelOrder()
	{
		Queue queue = new Queue();
		Node temp;
		if(root == null)
			return;
		queue.enQueue(root);
		while(!queue.isEmpty())
		{
			temp = queue.deQueue();
			System.out.println(temp.data);
			
			if(temp.left != null)
				queue.enQueue(temp.left);
			
			if(temp.right != null)
				queue.enQueue(temp.right);
		}
	}
	
	public static void main(String args[])
	{
		LevelOrder levelorder = new LevelOrder(1);
		levelorder.root.left = new Node(2);
		levelorder.root.right = new Node(3);
		levelorder.root.left.left = new Node(4);
		levelorder.root.left.right = new Node(5);
		levelorder.root.right.left = new Node(6);
		levelorder.root.right.right = new Node(7);
		levelorder.levelOrder();
	}
}