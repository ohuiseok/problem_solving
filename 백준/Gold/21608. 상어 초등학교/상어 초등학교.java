import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//1010
public class Main {
	static int[][] input;
	static int[][] area;
	static int N;
	static final int[][] near = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static final int[] scoreTable = { 0, 1, 10, 100, 1000 };
	static int answer = 0;

	public static void print() {

		for(int i = 0; i < N ;i++) {
			for(int j=0;j<N;j++)
				System.out.print(area[i][j]+" ");
			System.out.println();
		}
	}
	
	public static void layout() {

		for (int i = 0; i < input.length; i++) {
			nearFriend(input[i][0], input[i][1], input[i][2], input[i][3], input[i][4]);
//			print();
//			System.out.println();
			
		}
	}

	public static void nearFriend(int me, int f1, int f2, int f3, int f4) {
		int indexR = -1, indexC = -1;
		int howMany = 0, howVoid = 0;
		int nothingSetion = 0;
		int nothingR = -1,nothingC = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmpMany = 0, r = 0, c = 0, voidCount = 1;
				if(area[i][j]!=0)
					continue;
				
				for (int k = 0; k < 4; k++) {
					r = i + near[k][0];
					c = j + near[k][1];
					if (r >= 0 && r < N && c >= 0 && c < N) {
						if (area[r][c] == f1 || area[r][c] == f2 || area[r][c] == f3 || area[r][c] == f4) {
							tmpMany++;
						}

						if (area[r][c] == 0) {
							voidCount++;
						}
					}
				}
				
				if (tmpMany > howMany) {
					howMany = tmpMany;
					howVoid = voidCount;
					indexR = i;
					indexC = j;
				} else if (tmpMany == howMany && voidCount > howVoid) {
					howMany = tmpMany;
					howVoid = voidCount;
					indexR = i;
					indexC = j;
				}
				if( nothingSetion < voidCount ) {
					nothingSetion=voidCount;
					nothingR = i;
					nothingC = j;
				}
				
				
				
			}
		}

		if(howMany==0&&howVoid==0) {
			area[nothingR][nothingC] = me;
		}
		else {
			area[indexR][indexC] = me;
		}

	}

	public static void scoreCheck() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int matchNum = 0;
				int index = search(area[i][j]);
				
				for (int k = 0; k < 4; k++) {
					int r = i+near[k][0];
					int c = j+near[k][1];
					if (r >= 0 && r < N && c >= 0 && c < N ) {
						if(input[index][1]==area[r][c] || input[index][2]==area[r][c] || input[index][3]==area[r][c] || input[index][4]==area[r][c] )
							matchNum++;
					}
				}
				answer += scoreTable[matchNum];
			}
		}

	}

	public static int search(int num) {
		int ret = -1;
		for (int i = 0; i < N*N; i++) {
			if (num == input[i][0]) {
				ret = i;
				break;
			}
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		input = new int[N * N][5];
		area = new int[N][N];

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)
				input[i][j] = Integer.parseInt(st.nextToken());
		}

		layout();
		
		
		scoreCheck();
		System.out.println(answer);
		/*
		 * 첫번째 값은 중앙에 넣는다.
		 * 
		 * 그 다음 좋아하는 애 옆에 놓는다. 최대한 친구들 근처로. 그다음 순위가 가장 빈칸이 많은 곳 위주로. 그래도 경우의 수가 많으면 행번호가
		 * 가장 작고, 열번호가 가장 작은 곳으로.
		 * 
		 * 그다음 채점.
		 */
	}

}
