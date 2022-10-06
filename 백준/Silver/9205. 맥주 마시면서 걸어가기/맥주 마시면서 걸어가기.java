import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 20;// 한 박스 최대 20병
	static final int DISTANCE = 50;// 50m당 한병
	static final String SUCCESS = "happy";
	static final String FAIL = "sad";;
	static Point[] dist;
	static int storeNum;

	public static class Point {
		int y, x;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + "]";
		}

	}

	public static boolean getBottleNum(Point a, Point b) {
		if (Math.abs(a.x - b.x) + Math.abs(a.y - b.y) <= 1000)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		boolean[][] flag;

		for (int t = 1; t <= testCase; t++) {
			storeNum = Integer.parseInt(br.readLine()) + 2;
			dist = new Point[storeNum];
			flag = new boolean[storeNum][storeNum];

			StringTokenizer st = new StringTokenizer(br.readLine());
			dist[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 1; i <= storeNum - 2; i++) {
				st = new StringTokenizer(br.readLine());
				dist[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			dist[storeNum - 1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < storeNum; i++) {
				for (int j = 0; j < storeNum; j++) {
						flag[i][j] = getBottleNum(dist[i], dist[j]);
				}
			}

			for (int k = 0; k < storeNum; k++)
				for (int i = 0; i < storeNum; i++)
					for (int j = 0; j < storeNum; j++) {
						if (flag[i][k]  && flag[k][j] )
							flag[i][j] = true;
					}

			if(flag[0][storeNum-1])
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}
