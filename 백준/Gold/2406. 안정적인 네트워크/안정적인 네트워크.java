import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static PriorityQueue<Prim> node;
	static int[] loc;

	public static class Prim implements Comparable<Prim> {
		int start;
		int end;
		int weight;

		public Prim(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Prim o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static void make(int N) {
		node = new PriorityQueue<Prim>();
		loc = new int[N];
		for (int i = 0; i < N; i++) {
			loc[i] = i;
		}
	}

	static int find(int x) {
		if(loc[x]==x) return x;
		return find(loc[x]);
	}
	
	static void union(int a,int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA > rootB)
			loc[rootA] = rootB;
		else
			loc[rootB] = rootA;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		make(N + 1);// 0 사용 안함
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (find(a)==find(b)) continue;
			union(a,b);
			count++;
			
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(i!=j && i!=1 && j !=1)
					node.add(new Prim(i,j,tmp));
			}
		}


		long answer = 0;
		Queue<int[]> answer2 = new LinkedList<int[]>();

		while (!node.isEmpty()) {
			Prim cur = node.poll();
			if(find(cur.start)==find(cur.end))
				continue;
			union(cur.start,cur.end);
			answer += cur.weight;
			answer2.add(new int[] { cur.start, cur.end });
			count++;
			
		}
		System.out.println(answer + " " + answer2.size());
		while (!answer2.isEmpty()) {
			int[] tmpAnswer = answer2.poll();
			System.out.println(tmpAnswer[1] + " " + tmpAnswer[0]);
		}

	}

}
