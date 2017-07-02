class Stack
{
	int top;
	int stackarray[] = new int[20];

	Stack()
	{
		top=-1;
	}

	void push(int element)
	{
		stackarray[++top]= element;
	}

	int pop()
	{
		return stackarray[top--];
	}

	int peek()
	{
		return stackarray[top];
	}

	boolean isEmpty()
	{
		return top ==-1;
	}
}
class Vertex
{
	char label;
	boolean wasVisited;

	Vertex(char label)
	{
		this.label = label;
		wasVisited=false;
	}
}

class DepthFirstSearch
{
	static final int MAX_VERTEX=20;
	int numVertex;
	Vertex vertexlist[];
	int adjMat[][];

	DepthFirstSearch()
	{
		vertexlist = new Vertex[MAX_VERTEX];
		adjMat = new int[MAX_VERTEX][MAX_VERTEX];
	}

	void addVertex(char label)
	{
		vertexlist[numVertex++] = new Vertex(label);
		
	}

	void addEdge(int start, int end)
	{
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}

	void displayVertex(int vertex)
	{
		System.out.println(vertexlist[vertex].label);
	}

	int getAdjVertex(int v)
	{
		for(int i=0;i<numVertex;i++)
			if(adjMat[v][i]==1 && vertexlist[i].wasVisited==false)
				return i;
			else
				return -1;
	}

	void depthFirstSearch()
	{
		vertexlist[0].wasVisited=true;							//start from first vertex
		displayVertex(0);										// display it
		Stack thestack = new Stack();							
		thestack.push(0);										// push it into stack

		while(!thestack.isEmpty())								// process untill the stack is empty
		{
			int v = getAdjVertex(thestack.peek());				// get unvisited vertex of the top element of the stack
			if(v==-1)											// if it returns -1 means it already visited or no adjacent vertex
				thestack.pop();									// so remove the top most element of the stack
			else 
			{
				vertexlist[v].wasVisited=true;					// else mark it as visited
				displayVertex(v);								// display it
				thestack.push(v);								// push it into the stack
			}


		}

	}


	public static void main(String[] args) 
	{
		DepthFirstSearch depth = new DepthFirstSearch();
		depth.addVertex('A');
		depth.addVertex('B');
		depth.addVertex('C');
		depth.addEdge(1,2);
		depth.addEdge(2,3);
		depth.displayVertex(1);		
	}


}