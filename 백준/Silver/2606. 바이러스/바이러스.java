import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	static List<Integer>[] connection;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int answer = -1;
		connection = new List[N+1];
		for(int i=0;i<N+1;i++)
			connection[i] = new ArrayList<Integer>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			connection[from].add(to);
			connection[to].add(from);//양방향
		}
		boolean[] isVisited = new boolean[N+1];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		while(!queue.isEmpty()) {
			int a = queue.poll();
			if(isVisited[a])
				continue;
			isVisited[a] = true;
			answer++;
			for(int internal : connection[a])
				queue.add(internal);
		}

		System.out.println(answer);
	}
}