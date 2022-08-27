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
		double[] dist;

		public Graph(int N) {
			this.N = N;

			dist = new double[N + 1];

			node = new List[N + 1];
			for (int i = 0; i < N + 1; i++)
				node[i] = new ArrayList<Node>();
		}

		public void addNode(int from, int to, double weight) {
			node[from].add(new Node(to, weight));
		}

		public void dijkstra(int start) {
			boolean[] isVisited = new boolean[N + 1];
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.add(new Node(start, 0));

			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[start] = 0;

			while (!pq.isEmpty()) {
				Node curNode = pq.poll();

				if (isVisited[curNode.vertex])
					continue;
				isVisited[curNode.vertex] = true;

				for (Node nextNode : node[curNode.vertex]) {
					if (dist[nextNode.vertex] > dist[curNode.vertex] + nextNode.weight) {
						dist[nextNode.vertex] = dist[curNode.vertex] + nextNode.weight;
						pq.add(new Node(nextNode.vertex, dist[nextNode.vertex]));
					}
				}

			}
		}
	}

	static class Node implements Comparable<Node> {
		int vertex;
		double weight;

		public Node(int vertex, double weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}

	}

	static Node[] way;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double startX = Double.parseDouble(st.nextToken());
		double startY = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double endX = Double.parseDouble(st.nextToken());
		double endY = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		double[][] tmp = new double[N+1][2];//0은 스타트 지점 //N+1이 도착지

		Graph graph = new Graph(N+2);//0~N+1
		
		for (int i = 1; i<= N; i++) {
			st = new StringTokenizer(br.readLine());
			tmp[i][0] = Double.parseDouble(st.nextToken());
			tmp[i][1] = Double.parseDouble(st.nextToken());
		}
		
		startToAnother(graph,0,new double[] {startX,startY},N+1,new double[] {endX,endY});//시작지에서 대포로 가기
		
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) { // 대포끼리 걸리는 시간// 서로 같다
				cannonToAnother(graph,i,tmp[i],j,tmp[j]);
				cannonToAnother(graph,j,tmp[j],i,tmp[i]);
			}
			startToAnother(graph,0,new double[] {startX,startY},i,tmp[i]);//시작지에서 대포로 가기
			cannonToAnother(graph,i,tmp[i] ,N+1, new double[] {endX,endY});//캐논에서 도착지로 가기
				
		}

		
		graph.dijkstra(0);
		System.out.printf("%.6f\n",graph.dist[N+1]);
	}

	public static void startToAnother(Graph graph,int startIndex, double start[],int endIndex, double end[]) {
		double dist = Math.pow(start[0]-end[0], 2) + Math.pow(start[1]-end[1], 2);
		dist = Math.sqrt(dist);
		double time = (dist/5.0);
		
		graph.addNode(startIndex, endIndex, time);
	}
	
	
	public static void cannonToAnother(Graph graph,int startIndex, double start[],int endIndex, double end[]) {
		double time = 0.0;//0인덱스는 x 1인덱스는 y
		double dist = Math.pow(start[0]-end[0], 2) + Math.pow(start[1]-end[1], 2);
		dist = Math.sqrt(dist);
		
		if(dist <= 50) {
			//걸어가거나, 대포후 걷기
			double time1 = 0.0;
			double time2 = 0.0;
			time1+=(dist/5.0);//걸어만 가기
			
			time2+=2;//대포 한 번 타고 걷기
			dist = 50.0 - dist;
			time2+=(dist/5.0);
			time = Math.min(time1, time2);
		}
		else {//대포 타고 걷기
			time+=2.0;
			dist-=50.0;
			
			time+=(dist/5.0);
		}
		graph.addNode(startIndex, endIndex, time);
	}

}