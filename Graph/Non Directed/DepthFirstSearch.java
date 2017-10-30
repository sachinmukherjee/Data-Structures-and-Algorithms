/* Implementation of DepthFirstSearch using Adjacent Matrix*/

//Stack class for tracking of last vertex
class Stack
{
  final int SIZE = 30;
  int[] st;
  int top;

  Stack()
  {
    st = new int[SIZE];
    top = -1;
  }

  void push(int j)
  {
    st[++top] = j;
  }

  int pop()
  {
    return st[top--];
  }

  int peek()
  {
    return st[top];
  }
  boolean isEmpty()
  {
    return top==-1;
  }
}

// Vertex class for graph
class Vertex
{
  char label;
  boolean wasVisited;

  Vertex(char label)
  {
    this.label = label;
    wasVisited = false;
  }
}
class DepthFirstSearch
{
  final int MAX_VERTEX = 30;          // Number of vertex in Graph
  Vertex vertexlist[] = new Vertex[30];   // array for holding vertex
  int adjMat[][];                   // for filling edges in that connects vertex
  int nVertex;                      // keep tracking number of vertex
  Stack thestack;

  DepthFirstSearch()
  {
    adjMat = new int[30][30];
    nVertex = 0;
    thestack = new Stack();
    for(int i=0; i<MAX_VERTEX; i++)
        for(int j=0; j<MAX_VERTEX; j++)
            adjMat[i][j] = 0;
  }

  void addVertex(char lab)
  {
    vertexlist[nVertex++] = new Vertex(lab);  // adding vertex in array
  }
  void addEdge(int start, int end)
  {
    adjMat[start][end] = 1;           // connecting each vertex together
    adjMat[end][start] = 1;
  }

  void displayVertex(int v)
  {
    System.out.println(vertexlist[v].label);
  }
  int getAdjUnvisitedVertex(int v)
  {
    for(int j=0; j<MAX_VERTEX; j++)
        if(adjMat[v][j]==1 && vertexlist[j].wasVisited==false)      //it that vertex has unvisited vertex
            return j;   // then return that vetex
        return -1;
  }

  void depthFirstSearch()
  {
    vertexlist[0].wasVisited = true; // start from first, mark it as visited
    displayVertex(0);     // display it
    thestack.push(0);     // push it into stack

    while( !thestack.isEmpty())  // process unitll all vertex are processed i.e stack is not empty
    {
        int v = getAdjUnvisitedVertex(thestack.peek());   //take the vetex from top and find if it has unvisited vertex
        if(v ==-1)    // if it doesnot have then remove it
            thestack.pop();
        else
        {
          vertexlist[v].wasVisited=true;     //else mark it as visited
          displayVertex(v);                   //display it
          thestack.push(v);                   //push it into stack
        }
    }
  }

  public static void main(String args[])
  {
    DepthFirstSearch graph = new DepthFirstSearch();
    graph.addVertex('A');
    graph.addVertex('B');
    graph.addVertex('C');
    graph.addVertex('D');
    graph.addVertex('E');

    graph.addEdge(0,1);
    graph.addEdge(1,2);
    graph.addEdge(0,3);
    graph.addEdge(3,4);
    System.out.println("Calling depthFirstSearch");
    graph.depthFirstSearch();
  }


}
