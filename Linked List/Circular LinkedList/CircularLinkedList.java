/* Circular LinkedList or Double ended linkedlist */
/* the last element points to the first element */
/* Methods 
	* Insertion - 2
	* Deletion - 2
*/

class Node 
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
	}
}
class CircularLinkedList
{
	Node head;
	
	void insertFirst(int data)
	{
		if(head==null)
		{
			Node newnode = new Node(data);
			head = newnode;
			newnode.next= head;
		}
		else
		{
			Node newnode = new Node(data);
			newnode.next = head;
			head = newnode;
		}
	}
	
	void insertLast(int data)
	{
		if(head==null)
		{
			Node newnode = new Node(data);
			head = newnode;
			newnode.next = head;
		}
		else
		{
			Node current = head;
			Node previous = current;
			do
			{
				previous = current;
				current = current.next;
			}
			while(current!=head);
			Node newnode = new Node(data);
			previous.next = newnode;
			newnode.next = head;
		}
	}
	
	void deleteFirst()
	{
		if(head==null)
		{
			System.out.println("Empty List");
		}
		else
		{
			head = head.next;
		}
	}
	void deleteLast()
	{
		if(head==null)
		{
			System.out.println("Empty list");
		}
		else
		{
			Node current = head;
			Node previous = current;
			Node pre_previous = previous;
			do
			{
				pre_previous = previous;
				previous = current;
				current = current.next;
			}
			while(current!=head);
			pre_previous.next = head;
		}
	}
	
	void displayList()
	{
		Node current = head;
		do
		{
			System.out.print(current.data);
			System.out.print("-->");
			current = current.next;
		}
		while(current!=head);
	}
	
	public static void main(String args[])
	{
		CircularLinkedList list = new CircularLinkedList();
		System.out.println("Inserting data to first");
		System.out.println("100--200--300--400");
		list.insertFirst(100);
		list.insertFirst(200);
		list.insertFirst(300);
		list.insertFirst(400);
		list.displayList();
		System.out.println("Inserting data to last");
		System.out.println("30--20--10--90");
		list.insertLast(30);
		list.insertLast(20);
		list.insertLast(10);
		list.insertLast(90);
		list.displayList();
		System.out.println("Deleting list from first and last");
		list.deleteFirst();
		list.deleteLast();
		System.out.println("Displaying List");
		list.displayList();
	}
}