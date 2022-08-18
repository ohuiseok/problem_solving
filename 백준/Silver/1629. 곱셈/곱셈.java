import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int A,B,C;
	
	public static long power(int times) {
		if(times == 1) return A%C;
		
		long AA = power(times/2)%C;
		if(times%2==0) return AA*AA%C;
		else {
			return AA*AA%C * A%C;
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
//		System.out.println("i : "+i+" answer : "+answer+" B: "+B);

		System.out.println(power(B));
	}

}
