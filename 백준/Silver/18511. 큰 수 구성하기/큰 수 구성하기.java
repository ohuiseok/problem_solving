import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //큰 수 구성하기
    //https://www.acmicpc.net/problem/18511
    public static int N, K, answer;
    public static int[] arr;

    public static void recursion(int value) {
        if (value > N) return;
        answer = Math.max(answer, value);

        for (int i = K - 1; i >= 0; i--) {
            recursion(value * 10 + arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = Integer.MIN_VALUE;

        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursion(0);

        System.out.println(answer);

    }

}
