import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] area;
	static int[][] airCleaner = new int[2][2];
	static int R, C;
	static final int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(area[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int remainDust() {
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (area[i][j] != -1) {
					answer += area[i][j];
				}
			}
		}
		return answer;
	}

	public static int[][] areaCopy() {
		int[][] tmpArea = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tmpArea[i][j] = area[i][j];
			}
		}

		return tmpArea;
	}

	public static void diffuseDust() {
		int[][] tmpArea = areaCopy();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (area[i][j] > 0) {
					int dustCount = 0;

					for (int k = 0; k < 4; k++) {
						int newR = i + dir[k][0];
						int newC = j + dir[k][1];
						if (newR < 0 || newR >= R || newC < 0 || newC >= C || area[newR][newC] == -1)
							continue;
						dustCount++;
						tmpArea[newR][newC] += (area[i][j] / 5);
					}

					tmpArea[i][j] -= (area[i][j] / 5 * dustCount);

				}
			}
		}

		area = tmpArea;
	}

	public static void cleanAir() {
		int upCleanR = airCleaner[0][0];
		int downCleanR = airCleaner[1][0];

		for (int i = upCleanR - 1; i >= 1; i--) {
			area[i][0] = area[i - 1][0];
		}
		for (int i = 0; i <= C - 2; i++) {
			area[0][i] = area[0][i + 1];
		}
		for (int i = 0; i <= upCleanR - 1; i++) {
			area[i][C - 1] = area[i + 1][C - 1];
		}
		for (int i = C - 1; i >= 2; i--) {
			area[upCleanR][i] = area[upCleanR][i - 1];
		}
		area[upCleanR][1] = 0;

		for (int i = downCleanR + 1; i <= R - 2; i++) {
			area[i][0] = area[i + 1][0];
		}
		for (int i = 0; i <= C - 2; i++) {
			area[R - 1][i] = area[R - 1][i + 1];
		}
		for (int i = R - 1; i >= downCleanR + 1; i--) {
			area[i][C - 1] = area[i - 1][C - 1];
		}
		for (int i = C - 1; i >= 2; i--) {
			area[downCleanR][i] = area[downCleanR][i - 1];
		}
		area[downCleanR][1] = 0;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		area = new int[R][C];

		int airCleanerIndex = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if (area[i][j] == -1) {
					airCleaner[airCleanerIndex][0] = i;
					airCleaner[airCleanerIndex++][1] = j;
				}
			}
		}

		while (T > 0) {
			diffuseDust();
//			print();
			cleanAir();
//			print();
			T--;
		}

		System.out.println(remainDust());
		br.close();
	}

}
