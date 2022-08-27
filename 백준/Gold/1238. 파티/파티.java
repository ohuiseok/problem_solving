import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Graph {
		int N;
		List<Node>[] node;
		int[] dist;
		
		public Graph(int N) {
			this.N = N;
			
			dist = new int[N+1];
			
			node = new List[N+1];
			for(int i=0;i<N+1;i++)
				node[i] = new ArrayList<Node>();
		}
		
		public void addNode(int from,int to, int weight) {
			node[from].add(new Node(to,weight));
		}
		
		public int dijkstra(int start, int end) {
			boolean[] isVisited = new boolean[N+1];
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.add(new Node(start,0));
			
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[start] = 0;
			
			while(!pq.isEmpty()) {
				Node curNode = pq.poll();
				
				if(isVisited[curNode.vertex])
					continue;
				isVisited[curNode.vertex] = true;
				
				for(Node nextNode : node[curNode.vertex]) {
					if(dist[nextNode.vertex] > dist[curNode.vertex] + nextNode.weight) {
						dist[nextNode.vertex] = dist[curNode.vertex] + nextNode.weight;
						pq.add(new Node(nextNode.vertex,dist[nextNode.vertex]));
					}
				}
				
				
			}
			
			return dist[end];
		}
	}
	
	static class Node implements Comparable<Node> {
		int vertex,weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] answer = new int[N+1];
		int maxValue = Integer.MIN_VALUE;
		
		Graph graph = new Graph(N);
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			graph.addNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=1;i<=N;i++) {
			answer[i] = graph.dijkstra(i, X);
		}
		graph.dijkstra(X, 1);
		for(int i=1;i<=N;i++) {
			answer[i] += graph.dist[i];
			if(maxValue < answer[i])
				maxValue = answer[i];
		}
		System.out.println(maxValue);
		
	}
}