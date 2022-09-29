import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] color;
	static int[][] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		color = new int[N+1][3];
		memo = new int[N+1][3];
		int answer;
		
		for(int t=1;t<=N;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<3;i++)
				color[t][i] = Integer.parseInt(st.nextToken());
			memo[t][0] = color[t][0] + Integer.min(memo[t-1][1],memo[t-1][2]);
			memo[t][1] = color[t][1] +Integer.min(memo[t-1][0],memo[t-1][2]);
			memo[t][2] = color[t][2] +Integer.min(memo[t-1][0],memo[t-1][1]);
		}
	
		answer = Integer.min(memo[N][0], memo[N][1]);
		answer = Integer.min(answer, memo[N][2]);
		System.out.println(answer);
	}

	/*
	 * 하향식 방식
	 * r 선택 + 이전에서 g선택시최소값, r 선택 + 이전에서b선택최소값
	 * g 선택 + 이전에서 r선택시최소값, g 선택 + 이전에서b선택최소값
	 * b 선택 + 이전에서 r선택시최소값, b 선택 + 이전에서g선택최소값
	 * 이 세가지 중 가장 최소값 호출.
	 * 
	 * 코드로 작성하려니 어렵다. 
	 * 
	 * 상향식으로 변환해보자
	 * 첫번째 DP배열에는 R,G,B초기값을 넣는다.
	 * 두번째 DP배열에는 "현재 R을 골랐을 때 + (이전에 G,B값 중 최소값)"
	 * 				"현재 G을 골랐을 때 + (이전에 R,B값 중 최소값)"
	 * 				"현재 B을 골랐을 때 + (이전에 R,G값 중 최소값)" 
	 * 이렇게 나아간다.
	 * 
	 * 
	 * 
	 * */
}
