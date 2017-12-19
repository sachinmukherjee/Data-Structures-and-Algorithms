import java.util.Iterator;
import java.util.PriorityQueue;



class Edge implements Comparable
{
	private int startingPoint;
	private int endPoint;
	private float weight;

	public Edge(int startingPoint, int endPoint, float weight)
	{
		this.startingPoint = startingPoint;
		this.endPoint = endPoint;
		this.weight = weight;
	}

	public int getStartingPoint()
	{
		return startingPoint;
	}

	public int getEndPoint()
	{
		return endPoint;
	}

	public float getWeight()
	{
		return weight;
	}

	public boolean equals(Edge other)
	{
		if(this.startingPoint == other.startingPoint)
			if(this.endPoint == other.endPoint)
				return true;

		return false;
	}

	public int compareTo(Object o)
	{
		Edge other = (Edge) o;
		return Double.compare(this.weight, other.weight);
	}

	public String toString()
	{
		return startingPoint + " - "+endPoint+"("+weight+")";
	}

}

class Graph
{
	private int vCount;
	private PriorityQueue<Edge>[] adj;

	public int getvCount()
	{
		return vCount;
	} 

	public Graph(int vCount)
	{
		this.vCount = vCount;
		adj = new PriorityQueue[vCount];
		for(int i=0; i<vCount; i++)
		{
			adj[i] = new PriorityQueue<Edge>();
		}
	}

	public void addEdge(int i,int j, float weight)
	{
		adj[i].add(new Edge(i,j,weight));
	}

	public void addEdge(Edge e)
	{
		adj[e.getStartingPoint()].add(e);
	}

	public void removeEdge(int i, int j)
	{
		Iterator<Edge> it = adj[i].iterator();
		Edge other = new Edge(i,j,0);
		while(it.hasNext())
		{
			if(it.next().equals(other))
			{
				it.remove();
				return;
			}
		}
	}

	public boolean hasEdge(Edge e)
	{
		return adj[e.getStartingPoint()].contains(e);
	}

	public PriorityQueue<Edge> neighbours(int vertex)
	{
		return adj[vertex];
	}

	public void printGraph()
	{
		for(int i=0; i<vCount; i++)
		{
			PriorityQueue<Edge> edges = neighbours(i);
			Iterator<Edge> it = edges.iterator();
			System.out.print(i+":");
			for(int j=0;j<edges.size();j++)
			{
				System.out.print(it.next()+" ");
			}
			System.out.println();
		}
	}

	public static void bellmanFord(Graph g, int startVertex)
	{
		//for storing distances
		float[] distances = new float[g.getvCount()];

		//for storing predecessors
		int predecessors[] = new int[g.getvCount()];

		//initializing arrays
		for(int i=0; i<distances.length; i++)
		{
			distances[i] = Float.MAX_VALUE;
			predecessors[i] =-1;
		}
		distances[startVertex] = 0;

		//relax all edges  v-1 times repeadely
		for(int i=1;i<g.getvCount()-1;i++)
		{
			for(int j=0;j<g.getvCount()-1;j++)
			{
				Iterator<Edge> it = g.neighbours(j).iterator();
				while(it.hasNext())
				{
					Edge e = it.next();      //edge(u,v)
					// if dist(u)+w(u,v) < dist(v) then
					//dist(v) = dist(u)+w(u,v)
					//pred(v) = u
					if(distances[e.getStartingPoint()] + e.getWeight() < distances[e.getEndPoint()])
					{
						distances[e.getEndPoint()] = distances[e.getStartingPoint()] + e.getWeight();
						predecessors[e.getEndPoint()] = e.getStartingPoint();
					}

				}
			}
		}

		// check for negative weight circles
		for(int i=0; i<g.getvCount()-1;i++)
		{
			Iterator<Edge> it = g.neighbours(i).iterator();
			while(it.hasNext())
			{
				Edge e = it.next();   //edge(u,v)
				//if dist(u) + w(u,v) < dist(v) then
				// graph contains negative weight circles
				if(distances[e.getStartingPoint()] + e.getWeight() < distances[e.getEndPoint()])
				{
					System.out.println("Graph contains negative weight cycles");
					return;
				}
			}
		}
		//print final shortes path
		System.out.println("Vertex\t Distance\tPredecessor");
		for(int i=0; i<g.getvCount();i++)
		{
			System.out.println(i+"\t"+distances[i]+"\t\t"+predecessors[i]);
		}
	}


}

public class BellmanFord
{
	public static void main(String args[])
	{
		Graph g = new Graph(5);
     	g.addEdge(0, 1, 5.2f);
        g.addEdge(0, 3, 12.8f);
        g.addEdge(0, 2, 10.3f);
        g.addEdge(1, 3, 5.9f);
        g.addEdge(1, 4, 15.2f);
        g.addEdge(2, 1, 1.5f);
        g.addEdge(2, 3, 2.3f);
        g.addEdge(3, 4, 8.5f);
        g.addEdge(4, 2, 2.7f);
 

        g.printGraph();

        System.out.println("BellmanFord Shortest Path");

        g.bellmanFord(g,0);


          System.out.println("\nNew graph with negative weight circle!");
       
        Graph g2 = new Graph(8);
 
        System.out.println("Graph:");
        // add Edges
        g2.addEdge(0, 1, 4);
        g2.addEdge(0, 2, 4);
        // 1 nowhere
        g2.addEdge(2, 4, 4);
        g2.addEdge(2, 5, -2);
        g2.addEdge(3, 0, 3);
        g2.addEdge(3, 2, 2);
        g2.addEdge(4, 3, 1);
        g2.addEdge(4, 6, -2); // *
        g2.addEdge(5, 1, 3);
        g2.addEdge(5, 4, -3);
        g2.addEdge(6, 5, 2);
        g2.addEdge(6, 7, 2); // *
        g2.addEdge(7, 4, -2); //*
        // *part of a negative-weight circle -2 + 2 - 2 = -2 < 0
 
        // print Graph
        g2.printGraph();
 
        // Bellman-Ford Shortest Path Algorithm
        System.out.println("Bellman-Ford Shortest Path:");
        g2.bellmanFord(g2, 0);    

	}
}