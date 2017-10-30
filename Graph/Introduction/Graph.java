/* Implementation of Graph */
/* Adjacent Matrix */

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

class Graph
{
  final int MAX_VERTEX = 20;
  Vertex vertexlist[] = new Vertex[MAX_VERTEX];
  int adjMat[][] = new int[MAX_VERTEX][MAX_VERTEX];
  int nVertex = 0;

  Graph()
  {
    for(int i=0; i<MAX_VERTEX; i++)
      for(int j=0; j<MAX_VERTEX; j++)
          adjMat[i][j] = 0;
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

  public static void main(String args[])
  {
    Graph graph = new Graph();
    graph.addVertex('A');
    graph.addVertex('B');
    graph.addVertex('C');
    graph.addEdge(0,1);
    graph.addEdge(1,2);
    graph.displayVertex(1);
  }
}
