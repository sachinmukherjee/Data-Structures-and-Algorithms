// Simple implementation of circular queue //

class CircularQueue
{
	// Main methods of circular queue
	int array[] = new int[20];
	int rear;
	int front;
	int size = 20;
	int nItems;
	
	CircularQueue()
	{
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	void enQueue(int data)
	{
		// if rear is in the top of queue but still we have some vacant space then folding happens
		if(rear==size-1 && nItems!=size-1)
			rear = -1;
		array[++rear] = data;
		nItems++;
	}
	
	void deQueue()
	{
		// if front is in the top of queue but still we have some vacant space then folding happens
		if(front==size-1 && nItems!=size-1)
			front = 0;
		front++;
		nItems--;
	}
	
	int peek()
	{
		return array[front];
	}
	
	public static void main(String args[])
	{
		// basic operation to demostrate working of queue
		CircularQueue queue = new CircularQueue();
		System.out.println("Adding few items");
		queue.enQueue(10);
		queue.enQueue(22);
		queue.enQueue(5);
		queue.enQueue(25);
		queue.enQueue(30);
		System.out.println("Removing few items");
		queue.deQueue();
		queue.deQueue();
		System.out.println(queue.peek());
	}
}