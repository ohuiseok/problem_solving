import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Queue<Integer> card = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int number = 0;
		
		for(int i=1;i<=N;i++)
			card.offer(i);
		/*
		 * 1 2 3 4 5
		 *     3 4 5 2
		 *         5 2 4 
		 *             4 2
		 *             	 2
		 * */
		while(card.size()!=1) {
			card.poll();
			card.offer(card.poll());
		}
		
		bw.write(card.poll().toString());
		bw.flush();
		bw.close();
	}

}
