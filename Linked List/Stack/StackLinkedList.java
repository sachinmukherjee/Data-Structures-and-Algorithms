/* Implementation of Stack using Linked List */

class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
	}
}
// Stack using Linkedlist is same but we have to enter data and remove from front only
class StackLinkedList
{
	Node head;
	
	void push(int data)
	{
		if(head==null)
		{
			Node newnode = new Node(data);
			head = newnode;
		}
		else
		{
			Node newnode = new Node(data);
			newnode.next = head;
			head = newnode;
		}
	}
	
	Node pop()
	{
		if(head==null)
		{
			System.out.println("Empty Stack");
			return null;
		}
		else
		{
			Node temp = head;
			head = head.next;
			return temp;
		}
	}
	
	Node peek()
	{
		return head;
	}
	
	boolean isEmpty()
	{
		return head==null;
	}
	
	void displayList()
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
	
	public static void main(String args[])
	{
		StackLinkedList list = new StackLinkedList();
		System.out.println("Entering new  data in stack");
		list.push(10);
		list.push(50);
		list.push(20);
		list.push(60);
		list.push(100);
		System.out.println("Displaying stack");
		list.displayList();
		System.out.println("Removing two element from stack");
		System.out.println(list.pop().data);
		System.out.println(list.pop().data);
		System.out.println("Displaying stack");
		list.displayList();
	}
	
}