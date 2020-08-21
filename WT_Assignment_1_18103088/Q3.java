import java.util.*; 
 
class question3 
{ 
	class Edge 
	{ 
		int strt, end, wt; 
		Edge() 
		{ 
			strt = 0;
			end = 0;
			wt = 0; 
		} 
	}; 

	int V, E; 
	Edge edge[]; 

	question3(int v, int e) 
	{ 
		V = v; 
		E = e; 
		edge = new Edge[e]; 
		for (int i = 0; i < e; ++i) 
			edge[i] = new Edge(); 
	} 
	
	void BellmanFord(question3 graph, int strt) 
	{ 
		int V = graph.V, E = graph.E; 
		int dist[] = new int[V]; 

		for (int i = 0; i < V; ++i) 
			dist[i] = Integer.MAX_VALUE; 
		dist[strt] = 0; 

		for (int i = 1; i < V; ++i) 
		{ 
			for (int j = 0; j < E; ++j) 
			{ 
				int u = graph.edge[j].strt; 
				int v = graph.edge[j].end; 
				int wt = graph.edge[j].wt; 
				if (dist[u]!= Integer.MAX_VALUE && dist[u]+wt<dist[v])
				{
					dist[v]=dist[u]+wt;
				}
			} 
		} 

		for (int j = 0; j < E; ++j) 
		{ 
			int u = graph.edge[j].strt; 
			int v = graph.edge[j].end; 
			int wt = graph.edge[j].wt; 
			if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) 
			{ 
				System.out.println("Negative cycles Exist"); 
				return; 
			} 
		} 
		printArr(dist, V); 
	} 

	void printArr(int dist[], int V) 
	{ 
		System.out.println("Distance of vertex from Source"); 
		for (int i = 0; i < V; ++i) 
			System.out.println(i + "\t\t" + dist[i]); 
	} 

	public static void main(String[] args) 
	{ 
		Scanner input=new Scanner(System.in);
		System.out.println("Enter no. of vertices:");
		int V = input.nextInt();
		System.out.println("Enter no. of edges:");
		int E = input.nextInt();  

		question3 graph = new question3(V, E); 
		System.out.println("Enter the source vertex, destination vertex and weight of each edge:");
		for(int i=0;i<E;i++)
		{
			graph.edge[i].strt = input.nextInt(); 
			graph.edge[i].end = input.nextInt(); 
			graph.edge[i].wt = input.nextInt();
		}
		input.close();
		graph.BellmanFord(graph, 0); 
	} 
} 