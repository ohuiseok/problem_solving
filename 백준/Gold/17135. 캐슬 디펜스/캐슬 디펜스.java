import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N,M,D;
	static int[][] area;
	static int[][] archer = new int[3][2];//3명의 x,y좌표
	static boolean[] isArcher;
	static int answer;
	static int maxAnswer = Integer.MIN_VALUE;
	//적을 가장 많이 제거할 수 있는 위치는 성. MC3의 경우의 수 일듯. 0~M-1까지 수 중에 3개뽑기
	
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(area[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static boolean isGameEndAndMove() {
		boolean endFlag = true;
		
		for(int i=N-1;i>=0;i--) {//아래줄 부터 시작/
			for(int j=0;j<M;j++) {
				if(area[i][j]==1) {
					if(i==N-1)
						area[i][j]=0;//성으로 진입
					else {
						area[i+1][j]=area[i][j];//아래로 이동
						area[i][j]=0;//아래로 이동
						endFlag = false;
					}
				}
			}
		}
		
		return endFlag;//true면 게임 끝
	}
	
	
	public static int killEnemyNum (int count,int[][] attackLocation,boolean[] meetEnemy) {
		int killNum = 0;
		if(count == 3) {
			if(attackLocation[0][0]==attackLocation[1][0] && attackLocation[0][1]==attackLocation[1][1]
					&& attackLocation[0][0]==attackLocation[2][0] && attackLocation[0][1]==attackLocation[2][1]&& meetEnemy[0]&& meetEnemy[1]&& meetEnemy[2] ) {
				killNum=1;//3개가 다 같을 경우
			}
			else if(attackLocation[0][0]==attackLocation[1][0] && attackLocation[0][1]==attackLocation[1][1]&& meetEnemy[0] && meetEnemy[1] ) {
				killNum=2;//2개만 같을 경우
			}
			else if(attackLocation[0][0]==attackLocation[2][0] && attackLocation[0][1]==attackLocation[2][1]&& meetEnemy[0] && meetEnemy[2]) {
				killNum=2;//2개만 같을 경우
			}
			else if(attackLocation[1][0]==attackLocation[2][0] && attackLocation[1][1]==attackLocation[2][1]&& meetEnemy[1] && meetEnemy[2]) {
				killNum=2;//2개만 같을 경우
			}
			else {
				killNum=3;//다 다를경우
			}
			
			
		}
		else if(count == 2) {
			if(attackLocation[0][0]==attackLocation[1][0] && attackLocation[0][1]==attackLocation[1][1] && meetEnemy[0] && meetEnemy[1]) {
				killNum=1;//2개가 같을 경우
			}
			else if(attackLocation[0][0]==attackLocation[2][0] && attackLocation[0][1]==attackLocation[2][1]&& meetEnemy[0] && meetEnemy[2]) {
				killNum=1;//2개가 같을 경우
			}
			else if(attackLocation[1][0]==attackLocation[2][0] && attackLocation[1][1]==attackLocation[2][1]&& meetEnemy[1] && meetEnemy[2]) {
				killNum=1;//2개가 같을 경우
			}
			else {
				killNum=2;//다 다를경우
			}
		}
		else if(count == 1) {
			killNum = 1;
		}

		return killNum;
		
	}
	
	
	public static void archerAttack() {
		int[][] attackLocation = new int[3][2];//r,c좌표
		boolean[] meetEnemy = new boolean[] {false,false,false};
		int count = 0;
		
		
		for(int a=0;a<3;a++) {
			for(int availD =1; availD<=D;availD++) {
				
				for(int add=0; add<=availD;add++) { 
					int r = archer[a][0]-add;
					int leftC = archer[a][1]-(availD-add);
					if(r==archer[a][0] || r<0 || r>=N )
						continue;
					if(leftC>=0 && leftC<M && area[r][leftC]==1) {
						meetEnemy[a] = true;
						attackLocation[a][0] = r;
						attackLocation[a][1] = leftC;
						break;
					}
				}
				if(meetEnemy[a])
					break;
				for(int add=availD; add>=0;add--) { 
					int r = archer[a][0]-add;
					int rightC = archer[a][1]+(availD-add);
					if(r==archer[a][0] || r<0 || r>=N)
						continue;
					if(rightC>=0 && rightC<M && area[r][rightC]==1) {
						meetEnemy[a] = true;
						attackLocation[a][0] = r;
						attackLocation[a][1] = rightC;
						break;
					}
				}
				if(meetEnemy[a])
					break;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		for(int a=0;a<3;a++) {
//			int r = archer[a][0];
//			int c = archer[a][1];
//			int minDistance = Integer.MAX_VALUE;
//			
//			for(int i=N-1;i>=0;i--) {//아래 줄 부터 시작
//				for(int j=0;j<M;j++) { // 왼쪽 부터 시작
//					if(area[i][j]==1) {
//						int distance = Math.abs(i-r)+Math.abs(j-c);
//						if(distance <= D && distance <minDistance) {
//							minDistance=distance;
//							attackLocation[a][0] = j;
//							attackLocation[a][1] = i;
//							meetEnemy[a] = true;
//						}
//						else if(distance <= D && distance == minDistance && attackLocation[a][0] < j) {
//							attackLocation[a][0] = j;
//							attackLocation[a][1] = i;
//							meetEnemy[a] = true;
//						}
//					}
//				}
////				if(meetEnemy[a])//속도 때문에
////					break;
//			}
////			System.out.println("r:"+r+" c:"+c);
//			
//		}
//		
//		for(int i=0;i<3;i++) {
//			if(meetEnemy[i]) {
//				count++;
//			}
//		}
//		System.out.println(count);

		for(int i=0;i<3;i++) {
			if(meetEnemy[i]) {
				area[attackLocation[i][0]][attackLocation[i][1]]=0;
				count++;
			}
		}
		answer+=killEnemyNum(count,attackLocation,meetEnemy);
		
	}
	
	public static void archerSetting(int search,int count) {
		if(count==3) {
			int[][] tmp = copyArray(area);
//			System.out.print(Arrays.toString(archer[0])+" "+Arrays.toString(archer[1])+" "+Arrays.toString(archer[2]));
//			System.out.println();
			answer = 0;
			while(true) {
//				print();
//				System.out.println(answer);
				archerAttack();
//				print();
				if(isGameEndAndMove())
					break;
			}
//			System.out.println(answer);
//			System.out.println("======================");
			if(maxAnswer < answer)
				maxAnswer = answer;
			area=tmp;
			return;
		}
		
		for(int i=search;i<M;i++) {
			if(isArcher[i])
				continue;
			isArcher[i]=true;
			archer[count][1]=i;//조합에 의해 놓을 곳
			archer[count][0]=N;//성에 놓을 것
			archerSetting(i,count+1);
			isArcher[i]=false;
		}
	}
	
	public static int[][] copyArray(int[][] origin){
		int [][] newArray = new int[origin.length][origin[0].length];
		
		for(int i=0;i<origin.length;i++)
			for(int j=0;j<origin[0].length;j++)
				newArray[i][j]=origin[i][j];
		
		return newArray;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		isArcher = new boolean[M];
		area = new int[N+1][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		archerSetting(0,0);
		System.out.println(maxAnswer);
	}
	
	
	/*
	 * 모든 궁수는 동시에 D거리 이하의 "가장 가까운" 맨 왼쪽부터 공격한다. 3명놓는다.(같은 적이 여러 궁수에게 당할 수 있다. 한번맞으면 적은 gameover)
	 * 한칸에 하나의 궁수. 혹은 하나의 적
	 * 궁수먼저 공격->적은 아래로 내려옴. 반복. 적이 성에 내려오면 The end
	 * (궁수를 성에 놓아야 함)
	 * 격자판에 적이 존재하지 않으면 끝!! 다 죽이던지, 성에 다 들어오던지
	 * */

}
