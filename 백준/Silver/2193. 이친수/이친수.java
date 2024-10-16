import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int order = Integer.parseInt(br.readLine());
        long[][] binary = new long[2][91];
        binary[1][1] = 1;
        binary[0][1] = 0;


        for (int i = 2; i <= order ; i++) {
            binary[1][i] = binary[0][i-1];
            binary[0][i] = binary[0][i-1] + binary[1][i-1];
        }
        System.out.println(binary[1][order]+binary[0][order]);
    }
}