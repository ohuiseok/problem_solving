import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int[] person;//각 구역 인구수 1부터N까지
	static int[][] connection;//구역 연결 상태 1~N
	static int minValue = Integer.MAX_VALUE;
	static int[] choose;//1~N 0은 왼쪽구역,1은 오른쪽구역
	static boolean[] isVisited;//1~N 0은 왼쪽구역,1은 오른쪽구역

	/*
 * 두 구역 분배 -> 왼쪽 가던지 오른쪽 가던지
 * ->마지막에 가능성 확인 -> BFS갯수가 3등분이상or1등분은 fail
 * 2등분 딱 되면 그때 leftSum과 rightSum 차이를 minValue에 넣기
 * 
 * */
	
	public static void DFS(int tmp,int where) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(tmp);
		
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(isVisited[cur])
				continue;
			isVisited[cur] = true;
			
			for(int j=1;j<=N;j++) {
				if(connection[cur][j]==1 && !isVisited[j] && choose[j]==where)
					queue.add(j);
			}
		}
	}
	
	public static void combination(int count,int leftSum,int rightSum) {
		if(count == N+1) {
			int division = 0;
			isVisited = new boolean[N+1];
			for(int i=1;i<=N;i++) {
				if(!isVisited[i]) {
					DFS(i,choose[i]);
					division++;
				}
			}
			if(division==2) {
				int diff = Math.abs(leftSum-rightSum);
				if(minValue > diff)
					minValue = diff;
			}
			return;
		}
		choose[count] = 0;
		combination(count+1,leftSum+person[count],rightSum);
		choose[count] = 1;
		combination(count+1,leftSum,rightSum+person[count]);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		person = new int[N+1];
		connection = new int[N+1][N+1];
		choose = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
			person[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j=0;j<M;j++) {
				int to = Integer.parseInt(st.nextToken());
				connection[i][to] = 1;
				connection[to][i] = 1;
			}
		}
		
		combination(1,0,0);
		if(minValue == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(minValue);
	}
}