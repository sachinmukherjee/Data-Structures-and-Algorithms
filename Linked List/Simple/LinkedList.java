/* Simple Linked List */

// Class for Nodes in linked list each node contain data and a pointer to next node//
class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data = data;
	}

}
// Main LinkedList class
public class LinkedList
{
	Node head;
	
	// Inserting data // 
	void insert(int data)
	{
		// If no node in linked list then simply add to the first
		if(head==null)
		{
			Node newnode = new Node(data);
			head = newnode;
			newnode.next = null;
		}
		// else do some assigment for head and next pointer for newnode and current first node
		else
		{
			Node newnode = new Node(data);
			newnode.next = head;
			head = newnode;
			
		}
	}
	
	// Displaying List
	void displayList()
	{
		// Display untill heads points to null
		Node current = head;
		while(current!=null)
		{
			System.out.print(current.data);
			System.out.print("-->");
			current = current.next;
		}
	}
	
	public static void main(String args[])
	{
		LinkedList list = new LinkedList();
		System.out.println("Inserting Data in LinkedList");
		System.out.println("100--20--22--2");
		list.insert(100);
		list.insert(20);
		list.insert(22);
		list.insert(2);
		System.out.println("Displaying LinkedList");
		list.displayList();
	}
	
}