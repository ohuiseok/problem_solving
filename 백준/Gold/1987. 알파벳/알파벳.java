import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static char[][] board;
	static boolean[][] isBoard;
	static boolean[] isUsedChar;
	static int R,C;
	static int moveMax = Integer.MIN_VALUE;
	
	public static void boardGo(int r, int c,int count) {
		isUsedChar[board[r][c]-'A']=true;
		isBoard[r][c] = true;
		if(count > moveMax)
			moveMax = count;
		
		if(r+1<R) {
			searchAndGo(r+1,c,count+1);
		}
		if(c+1<C) {
			searchAndGo(r,c+1,count+1);
		}
		if(r-1>=0) {
			searchAndGo(r-1,c,count+1);
		}
		if(c-1>=0) {
			searchAndGo(r,c-1,count+1);
		}
	}
	
	public static void searchAndGo(int newR, int newC,int newCount) {
		boolean go = true;
		if(isBoard[newR][newC])
			return;
		
		if(isUsedChar[board[newR][newC]-'A'])
		{
			go = false;
		}
		
		if(go) {
			boardGo(newR,newC,newCount);
			isUsedChar[board[newR][newC]-'A'] = false;
			isBoard[newR][newC] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		isUsedChar = new boolean[27];
		isBoard = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		boardGo(0,0,1);
		System.out.println(moveMax);
	}

}
