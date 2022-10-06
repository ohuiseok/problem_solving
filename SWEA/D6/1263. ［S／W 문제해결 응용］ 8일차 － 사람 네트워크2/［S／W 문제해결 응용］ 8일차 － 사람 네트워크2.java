import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] area;
	static final int INF = 100000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			area = new int[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
					if (area[i][j] == 0)
						area[i][j] = INF;
				}
			}

			for (int k = 0; k < size; k++)
				for (int i = 0; i < size; i++)
					for (int j = 0; j < size; j++) {
						area[i][j] = Math.min(area[i][k] + area[k][j], area[i][j]);
					}

			int answer = Integer.MAX_VALUE;
			for (int i = 0; i < size; i++) {
				int tmp = 0;
				for (int j = 0; j < size; j++) {
					if (i != j)
						tmp += area[i][j];
				}
				if (tmp < answer)
					answer = tmp;
			}
			System.out.printf("#%d %d\n", t, answer);
		}
	}
}
