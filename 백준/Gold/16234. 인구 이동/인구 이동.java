import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] area;
	static int N, L, R;
	static final int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] isVisited;
	
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(area[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean suffle(int r, int c) {
		boolean isSuffle = false;
		List<int []> divideArray = new ArrayList<int []>();
		int count = 0;
		int sum = 0;
		
		Queue<int []> search = new LinkedList<int []>();
		search.add(new int[] {r,c});
		
		while(!search.isEmpty()) {
			int[] cur = search.poll();
			if(isVisited[cur[0]][cur[1]])
				continue;
			isVisited[cur[0]][cur[1]] = true;
			divideArray.add(new int[] {cur[0],cur[1]});
			count++;
			sum+=area[cur[0]][cur[1]];
			
			for(int i=0;i<4;i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];
				if(newR <0||newR>=N||newC<0||newC>=N)
					continue;
				int diff = Math.abs(area[cur[0]][cur[1]] - area[newR][newC] );
				if( diff >= L && diff <= R) {
					isSuffle = true;
					search.add(new int[] {newR,newC});
				}
			}
			
		}
		
		
		sum = sum / count;
		for(int[] loc : divideArray) {
			area[loc[0]][loc[1]] = sum;
		}
		
		return isSuffle;
	}

	public static boolean shuffleStart() {
		boolean isSuffle = false;
		isVisited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!isVisited[i][j]) {
					if(suffle(i,j))
						isSuffle = true;
				}
			}
		}
		
		
		return isSuffle;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		area = new int[N][N];
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				area[i][j] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			if (!shuffleStart())
				break;
//			print();
			count++;
		}
		System.out.println(count);

	}
}