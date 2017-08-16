// Implementation of finding maximum and minimum in a binary search tree
// created by sachin mukherjee
// sachinmukherjee29@gmail.com

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

class MaxMin
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

	void Max()
	{
		if(root==null)
			System.out.println("Empty Tree");
		else
		{
			Node current = root;
			Node previous = current;
			while(current!=null)
			{
				previous = current;
				current = current.rightchild;
			}
			System.out.println(previous.data);
		}
	}

	void Min()
	{
		if(root==null)
			System.out.println("Empty Tree");
		else
		{
			Node current = root;
			Node previous = current;
			while(current!=null)
			{
				previous = current;
				current = current.leftchild;
			}
			System.out.println(previous.data);
		}
	}

	public static void main(String args[])
	{
		MaxMin maxmin = new MaxMin();
		maxmin.insertion(120);
		maxmin.insertion(80);
		maxmin.insertion(500);
		maxmin.insertion(150);
		maxmin.insertion(200);
		System.out.println("Displaying Maximum element");
		maxmin.Max();
		System.out.println("Displaing minimum element");
		maxmin.Min();

	}
}