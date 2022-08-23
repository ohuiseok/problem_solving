import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int node[];
	static kruskal[] kr;
	
	static void make(int N) {
		node = new int[N];
		for(int i=0;i<N;i++)
			node[i]=i;
	}
	
	static int find(int x) {
		if(node[x]==x) return x;
		return find(node[x]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA < rootB)
			node[rootB] = rootA;
		else
			node[rootA] = rootB;
	}
	
	static class kruskal implements Comparable<kruskal> {
		int start;
		int end;
		int weight;
		
		public kruskal(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(kruskal o) {
			if(this.weight == o.weight)
				return 0;
			return this.weight < o.weight ? -1 : 1;
		}
		@Override
		public String toString() {
			return "kruskal [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		int answer = 0;
		
		make(N+1);//0이 없어서.
		kr = new kruskal[M];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			kr[i] = new kruskal(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
//			System.out.println("start "+kr[i].start+" end "+kr[i].end+" weight "+kr[i].weight);
			
		}
		
		Arrays.sort(kr);
		
		for(int i=0;i<M;i++) {
			int start = kr[i].start;
			int end = kr[i].end;
			int weight = kr[i].weight;
			
			if(find(start)==find(end))
				continue;
			union(start,end);
			count++;
			if(count==N-1)
				break;
			answer+=weight;
		}
		System.out.println(answer);
		
	}

}
