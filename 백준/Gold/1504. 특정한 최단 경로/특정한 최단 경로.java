import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Graph{
		int N;
		int[] dist;
		List<Node>[] node;
		
		public Graph(int N) {
			this.N = N;
			
			dist = new int[N+1];
			Arrays.fill(dist,200_000_000);
			
			node = new List[N+1];
			for(int i=0;i<N+1;i++)
				node[i]=new ArrayList<Node>();
			
		}
		
		public void addNode(int from,int to,int weight) {
			node[from].add(new Node(to,weight));
			node[to].add(new Node(from,weight));
		}
		
		public int dikstra(int start,int end) {
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			boolean[] isVisited = new boolean[N+1];
			
			pq.add(new Node(start,0));
			Arrays.fill(dist,200_000_000);
			
			dist[start] = 0;
			
			while(!pq.isEmpty()) {
				Node curNode = pq.poll();
				if(isVisited[curNode.vertex])
					continue;
				isVisited[curNode.vertex] = true;
				
				for(Node nextNode : node[curNode.vertex]) {
					
					if(dist[nextNode.vertex] > dist[curNode.vertex]+nextNode.weight) {
						dist[nextNode.vertex]= dist[curNode.vertex]+nextNode.weight;
						pq.add(new Node(nextNode.vertex,dist[nextNode.vertex]));								
					}
						
				}
			}
			
			return dist[end];
		}
	}
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			
			if(this.weight == o.weight) return 0;
			return this.weight < o.weight ? -1 : 1;
		}
		
		
	}
	
	static Graph graph;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph= new Graph(N);
		
		for (int i = 0; i <M ; i++) {
			st = new StringTokenizer(br.readLine());
			graph.addNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		int essentialStart = Integer.parseInt(st.nextToken());
		int essentialEnd = Integer.parseInt(st.nextToken());
		
		int case1 = 0;
		int case2 = 0;
		
		case1+=graph.dikstra(1,essentialStart);
		case1+=graph.dikstra(essentialStart,essentialEnd);
		case1+=graph.dikstra(essentialEnd,N);
		
		case2+=graph.dikstra(1,essentialEnd);
		case2+=graph.dikstra(essentialEnd,essentialStart);
		case2+=graph.dikstra(essentialStart,N);
		
		int ans = (case1 >= 200_000_000 && case2 >= 200_000_000) ? -1 : Math.min(case1, case2);
		//System.out.println(case1+" "+ case2);
		System.out.println(ans);
		
	}
}