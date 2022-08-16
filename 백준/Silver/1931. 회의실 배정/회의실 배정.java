import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		int answer = 0;
		int curTime = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] < o2[1]) {
					return -1;
				} else if (o1[1] > o2[1]) {
					return 1;
				} else {
					if (o1[0] < o2[0])
						return -1;
					else if (o1[0] > o2[0])
						return 1;
					else
						return 0;
				}

			}
		});
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int longTime = Integer.parseInt(st.nextToken());
			pq.add(new int[] { startTime, longTime });
		}

		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();

			if (curTime > tmp[0])
				continue;

			curTime = tmp[1];
			answer++;

		}
		System.out.println(answer);

	}

}
