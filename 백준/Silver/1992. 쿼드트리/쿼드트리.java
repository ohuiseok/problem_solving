import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int[][] area;
	static StringBuilder sb;
	
	public static void searchDiv(int r, int c, int size) {
		if(isDiffCheck(r,c,size)) {
			sb.append("(");
			searchDiv(r,c,size/2);
			searchDiv(r,c+size/2,size/2);
			searchDiv(r+size/2,c,size/2);
			searchDiv(r+size/2,c+size/2,size/2);
			sb.append(")");
		}else {
			sb.append(area[r][c]);
		}
		
	}
	public static boolean isDiffCheck(int r,int c,int size) {
		int standard = area[r][c];

		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(area[i][j]!=standard)
					return true;//다른 게 존재
			}
		}
		
		return false;//다른 게 존재x
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		area = new int[N][N];
		sb = new StringBuilder();
		
 		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				area[i][j] = str.charAt(j)-'0';
			}
		}
		
// 		sb.append("(");
		searchDiv(0,0,N);
// 		sb.append(")");
 		System.out.println(sb.toString());
		
		
	}
	/*
	 * 
분할 검색(?) 
괄호 열고
탐색(왼위,오른위,왼아래,오른아래) -> 서로 다른게 존재? ->( 괄호열기 반복)나오면괄호 닫기)


	 * */
}
