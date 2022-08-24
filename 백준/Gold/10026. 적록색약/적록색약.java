import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[][] area;
	static boolean[][] isUsed;
	static final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int colorNum = 0;//0 red 1 green 2 blue
	static int colorNum2 = 0;//0 red 1 green 2 blue
	
	
	public static void colorCheck(int r,int c) {
		isUsed[r][c]=true;
		char color = area[r][c];
		Queue<int[]> search = new LinkedList<int []>();
		search.add(new int[] {r,c});
		
		while(!search.isEmpty()) {
			Queue<int[]> newSearch = new LinkedList<int []>();
			
			while(!search.isEmpty()) {
				int[] loc = search.poll();
				for(int i=0;i<4;i++) {
					int newR = loc[0]+dir[i][0];
					int newC = loc[1]+dir[i][1];
					
					if(newR<0||newR>=N||newC<0||newC>=N || isUsed[newR][newC] || color != area[newR][newC])
						continue;
					isUsed[newR][newC] = true;
					newSearch.add(new int[] {newR,newC});
				}
			}
			
			search = newSearch;
		}
		colorNum++;
		
		
	}
	
	public static void colorCheck2(int r,int c) {
		isUsed[r][c]=true;
		char color = area[r][c];
		Queue<int[]> search = new LinkedList<int []>();
		search.add(new int[] {r,c});
		
		while(!search.isEmpty()) {
			Queue<int[]> newSearch = new LinkedList<int []>();
			
			while(!search.isEmpty()) {
				int[] loc = search.poll();
				for(int i=0;i<4;i++) {
					int newR = loc[0]+dir[i][0];
					int newC = loc[1]+dir[i][1];
					
					if(newR<0||newR>=N||newC<0||newC>=N || isUsed[newR][newC] )
						continue;
					if( (color=='R'||color=='G') && area[newR][newC]=='B'  )
						continue;
					if( color == 'B' && color != area[newR][newC])
						continue;
					
					isUsed[newR][newC] = true;
					newSearch.add(new int[] {newR,newC});
				}
			}
			
			search = newSearch;
		}
		colorNum2++;
		
		
	}
	public static void searchStart() {
		isUsed = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				if(!isUsed[i][j]) {
					colorCheck(i,j);
				}
		}

		isUsed = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				if(!isUsed[i][j]) {
					colorCheck2(i,j);
				}
		}
		System.out.println(colorNum+" "+colorNum2);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		area = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++)
				area[i][j]=str.charAt(j);
		}
		
		
		searchStart();
		
	}

}
