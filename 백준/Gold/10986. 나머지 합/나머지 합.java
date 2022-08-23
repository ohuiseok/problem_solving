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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] count = new int[M];
		int sum = 0;
		long answer = 0;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			sum = (sum + Integer.parseInt(st.nextToken())) % M;
			count[sum]++;
		}
		answer = count[0];

		for (int i = 0; i < M; i++)
			answer += (long)count[i] * (count[i] - 1) / 2;
		System.out.println(answer);
	}

}
