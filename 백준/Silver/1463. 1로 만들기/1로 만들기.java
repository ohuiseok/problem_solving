import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int memo[] = new int[1000000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int first = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(first);
		int cnt = 0;
		
		
		while(!queue.isEmpty()) {
			cnt ++;
			Queue<Integer> newQueue = new LinkedList<Integer>();
			
			while(!queue.isEmpty()) {
				int value = queue.poll();
//				System.out.print(value+" ");
				if( value==1)
				{
					System.out.println(cnt-1);
					return;
				}
				
				if(value%3==0 && memo[value/3] == 0) {
					memo[value/3] = cnt;
					newQueue.add(value/3);
				}
				if(value%2==0 && memo[value/2] == 0) {
					memo[value/2] = cnt;
					newQueue.add(value/2);
				}
				if(value-1>0 && memo[value-1]==0) {
					memo[value-1] = cnt;
					newQueue.add(value-1);
					
				}
					
			}
//			System.out.println();
			queue = newQueue;
		}
		
	}

	
}
