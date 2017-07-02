class Queue
{
	int queuearray[] = new int[20];
	int front=0;
	int rear=-1;
	int nitems;

	void enQueue(int vertex)
	{
		queuearray[++rear]=vertex;
		nitems++;
	}
	int deQueue()
	{
		nitems--;
		return queuearray[front++];
	}

	int displayItem()
	{
		return queuearray[front];
	}

	boolean isEmpty()
	{
		return nitems==0;
	}
}

class Vertex
{
	char label;
	boolean wasVisited;

	Vertex(char label)
	{
		this.label=label;
		wasVisited=false;
	}
}

class BredthFirstSearch
{
	Vertex vertexlist[];
	int adjMat[][];
	static final int MAX_VERTEX=20;
	int numVertex;

	BredthFirstSearch()
	{
		vertexlist = new Vertex[MAX_VERTEX];
		adjMat = new int[MAX_VERTEX][MAX_VERTEX];

	}

	void addVertex(char label)
	{
		vertexlist[numVertex++]= new Vertex(label);

	}

	void adjVertex(int start, int end)
	{
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	int getAdjVertex(int vertex)
	{
		for(int i=0;i<numVertex;i++)
		
			if(adjMat[vertex][i]==1 && vertexlist[i].wasVisited==false)
				return i;
			

			return -1;

	}

	void display(int vertex)
	{
		System.out.println(vertexlist[vertex].label);
	}

	void bredthFirstSearch()
	{
		vertexlist[0].wasVisited=true;									// start from the first
		display(0);														// display that vertex	
		Queue thequeue = new Queue();
		thequeue.enQueue(0);											// move it into queue

		while(!thequeue.isEmpty())										// process untill you process all vertex
		{
			int v1 = thequeue.deQueue();								// remove the top most  element of the queue
			int v2=0;

			// get all the unvisited adjacent vertex from v1
			while((v2=getAdjVertex(v1))!=-1)							// process untill you doesnot get a unvisited vertex
			{
				vertexlist[v2].wasVisited=true;							// mark the unvisited vertex as true
				display(v2);											// display it
				thequeue.enQueue(v2);									// move it into queue
			}
		}

	}

	public static void main(String[] args) 
	{
		BredthFirstSearch thebredth = new BredthFirstSearch();
		thebredth.addVertex('A');
		thebredth.addVertex('B');
		thebredth.addVertex('C');
		thebredth.adjVertex(0,1);
		thebredth.adjVertex(1,2);
		thebredth.bredthFirstSearch();
		
	}

}