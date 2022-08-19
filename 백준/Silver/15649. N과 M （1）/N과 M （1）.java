import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N,C;
	static boolean[] visit;
	static int[] order;
	public static void dfs(int search,int count) {
		if(count==C) {
			for(int i=0;i<C;i++)
				sb.append(order[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(visit[i])
				continue;
			visit[i]=true;
			order[count]=i;
			dfs(search+1,count+1);
			visit[i]=false;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		order = new int[N+1];
		dfs(0,0);
		System.out.println(sb.toString());
	}

	
}
