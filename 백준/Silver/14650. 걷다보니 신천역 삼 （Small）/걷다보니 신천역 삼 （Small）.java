import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static int n;
    public static HashSet<Integer> list = new HashSet<>();

    public static void search(int number) {
        String digit = "" + number;
        if (digit.length() == n) {
            if (number % 3 == 0 && number != 0) list.add(number);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (number == 0 && i == 0) continue;
            search(number*10 + i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        search(0);

        System.out.println(list.size());
    }
}
