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
	static List<kruskal> krList = new ArrayList<kruskal>();
	
	
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
		double weight;
		
		public kruskal(int start, int end, double weight) {
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
		int N = Integer.parseInt(st.nextToken());
		double tmpNode[][] = new double[N][2];
		int count = 0;
		double answer = 0;

		make(N);
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			tmpNode[i][0] = Double.parseDouble(st.nextToken());
			tmpNode[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) {
				if(i==j)
					continue;
				double distance = Math.pow(tmpNode[i][0]-tmpNode[j][0], 2) + Math.pow(tmpNode[i][1]-tmpNode[j][1], 2);
				distance = Math.sqrt(distance);
				krList.add(new kruskal(i,j,distance));
			}
		}
		
		kr = krList.toArray(new kruskal[krList.size()]);
		Arrays.sort(kr);
		
		for(int i=0;i<kr.length;i++) {
			int start = kr[i].start;
			int end = kr[i].end;
			double weight = kr[i].weight;
			if(find(start)==find(end))
				continue;
			union(start,end);
			count++;
			if(count<=N-1)
				answer+=weight;
		}
		
		System.out.printf("%.2f",answer);
		
		
		
		
		
		
	}

}
