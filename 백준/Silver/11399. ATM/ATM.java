import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
//16935
public class Main {
	/*

오름차순, 그리고 누적합 느낌

	* */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int[] person = new int[N];
		int answer =0;
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
			person[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(person);
		
		for(int i=0;i<N;i++)
			answer += person[i]*(N-i);
		
		System.out.println(answer);
	}

}


