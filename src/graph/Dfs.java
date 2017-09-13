package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Dfs {
		
		public class GraphNode{
			private int v;  //no. of vertices
			private LinkedList<Integer> adj[];  //adj list
			
			public GraphNode(int v) {
				this.v = v;
				adj = new LinkedList[v];
				for(int i=0; i<v;i++) {
					adj[i] = new LinkedList<>();
				}
				
			}
		
		}
		
		
		
		
		
		
		public void BFS(int s, int V) {
			
			boolean[] visited = new boolean[V];
			
			LinkedList<Integer> queue = new LinkedList<Integer>();
			
			visited[s] = true;
			
			queue.add(s);
			
			while(!queue.isEmpty()) {
				s = queue.poll();
				
				int child = getChildNodes(s);
				
				if(visited[child] != false)
					visited[child] = true;
					queue.add(child);
			}
			
			
			
		}
		
		
		
	


}
