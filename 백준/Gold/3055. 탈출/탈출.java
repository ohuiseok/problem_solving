import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Queue<short[]> water = new LinkedList<short[]>();
	static Queue<short[]> hedgehog = new LinkedList<short[]>();
	static short[] target;
	static short R, C;
	static char[][] area;
	static final short[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static short count = 0;
	static boolean success;

	public static void waterFlow() {
		int waterSize = water.size();

		while (waterSize > 0) {
			waterSize--;
			short[] loc = water.poll();

			
			for (int i = 0; i < 4; i++) {
				short newR = (short) (loc[0] + dir[i][0]);
				short newC = (short) (loc[1] + dir[i][1]);

				if (newR < 0 || newR >= R | newC < 0 || newC >= C || area[newR][newC] == 'D' || area[newR][newC] == 'X'  || area[newR][newC] == '*' )
					continue;

				area[newR][newC] = '*';
				water.add(new short[] { newR, newC });
			}
		}
	}

	public static boolean hedgehogFlow() {
		int hedgehogSize = hedgehog.size();
		count++;
		if(hedgehogSize==0)
			return false;
		while (hedgehogSize > 0) {
			hedgehogSize--;
			short[] loc = hedgehog.poll();

			if (area[loc[0]][loc[1]] != 'S') {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				short newR = (short) (loc[0] + dir[i][0]);
				short newC = (short) (loc[1] + dir[i][1]);

				if (newR < 0 || newR >= R | newC < 0 || newC >= C || area[newR][newC] == 'X' || area[newR][newC] == '*' )
					continue;

				if (area[newR][newC] == 'D') {
					success = true;
					return false;
				}

				area[loc[0]][loc[1]] = '.';
				area[newR][newC] = 'S';
				hedgehog.add(new short[] { newR, newC });
			}
		}
		return true;
	}

	public static boolean isEndFlag() {

		for (short i = 0; i < 4; i++) {
			short newR = (short) (target[0] + dir[i][0]);
			short newC = (short) (target[1] + dir[i][1]);

			if (newR < 0 || newR >= R | newC < 0 || newC >= C)
				continue;

			if (area[newR][newC] == '.')
				return false;// 끝난 거 아님
			if (area[newR][newC] == 'S') {
				count++;
				success = true;
				return true;// 성공 끝
			}
		}

		return true;// 끝

	}

	public static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(area[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Short.parseShort(st.nextToken());
		C = Short.parseShort(st.nextToken());
		area = new char[R][C];

		for (short i = 0; i < R; i++) {
			String str = br.readLine();
			for (short j = 0; j < C; j++) {
				area[i][j] = str.charAt(j);
				switch (area[i][j]) {
				case 'D':
					target = new short[] { i, j };
					break;
				case '*':
					water.add(new short[] {  i, j });
					break;
				case 'S':
					hedgehog.add(new short[] {  i, j });
					break;
				case 'X':// 사실 돌은 무언가 할필요는 없다 ㅎㅎ
					break;
				}
			}
		}

		while (true) {

			if(!hedgehogFlow())
				break;
//			print();
			waterFlow();
//			print();


		}
		if (success) {
			System.out.println(count);
		} else {
			System.out.println("KAKTUS");
		}
		/*
		 * 매순간 고슴도치 이동 물도 찬다.
		 * 
		 * 고슴도치 도착하면 최소 길이를 저장 도착 못하고 물이나 돌로 가득차면 fail
		 * 
		 */

	}

}
