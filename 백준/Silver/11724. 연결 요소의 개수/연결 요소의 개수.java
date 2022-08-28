import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] node;
	static boolean[] isVisited;
	static int N;
	
	public static void DFS(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(isVisited[cur])
				continue;
			isVisited[cur] = true;
			for(int j=1;j<=N;j++) {
				if(isVisited[j])
					continue;
				if(node[cur][j]==1)
					queue.add(j);
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		node = new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b]=1;
			node[b][a]=1;
		}

		isVisited = new boolean[N+1];
		for(int i = 1; i<=N ; i++) {
			if(!isVisited[i]) {
				DFS(i);
				count++;
			}
		}
				
		System.out.println(count);
	}
}