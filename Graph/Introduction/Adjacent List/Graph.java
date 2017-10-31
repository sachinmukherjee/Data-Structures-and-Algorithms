/* Implementation of Graph using Adjacent List */

import java.util.LinkedList;
class Graph
{
  int v;        // Number of vertices
  LinkedList<Integer> adjListArray[];         // LinkedList for each vertices
  Graph(int v)
  {
    this.v = v;
    adjListArray = new LinkedList[v];
    for(int i=0; i<v; i++)
        adjListArray[i] = new LinkedList<>();       // creating a LinkedList object for each vertex
  }

// add vertex to each source vertex
  void addEdge(int source, int destination)
  {
    adjListArray[source].addFirst(destination);         // add vertex to each source vertex
    adjListArray[destination].addFirst(source);
  }

  void printGraph()
  {
    for (int i=0; i<v; i++)                     //for each vertex in array
    {
      for(Integer pCrawl: adjListArray[i])      // for each vertex in array it connected List
        {
          System.out.print("-->"+ pCrawl);
        }
        System.out.println("");
    }

  }

  public static void main(String args[])
  {
    int v = 5;
    Graph grp = new Graph(v);
    grp.addEdge(0,1);
    grp.addEdge(0,4);
    grp.addEdge(1,2);
    grp.addEdge(1,3);
    grp.addEdge(1,4);
    grp.addEdge(2,3);
    grp.addEdge(3,4);
    grp.printGraph();

  }
}
