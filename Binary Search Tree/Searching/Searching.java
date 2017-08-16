// Implementation of seaching algorith for binary search tree
// created by sachin mukherjee
// sachinmukherjee29@gmail.com

class Node
{
	Node leftchild;
	Node rightchild;
	int data;

	Node(int data)
	{
		this.data = data;
		leftchild = null;
		rightchild = null;
	}
}

class Searching
{
	Node root;

	void insertion(int data)
	{
		Node newnode = new Node(data);
		if(root==null)
			root = newnode;
		else
		{
			Node current = root;
			Node previous = current;
			while(true)
			{
				previous = current;
				if(current.data>data)
				{
					current = current.leftchild;
					if(current==null)
					{
						previous.leftchild = newnode;
						return;
					}
				}
				else
				{
					current = current.rightchild;
					if(current==null)
					{
						previous.rightchild = newnode;
						return;
					}
				}

			}
		}

	}

	Node searching(int data)
	{
		if(root==null)
			return null;
		else
		{
			while(root!=null)
			{
				if(root.data==data)
					return root;
				else if(root.data>data)
					root = root.leftchild;
				else
					root = root.rightchild;
			}
		}
		return null;
	}

	public static void main(String[] args) 
	{
		Searching search = new Searching();
		search.insertion(100);
		search.insertion(200);
		search.insertion(300);
		search.insertion(400);
		search.insertion(700);

		Node temp = search.searching(400);
		if(temp==null)
			System.out.println("Data not found");
		else
			System.out.println("Data found "+ temp.data);

		
	}
}