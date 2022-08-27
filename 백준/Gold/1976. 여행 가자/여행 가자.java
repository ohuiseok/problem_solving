import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	
	static void make(int N) {
		node = new int[N+1];
		for(int i=0;i<N+1;i++)
			node[i]=i;
	}
	
	static int find(int x) {
		if(node[x]==x) return x;
		return find(node[x]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return;
		if(rootA < rootB)
			node[rootB] = rootA;
		else 
			node[rootA] = rootB;
	}

	static int[] node;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		make(N);
		
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1)
					union(i,j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int cmp = Integer.parseInt(st.nextToken());
		for(int i=1;i<M;i++){
			if(find(cmp)!=find(Integer.parseInt(st.nextToken())))
			{
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}