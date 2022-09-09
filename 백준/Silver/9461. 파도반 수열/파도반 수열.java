import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Long> P = new ArrayList<Long>();
		StringBuilder sb = new StringBuilder();
		P.add(0l);
		P.add(1l);
		P.add(1l);
		P.add(1l);
		P.add(2l);
		P.add(2l);
		for(int t=0;t<N;t++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			while( index  >= P.size() ) {
				P.add(P.get(P.size()-1) + P.get(P.size()-5));
			}
			sb.append(P.get(index)).append("\n");
//			System.out.println(P.toString());
		}
		System.out.println(sb.toString());
	}

}