import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int A = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (list.get(list.size() - 1) < tmp) {
                list.add(tmp);
            } else {
                int left = 1;                       //0은 무한대로 계속 나두자..
                int right = list.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) < tmp) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, tmp);
            }
        }

        System.out.println(list.size() - 1);


    }
}
