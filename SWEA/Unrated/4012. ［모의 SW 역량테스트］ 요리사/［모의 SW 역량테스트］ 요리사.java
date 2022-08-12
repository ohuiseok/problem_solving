import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int selectNum;
	static int[][] taste;
	static boolean[] isSelected;
	static int answer;
	public static void combination(int search, int count) {
		if (count == selectNum) {
			int firstTaste=0,secondTaste=0,tmp;
			for (int i = 1; i < taste.length; i++) {
				for (int j = 1; j < taste.length; j++) {
					if (isSelected[i]&&isSelected[j]) {
						firstTaste+=taste[i][j];
					} 
					else if(!isSelected[i]&&!isSelected[j])
					{
						secondTaste+=taste[i][j];
					}
				}
			}
			tmp=Math.abs(firstTaste-secondTaste);
//			System.out.println("firstTaste :"+firstTaste+" secondTaste :"+secondTaste);
			answer = Math.min(tmp, answer);
			
		}

		for (int i = search; i < taste.length; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			combination(i, count + 1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			taste = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++)
					taste[i][j] = Integer.parseInt(st.nextToken());
			}
			selectNum = N / 2;
			isSelected = new boolean[N + 1];
			answer = Integer.MAX_VALUE;
			combination(1, 0);
			System.out.println("#"+t+" "+answer);
		}

		/*
		 * 조합으로 2개를 고른다. => 그리고 각 시너지 값을 구한다. 가장 낮은 값을 찾는다.
		 */

	}

}