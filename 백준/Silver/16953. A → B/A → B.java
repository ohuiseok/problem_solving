import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static HashSet<Long> isExist = new HashSet<>();

    public static void main(String[] args) throws Exception {
        // 코드 작성
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{A,0});

        while (!queue.isEmpty()){
            long[] value = queue.poll();
            long num = value[0];
            long operation = value[1];
            if(num == B){
                System.out.println(operation+1);
                return;
            }

            if(isExist.contains(num)){
                continue;
            }
            isExist.add(num);

            long nextNumFirst = num*2;
            if(nextNumFirst <= B){
                queue.add(new long[]{nextNumFirst,operation+1});
            }

            long nextNumSecond = num*10+1;
            if(nextNumSecond <= B){
                queue.add(new long[]{nextNumSecond,operation+1});
            }

        }


        System.out.println(-1);
    }
}