// Graph representation using adjacent list

import java.util.*;
class Graph1
{
	int v;
	LinkedList<Integer> adjacent[];

	Graph(int v)
	{
		this.v = v;
		// Number of vertices for graph
		adjacent = new LinkedList[v];

		// create a new list for each vertex
		// such that adjacent vertex can be stored
		for(int i=0; i<v; i++)
			adjacent[i] = new LinkedList<>();
	}


}