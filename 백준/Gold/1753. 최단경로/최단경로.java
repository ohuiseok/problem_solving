import java.io.*;
import java.util.*;

public class Main {


	static Graph graph;
	
	static class Graph {

		static int N;	// 노드 수
		static List<Node>[] node;
		static int[] dist;
		
		public Graph(int N) {
			this.N = N;
			
			node = new List[N+1];
			for(int i=0;i<N+1;i++)
				node[i] = new ArrayList<Node>();

			dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
		}
		
		public static void dijkstra(int start) {
			PriorityQueue<Node> queue = new PriorityQueue<>();
			boolean[] check = new boolean[N + 1];
			queue.add(new Node(start, 0));

			dist[start] = 0;
			
			while (!queue.isEmpty()) {
				Node curNode = queue.poll();
				int cur = curNode.end;

				if (check[cur] == true)
					continue;
				check[cur] = true;

				for (Node node : graph.node[cur]) {
					if (dist[node.end] > dist[cur] + node.weight) {
						dist[node.end] = dist[cur] + node.weight;
						queue.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}

		public static void result() {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i <= N; i++) {
				if (dist[i] == Integer.MAX_VALUE)
					sb.append("INF\n");
				else
					sb.append(dist[i]).append("\n");
			}
			System.out.println(sb.toString());
		}
		
	}
	
	static class Node implements Comparable<Node> {
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			if (this.weight == o.weight)
				return 0;
			return this.weight < o.weight ? -1 : 1;
		}
		
		
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		
		graph = new Graph(N);

		// 리스트에 그래프 정보를 초기화
		for (int i = 0; i < end; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// start에서 end로 가는 weight 가중치
			graph.node[from].add(new Node(to, weight));
		}

		graph.dijkstra(start);
		graph.result();

		br.close();
	}

}