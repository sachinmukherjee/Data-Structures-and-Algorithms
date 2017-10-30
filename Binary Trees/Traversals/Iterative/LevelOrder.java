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
		if(root == null)				// if tree is empty then return without processing further
			return;
		queue.enQueue(root);			// push root into the queue
		while(!queue.isEmpty())
		{
			temp = queue.deQueue();		// pop one node from queue
			System.out.println(temp.data);	// display it
			
			if(temp.left != null)			// if it has left child then push it into queue
				queue.enQueue(temp.left);
			
			if(temp.right != null)			// if it has right child then push it into queue
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