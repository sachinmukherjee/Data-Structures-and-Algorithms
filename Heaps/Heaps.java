// Implementing Maximum Heaps 
class Node
{
	int data;

	Node(int data)
	{
		this.data = data;
	}

	int getData()
	{
		return data;
	}
}
class Heaps
{
	Node[] heaps;							// array of nodes
	int capacity;							// capacity of heaps
	int count = 0;							// count of number of nodes in heaps
	Heaps(int capacity)						
	{										// initiallization 
		this.capacity = capacity;
		heaps = new Node[capacity];
	}

	// calculating left child
	int leftChild(int parent)
	{
		int left = 2*parent+1;
		if(left>=count)
			return -1;
		else
			return left;
	}
	// calculating right child
	int rightChild(int parent)
	{
		int right = 2*parent+2;
		if(right>=count)
			return -1;
		else
			return right;
	}
	// percolate down used for deletion purpose
	void perColateDown(int parent)
	{
		int left,right,max;
		left = leftChild(parent);
		right = rightChild(parent);

		if(left != -1 && heaps[left].data>heaps[parent].data)
			max = left;
		else if(right != -1 && heaps[right].data>heaps[parent].data)
			max = right;
		else 
			max = parent;
		if(max!=parent)
		{
			int temp = heaps[parent].data;
			heaps[parent].data = heaps[max].data;
			heaps[max].data = temp;
		}
		perColateDown(max);
	}

	// percolateup for insertion purpose
	void perColateUp(int count)
	{
		int parent = (count-1)/2;												// calculate parent
		while(parent>-1)														// continue the loop untill parent is greater than -1
		{
			if(heaps[parent].data<heaps[count].data)							// check if parent is smaller than child if yes then swap else break the loop
			{
				System.out.println(heaps[parent].data);
				int temp = heaps[parent].data;
				heaps[parent].data = heaps[count].data;
				heaps[count].data = temp;
				count = parent;
				parent = (parent-1)/2;
			}
			else 
			{
				
				break;
			}
			

		}
	}

	int  insert(int data)
	{
		if(count==capacity)
			return -1;
		else if(count==0)
		{
			Node newnode = new Node(data);
			heaps[count] = newnode;
			count++;
			return 1;


		}
		else
		{
			Node newnode = new Node(data);
			heaps[count] = newnode;
		}

		perColateUp(count++);
		return 1;

	}

	int delete()
	{
		int data;
		if(count==0)
			return -1;
		else
		{
			data = heaps[0].data;
			heaps[0] = heaps[count];
			count--;
			perColateDown(0);
		}
		return data;
	}

	public static void main(String[] args) 
	{
		Heaps heap = new Heaps(20);
		heap.insert(10);
		heap.insert(50);
		heap.insert(20);
		heap.insert(30);
		System.out.println(heap.heaps[2].data);
		
	}

}