import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int answer = 0;
		boolean success = false;
		Queue<Integer> list = new LinkedList<Integer>();
		Set<Integer> store = new HashSet<Integer>();
		
		if(start == end) {
			System.out.println(0);
			return;
		}
		
		if(start>0) {
			list.add(start-1);
			store.add(start-1);
		}
		list.add(start+1);
		list.add(start*2);
		store.add(start+1);
		store.add(start*2);
		
		while(true) {
			answer++;
			int size = list.size();
			for(int i=0;i<size;i++) {
				int a = list.poll();
				if(a==end) {
					success= true;
					break;
				}
				if(a-1 >=0 &&  store.add(a-1)) {
					list.add(a-1);
				}
				if(a < end && store.add(a*2)) {
					list.add(a*2);
				}
				if(a < end && store.add(a+1)) {
					list.add(a+1);
				}
				
			}
			if(success)
				break;
		}
		System.out.println(answer);
		
	}
	
	
	/*
	 경우의 수 
	 1 더하기
	 1 빼기
	 2 곱하기
	 */

}
