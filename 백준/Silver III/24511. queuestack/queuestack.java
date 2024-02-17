import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        boolean[] isQueue = new boolean[N]; //큐인 것만 빼오기 위해서..

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int queueOrStack = Integer.parseInt(st.nextToken());
            if(queueOrStack == 0){
                isQueue[i] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        Deque<Integer> queuestack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (isQueue[i]){
                queuestack.addLast(tmp);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            queuestack.addFirst(input);

            int output = queuestack.pollLast();
            sb.append(output).append(' ');
        }

        System.out.println(sb.toString());


    }
}
