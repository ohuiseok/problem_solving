import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] area;
    public static long[][] dp;
    public static int N;
    public static void main(String[] args) throws Exception {
        // 코드 작성
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        dp = new long[N][N];

        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for(int i=0; i<N;i++){
            for(int j=0;j<N;j++){
                int move = area[i][j];
                if(move == 0 )continue;
                if( i + move < N ){
                    dp[i+move][j] += dp[i][j];
                }
                if( j + move < N ){
                    dp[i][j+move] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
        //System.out.println(Arrays.toString(dp));
    }
}