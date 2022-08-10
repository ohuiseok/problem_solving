import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	
	public static int[][] arrRotation(int[][] arr){
		int[][] answer = new int[N+1][M+1];
		
		//5*4  14=(5+4)*2-4 // 4*4 12=(4+4)*2-4
		int r=1;
		int c=1;//5 4 7
		int vertical = M-1;//3
		int horizon = N-1;//4
		while( r<=N/2 && c<=M/2) {
//			System.out.println("test");
			int i;
//			System.out.println("r"+r+"c"+c);
			for(i=c;i<c+vertical;i++) {
				answer[r][i]=arr[r][i+1];
			}
			c=i;
//			System.out.println("r"+r+"c"+c);

			for(i=r;i<r+horizon;i++){
				answer[i][c]=arr[i+1][c];
			}
			r=i;
//			System.out.println("r"+r+"c"+c);
			for(i=c;i>c-vertical;i--)
				answer[r][i]=arr[r][i-1];
			c=i;
//			System.out.println("r"+r+"c"+c);
			for(i=r;i>r-horizon;i--) {
				answer[i][c]=arr[i-1][c];
			}
			r=i;
			++r;
			++c;
			vertical-=2;
			horizon-=2;
		}
		
		
		
		return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int rotation = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<rotation;i++)
			arr = arrRotation(arr);
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
		bw.close();
	}
	/*
	 * 배열을 돌린다. 외곽 돌리고, 그 다음외곽 돌리고. 그렇게N/2 M/2 넘어가면 안돌린다.
	 *  
	 * */

}
