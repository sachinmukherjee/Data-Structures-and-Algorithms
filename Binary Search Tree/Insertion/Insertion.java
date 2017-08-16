// implementation of inserting element into binary search tree
// created by sachin mukherjee
// sachinmukherjee

class Node
{
	int data;
	Node rightchild;
	Node leftchild;

	Node(int data)
	{
		this.data=data;
		rightchild = null;
		leftchild = null;
	}
}

class Insertion
{
	Node root;


	void insertion(int data)
	{
		
		if(root==null)
		{
			Node newnode = new Node(data);
			root = newnode;
		}
		else
		{
			
			Node current = root;
			Node parent = current;
			
			while(true)
			{
				parent = current;
				if(root.data>data)
				{
					current = current.leftchild;
					if(current==null)
					{
						Node newnode = new Node(data);
						parent.leftchild = newnode;
						return;
					}
				}
				else
				{
					current = current.rightchild;
					if(current==null)
					{
						Node newnode = new Node(data);
						parent.rightchild = newnode;
						return;
					}
				}
			}
		}

	}

	void displaydata(Node root)
	{
		if(root==null)
			return;
		else
		{
			displaydata(root.leftchild);
			System.out.println(root.data);
			displaydata(root.rightchild);
		}


	}

	public static void main(String args[])
	{
		Insertion insert = new Insertion();
		insert.insertion(100);
		insert.insertion(120);
		insert.insertion(130);
		insert.insertion(50);
		insert.insertion(80);
		insert.displaydata(insert.root);
	}
}