import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int roomMax;
	static int roomLocation;
	static int N;
	final static int[][] dmove = {{0,-1},{0,1},{-1,0},{1,0}};
	
	public static int roomMove(int i,int j,int[][] room,int sum) {
//		System.out.println(i+" "+j);
		
		for(int d=0;d<4;d++) {
			int r = i+dmove[d][0];
			int c = j+dmove[d][1];
			if( r <= 0 || r > N || c <= 0 || c > N)
				continue;
//			if(isRoom[r][c])
//				continue;
			if(room[r][c]-room[i][j]!=1)
				continue;
			
			sum = roomMove(r,c,room,sum+1);
			if(roomMax<sum) {
				roomMax=sum;
				roomLocation=room[i][j];
			}
			else if(roomMax==sum && roomLocation > room[i][j]) {
				roomLocation=room[i][j];
			}
			break;
		}
		
		return sum;
	}
	
	public static void roomSearch(int[][] room) {

		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++) {
				roomMove(i,j,room,1);
				
			}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testCase;t++) {
			N = Integer.parseInt(br.readLine());
			int[][] room = new int[N+1][N+1];
			
			for(int i=1;i<=N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++)
					room[i][j] = Integer.parseInt(st.nextToken());
			}
			roomMax=0;
			roomLocation=Integer.MAX_VALUE;
			roomSearch(room);
			System.out.println("#"+t+" "+roomLocation+" "+roomMax);
			
		}
	}
	/*
	 * N*N 방 만들기
	 * 
	 * 
	 * */

}
