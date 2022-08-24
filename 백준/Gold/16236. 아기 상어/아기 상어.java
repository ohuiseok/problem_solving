import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	
	
	static class BabyShark{
		int x,y;
		int size;
		int requireFood;
		
		public BabyShark(int y, int x, int size, int requireFood) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.requireFood = requireFood;
		}
	}
	

	static BabyShark babyShark;
	
	static int[][] area;
	static int N;
	static final int[][] dir= {{-1,0},{0,-1},{0,1},{1,0}};//상 좌 우 하
	static int answer;
	public static void print() {
		System.out.println("아기상어 사이즈 : "+babyShark.size +" 총이동 거리 : "+answer);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(area[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int searchAndEat() {
		boolean[][] isVisited = new boolean[N][N];
		
		PriorityQueue<int []> queue = new PriorityQueue<int []>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] < o2[0]) return -1;
				if(o1[0] > o2[0]) return 1;
				if(o1[1] < o2[1]) return -1;
				if(o1[1] > o2[1]) return 1;
				return 0;
			}
		});
		queue.add(new int[] {babyShark.y,babyShark.x});

		isVisited[babyShark.y][babyShark.x]=true;
		
		int count = 0;

		while(!queue.isEmpty()) {
			PriorityQueue<int []> newQueue = new PriorityQueue<int []>(new Comparator<int[]>(){
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if(o1[0] < o2[0]) return -1;
					if(o1[0] > o2[0]) return 1;
					if(o1[1] < o2[1]) return -1;
					if(o1[1] > o2[1]) return 1;
					return 0;
				}
			});
			
			while(!queue.isEmpty()) { //있는 거 다빼서 확인
				int[] loc = queue.poll();
				if(area[loc[0]][loc[1]]!=0 && area[loc[0]][loc[1]] < babyShark.size && area[loc[0]][loc[1]]!= 9 ) {
					//0도아니고, 아기 상어보다 작고 9도 아니면 먹을 수 있는 물고기다
					area[babyShark.y][babyShark.x]=0;
					area[loc[0]][loc[1]]=9;
					babyShark.y = loc[0];
					babyShark.x = loc[1];
					babyShark.requireFood--;
					if(babyShark.requireFood==0) {
						babyShark.size++;
						babyShark.requireFood = babyShark.size;
					}
					return count;	//먹이 찾음
					
				}
				
				for(int i=0;i<4;i++) {
					int newR = loc[0] +dir[i][0];
					int newC = loc[1] +dir[i][1];
					
					if(newR<0 || newR>=N ||newC<0 || newC>=N || isVisited[newR][newC] || area[newR][newC] > babyShark.size)
						continue;//아기상어보다 크면 이동 불가
					
					isVisited[newR][newC]=true;
					newQueue.add(new int[] {newR,newC});
				}
			}
			
			queue = newQueue;
			count++;
			
		}
		
		return 0;
	}
	/*
	 * BFS 정리 =>
	 * 		queue에서 값을 다 뺀다. (도착지가 존재하면 빠져나온다.)
	 * 			주변값을 탐색한다.(바운더리 안, size가능, 방문여부 판별)
	 * 				가능하면  queue에 넣는다.
	 * 		카운터++
	 * */
	
	
	public static void eatFish() {
		answer = 0 ;
		while(true) {
			int tmp = searchAndEat();
			if(tmp==0) {
				System.out.println(answer);
				return;
			}
			answer+=tmp;
//			print();
			
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		area = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j]==9)
					babyShark = new BabyShark(i,j,2,2);
			}
		}
		
		
		eatFish();


	}

	
	
}
