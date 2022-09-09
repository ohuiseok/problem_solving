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
		long[][] wine = new long[T+1][3];
		long answer = Long.MIN_VALUE;
		
		for(int t=1;t<=T;t++) { // 0 skip //1 
			st = new StringTokenizer(br.readLine());
			Long tmp = Long.parseLong(st.nextToken());
			wine[t][0] = Long.max(wine[t-1][0], wine[t-1][1]);//현재는 skip
			wine[t][0] = Long.max(wine[t][0], wine[t-1][2]);
			
			wine[t][1]=tmp;//내가 첫번째 연속일때
			if(t-2>=0) {
				long maxTmp = Long.max(wine[t-2][0],wine[t-2][1]);
				maxTmp = Long.max(maxTmp,wine[t-2][2]);
				wine[t][1] += maxTmp;
			}
			wine[t][2] = tmp + Long.max(wine[t-1][0], wine[t-1][1]);//내가 두번째로 마시는 것 일 때
			
			tmp = Long.max(wine[t][0], wine[t][1]);
			tmp = Long.max(tmp, wine[t][2]);
			
			answer = Long.max(tmp, answer);
		}
		
		System.out.println(answer);
//		for(int t=1;t<=T;t++) {
//			System.out.println(wine[t][0]+" "+ wine[t][1]+" "+ wine[t][2]);
//		}
		
	}

}