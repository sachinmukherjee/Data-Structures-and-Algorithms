/* Implementation of Depth First Search using adjacent list */
import java.util.*;
class DepthFirstSearch
{
  int v;
  LinkedList<Integer> adj[];

  DepthFirstSearch(int v)
  {
    this.v = v;
    adj = new LinkedList[v];
    for(int i=0; i<v; i++)
    {
      adj[i] = new LinkedList();
    }
  }

  void addEdge(int start, int end)
  {
    adj[start].add(end);
  }

  void depthFirstSearch(int source)
  {
    boolean visited[] = new boolean[v];             // marker whether vertex visited or not
    Stack<Integer> stack = new Stack<Integer>();    // stack for keeping track of last entered vertex
    visited[source] = true;                         // mark it as true
    stack.push(source);                             // push it into stack
    while(!stack.empty())                           // process untill stack is empty
    {
      int s = stack.pop();                          // remove the top most element of stack
      System.out.println(s);                        // print it
      Iterator<Integer> i = adj[s].listIterator();   // Iterator for iterating all the connected vertex
      while(i.hasNext())                            // process unitll all the connected vertex
      {
        int n = i.next();                           // take one vertex at a time
        if(!visited[n])                             // if not visited
        {
          visited[n] = true;                        // mark it as visited
          stack.push(n);                            // push it into stack
        }
      }
    }
  }
  public static void main(String args[])
  {
    DepthFirstSearch graph = new DepthFirstSearch(4);
    graph.addEdge(0,1);
    graph.addEdge(0,2);
    graph.addEdge(1,2);
    graph.addEdge(2,0);
    graph.addEdge(2,3);
    graph.addEdge(3,3);
    graph.depthFirstSearch(2);
  }

}
