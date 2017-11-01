/* TopologicalSort implemented using adjacent list (recursive) */

import java.util.*;

class TopologicalSort
{
  LinkedList<Integer> adjMat[];
  int V;
  Stack stack = new Stack();          // for storing topological sort result

  TopologicalSort(int V)
  {
    this.V = V;
    adjMat = new LinkedList[V];
    for(int i=0; i<V; i++)
    {
      adjMat[i] = new LinkedList();
    }
  }

  void addEdge(int start, int end)
  {
    adjMat[start].add(end);
  }

  void topologicalSortUtil(int v, boolean visited[], Stack stack)
  {
      visited[v] = true;          // mark it as visited
      Integer i;

      Iterator<Integer> it = adjMat[v].iterator();      // iterate over connected vertex
      while(it.hasNext())                 // process unitll it has connected vertices
      {
        i = it.next();                  // take one vertices at a time
        if(visited[i]==false)           // if it is unvisited
              topologicalSortUtil(i, visited, stack);     // recursive call to topologicalsort method
      }
      stack.push(new Integer(v));

  }
  void topologicalSort()
  {
    Stack stack = new Stack();
    boolean visited[] = new boolean[V];
    for(int i=0; i<V; i++)
        visited[i] = false;

    for(int j=0; j<V; j++)
      if(visited[j]==false)
          topologicalSortUtil(j, visited, stack);

    while(!stack.isEmpty())
    {
          System.out.print(stack.pop());
    }
  }


  public static void main(String args[])
  {
    TopologicalSort graph = new TopologicalSort(6);
    graph.addEdge(5,2);
    graph.addEdge(5,0);
    graph.addEdge(4,0);
    graph.addEdge(4,1);
    graph.addEdge(2,3);
    graph.addEdge(3,1);
    System.out.println("Now Doing Topological sort");
    graph.topologicalSort();
    //graph.displayTopologicalSortted();
  }
}
