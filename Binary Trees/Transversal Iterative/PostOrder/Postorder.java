// Implementation of postorder transversal algorithm using iterative technique
// created by sachinmukherjee
// sachinmukherjee29@gmail.com

class Node
{
	Node right;
	Node left;
	int data;

	Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}

class Stack
{
	int top1;
	int top2;
	Node stack1 = new Node[20];
	Node stack2 = new Node[20];

	Stack()
	{
		top1 = -1;
		top2 = -1;
	}

	void Push1(Node data1)
	{
		stack1[++top1] = data1;
	}

	void Push2(Node data2)
	{
		stack2[++top2] = data2;
	}

	Node pop1()
	{
		return stack1[top1--];
	}

	Node pop2()
	{
		return stack2[top2--];
	}

	boolean isEmpty1()
	{
		return top1 == 19;
	}

	boolean isEmpty2()
	{
		return top2 == 19;
	}
}

class Postorder
{
	Node root;

	Postorder(int data)
	{
		root = new Node(data);

	}

	postOrder()
	{
		Stack thestack = new Stack();
		while(!thestack.isEmpty1())
		{
			thestack.Push1(root);
			while(!thestack.isEmpty1())
			{
				Node temp = thestack.pop1();
				thestack.Push2();
				thestack.Push1(temp.left);
				thestack.Push1(temp.right);
			}
			Node temp = thestack.pop2();
			System.out.println(temp.data);
		}
		
	}
}