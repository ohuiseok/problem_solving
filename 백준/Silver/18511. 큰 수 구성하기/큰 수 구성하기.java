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

    public static void recursion(int value) {       //0  //7  //77 //777 //775 //771 //77 //75 //757 //755 //751
        if (value > N) return;  // 비교할 값
        answer = Math.max(answer, value);

        for (int i = K - 1; i >= 0; i--) {
            recursion(value * 10 + arr[i]);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 비교할 값 <- 이것보다 작은 것 중에 `가장 큰 수`!!!
        K = Integer.parseInt(st.nextToken()); // 앞으로 입력 받을 원소의 갯수
        answer = Integer.MIN_VALUE;             //답

        arr = new int[K];                       //원소 모아둘 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());      //원소를 배열에 넣었습니다.
        }
        /////////////////////////////////
        Arrays.sort(arr);

        recursion(0);

        System.out.println(answer);

    }

}
