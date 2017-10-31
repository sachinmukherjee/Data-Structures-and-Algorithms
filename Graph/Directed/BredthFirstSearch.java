/* Implementation of BredthFirstSearch using Adjacent List */

import java.util.*;
class BredthFirstSearch
{
  int v;
  LinkedList<Integer> adj[];             // Nodes for storing vertex

  BredthFirstSearch(int v)
  {
    this.v = v;
    adj = new LinkedList[v];
    for(int i=0; i<v; i++)
        adj[i] = new LinkedList();       // for each index in array create a List object
  }

  void addEdge(int start, int end)
  {
    adj[start].add(end);                // add edge
  }

  void bredthFirstSearch(int source)
  {
    boolean visited[] = new boolean[v];           // marker for keeping track whether node has been visited or not
    LinkedList<Integer> queue = new LinkedList<Integer>();      // created a queue
    visited[source] = true;                 // mark the source vertex as visited
    queue.add(source);                      // add it into queue
    while(queue.size()!=0)                  // process unitll the queue is empty
    {
      int s = queue.poll();               // remove first element from queue
      System.out.println(s);              // print it

      Iterator<Integer> i = adj[s].listIterator();      // iterator for iterating all the connected vertex
      while(i.hasNext())        // process unitll it has vertex
      {
        int n = i.next();     // pull out the next vertex
        if(!visited[n])       // check in visited array if it is visited or not
        {
          visited[n] = true;    // if visited mark it as visited
          queue.add(n);         // add it into queue
        }
      }
    }
  }

  public static void main(String args[])
  {
    BredthFirstSearch graph = new BredthFirstSearch(4);
    graph.addEdge(0,1);
    graph.addEdge(0,2);
    graph.addEdge(1,2);
    graph.addEdge(2,0);
    graph.addEdge(2,3);
    graph.addEdge(3,3);
    graph.bredthFirstSearch(2);
  }
}
