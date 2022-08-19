import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static final int vertical = 0;
	static final int horizon = 1;
	static final int diagonal = 2;
	
	static int answer = 0,N;
	static int[][] area;
	
	public static void pipeGo(int r, int c, int type) {
		if(r==N && c==N) { //도착
			answer++;
			return;
		};
		if(r<1|| r>N || c<1 || c>N || area[r][c]==1)
			return;
//		System.out.println("r:"+r+" c:"+c+" type:"+type);
		
		if(type==vertical) {//이전 타입이 가로였음
			if( c+1 <=N && area[r][c+1]!=1) {
				pipeGo(r,c+1,vertical);	
			}
			if( r+1 <=N && c+1 <=N && area[r][c+1]!=1 && area[r+1][c]!=1 && area[r+1][c+1]!=1) {
				pipeGo(r+1,c+1,diagonal);
			}
		}else if(type == horizon) {//이전 타입이 세로였음
			if( r+1 <=N && area[r+1][c]!=1) {
				pipeGo(r+1,c,horizon);
			}
			if( r+1 <=N && c+1 <=N && area[r+1][c]!=1 && area[r][c+1]!=1 && area[r+1][c+1]!=1) {
				pipeGo(r+1,c+1,diagonal);
			}
		}else if(type == diagonal) {//이전 타입이 대각선이었음
			if( r <=N && c+1 <=N && area[r][c+1]!=1) {
				pipeGo(r,c+1,vertical);
			}
			if( r+1 <=N && c <=N && area[r+1][c]!=1 ) {
				pipeGo(r+1,c,horizon);
			}
			if( r+1 <=N && c+1 <=N && area[r+1][c+1]!=1 && area[r][c+1]!=1 && area[r+1][c]!=1) {
				pipeGo(r+1,c+1,diagonal);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		area = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<=N;j++)
				area[i][j]=Integer.parseInt(st.nextToken());
		}
		pipeGo(1,2,vertical);//가로 타입
		System.out.println(answer);
	}

}
