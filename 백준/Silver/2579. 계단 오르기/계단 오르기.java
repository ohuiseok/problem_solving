import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	/*
	 * 배열 저장 순서 현재가 처음 밟은 거(이전꺼 x) , 두번째연속밟은 거. 1 2 3 4 5 6 계단이라는 가정 0 0 1,1
	 *
	 * 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[T + 1][2];

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			arr[t][0] = tmp;
			if (t - 2 >= 0)
				arr[t][0] += Integer.max(arr[t - 2][0], arr[t - 2][1]); // 저번꺼 안밟음
			arr[t][1] = arr[t - 1][0] + tmp;
		}
		System.out.println(Integer.max(arr[T][0], arr[T][1]));
	}

}