import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static boolean[] visit;
	static boolean[][] area;
	static int N;
	
	public static void DFS(int node) {
		visit[node] = true;
		System.out.print(node+" ");

		for(int i=1;i<=N;i++) {
			if(visit[i])
				continue;
			if(area[node][i])
				DFS(i);
			
		}
	}

	public static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		System.out.print(node+" ");
		visit[node] = true;
		
		while(!queue.isEmpty()) {
			int loc = queue.poll();

			for(int i=1;i<=N;i++) {
				if(visit[i])
					continue;
				if(area[loc][i]) {
					System.out.print(i+" ");
					queue.add(i);
					visit[i]=true;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		area = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0;i<line;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			area[a][b] = true;
			area[b][a] = true;			
		}
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.print(area[i][j]+" ");
//			}
//			System.out.println();
//		}
		DFS(start);
		visit = new boolean[N+1];
		System.out.println();
		BFS(start);
	}

}
