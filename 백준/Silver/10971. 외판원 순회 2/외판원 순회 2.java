import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] area;
	static int N;
	static boolean[] isVisited;
	static int minValue = Integer.MAX_VALUE;
	

	public static boolean allVisited() {
		for(int i=0;i<N;i++)
			if(!isVisited[i])
				return false;
		
		return true;
	}
	
	
	public static void searchWay(int sum,int start) {
		if(allVisited()) {
			if(area[start][0]!=0)//되돌아 갈 수 있어야 함...
				minValue = Math.min(minValue, sum+area[start][0]);
			return;
		}
		for(int i=0;i<N;i++) {
			if(isVisited[i]||area[start][i]==0)
				continue;
			isVisited[i]= true;
			searchWay(sum+area[start][i],i);
			isVisited[i]= false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		area = new int[N][N];
		isVisited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				area[i][j] = Integer.parseInt(st.nextToken());
		}

		isVisited[0]= true;
		searchWay(0,0);
		System.out.println(minValue);


	}
}