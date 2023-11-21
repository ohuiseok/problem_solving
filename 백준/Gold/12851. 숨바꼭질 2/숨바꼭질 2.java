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
        int[] arr = new int[100001];
        int[] store = new int[100001];

        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[N] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == K)
                continue;

            if(cur + 1 <= 100000 && arr[cur+1] == arr[cur] + 1 ){
                store[cur+1]++;
                queue.add(cur+1);
            }else if(cur + 1 <= 100000 && arr[cur+1] > arr[cur] + 1){
                store[cur+1] = 1;
                arr[cur+1] = arr[cur] + 1;
                queue.add(cur+1);
            }

            if(cur -1 >= 0 && arr[cur-1] == arr[cur] + 1){
                store[cur-1]++;
                queue.add(cur-1);
            }else if(cur -1 >= 0 && arr[cur-1] > arr[cur] + 1){
                store[cur-1] = 1;
                arr[cur-1] = arr[cur] + 1;
                queue.add(cur-1);
            }

            if(cur*2 <=100000 && arr[cur*2] == arr[cur] + 1 ){
                store[cur*2]++;
                queue.add(cur*2);
            }else if(cur*2 <=100000 && arr[cur*2] > arr[cur] + 1 ){
                store[cur*2] = 1;
                arr[cur*2] = arr[cur] + 1;
                queue.add(cur*2);
            }
        }

        System.out.println(arr[K]);
        if(store[K]==0) store[K]=1;
        System.out.println(store[K]);


    }
}