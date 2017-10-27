/* Implementation of Queue using Linked List */

class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		next = null;
	}
}

class QueueLinkedList
{
	Node front;
	Node rear;
	
	void enQueue(int data)
	{
		if(rear==null && front==null)
		{
			Node newnode = new Node(data);
			rear = newnode;
			front = newnode;
		}
		else
		{	// Inserting at the end of the list
			Node newnode = new Node(data);
			rear.next = newnode;
		}
	}
	
	Node deQueue()
	{
		if(front==null && rear==null)
		{
			System.out.println("Empty Queue");
			return null;
		}
		else
		{
			Node temp = front;
			front = front.next;
			return temp;
		}
	}
	void displayQueue()
	{
		Node current = front;
		while(current!=null)
		{
			System.out.print(current.data);
			System.out.print("-->");
			current = current.next;
		}
		System.out.println(" ");
	}
	
	public static void main(String args[])
	{
		QueueLinkedList list = new QueueLinkedList();
		System.out.println("Inserting few data into the queue");
		list.enQueue(1110);
		list.enQueue(20);
		list.enQueue(10);
		list.enQueue(50);
		list.enQueue(60);
		list.enQueue(70);
		System.out.println("Displaying the Queue");
		list.displayQueue();
		System.out.println("removing few element from the queue");
		System.out.println(list.deQueue().data);
		System.out.println(list.deQueue().data);
		System.out.println("Displaying the queue");
		list.displayQueue();
	}
}