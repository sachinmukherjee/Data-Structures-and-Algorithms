/* a java program for double ended linked list or we can say circular linked list
   * insert first, insert last
   * delete first, delete last
   * created by sachin mukherjee
   * sachinmukherjee29@gmail.com
*/

class Node
{
	Node next;
	int data;

	Node(int data)
	{
		this.data=data;
	}

}

class DoubleEndedLinkedList
{
	Node head;
	Node tail;

	void insertFirst(int data)
	{
		Node newnode = new Node(data);

		if(head==null)
		{
			head=newnode;
			tail=newnode;
		}
		else 
		{
			newnode.next=head;
			head = newnode;
			tail.next=newnode;
		}
	}
	void insertLast(int data)
	{
		Node newnode = new Node(data);

		if(head==null)
		{
			head=newnode;
			tail=newnode;
		}
		else
		{
			tail.next=newnode;
			tail=newnode;
			tail.next=head;
		}
	}
	void deleteFirst()
	{
		if(head==null)
			System.out.println("Empty List");

		else 
		{
			head=head.next;
			tail.next=head;

		}
	}
	void deleteLast()
	{
		if(head==null)
			System.out.println("Empty List");

		else 
		{
			Node current=head;
			Node previous=current;
			while(current!=tail)
			{
				previous=current;
				current=current.next;
			}
			previous=tail;
			tail.next=head;

		}
	}
	void displayList()
	{
		Node current = head;
		while(current!=tail)
		{
			System.out.println(current.data);
			current=current.next;
		}
	}
	public static void main(String[] args) 
	{
		DoubleEndedLinkedList thelist = new DoubleEndedLinkedList();
		thelist.insertFirst(10);
		thelist.insertFirst(20);
		thelist.insertFirst(30);
		thelist.insertLast(5);
		thelist.insertLast(50);
		System.out.println("Displaying List");
		thelist.displayList();
		System.out.println();

		thelist.deleteFirst();
		thelist.deleteLast();
		System.out.println();
		System.out.println("Displaying List");
		thelist.displayList();
	}
}