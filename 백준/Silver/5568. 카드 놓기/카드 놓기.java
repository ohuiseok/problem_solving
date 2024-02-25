import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int n, k;
    public static int[] arr;

    public static Set<Integer> answer = new HashSet<>();
    public static boolean[] isSelect;

    public static void selectCard(int count, int number) {
        if (count == k) {
            answer.add(number);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSelect[i]) continue;
            isSelect[i] = true;
            String tmpNum = "" + arr[i];
            int nextNum = number * (int) Math.pow(10, tmpNum.length()) + arr[i];
            selectCard(count + 1, nextNum);
            isSelect[i] = false;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        isSelect = new boolean[n];
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        selectCard(0,0);

        System.out.println(answer.size());
    }
}
