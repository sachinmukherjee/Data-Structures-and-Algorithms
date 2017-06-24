/* a java program for DoublyLinkedList Implementation
  * insert first, last , interdimidiate
  * display first,last, intermidiate
  * created by sachin mukherjee
  * sachinmukherjee29@gmail.com
*/

class Node
{
	Node next;
	Node prev;
	int data;

	Node(int data)
	{
		this.data = data;
	}

	void displayNode()
	{
		System.out.println(data);
	}
}

class DoublyLinkedList
{
	Node head;

	void insertFirst(int data)
	{
		Node newnode = new Node(data);

		if(head==null)
			head=newnode;
		else 
		{
			newnode.next=head;
			head.prev=newnode;
			head = newnode;
		}

	}
	void insertLast(int data)
	{
		Node newnode = new Node(data);

		if(head==null)
			head = newnode;
		else 
		{
			Node current = head;
			Node previous = current;
			while(current!=null)
			{
				previous=current;
				current=current.next;

			}
			previous.next=newnode;
			newnode.prev=previous;
		}
	}
	void insertIntermidiate(int data, int position)
	{
		Node newnode = new Node(data);

		if(head==null)
			head=newnode;
		else if(position==0)
			System.out.println("No Position available");
		else if(position==1)
		{
			newnode.next=head;
			newnode = head.prev;
			head = newnode;
		}
		else 
		{
			Node current = head;
			Node previous = current;
			int current_position=1;
			while(current_position!=position)
			{
				previous = current;
				current = current.next;
				current_position++;
			}
			previous.next = newnode;
			current.prev=newnode;
			newnode.next=current;
			newnode.prev=previous;

		}
	}

	void displayLink()
	{
		Node current = head;
		Node previous = current;
		while(current!=null)
		{
			System.out.println(current.data);
			current=current.next;
		}
	}
	void deleteFirst()
	{
		if(head==null)
			System.out.println("Linked List is empty");
		else 
		{
			head.next.prev=null;
			head = head.next;
		    

		}
	}
	void deleteLast()
	{
		if(head==null)
			System.out.println("Empty Linked List");
		else 
		{
			Node current = head;
			Node previous = current;
			while(current!=null)
			{
				previous = current;
				current=current.next;
			}
			previous.prev.next=null;
			previous.next=null;
		}
	}

	void deleteIntermidiate(int position)
	{
		if(head==null)
			System.out.println("Empty list");

		else if(position==0)
			System.out.println("No such position");

		else if(position==1)
		{
			head.next.prev = null;
			head = head.next;
			
		}
		else 
		{
			Node current = head;
			Node previous = current;
			int current_position=1;
			while(current_position!=position)
			{
				previous=current;
				current = current.next;
				current_position++;
			}
			previous.next=current.next;
			current.next.prev=previous;
		}

	}
	void displayList()
	{
		Node current = head;
		Node previous = current;
		while(current!=null)
		{
			System.out.println(current.data);
			current=current.next;
		}
	}

	public static void main(String[] args) 
	{
		DoublyLinkedList thelist = new DoublyLinkedList();
		thelist.insertFirst(10);
		thelist.insertFirst(20);
		thelist.insertFirst(30);
		thelist.insertLast(50);
		thelist.insertLast(40);
		thelist.insertLast(100);
		thelist.insertLast(200);
		thelist.insertIntermidiate(110,2);
		thelist.insertIntermidiate(140,4);
		System.out.println("Displaying data");
		thelist.displayList();
		System.out.println();
		System.out.println("Displaying after deleting");
		thelist.deleteFirst();
		thelist.deleteLast();
		thelist.deleteIntermidiate(3);
		thelist.displayList();
		
	}
}