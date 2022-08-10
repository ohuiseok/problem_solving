import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	
	static int[][] upDown(int[][] arr){
		int[][] answer = new int[N+1][M+1];
		
		for(int j=1;j<=M;j++)
			for(int i=1;i<=N;i++)
				answer[N+1-i][j]=arr[i][j];
		
		return answer;
	}
	static int[][] leftRight(int[][] arr){
		int[][] answer = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++)
			for(int j=1;j<=M;j++)
				answer[i][M+1-j]=arr[i][j];
		
		return answer;
	}
	
	static int[][] rotationL(int[][] arr){
		int[][] answer = new int[M+1][N+1];
		int tmp;
		for(int i=1;i<=N;i++)
			for(int j=1;j<=M;j++)
				answer[M+1-j][i]=arr[i][j];
//N+1-i
		tmp=N;
		N=M;
		M=tmp;
		return answer;
	}
	static int[][] rotationR(int[][] arr){
		int[][] answer = new int[M+1][N+1];
		int tmp;
		for(int i=1;i<=N;i++)
			for(int j=1;j<=M;j++)
				answer[j][N+1-i]=arr[i][j];

		tmp=N;
		N=M;
		M=tmp;
		return answer;
	}
	static int[][] type5(int[][] arr){
		int[][] answer = new int[N+1][M+1];

		for(int i=1;i<=N/2;i++)
			for(int j=1;j<=M/2;j++) 
				answer[i][j+M/2]=arr[i][j];
		for(int i=1;i<=N/2;i++)
			for(int j=M/2+1;j<=M;j++) 
				answer[i+N/2][j]=arr[i][j];
		for(int i=N/2+1;i<=N;i++)
			for(int j=M/2+1;j<=M;j++) 
				answer[i][j-M/2]=arr[i][j];
		for(int i=N/2+1;i<=N;i++)
			for(int j=1;j<=M/2;j++) 
				answer[i-N/2][j]=arr[i][j];
		
		return answer;
	}	
	static int[][] type6(int[][] arr){
		int[][] answer = new int[N+1][M+1];

		for(int i=1;i<=N/2;i++)
			for(int j=1;j<=M/2;j++) 
				answer[i+N/2][j]=arr[i][j];
		for(int i=N/2+1;i<=N;i++)
			for(int j=1;j<=M/2;j++) 
				answer[i][j+M/2]=arr[i][j];
		for(int i=N/2+1;i<=N;i++)
			for(int j=M/2+1;j<=M;j++) 
				answer[i-N/2][j]=arr[i][j];
		for(int i=1;i<=N/2;i++)
			for(int j=M/2+1;j<=M;j++) 
				answer[i][j-M/2]=arr[i][j];
		
		return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int rotation = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		int type=1;
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		type = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<rotation;i++) {
			switch(type) {
			case 1:
					arr=upDown(arr);
				break;
			case 2:
					arr=leftRight(arr);
				break;
			case 3:
					arr=rotationR(arr);
				break;
			case 4:
					arr=rotationL(arr);
				break;
			case 5:
					arr=type5(arr);
				break;
			case 6:
					arr=type6(arr);
				break;
			}
			if(st.hasMoreElements())
				type = Integer.parseInt(st.nextToken());
				
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<arr[0].length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
//		bw.close();
	}

}
