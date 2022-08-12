import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2) ) {
					return 1;
				}
				else if(Math.abs((int) o1) == Math.abs((int) o2)) {
					if((int) o1 > (int) o2)
						return 1;
					else 
						return -1;
				}
				else {
					return -1;
				}
				
			}
		});
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp!=0)
			{
				pq.add(tmp);
			}
			else {
				if(pq.isEmpty())
					System.out.println("0");
				else {
					System.out.println(pq.poll());
				}
			}
				
		}
		
		
		
	}

}
