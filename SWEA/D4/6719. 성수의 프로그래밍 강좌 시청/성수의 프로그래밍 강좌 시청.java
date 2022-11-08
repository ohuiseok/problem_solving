import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testCase;t++) {
			float answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int store[] = new int[N];
			for(int i=0;i<N;i++) {
				store[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(store);
			for(int i=N-K;i<N;i++) {
				answer = (answer+store[i])/2;
			}
			System.out.printf("#%d %.6f\n",t,answer);
		}
	}
}