import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] tomato;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int answer = 0;//?
//	static Queue<int []> queue;
	
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				System.out.print(tomato[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public static boolean success() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomato[i][j]==0)
					return false;
			}
		}
		
		return true;
	}
	
	public static Queue<int []> tomatoStart(Queue<int []> queue) {
		Queue<int []>newQueue = new LinkedList<int []>();
		
		while(!queue.isEmpty()) {
			int[] curLocation = queue.poll();
			for(int i=0;i<4;i++) {
				int r = curLocation[0]+dir[i][0];
				int c = curLocation[1]+dir[i][1];
				if( r>=0 && r<N && c >=0 && c<M && tomato[r][c]==0) {
					tomato[r][c]=1;
					newQueue.add(new int[] {r,c});
				}
			}
		}
		return newQueue;
	}
	
	public static int[][] copyArray(int[][] tomato) {
		int[][] newTomato = new int[tomato.length][tomato[0].length];
		for (int i = 0; i < tomato.length; i++)
			for (int j = 0; j < tomato[0].length; j++)
				newTomato[i][j] = tomato[i][j];
		return newTomato;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		Queue<int []> queue = new LinkedList<int []>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j]==1)
					queue.add(new int[] {i,j});
			}
		}

		while(!queue.isEmpty()) {
			queue=tomatoStart(queue);
			answer++;
		}
		answer--;
		if(!success())
			answer = -1;
		
		System.out.println(answer);
	}

	/*
	 * 
	익은 토마토 좌표들 저장
	그 토마토 기준으로 상하좌우 한칸 익히기
	-> 외곽선
	
	
	 * */
}
