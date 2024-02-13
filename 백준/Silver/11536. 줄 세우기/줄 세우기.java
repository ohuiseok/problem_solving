import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        String[] up = new String[N];
        String[] down = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            up[i] = arr[i];
            down[i] = arr[i];
        }

        //오름차순 배열 만들기
        Arrays.sort(up);
        //내일차순 배열 만들기
        Arrays.sort(down, Collections.reverseOrder());

        boolean isSameArrDown = true;
        boolean isSameArrUp = true;

        //up과 하나로 다르면 다른 것
        for (int i = 0; i < N; i++) {
            if(arr[i].equals(up[i]) == false){
                isSameArrUp = false;
            }
        }

        //down과 하나로 다르면 다른 것
        for (int i = 0; i < N; i++) {
            if(arr[i].equals(down[i]) == false){
                isSameArrDown = false;
            }
        }

        if(isSameArrUp){
            System.out.println("INCREASING");
        }else if(isSameArrDown){
            System.out.println("DECREASING");
        }else{
            System.out.println("NEITHER");
        }
    }
}

