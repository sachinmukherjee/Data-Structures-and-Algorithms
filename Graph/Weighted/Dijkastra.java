import java.util.*;

class Vertex implements Comparable<Vertex>
{
	public final String name;						// Name of vertex
	public ArrayList<Edge> neighbours;				// Neighbours of vertex
	public LinkedList<Vertex> path;					// path of vertex
	public double minDistance = Double.POSITIVE_INFINITY;		//maximum distance
	public Vertex previous;							//previous vertex

	public int compareTo(Vertex other)
	{
		return Double.compare(minDistance, other.minDistance);	// comparing distance of two vertex
	}

	public Vertex(String name)				// creating vertex
	{
		this.name = name;					//name
		neighbours = new ArrayList<Edge>();	// neighbours
		path = new LinkedList<Vertex>();	// path
	}

	public String toString()
	{
		return name;
	}
}

class Edge
{
	public final Vertex target;					// target node
	public final double weight;					// distance between source and node
	
	public Edge(Vertex target, double weight)
	{
		this.target = target;
		this.weight = weight;
	}
}

class Graph
{
	private ArrayList<Vertex> vertices;
	
	public Graph(int numberVertices)
	{
		vertices = new ArrayList<Vertex>(numberVertices);
		for(int i=0; i<numberVertices; i++)
		{
			vertices.add(new Vertex("V"+Integer.toString(i)));
		}
	}

	public void addEdge(int src, int dest, int weight)
	{
		Vertex s = vertices.get(src);
		Edge new_edge = new Edge(vertices.get(dest), weight);			//vertices.get is the returning vertex from arraylist
		s.neighbours.add(new_edge);
	}

	// returning the arraylist of vertex that we declared int the Graph Class
	public ArrayList<Vertex> getVertices()
	{
		return vertices;
	}

	public Vertex getVertex(int vert)
	{
		return vertices.get(vert);
	}
}

public class Dijkastra
{
	public static void main(String args[])
	{
		Dijkastra obj = new Dijkastra();
		Graph g = new Graph(9);

		g.addEdge(0, 1, 4); 
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 1, 8);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 2, 7);
		g.addEdge(3, 5, 14);
		g.addEdge(3, 4, 9); 
		g.addEdge(4, 3, 9);
		g.addEdge(4, 5, 10); 
		g.addEdge(5, 4, 10);
		g.addEdge(5, 3, 9);
		g.addEdge(5, 2, 4); 
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(6, 5, 2);
		g.addEdge(7, 0, 8);
		g.addEdge(7, 8, 7); 
		g.addEdge(7, 1, 11);
		g.addEdge(7, 6, 1);
		g.addEdge(8, 2, 2); 
		g.addEdge(8, 7, 7);
		g.addEdge(8, 6, 6);

		obj.calculate(g.getVertex(0));

		for(Vertex v: g.getVertices())				//all the vertices object
		{
			System.out.print("Vertex - "+v+" , Dist - "+v.minDistance+" , Path - ");
			for(Vertex pathvert: v.path)
			{
				System.out.print(pathvert+ " ");
			}
			System.out.println(""+v);
		}
}
		void calculate(Vertex source)
		{
			source.minDistance = 0;
			PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
			queue.add(source);

			while(!queue.isEmpty())
			{
				Vertex u = queue.poll();

				for(Edge neighbour: u.neighbours)
				{
					Double newDist = u.minDistance + neighbour.weight;

					if(neighbour.target.minDistance > newDist)
					{
						//Remove the node from the queue to update the distance value
						queue.remove(neighbour.target);
						neighbour.target.minDistance = newDist;

						//Take the path visited till now and add the new node s
						neighbour.target.path = new LinkedList<Vertex>(u.path);
						neighbour.target.path.add(u);

						//Re enter the node with new distance
						queue.add(neighbour.target);
					}
				}
			}
		}
	}
