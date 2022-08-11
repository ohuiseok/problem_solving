import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int minValue = Integer.MAX_VALUE;
	static int rotation;
	static boolean[] isRotation;
	static int[][] rotCase;

	public static int minArr(int[][] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			int tmp = 0;
			for (int j = 1; j < arr[0].length; j++) {
				tmp += arr[i][j];
			}
			if (tmp < min)
				min = tmp;
		}
		return min;
	}

	public static int[][] arrRotation(int[][] arr, int centerR, int centerC, int interval) {
		int arrSize = interval * 2 + 1;

		int[][] answer = new int[arr.length][arr[0].length];
		// 5*4 14=(5+4)*2-4 // 4*4 12=(4+4)*2-4
		centerC -= interval + 1;
		centerR -= interval + 1;
		int r = 1;
		int c = 1;// 5 4 7
		int vertical = arrSize - 1;// 3
		int horizon = arrSize - 1;// 4
		while (r <= arrSize / 2 && c <= arrSize / 2) {
			int i;

			for (i = r; i < r + horizon; i++) {
				answer[centerR + i][centerC + c] = arr[centerR + i + 1][centerC + c];
			}

			r = i;

			for (i = c; i < c + vertical; i++) {
				answer[centerR + r][centerC + i] = arr[centerR + r][centerC + i + 1];
			}
			c = i;

			for (i = r; i > r - horizon; i--) {
				answer[centerR + i][centerC + c] = arr[centerR + i - 1][centerC + c];
			}

			r = i;
			for (i = c; i > c - vertical; i--)
				answer[centerR + r][centerC + i] = arr[centerR + r][centerC + i - 1];

			c = i;

			++r;
			++c;
			vertical -= 2;
			horizon -= 2;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (answer[i][j] != 0)
					continue;
				answer[i][j] = arr[i][j];
			}

		}
		return answer;
	}

	public static void repeat(int index, int[][] arr) {
		if (index == rotation) {
			int tmpMin = minArr(arr);
			if (tmpMin < minValue)
				minValue = tmpMin;
//			System.out.println("tmpMin "+tmpMin);
			return;
		}

		for (int i = 0; i < rotation; i++) {
			if (isRotation[i])
				continue;
			isRotation[i]=true;
			repeat(index + 1, arrRotation(arr, rotCase[i][0], rotCase[i][1], rotCase[i][2]));
			isRotation[i]=false;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		rotation = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotCase = new int[rotation][3];
		isRotation = new boolean[rotation];

		for (int i = 0; i < rotation; i++) {
			st = new StringTokenizer(br.readLine());
			rotCase[i][0] = Integer.parseInt(st.nextToken());
			rotCase[i][1] = Integer.parseInt(st.nextToken());
			rotCase[i][2] = Integer.parseInt(st.nextToken());
		}
		repeat(0, arr);
//		arr = arrRotation(arr,r,c,interval);

//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=M;j++)
//				System.out.print(arr[i][j]+" ");
//			System.out.println();
//		}
		System.out.println(minValue);
		bw.close();
	}
	/*
	 * 배열을 돌린다. 외곽 돌리고, 그 다음외곽 돌리고. 그렇게N/2 M/2 넘어가면 안돌린다.
	 * 
	 */

}