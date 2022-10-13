import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int MOD;

	public static void setFactorial(long[] factorial) {
		factorial[0] = 1;
		for (int i = 1; i <= MOD; i++) {
			factorial[i] = (i * factorial[i - 1]) % MOD;
		}
	}

	public static long pow(long a, long N) {// a의 n승 구하기 최적화방법
		if (N == 0)
			return 1;
		if (N == 1)
			return a;
		if (N % 2 == 0) {
			long temp = pow(a, N / 2);
			return (temp * temp) % MOD;
		}
		long temp = pow(a, N - 1) % MOD;
		return (temp * a) % MOD;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] factorial = new long[1000001];

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			MOD = Integer.parseInt(st.nextToken());
			setFactorial(factorial);
			long answer = 1;
			while (N > 0 || R > 0) {
				int n = (int) (N % MOD);
				int r = (int) (R % MOD);

				if(r>n) {
					answer = 0 ;
					break;
				}
				
				answer = (answer * factorial[n]) % MOD;
				for (int i = 0; i < MOD - 2; i++) {
					answer = (answer * factorial[n - r] * factorial[r]) % MOD;
				}

				N /= MOD;
				R /= MOD;
			}
			
			answer %= MOD;
			System.out.printf("#%d %d\n", t, answer);
		}

	}
}
