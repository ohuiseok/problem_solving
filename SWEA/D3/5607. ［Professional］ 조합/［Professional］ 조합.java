import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int MOD = 1234567891;
	
	public static long pow(long a, long N) {// a의 n승 구하기 최적화방법
		if(N==0)return 1;
		if(N==1)return a;
		if(N%2==0) {
			long temp=pow(a,N/2);
			return (temp*temp)%MOD;
		}
		long temp=pow(a,N-1)%MOD;
		return (temp*a)%MOD;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] factorial = new long[1000001];
		factorial[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			factorial[i] = (i * factorial[i - 1]) % MOD;
		}
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long answer = (factorial[N] * pow((factorial[R] * factorial[N - R]) % MOD, MOD - 2))% MOD;
			System.out.printf("#%d %d\n",t,answer);
		}

	}
}
