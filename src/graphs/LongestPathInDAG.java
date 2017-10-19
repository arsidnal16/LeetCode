package graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class LongestPathInDAG {

	/*
	 * Points to Remember(From my experience):- 
	 * 1) When the graph is strictly a DAG, the first step would be to think of a topological sorting as almost every
	 * "solvable" DAG question requires a topological sorting. 
	 * 2) Never ever think of a topological sorting when the graph is not a DAG. Topological sorting
	 * becomes useless for graphs with cycles.
	 */

	public class Pair {
		// v--adjacent vertex
		// w--weight associated with edge to v
		int v, w;

		public Pair(int adjVertex, int weight) {
			v = adjVertex;
			w = weight;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestPathInDAG test = new LongestPathInDAG();
		LinkedList<Pair>[] edges = new LinkedList[6];
		for (int i = 0; i < 6; i++)
			edges[i] = new LinkedList<Pair>();
		edges[0].add(test.new Pair(1, 5));
		edges[0].add(test.new Pair(2, 3));
		edges[1].add(test.new Pair(3, 6));
		edges[1].add(test.new Pair(2, 2));
		edges[2].add(test.new Pair(4, 4));
		edges[2].add(test.new Pair(5, 2));
		edges[2].add(test.new Pair(3, 7));
		edges[3].add(test.new Pair(5, 1));
		edges[3].add(test.new Pair(4, -1));
		edges[4].add(test.new Pair(5, -2));
		int source = 1;
		LinkedList<Integer> sortedOrder = test.topologicSorting(edges);
		int[] distance = new int[6];
		Arrays.fill(distance, Integer.MIN_VALUE);
		distance[source] = 0;
		// for every vertex in topological order
		for (int currentVertex : sortedOrder) {
			for (Pair adj : edges[currentVertex]) {
				// if distance of adjacent vertex from source(distance[currentVertex]+adj.w) is
				// greater than previously evaluated distance
				if (distance[adj.v] == Integer.MIN_VALUE || distance[adj.v] < distance[currentVertex] + adj.w) {
					distance[adj.v] = distance[currentVertex] + adj.w;
				}
			}
		}
		// printing the longest distance from source in natural ordering of vetices from
		// 0-V
		for (int dist : distance) {
			System.out.print(dist == Integer.MIN_VALUE ? "NotReachable " : dist + " ");
		}
		System.out.println();
	}

	// takes adjacency list of a directed acyclic graph(DAG) as input
	// returns a linkedlist which consists the vertices in topological order
	public LinkedList<Integer> topologicSorting(LinkedList<Pair>[] edges) {
		// v---numOfVertices
		int v = edges.length;
		boolean[] visited = new boolean[v];
		LinkedList<Integer> result = new LinkedList<Integer>();
		// loop is for making sure that every vertex is visited since if we select only
		// one random source
		// all vertices might not be reachable from this source
		// eg:1->2->3,1->3 and if we select 3 as source first then no vertex can be
		// visited ofcourse except for 3
		for (int i = 0; i < v; i++) {
			if (visited[i])
				continue;
			topoSortHelper(edges, i, visited, result);
		}
		return result;
	}

	private void topoSortHelper(LinkedList<Pair>[] edges, int src, boolean[] visited, LinkedList<Integer> result) {
		for (Pair adj : edges[src]) {
			// skipping through if already visited
			if (visited[adj.v])
				continue;
			topoSortHelper(edges, adj.v, visited, result);
		}
		// making the vertex visited for future reference
		visited[src] = true;
		// pushing to the stack as departing
		result.addFirst(src);
	}

}
