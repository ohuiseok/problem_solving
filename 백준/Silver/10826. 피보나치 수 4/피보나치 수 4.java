import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static int THREE = 1;
    public static int ONE = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        BigInteger[] temp = new BigInteger[3];
        int times = 3;
        temp[0] = BigInteger.valueOf(0);
        temp[1] =  BigInteger.valueOf(1);
        temp[2] =  BigInteger.valueOf(1);
        if(n < 3){
            System.out.println(temp[n]);
            return;
        }
        for (int i = 0; i <= n-3 ; i++) {
            temp[times%3] = temp[(times-1)%3].add(temp[(times-2)%3]);
//            System.out.println(temp[times%3]);
            times++;
        }
        System.out.println(temp[n%3]);

    }
}
