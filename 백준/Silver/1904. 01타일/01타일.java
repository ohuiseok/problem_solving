import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
//16935
public class Main {
	/*6개일 경우   
	 * 00:0개  1 1 1 1 1 1 1가지 
	 * 00:1개  00 1 1 1 1  5가지
	 * 00:2개  00 00 1 1   4가지
	 * 00:3개  00 00 00    1가지
	 * 
	 * 1개 1							1개
	 * 2개 11 00	 					2개
	 * 3개 001 100 111 				3개
	 * 4개 1111 1100 1001 0011 0000 5개
	 * 5개 11111 11100 11001 10011 00111 10000 00100 00001 8개
	 * 6개 111111 111100 111001 110011 100111 001111 110000 100100 100001 001001 001100 000011 000000
	 * */
	public static long calcArray(int N) {
		Deque<Long> dq = new LinkedList<Long>();
		dq.add((long) 1);
		dq.add((long) 2);
		
		if(N==1)
			return 1;
		else if(N==2)
			return 2;
		else {
			for(int i=3;i<=N;i++) {
				long a = (dq.pollFirst() + dq.peekLast())%15746;
				dq.add(a);
			}
			return dq.pollLast();
		}
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		
		System.out.println(calcArray(N)%15746);
		
	}

}


