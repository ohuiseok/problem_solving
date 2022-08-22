import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static boolean[][] area;
	static boolean[]isUsed;
	
	public static int searchCall(int start) {
		Queue<Integer> store = new LinkedList<Integer>();
		isUsed[start]=true;
		store.add(start);
		int answer = 0;
		while(true) {
			int size = store.size();
			int maxValue = Integer.MIN_VALUE;
			if(size==0) {
				break;
			}
			while(size>0) {
				size--;
				int tmpIndex = store.poll();
				for(int i=1;i<=100;i++) {
					if(!area[tmpIndex][i])//방향확인
						continue;
					if(isUsed[i])//사용했는 지 확인
						continue;
					isUsed[i] = true;
					store.add(i);
					if(maxValue < i )
						maxValue = i;
				}
			}
//			System.out.println(Arrays.toString(store.toArray()));
			if(maxValue!=Integer.MIN_VALUE)
				answer = maxValue;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = 10;
		
		for(int t=1;t<=testCase;t++) {
			Map<Integer,List<Integer>> store = new HashMap<Integer,List<Integer>>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			area = new boolean[101][101];
			isUsed = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N/2;i++) {
				area[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			System.out.println("#"+t+" "+searchCall(start));
			
		}
		

	}

}
