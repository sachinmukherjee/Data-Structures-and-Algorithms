// Implementation of insertion of element in heaps 
// Maximum Heaps, root must be greater than two children
// created by sachinmukherjee
// sachinmukherjee29@gmail.com

class Node 
{
	int data;

	Node(int data)
	{
		this.data = data;
	}
}

class Heaps
{
	int count = 0;
	int capacity = 100;
	Node heaps[] = new Node[capacity];


	void insert(int data)
	{
		Node newnode = new Node(data);
		if(count==0)
		{
			heaps[0] = new Node(data);
			count++;
		}

		else if(count == capacity-1)
			return;
		else
		{
			heaps[count] = newnode;
			perColateUp(count++);
		}
	}

	void perColateUp(int index)
	{
		Node bottom = heaps[index];
		int parent = (index-1)/2;

		while(index>0 && heaps[parent].data < heaps[index].data)
		{
			heaps[index] = heaps[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		
		
		
		 
	}

	public static void main(String args[])
	{
		Heaps heap = new Heaps();
		heap.insert(100);
		heap.insert(80);
		heap.insert(120);
		heap.insert(70);
		for(int i=0; i<heap.count; i++)
		{
			System.out.println(heap.heaps[i].data);
		}
	}
}