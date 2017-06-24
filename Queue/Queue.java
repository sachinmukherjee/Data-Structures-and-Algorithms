/* a java program implementation of queue
  * enqueue, dequeue, and display method 
  * created by sachin mukherjee
  * sachinmukherjee29@gmail.com
*/
class Queue
{
	final int MAXSIZE=10;
	int front;
	int rear;
    int data;
    int nitems;
    int queuearray[] = new int[MAXSIZE];

    Queue()
    {
    	front=0;
    	rear=-1;
    	nitems=0;
    }

    void enQueue(int data)
    {
    	if(nitems==MAXSIZE-1)
    		System.out.println("Queue is Full");

    	else if(rear==MAXSIZE-1)
    		rear=-1;
    	else 
    	{
    		queuearray[++rear]=data;
    		nitems++;
    	}

    }
    void deQueue()
    {
    	if(nitems==0)
    		System.out.println("Queue is empty");

    	else if(front==MAXSIZE-1)
    		front=0;
    	else 
    	{
    		
    		nitems--;
    		front++;
    	}
    }
    void display()
    {
    	System.out.println(queuearray[front]);
    }

    public static void main(String[] args) 
    {
    	Queue thequeue = new Queue();
    	thequeue.enQueue(10);
    	thequeue.enQueue(15);
    	thequeue.enQueue(20);
    	thequeue.enQueue(19);
    	thequeue.display();
    	thequeue.deQueue();
    	thequeue.display();
    	
    }

}