/* Doubly LinkedList */ 
/* Linked List with a pointer pointing to previous node */
/* Methods
	*Insertion	--> 3 Methods 
	* Deletion  --> 3 Methods
*/

// Nodes of linked list
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
		this.data = data;
		next = null;
		prev = null;
	}
}

// LinkedList
class DoublyLinkedList
{
	Node head;
	
	void insertFirst(int data)
	{
		if(head==null)
		{
			Node newnode = new Node(data);
			head = newnode;
		}
		else
		{
			Node newnode = new Node(data);
			head.prev = newnode;
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
		}
		else
		{
			Node current = head;
			Node previous = current;
			while(current!=null)
			{
				previous = current;
				current=current.next;
			}
			Node newnode = new Node(data);
			previous.next = newnode;					//previous is the last node while current points to null(last-->null)
			newnode.prev = previous;
		}
	}
	// insert after given postion
	void insertIntermidiate(int data,int position)
	{
		if(head==null)
		{
			Node newnode = new Node(data);
			head = newnode;
		}
		else
		{
			Node current = head;
			int count = 0;
			while(count!=position)
			{
				current = current.next;
				if(current!=null && count<=position-1)
				{
					System.out.println("Shorter Linkedlist");
					break;
				}
				else
				{
					count++;
				}	
			}
			Node newnode = new Node(data);
			current.next = newnode;
			newnode.prev = current;
			
		}
	}
	
	void deleteFirst()
	{
		if(head==null)
		{
			System.out.println("Empty LinkedList");
		}
		else
		{
			head = head.next;
			head.prev = null;
			
		}
	}
	
	void deleteLast()
	{
		if(head==null)
		{
			System.out.println("Empty LinkedList");
		}
		else
		{
			Node current = head;
			Node previous = current;
			while(current!=null)
			{
				previous = current;
				current = current.next;
			}
			previous.next = null;
			
		}
	}
	
	// deleter that position
	void deleteIntermidiate(int position)
	{
		if(head==null)
		{
			System.out.println("Empty LinkedList");
		}
		else
		{
			Node current = head;
			Node previous = current;
			int count = 0;
			while(count!=position)
			{
				if(current==null && count<=position-1)
				{
					System.out.println("Shorter LinkedList");
					break;
				}
				else
				{
					count++;
				}
				previous = current;
				current = current.next;
			}
			current.next.prev = previous;
			previous.next = current.next;
		}
	}
	
	void displayFromFirst()
	{
		Node current = head;
		while(current!=null)
		{
			System.out.print(current.data);
			System.out.print("-->");
			current = current.next;
		}
		System.out.println(" ");
	}
	void displayFromLast()
	{
		Node current = head;
		Node previous = current;
		while(current!=null)
		{
			previous = current;
			current = current.next;
		}
		while(previous!=null)
		{
			System.out.print(previous.data);
			System.out.print("-->");
			previous = previous.prev;
		}
		System.out.println(" ");
	}
	
	public static void main(String args[]) 
	{
		DoublyLinkedList list = new DoublyLinkedList();
		System.out.println("Entering data from first");
		System.out.println("100--200--300");
		list.insertFirst(100);
		list.insertFirst(200);
		list.insertFirst(300);
		System.out.println("Displaying from first");
		list.displayFromFirst();
		System.out.println("Displaying from last");
		list.displayFromLast();
		System.out.println("Inserting from last");
		System.out.println("30--55--70--95");
		list.insertLast(30);
		list.insertLast(55);
		list.insertLast(70);
		list.insertLast(90);
		list.insertLast(95);
		System.out.println("Displaying from first");
		list.displayFromFirst();
		System.out.println("Displaying from last");
		list.displayFromLast();
		System.out.println("Inserting at the middle postion:5 data--1000");
		list.insertIntermidiate(1000, 5);
		System.out.println("Displaying from first");
		list.displayFromFirst();
		System.out.println("Deleting from first, last and middle");
		list.deleteFirst();
		list.deleteLast();
		//list.deleteIntermidiate(2);
		System.out.println("Displaying from first");
		list.displayFromFirst();
		System.out.println("Displaying from last");
		list.displayFromLast();
		
	}
	
}