import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static class kruskal implements Comparable<kruskal> {
		int s;
		int e;
		int v;

		public kruskal(int s, int e, int v) {
			super();
			this.s = s;
			this.e = e;
			this.v = v;
		}

		@Override
		public String toString() {
			return "kruskal [s=" + s + ", e=" + e + ", v=" + v + "]";
		}

		@Override
		public int compareTo(kruskal o) {
			// TODO Auto-generated method stub
			return this.v <= o.v ? -1 : 1;
		}

	}

	static int[] group;

	public static void make(int N) {
		group = new int[N + 1];
		for(int i=0;i<group.length;i++)
			group[i]=i;
	}
	
	public static int find(int x) {
		if (group[x] == x)
			return x;
		else
			return find(group[x]);
	}

	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA < rootB) // 오름차순
			group[rootB] = rootA;
		else
			group[rootA] = rootB;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int count = 0;
			long answer = 0;
			
			kruskal[] kr = new kruskal[M];

			make(N);

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				kr[i] = new kruskal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(kr);

			for (int i = 0; i < M; i++) {
				int s = kr[i].s;
				int e = kr[i].e;
				int v = kr[i].v;
				
				if(find(s)==find(e))
					continue;
				union(s,e);
				count++;
				answer+=v;
				if(count==N-1)
					break;
				
			}
			System.out.printf("#%d %d\n",t,answer);
		}

		/*
		 * 1~N까지 배열 생성 자기자신
		 */

	}

}