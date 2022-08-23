import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int node[];
	
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
		int weight = 1;
		
		public kruskal(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(kruskal o) {
			return this.weight <= o.weight ? -1 : 1;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=testCase;t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int count = 0;
			int answer = 0;
			make(N+1);
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(find(a)==find(b))
					continue;
				
				union(a,b);
				count++;
				if(count<=N-1)
					answer+=1;
				
			}
			System.out.println(answer);
			
		}
		
	}

}
