import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//16935
public class Main {
	/*
	 * 
	 * 최소가격 도시전까지만 더하기
	 * 
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long[] km = new long[N - 1];
		long[] city = new long[N];
		long minCost = Long.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < km.length; i++)
			km[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < city.length; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}

		long answer = 0;
		for (int i = 0; i < N - 1; i++) {
			if (city[i] < minCost) {
				minCost = city[i];
			}

			answer += (minCost * km[i]);
		}
		System.out.println(answer);
	}

}
