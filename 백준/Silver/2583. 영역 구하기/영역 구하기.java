import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K;
	static int[][] area;
	static boolean[][] isVisited;
	static final int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void print() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				System.out.print(area[y][x]+" ");
				
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void paint(int x1, int y1, int x2, int y2) {
		for (int y = y1; y < y2; y++) {
			for (int x = x1; x < x2; x++) {
				area[y][x]++;
			}
		}
	}

	public static int noPaintCheck(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { r, c });
		int count = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if (isVisited[cur[0]][cur[1]])
				continue;
			isVisited[cur[0]][cur[1]] = true;
			count++;

			for (int i = 0; i < dir.length; i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];

				if (newR < 0 || newR >= N || newC < 0 || newC >= M || isVisited[newR][newC] || area[newR][newC] != 0)
					continue;
				queue.add(new int[] { newR, newC });
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		area = new int[N][M];
		isVisited = new boolean[N][M];
		PriorityQueue<Integer> cnt = new PriorityQueue<Integer>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			paint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i <N; i++)
			for (int j = M-1; j >=0 ; j--)
				if (!isVisited[i][j] && area[i][j] == 0) {
					int tmp = noPaintCheck(i, j);
					cnt.add(tmp);
				}
		
		System.out.println(cnt.size());
		while(!cnt.isEmpty())
			System.out.print(cnt.poll()+" ");
	}
}