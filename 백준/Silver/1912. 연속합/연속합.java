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
		int[] arr = new int[T+1];
		int[] dp = new int[T+1];
		int answer = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int t=1;t<=T;t++) {
			arr[t] =  Integer.parseInt(st.nextToken());
			if(arr[t-1] > 0)
				arr[t]+=arr[t-1];
			if(answer < arr[t])
				answer = arr[t];
		}
		System.out.println(answer);
	
	}

}