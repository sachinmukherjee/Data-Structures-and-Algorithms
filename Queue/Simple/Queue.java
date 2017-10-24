// Simple Queue Operation//

import java.util.*;
class Queue
{
	int array[] = new int[20];
	int rear;			//for entering operation
	int front;			// for removal operation
	int nItems = 0;
	
	// Main methods of queue //
	Queue()
	{
		rear = -1;
		front = 0;
	}
	
	void enQueue(int data)
	{
		array[++rear] = data;
		nItems++;
	}
	
	void deQueue()
	{
		front ++;
		nItems--;
	}
	int peek()
	{
		return array[rear];
	}
	
	public static void main(String args[])
	{
		// Basic operations to demostrate working of queue
		Queue q = new Queue();
		System.out.println("Entering two numbers");
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(30);
		q.enQueue(5);
		q.enQueue(55);
		System.out.println("Removing two numbers");
		q.deQueue();
		q.deQueue();
		System.out.println(q.peek());
		
		
		
	}
}