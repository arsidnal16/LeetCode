package graphs;
import java.util.LinkedList;
public class TransitiveClosure
{
	int V; // No. of vertices
	boolean [][]tc; // To store transitive closure
	LinkedList<Integer> adj[]; // array of adjacency lists
	public TransitiveClosure(int V){
	this.V = V;
	adj = new LinkedList[V];

	tc = new boolean[V][V];
	for (int i=0; i<V; i++)
	{
		tc[i] = new boolean[V];
		adj[i] = new LinkedList<Integer>();
		for(int j =0 ;j < V; j++)
		    tc[i][j] = false;
	}
}

	// function to add an edge to graph
	public void addEdge(int v, int w) { adj[v].addLast(w); }

	// prints transitive closure matrix
	public void transitiveClosure(){
	// Call the recursive helper function to print DFS
	// traversal starting from all vertices one by one
	for (int i = 0; i < V; i++)
		DFSUtil(i, i); // Every vertex is reachable from self.

	for (int i=0; i<V; i++)
	{
		for (int j=0; j<V; j++)
			System.out.print( tc[i][j] + " ");
		System.out.println();
	}
}


public void DFSUtil(int s, int v)
{
	// Mark reachability from s to t as true.
	tc[s][v] = true;
	for (Integer i : adj[v])
		if (tc[s][i] == false)
			DFSUtil(s, i);
}
public static void main(String[] args)
{
	// Create a graph given in the above diagram
	TransitiveClosure g = new TransitiveClosure(4);
	g.addEdge(0, 1);
	g.addEdge(0, 2);
	g.addEdge(1, 2);
	g.addEdge(2, 0);
	g.addEdge(2, 3);
	g.addEdge(3, 3);

	System.out.println( "Transitive closure matrix is ");
	g.transitiveClosure();

	
}
}