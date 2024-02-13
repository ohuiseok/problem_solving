
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(true){
            String str = "" + N;

            if(str.contains("0") ||str.contains("1") ||str.contains("2") ||str.contains("3") ||
                    str.contains("5") ||str.contains("6") || str.contains("8") ||str.contains("9") ){
                //금만수가 아닐때
                N--;
            }else{
                //금만수일 경우
                break;
            }
        }

        System.out.println(N);


    }
}