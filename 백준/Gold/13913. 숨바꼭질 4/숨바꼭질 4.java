import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] order = new int[100001];
        int[] before = new int[100001];
        Arrays.fill(order,Integer.MAX_VALUE);
        Arrays.fill(before,Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        order[N] = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();

            if(cur == K) break;

            if(cur + 1 <= 100000 && order[cur+1] > order[cur] + 1){
                order[cur+1] = order[cur] + 1;
                before[cur+1] = cur;
                queue.add(cur+1);
            }

            if(cur-1 >= 0 && order[cur-1] > order[cur] + 1){
                order[cur-1] = order[cur] + 1;
                before[cur-1] = cur;
                queue.add(cur-1);
            }

            if(cur*2 <= 100000 && order[cur*2] > order[cur] + 1 ){
                order[cur*2] = order[cur]+1;
                before[cur*2] = cur;
                queue.add(cur*2);
            }


        }

        sb.append(order[K]).append('\n');
        int tmp = K;
        Stack<Integer> stack = new Stack<>();

        while(tmp!= Integer.MAX_VALUE){
            stack.push(tmp);
            tmp = before[tmp];
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb.toString());
    }
}