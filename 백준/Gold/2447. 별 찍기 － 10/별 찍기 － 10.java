import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void divide(int x, int y, int sector) {
        if ((x / sector) % 3 == 1 && (y / sector) % 3 == 1) {
            sb.append(' ');
            return;
        }

        if (sector / 3 == 0) {
            sb.append('*');
        } else {
            divide(x, y, sector / 3);
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                divide(i, j, N);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());

    }
}

