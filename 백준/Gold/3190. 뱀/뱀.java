import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static Deque<int []> snakeLocaton = new ArrayDeque<int []>();
	static List<int []> command;
	static int[][] area;
	static int N;
	static final int up = 0;
	static final int right = 1;
	static final int down = 2;
	static final int left = 3;
	static int second = 0;
	
	public static int dirCheck(int dir) {
		int curDir = dir;
		if((!command.isEmpty())&&command.get(0)[0]==second) {

			if(command.get(0)[1]=='L') {
				curDir = (curDir+4-1)%4;
			}
			if(command.get(0)[1]=='D') {
				curDir = (curDir+1)%4;
			}	
			command.remove(0);
		}
		return curDir;
	}
	
	
	
	public static void gameStart(int r, int c, int dir){
		second++;
		if(r>N || c >N || r<1 || c<1 || area[r][c]==1) {//벽 또는 자기자신과 부딪히면 the end
			return;
		}
		snakeLocaton.add(new int[] {r,c});
		if(area[r][c]!=2) {//온 곳에 사과가 없다면
			int[] erase = snakeLocaton.pollFirst();
			area[erase[0]][erase[1]]=0;
		}
		area[r][c]=1;
		
		int nextDir = dirCheck(dir);
		
		switch(nextDir) {
		case up:{
			gameStart(r-1,c,nextDir);
			break;
		}
		case right:{
			gameStart(r,c+1,nextDir);
			break;
		}
		case down:{
			gameStart(r+1,c,nextDir);
			break;
		}
		case left:{
			gameStart(r,c-1,nextDir);
			break;
		}
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		/////보드크기
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		//보드 세팅
		area = new int[N+1][N+1];
		///사과 수
		int K = Integer.parseInt(st.nextToken());
		//사과 위치
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()); //R 행
			int c = Integer.parseInt(st.nextToken()); //C 열
			area[r][c] = 2;
		}
		//방향전환 수
		st = new StringTokenizer(br.readLine(), " ");
		int dirNum = Integer.parseInt(st.nextToken()); 
		//방향전환 위치
		command = new ArrayList<int []>();
		for(int i=0;i<dirNum;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			command.add(new int[] {Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)});
		}
		//////////////////////up just setting///////////////////
		//1은 뱀. 2는 사과. 
		area[1][1] =1;
		snakeLocaton.add(new int[] {1,1});
		gameStart(1,2,right);//오른쪽으로 한칸 이동 // 
		System.out.println(second);
	}

	/*
	 * 
이동 한다 -> 사과 있는지 본다 (있으면 뒤에 길이 그대로, size++) 
				-> 커맨드 확인
	 * */
}
