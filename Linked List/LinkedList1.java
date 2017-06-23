/* a java program for linked list insertion 
   * insert at the begin
   * insert at the last
   * insert at the end
   * created by sachin mukherjee
   * sachinmukherjee29@gmail.com
*/
class Node 												// for each node in the linked list
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

class LinkedList1
{
	Node head;

	void insertAtFirst(int data)							
	{

		Node newnode = new Node(data);

		if(head==null)                          // if linked list is empty
		{
			head=newnode;
		}
		else
		{
			newnode.next=head;
			head = newnode;
		}

	}
	void insertAtLast(int data)
	{
		Node newnode = new Node(data);
		if(head==null)
		{
			head=newnode;
		}
		else
		{
			Node current = head;
			Node previous = current;
			while(current!=null)
			{
				previous=current;
				current = current.next;
			}
			previous.next=newnode;
			newnode.next=null;
		}
	}

	void insertAtPosition(int data,int position)
	{
		Node newnode = new Node(data);
		if(head==null)
		{
			head = newnode;
		}

		else if(position==1)
		{
			newnode.next = head;
			head = newnode;
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
			newnode.next=previous.next;
			previous.next=newnode;

		}

	}	
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
	
	public static void main(String[] args) 
	{
		LinkedList1 thelink = new LinkedList1();
		thelink.insertAtFirst(10);
		thelink.insertAtFirst(20);
		thelink.insertAtFirst(25);
		thelink.insertAtPosition(40,2);
		thelink.insertAtPosition(33,1);
		thelink.insertAtFirst(50);
		thelink.insertAtLast(60);
		thelink.displayList();
		
	}
}