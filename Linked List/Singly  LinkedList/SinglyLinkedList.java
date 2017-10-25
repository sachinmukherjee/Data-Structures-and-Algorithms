/* Singly Linked List */
/*Methods
  * Insert Node
	*insert node at first
	*insert node at last
	*insert node at middle
  * Delete Node
	* delete first node
	* delete last node
	* delete middle node
*/

// Node for LinkedList
class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
	}
}

// Linked List
class SinglyLinkedList
{
	Node head;								// always keep tracks no matter list is empty or not
	
	// Insert at the begining
	void insertFirst(int data)
	{
		if(head==null)
		{
			Node newnode = new Node(data);
			head = newnode;
			newnode.next= null;
		}
		else
		{
			Node newnode = new Node(data);
			newnode.next = head;
			head = newnode;
		}
	}
	// Insert at the last
	void insertLast(int data)
	{
		if(head==null)
		{
			Node newnode = new Node(data);
			head = newnode;
			newnode.next = null;
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
			Node newnode = new Node(data);
			previous.next = newnode;
			newnode.next = null;
		}
	}
	
	// insert after given postion
	void insertMiddle(int data,int number)
	{
		if(head==null)
			System.out.println("No Node in Linkedlist");
		else
		{
			Node current = head;
			int count = 1;
			while(count!=number)
			{
				
				current = current.next;
				// if we reach end of the list but cannot reach that one less than given position(position-1) means short linked list
				if(current==null && count<=number-1)
				{
					System.out.println("Not so much of node");
					break;
				}
				// increase the counter
				else
				{
					count++;
				}
			}
			Node newnode = new Node(data);
			newnode.next = current.next;
			current.next = newnode;
		}
	}
	
	// delete first node
	void deleteFirst()
	{
		if(head==null)
			System.out.println("No Node in LinkedList");
		else
		{
			head = head.next;
			
		}
	}
	
	// delete last node
	void deleteLast()
	{
		if(head==null)
			System.out.println("No Node in LinkedList");
		else
		{
			Node current = head;
			Node previous = current;
			Node pre_previous = previous;
			while(current !=null)
			{
				pre_previous = previous;
				previous = current;
				current = current.next;
			}
			pre_previous.next = null;
		}
	}
	
	// delete node after given postion means if postion is 6 then node will be deleted after 6th postion
	void deleteMiddle(int number)
	{
		if(head==null)
			System.out.println("No Node in LinkedList");
		else
		{
			Node current = head;
			Node previous = current;
			int count = 1;
			while(count!=number)
			{
				// if we reach end of list but we didn't reach that position mean list is shorter
				if(current==null && count<=number-1)
				{
					System.out.println("Not so much node");
					break;
				}
				else
				{
					count++;
				}
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
			
		}
	}
	
	void displayList()
	{
		Node current = head;
		while(current!=null)
		{
			System.out.print(current.data);
			System.out.print("--->");
			current = current.next;
		}
		System.out.println("");
		
	}
	
	public static void main(String args[])
	{
		SinglyLinkedList list = new SinglyLinkedList();
		System.out.println("Inserting data at first");
		System.out.println("100--200--300");
		list.insertFirst(100);
		list.insertFirst(200);
		list.insertFirst(300);
		System.out.println("Displaying List");
		list.displayList();
		System.out.println("Insert data at last");
		System.out.println("5--10--30");
		list.insertLast(5);
		list.insertLast(10);
		list.insertLast(30);
		System.out.println("Displaying List");
		list.displayList();
		System.out.println("Inserting at middle");
		System.out.println("Index number 3 data 60");
		list.insertMiddle(60,3);
		System.out.println("Displaying List");
		list.displayList();
		
		System.out.println("Now Deleting Nodes: Order -- First--Last--Middle(5)");
		list.deleteFirst();
		list.displayList();
		list.deleteLast();
		list.displayList();
		list.deleteMiddle(5);
		list.displayList();
		
	}
}