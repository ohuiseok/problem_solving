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

	static boolean[][] isVisited;
	static int[][] area;
	static final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int R,C;
	
	public static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(area[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int search(int r,int c) {
		Queue<int []> queue = new LinkedList<int []>();
		queue.add(new int[] {r,c});
		int count = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(isVisited[cur[0]][cur[1]])
				continue;
			if(cur[0] == R-1 && cur[1]==C-1)
				break;
			
			isVisited[cur[0]][cur[1]] = true;
			count++;
			
			for(int i=0;i<4;i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];
				
				if(newR <0 || newR >=R || newC <0 || newC >=C )
					continue;
				if(area[newR][newC]!=0 && !isVisited[newR][newC])
				{	
					queue.add(new int[] {newR,newC});
					area[newR][newC] = area[cur[0]][cur[1]]+1;
				}
			}
			
			
		}
		
		return area[R-1][C-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		isVisited = new boolean[R][C];
		area = new int[R][C];
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++)
				area[i][j] = str.charAt(j) - '0';
		}
		
//		print();
		System.out.println(search(0,0));
	}
}