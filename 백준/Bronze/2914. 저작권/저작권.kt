import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val st = StringTokenizer(br.readLine());
    val A = st.nextToken().toInt();
    val I = st.nextToken().toInt();
    val answer = A * (I - 1) + 1;

    println(answer);

}