/* Implementation of ShortestPath in UnWeighted Directed Graph */
import java.util.*;
class ShortestPath
{
  LinkedList<Integer> adj[];
  int V;

  ShortestPath(int V)
  {
    this.V = V;
    adj = new LinkedList[V];
    for(int i=0;i<V;i++)
    {
      adj[i] = new LinkedList();
    }
  }

  void addVertex(int start, int end)
  {
    adj[start].add(end);
  }

  void shortestPath(int source)
  {
    LinkedList<Integer> queue = new LinkedList<Integer>();
    int[] distance = new int[V];
    int [] path = new int[V];
    queue.add(source);
    for(int i=0; i<V; i++)
    {
      distance[i] = -1;
    }
    distance[source] = 0;
    Integer w;
    while(!queue.isEmpty())
    {
      int v = queue.remove();
      Iterator<Integer> i = adj[v].iterator();
      while(i.hasNext())
      {
        w = i.next();
        if(distance[w]==-1)
        {
          distance[w] = distance[v]+1;
          path[w] = v;
          queue.add(w);

        }
      }
    }
    for(int k=0; k<V; k++)
    {
      System.out.println("Vertex "+k+" --- "+" Distance "+distance[k]+" --- "+" Path "+path[k]);
    }
  }

  public static void main(String args[])
  {
    ShortestPath graph = new ShortestPath(7);
    graph.addVertex(0,1);
    graph.addVertex(0,3);
    graph.addVertex(1,3);
    graph.addVertex(1,4);
    graph.addVertex(2,5);
    graph.addVertex(3,5);
    graph.addVertex(3,6);
    graph.addVertex(4,6);
    graph.addVertex(6,5);
    graph.shortestPath(0);
  }

}
