// Implementation of Heaps in java simple implementation in java simply showing result
// created by sachinmukherjee
// sachinmukherjee29@gmail.com

class Node
{
	int data;

	Node()
	{
		this.data = data;
	}
}

class Heaps
{
	Node heaps[] = new Node[100];
	int count;
	int capacity = 100;

	int leftChild(int index)
	{
		int leftchild = 2*index+1;
		if(leftchild>capacity-1)
			return -1;
		else 
			return leftchild;
	}

	int rightChild(int index)
	{
		int rightchild = 2*index+2;
		if(rightchild>capacity-1)
			return -1;
		else
			return rightchild;
	}

	int maximum()
	{
		if(count==0)
			return -1;
		else
		 return heaps[0].data;
	}

	int minimum()
	{
		if(count==0)
			return -1;
		else
			return heaps[0].data;
	}

	public static void main(String args[])
	{
		Heaps heap = new Heaps();
		System.out.println("Leftchild ");
		if(heap.leftChild(1) == -1)
			System.out.println("No leftchild");
		else 
			System.out.println(heap.leftChild(1));

		if(heap.rightChild(2)==-1)
			System.out.println("No rightchild");
		else
			System.out.println(heap.rightChild(2));
		

	}
}