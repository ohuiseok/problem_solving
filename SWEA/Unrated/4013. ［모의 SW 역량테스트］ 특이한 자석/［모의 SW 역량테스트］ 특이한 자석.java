import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static final int LEFT = 6;
	static final int RIGHT = 2;
	static List<Integer>[] wheel = new List[5];
	static int answer = 0;

	public static void print() {
		for (int i = 1; i < 5; i++) {
			System.out.println(Arrays.toString(wheel[i].toArray()));
		}
		System.out.println();

	}

	public static void wheelInit() {
		for (int i = 0; i < 5; i++)
			wheel[i] = new ArrayList<Integer>();
		answer = 0;
	}


	public static void wheelResult() {
		answer = 0;
		for (int i = 1; i <= 4; i++) {
			if (wheel[i].get(0) == 1) {
				answer += Math.pow(2, i - 1);
			}
		}
	}

	public static void rotation(int cur, int dir) {// dir 1 시계.
		if (dir == 1) {
			wheel[cur].add(0,wheel[cur].get(wheel[cur].size()-1));
			wheel[cur].remove(wheel[cur].size()-1);
		} else {
			wheel[cur].add(wheel[cur].get(0));
			wheel[cur].remove(0);
		}
	}


	public static void leftCheck(int cur,int curDir) {
		boolean[] isRotated = new boolean [6];
		if(cur==1)
			return;
		for(int i=cur-1;i>=1;i--) {
			if(wheel[i].get(RIGHT)!=wheel[i+1].get(LEFT))
				isRotated[i]=true;
		}
		int index=cur-1;
		int dir = curDir;
		while(isRotated[index]) {
			dir = dir==1?-1:1;
			rotation(index,dir);
			index--;
		}
	}
	
	public static void rightCheck(int cur,int curDir) {
		boolean[] isRotated = new boolean [6];
		if(cur==4)
			return;
		for(int i=cur+1;i<=4;i++) {
			if(wheel[i].get(LEFT)!=wheel[i-1].get(RIGHT))
				isRotated[i]=true;
		}
		int index=cur+1;
		int dir = curDir;
		while(isRotated[index]) {
			dir = dir==1?-1:1;
			rotation(index,dir);
			index++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= testCase; t++) {
			wheelInit();
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					wheel[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int how = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				leftCheck(how,dir);

				rightCheck(how,dir);

				rotation(how,dir);
				
			}

			wheelResult();
			System.out.printf("#%d %d\n",t,answer);

		}

		/*
		 * 1~N까지 배열 생성 자기자신
		 */

	}

}