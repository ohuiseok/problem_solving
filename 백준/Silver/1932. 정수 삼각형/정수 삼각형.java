import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[T + 1][T+1];
		int index  =1 ;
		int answer = Integer.MIN_VALUE;
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=index;i++) {
				arr[t][i] = Integer.parseInt(st.nextToken());
				arr[t][i] += Integer.max(arr[t-1][i-1], arr[t-1][i]);
			}
			index++;
		}
		for(int i=0;i<=T;i++) {
			if(answer < arr[T][i])
				answer = arr[T][i];
		}
		System.out.println(answer);
	}

}