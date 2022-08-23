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
		double weight;

		public Prim(int start, int end, double weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Prim o) {
			return Double.compare(this.weight, o.weight);
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
		if (loc[x] == x)
			return x;
		return find(loc[x]);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB)
			return;
		if (rootA > rootB)
			loc[rootA] = rootB;
		else
			loc[rootB] = rootA;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] tmpStore = new int[N][2];
		double answer = 0;
		
		make(N+1);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			tmpStore[i][0] = Integer.parseInt(st.nextToken());
			tmpStore[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				double distance = Math.pow(tmpStore[i][0] - tmpStore[j][0], 2)
						+ Math.pow(tmpStore[i][1] - tmpStore[j][1], 2);
				distance = Math.sqrt(distance);
				node.add(new Prim(i+1, j+1, distance));
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (find(a) == find(b))
				continue;
			union(a, b);
		}

		while (!node.isEmpty()) {
			Prim cur = node.poll();
			if (find(cur.start) == find(cur.end))
				continue;

			union(cur.start, cur.end);
			answer+=cur.weight;
		}
		System.out.printf("%.2f",answer);

	}

}
