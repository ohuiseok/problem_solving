import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[T + 1][3];

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[t][0] = Integer.min(arr[t - 1][1], arr[t - 1][2]) + r;
			arr[t][1] = Integer.min(arr[t - 1][0], arr[t - 1][2]) + g;
			arr[t][2] = Integer.min(arr[t - 1][0], arr[t - 1][1]) + b;
		}
		int tmp = Integer.min(arr[T][0], arr[T][1]);
		System.out.println(Integer.min(tmp, arr[T][2]));
	}

}