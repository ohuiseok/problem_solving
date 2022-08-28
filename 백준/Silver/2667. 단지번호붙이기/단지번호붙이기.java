import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static PriorityQueue<Integer> answer = new PriorityQueue<Integer>();
	static boolean[][] isVisited;
	static int[][] area;
	static final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N;
	
	public static void search(int r,int c) {
		Queue<int []> queue = new LinkedList<int []>();
		queue.add(new int[] {r,c});
		int count = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(isVisited[cur[0]][cur[1]])
				continue;
			isVisited[cur[0]][cur[1]] = true;
			count++;
			
			for(int i=0;i<4;i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];
				
				if(newR <0 || newR >=N || newC <0 || newC >=N )
					continue;
				if(area[newR][newC]==1)
					queue.add(new int[] {newR,newC});
			}
			
			
		}
		
		answer.add(count);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		isVisited = new boolean[N][N];
		area = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++)
				area[i][j] = str.charAt(j) - '0';
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				if(area[i][j] == 1 && (!isVisited[i][j]))
					search(i,j);
		}
		
		System.out.println(answer.size());
		while(!answer.isEmpty())
			System.out.println(answer.poll());
			
	}
}