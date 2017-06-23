/* a program for deletion of singly linked list 
   * delete at first
   * delete at last
   * delete at a postion
   * created by sachin mukherjee
   * sachinmukherjee29@gmail.com
*/

class Node
{
	Node next;
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

class LinkedList2
{
	Node head;

	void displayList()
	{
		Node current=head;
		Node previous = current;
		while(current!=null)
		{
			System.out.println(current.data);
			current = current.next;
		}
	}
	void insertFirst(int data)
	{
		Node newnode = new Node(data);
		if(head==null)
			head=newnode;
		else
		{
			newnode.next=head;
			head = newnode;
		}
    }

	void deleteFirst()
	{
		if(head==null)
			System.out.println("LinkedList is empty");
		else 
		{
			head = head.next;
		}

	}
	void deleteLast()
	{
		if(head==null)
		{
			System.out.println("Linked List is empty");
		}
		else 
		{
			Node current = head;
			Node previous=current;
			while(current!=null)
			{
				previous=current;
				current = current.next;
			}
			previous=null;
		}
	}
	void deleteIntermidiate(int position)
	{
		if(head==null)
			System.out.println("Linked List is empty");

		else if(position==1)
			head = head.next;

		else if(position==0)
			System.out.println("No link exits");

		else 
		{
			Node current = head;
			Node previous=current;
			int current_position=1;
			while(current_position!=position)
			{
				previous=current;
				current = current.next;
				current_position++;
			}
			previous.next = current.next;
		}

	}
	void displayLink()
	{
		Node current = head;
		Node previous=current;
		while(current!=null)
		{
			System.out.println(current.data);
			current = current.next;
		}
	}
	public static void main(String[] args) 
	{
		LinkedList2 thelist = new LinkedList2();
		thelist.insertFirst(15);
		thelist.insertFirst(11);
		thelist.insertFirst(5);
		thelist.insertFirst(77);
		thelist.insertFirst(30);
		thelist.insertFirst(22);
		thelist.insertFirst(11);
		thelist.insertFirst(22);
		thelist.insertFirst(10);
		thelist.insertFirst(100);
		System.out.println("Displaying Link");
		thelist.displayLink();
		thelist.deleteFirst();
		thelist.deleteIntermidiate(5);
		thelist.deleteLast();
		System.out.println();
		System.out.println("After deleting displaying");
		thelist.displayLink();

		
	}
}