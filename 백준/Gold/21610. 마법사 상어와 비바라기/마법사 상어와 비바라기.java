import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] area;
	static boolean[][] isSelect;
	static final int[][] dirType = {{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
	static final int[][] diagonal = {{-1,-1},{-1,1},{1,-1},{1,1}};
	static int N;
	
	
	
	public static void moveCloud(int dir,int distance) {
		boolean[][] newSelect = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(isSelect[i][j]) {
					int r=i+dirType[dir][0]*distance;
					int c=j+dirType[dir][1]*distance;
					
					while(r<0) {
						r=N+r;
					}
					while(c<0) {
						c=N+c;
					}
					r%=N;
					c%=N;
					newSelect[r][c]=true;
					area[r][c]++;
				}
			}
		}
		isSelect=newSelect;
	}
	public static void copyWater() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!isSelect[i][j]) 
					continue;
				for(int k=0;k<diagonal.length;k++) {
					int r=i+diagonal[k][0];
					int c=j+diagonal[k][1];
					if( r>=0 && r<N && c>=0 && c<N && area[r][c]!=0) { 
						area[i][j]++;
					}
				}
					
			}
		}
	}
	
	public static void newCloud() {
		boolean[][] newSelect = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(area[i][j]<2)
					continue;
				if(isSelect[i][j])
					continue;
				newSelect[i][j]=true;
				area[i][j]-=2;
			}
		}
		isSelect=newSelect;
	}
	public static int sumWater() {
		int sum=0;
	
		for(int i=0;i<N;i++) 
			for(int j=0;j<N;j++) 
				sum+=area[i][j];
		return sum;
	}
	
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) 
				System.out.print(area[i][j]+" ");
		System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int repeat = Integer.parseInt(st.nextToken());
		
		area = new int[N][N];
		isSelect = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				area[i][j] = Integer.parseInt(st.nextToken());
		}
		
		isSelect[N-1][0]=true;
		isSelect[N-1][1]=true;
		isSelect[N-2][0]=true;
		isSelect[N-2][1]=true;//초반 구름
		
		for(int r=0;r<repeat;r++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
//			print();
			moveCloud(dir,distance);
//			print();
			copyWater();
//			print();
			newCloud();
		}
		System.out.println(sumWater());
/*
 * 구름 선택
 * 
 * 
 * 이동
 * 구름 있던 곳 물 1증가
 * 
 * 대각선에 물이 존재하면 1증가(다만 외곽선 안됨)
 * 
 * 구름 사라짐
 * 물 양이 2이상인 곳에 구름 생성(전과 달라야함) & 해당 자리 물은2씩 감소
 * 
 * 반복.
 * 
 * 그 후 모든 칸 물 양 출력

 *
 */

	}

}