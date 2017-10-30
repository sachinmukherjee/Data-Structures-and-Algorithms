/* Implementation of Bredth First Search using Adjacent Arrays */

// Queue for first in first out
class Queue
{
  final int SIZE = 20;
  int[] array;
  int front;
  int rear;

  Queue()
  {
    array = new int[SIZE];
    front = 0;
    rear = -1;
  }

  void insert(int j)
  {
    if(rear==SIZE-1)
        rear = -1;
    array[++rear] = j;
  }

  int remove()
  {
    int temp = array[front++];
    if(front==SIZE)
        front = 0;
    return temp;
  }

  boolean isEmpty()
  {
    return(rear+1==front || front+SIZE-1 == rear);
  }
}

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

class BredthFirstSearch
{
  final int MAX_VERTEX = 20;
  Vertex[] vertexlist;
  int adjMat[][];
  int nVertex;
  Queue thequeue;

  BredthFirstSearch()
  {
    vertexlist = new Vertex[MAX_VERTEX];
    adjMat = new int[MAX_VERTEX][MAX_VERTEX];
    nVertex = 0;
    for(int i=0; i<MAX_VERTEX; i++)
        for(int j=0; j<MAX_VERTEX; j++)
              adjMat[i][j]=0;
    thequeue = new Queue();
  }

  void addVertex(char lab)
  {
    vertexlist[nVertex++] = new Vertex(lab);
  }

  void addEdge(int start, int end)
  {
    adjMat[start][end] = 1;
    adjMat[end][start] = 1;
  }

  void displayVertex(int v)
  {
    System.out.println(vertexlist[v].label);
  }

  int getAdjUnvisitedVertex(int v)
  {
    for(int j=0; j<MAX_VERTEX; j++)
        if(adjMat[v][j] == 1 && vertexlist[j].wasVisited == false)
            return j;
    return -1;
  }

  void bredthFirstSearch()
  {
    vertexlist[0].wasVisited = true;        // start from first
    displayVertex(0);                       // display it
    thequeue.insert(0);                     //insert it
    int v2;
    while(! thequeue.isEmpty())             // run untill the queue is not empty
    {
      int v = thequeue.remove();            // remove the top most element from the queue
      while((v2 = getAdjUnvisitedVertex(v))!=-1)      // run the loop utill all the adjacent vertex are processed
      {
        vertexlist[v2].wasVisited = true;     // mark it as true
        displayVertex(v2);                    // display it
        thequeue.insert(v2);                  // insert it
      }
    }
  }

  public static void main(String args[])
  {
    BredthFirstSearch graph = new BredthFirstSearch();
    graph.addVertex('A');
    graph.addVertex('B');
    graph.addVertex('C');
    graph.addVertex('D');
    graph.addVertex('E');

    graph.addEdge(0,1);
    graph.addEdge(1,2);
    graph.addEdge(0,3);
    graph.addEdge(3,4);
    System.out.println("Calling bredthFirstSearch");
    graph.bredthFirstSearch();
  }
}
