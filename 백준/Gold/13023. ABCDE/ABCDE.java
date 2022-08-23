import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static List<Integer>[] friend;
	public static boolean[] isUsed;
	public static boolean success;
	
	public static void dfs(int start,int count) {
		if(count==4) {
			success = true;
			return;
		}
		isUsed[start] = true;
		
		for(int f : friend[start]) {
			if(isUsed[f])
				continue;
			dfs(f,count+1);
			if(success)
				return;
		}

		isUsed[start] = false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		friend = new List[N];
		
		for(int i=0;i<N;i++)
			friend[i]=new ArrayList<Integer>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a].add(b);
			friend[b].add(a);
		}
		
		for(int i=0;i<N;i++) {
			isUsed = new boolean[N];
			dfs(i,0);
			if(success) {
				System.out.println("1");
				return;
			}
		}
		System.out.println("0");
		
	}

}
