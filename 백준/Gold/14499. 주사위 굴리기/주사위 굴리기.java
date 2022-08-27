import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static final int[] front = new int[] { 1, 1 };
	static final int[] floor = new int[] { 3, 1 };
	static int[] curLocation;
	static int[][] dice = new int[4][3];
	static int[][] area;
	static int R, C;
	/*
	 * 0 0 0 0 0 0
	 */

	static void print() {
		System.out.println("  " + dice[0][1]);
		for (int i = 0; i < 3; i++)
			System.out.print(dice[1][i] + " ");
		System.out.println();
		for (int i = 0; i < 2; i++)
			System.out.println("  " + dice[i + 2][1]);
		System.out.println();
	}

	static void changeValue() {

		if (area[curLocation[0]][curLocation[1]] == 0)
			area[curLocation[0]][curLocation[1]] = dice[floor[0]][floor[1]];
		else {
			dice[floor[0]][floor[1]] = area[curLocation[0]][curLocation[1]];
			area[curLocation[0]][curLocation[1]] = 0;
		}
		sb.append(viewValue()).append("\n");

	}

	static int viewValue() {
		return dice[front[0]][front[1]];
	}

	static void down() {
		if (curLocation[0] + 1 >= R)
			return;
		int tmp = dice[3][1];
		dice[3][1] = dice[2][1];
		dice[2][1] = dice[1][1];
		dice[1][1] = dice[0][1];
		dice[0][1] = tmp;
		curLocation[0]++;
		changeValue();
	}

	static void up() {
		if (curLocation[0] - 1 < 0)
			return;
		int tmp = dice[0][1];
		dice[0][1] = dice[1][1];
		dice[1][1] = dice[2][1];
		dice[2][1] = dice[3][1];
		dice[3][1] = tmp;
		curLocation[0]--;
		changeValue();
	}

	static void right() {
		if (curLocation[1] + 1 >= C)
			return;
		int tmp = dice[3][1];
		dice[3][1] = dice[1][2];
		dice[1][2] = dice[1][1];
		dice[1][1] = dice[1][0];
		dice[1][0] = tmp;
		curLocation[1]++;
		changeValue();
	}

	static void left() {
		if (curLocation[1] - 1 < 0)
			return;
		int tmp = dice[3][1];
		dice[3][1] = dice[1][0];
		dice[1][0] = dice[1][1];
		dice[1][1] = dice[1][2];
		dice[1][2] = tmp;
		curLocation[1]--;
		changeValue();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		curLocation = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		int cmd = Integer.parseInt(st.nextToken());
		area = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++)
				area[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());

		dice[floor[0]][floor[1]] = area[curLocation[0]][curLocation[1]];

		for (int i = 0; i < cmd; i++) {
			int move = Integer.parseInt(st.nextToken());
			switch (move) {
			case 1:
				right();
				break;
			case 2:
				left();
				break;
			case 3:
				up();
				break;
			case 4:
				down();
				break;
			}
//			print();

		}
		System.out.println(sb.toString());

	}
}