import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] order = new int[100001];
        Arrays.fill(order,Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        order[N] = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();

            if(cur == K) break;

            if(cur + 1 <= 100000 && order[cur+1] > order[cur] + 1){
                order[cur+1] = order[cur] + 1;
                queue.add(cur+1);
            }

            if(cur-1 >= 0 && order[cur-1] > order[cur] + 1){
                order[cur-1] = order[cur] + 1;
                queue.add(cur-1);
            }

            if(cur*2 <= 100000 && order[cur*2] > order[cur] ){
                order[cur*2] = order[cur];
                queue.add(cur*2);
            }


        }


        System.out.println(order[K]);
    }
}