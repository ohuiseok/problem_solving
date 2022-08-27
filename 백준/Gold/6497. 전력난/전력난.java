import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] node;
	
	static void make(int N) {
		node = new int[N+1];
		for(int i=0;i<N+1;i++)
			node[i]=i;
	}
	
	static int find(int x) {
		if(node[x]==x) return x;
		return find(node[x]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return;
		if(rootA < rootB)
			node[rootB] = rootA;
		else 
			node[rootA] = rootB;
	}
	
	static class Kruskal implements Comparable<Kruskal> {
		int from,to,weight;

		public Kruskal(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Kruskal o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight,o.weight);
		}
		
	}
	
	static PriorityQueue<Kruskal> kruskal = new PriorityQueue<Kruskal>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			long answer = 0;
			long sum =0;
			
			if(N==0 && M ==0)
				break;
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to  = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
		
				kruskal.add(new Kruskal(from,to,weight));
				sum += weight;
			}
			
			make(N);
			while(!kruskal.isEmpty()) {
				Kruskal cur = kruskal.poll();
				
				if(find(cur.from)==find(cur.to))
					continue;
				
				union(cur.from,cur.to);
				answer+=cur.weight;
			}
		System.out.println(sum-answer);
		}
		
	}
}