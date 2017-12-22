import java.util.*;

public class Kruskal 
{
	static class EDGE implements Comparable<EDGE>
	{
		char from,to;
		int weight;
		EDGE(char f, char t, int w)
		{
			from = f;
			to = t;
			weight = w;
		}

		@Override 
		public int compareTo(EDGE o)
		{
			return weight<o.weight?-1:(weight>o.weight?1:0);
		}

		@Override
		public String toString()
		{
			return "["+from+", "+to+"]";
		}
	}

	private static Map<Character, Character> PARENT;
	private static Map<Character, Integer> RANKS;

	public static void initialize(char[] universe)
	{
		PARENT = new HashMap<>();
		RANKS = new HashMap<>();
		for(char x:universe)
		{
			PARENT.put(x,x);
			RANKS.put(x,1);
		}
	}

	public static char FindSet(char item)
	{
		char parent = PARENT.get(item);
		if(parent == item)
			return item;
		else
			return FindSet(parent);
	}

	public static void Union(char SetA, char SetB)
	{
		char pA, pB;
		while((pA = PARENT.get(SetA)) != SetA)
		{
			SetA = pA;
		}
		while((pB = PARENT.get(SetB)) != SetB)
		{
			SetB = pB;
		}

		int rankFirst = RANKS.get(SetA);
		int rankSecond = RANKS.get(SetB);

		if(rankFirst > rankSecond)
		{
			PARENT.put(SetB, SetA);
			updateRankUpward(SetB);
		}
		else if(rankSecond > rankFirst)
		{
			PARENT.put(SetA, SetB);
			updateRankUpward(SetA);
		}
		else
		{
			PARENT.put(SetB,SetA);
			updateRankUpward(SetB);
		}
	}

	public static void updateRankUpward(char current)
	{
		int currentDepth = RANKS.get(current);
		char currentsParent = PARENT.get(current);
		int parentsDepth = RANKS.get(currentsParent);
		if(! (currentDepth<parentsDepth || currentsParent == current))
		{
			RANKS.put(currentsParent, currentDepth+1);
			updateRankUpward(currentsParent);
		}
	}

	public static void main(String[] args) 
	{
		  char[] vertices = new char[]{'a','b','c','d','e','f','g','h','i'}; 
        EDGE[] edges = new EDGE[14];
        edges[0] = new EDGE('a','b',4);
        edges[1] = new EDGE('a','h',8);
        edges[2] = new EDGE('b','h',11);
        edges[3] = new EDGE('b','c',8);
        edges[4] = new EDGE('h','g',1);
        edges[5] = new EDGE('h','i',7);
        edges[6] = new EDGE('c','i',2);
        edges[7] = new EDGE('i','g',6);
        edges[8] = new EDGE('g','f',2);
        edges[9] = new EDGE('f','c',4);
        edges[10] = new EDGE('c','d',7);
        edges[11] = new EDGE('f','d',14);
        edges[12] = new EDGE('f','e',10);
        edges[13] = new EDGE('d','e',9);

        Kruskal(vertices, edges);


	}

	public static ArrayList<EDGE> Kruskal(char[] vertices, EDGE[] edges)
	{
		ArrayList<EDGE> mst = new ArrayList<>();
		initialize(vertices);
		Arrays.sort(edges);

		for (EDGE edge : edges)
		{
			if(FindSet(edge.from) != FindSet(edge.to))
			{
				mst.add(edge);
				Union(edge.from, edge.to);
			}	
		}

		System.out.println("MST contains the edges: "+mst);
		return mst;
	}
}