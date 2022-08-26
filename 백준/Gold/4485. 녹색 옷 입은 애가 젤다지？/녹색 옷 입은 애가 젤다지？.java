import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static class Graph {
		int N;
		List<Node>[] node;
		int[] dist;

		public Graph(int N) {
			this.N = N + 1;

			node = new List[ (N+1)*(N+1)];
			for (int i = 0; i < (N+1)*(N+1); i++) {
				node[i] = new ArrayList<Node>();
			}

			dist = new int[(N+1)*(N+1)];
			
			Arrays.fill(dist, Integer.MAX_VALUE);
		}

		public void addNode(int from, int to, int weight) {
			node[from].add(new Node(to, weight));
		}
		
		public void dijkstra(int start) {
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.add(new Node(start,0));
			
			boolean[] isVisited = new boolean[(N+1)*(N+1)];
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
		}
		

	}

	static class Node implements Comparable<Node> {
		int vertex, weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (this.weight == o.weight)
				return 0;
			return this.weight < o.weight ? -1 : 1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int problem = 0;

		while (true) {
			problem++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;
			int[][] area = new int[N][N];
			int[][] nodeName = new int[N][N];
			int index=0;
			Graph graph = new Graph(N);

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());	
					nodeName[i][j] = index++;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for(int k=0;k<4;k++) {
						int newR = i+dir[k][0];
						int newC = j+dir[k][1];
						if(newR <0 || newR>=N ||newC<0||newC>=N)
							continue;
						graph.addNode(nodeName[newR][newC],nodeName[i][j],area[i][j]);
					}
				}
			}
			
			graph.dijkstra(0);
			
//			System.out.println(Arrays.toString(graph.dist));
//			System.out.println(graph.dist[index-1]+area[0][0]);
			System.out.printf("Problem %d: %d\n", problem, graph.dist[index-1]+area[0][0]);

		}
		br.close();
	}


}
