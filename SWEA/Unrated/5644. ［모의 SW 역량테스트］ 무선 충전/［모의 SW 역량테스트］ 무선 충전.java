import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] curPersonA = new int[2]; // 현재 위치 y,x
	static int[] curPersonB = new int[2];
	static int[] personA;	//앞으로 갈 것
	static int[] personB;
	static int index,A;//위치 , 안테나 갯수
	static int[][] area;
	static int antennaPower[];
	static final int[][] dir = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	static int point;
	
	public static void print() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++)
				System.out.print(area[i][j]+"\t");
			System.out.println();
		}
	}
	
	public static void antennaSetting(int[][] antennaInfo) {
		antennaPower = new int[A];
		for(int i=0;i<A;i++) {
			antennaPower[i]=antennaInfo[i][3];
		}
		
		for(int k=0;k<A;k++) {
			int BCflag = 1<<k;	//해당  BC의 존재 여부
			
			 for(int i=0;i<10;i++) {
				 for(int j=0;j<10;j++) {
					 int d = Math.abs(i-antennaInfo[k][1])+Math.abs(j-antennaInfo[k][0]);
					 if(d<=antennaInfo[k][2])
						 area[i][j]+=BCflag;
				 }
			 }
		}
	}
	
	public static void move(int moveNum) {
		addPoint(curPersonA[1],curPersonA[0],curPersonB[1],curPersonB[0]);
		
		for(int i=0;i<moveNum;i++) {
			curPersonA[0]+=dir[personA[i]][0]; 	//이동한 곳의  x좌표
			curPersonA[1]+=dir[personA[i]][1];//이동한 곳의  y좌표
			curPersonB[0]+=dir[personB[i]][0]; 	//이동한 곳의  x좌표
			curPersonB[1]+=dir[personB[i]][1];//이동한 곳의  y좌표
			addPoint(curPersonA[1],curPersonA[0],curPersonB[1],curPersonB[0]);
		}
		
	}
	public static void addPoint(int personAX ,int personAY, int personBX, int personBY) {
		int existAntennaA = 0; 
		int existAntennaB = 0; 
		int pointA = 0, pointB = 0, both=0;
		
		for(int i=A-1;i>=0;i--) {
			int BCFlag = 1<<i;
			if((area[personAY][personAX]&BCFlag)==BCFlag)
				existAntennaA=existAntennaA|BCFlag;
			if((area[personBY][personBX]&BCFlag)==BCFlag)
				existAntennaB=existAntennaB|BCFlag;
		}
		
		
		if(existAntennaA==0&& existAntennaB==0) {
			return;
		}
		else if(existAntennaA==0) {
			for(int i=A-1;i>=0;i--) {
				int BCFlag = 1<<i;
				if((existAntennaB&BCFlag)==BCFlag) {
					point += antennaPower[i];
//					System.out.println("A : "+antennaPower[i]);
					break;
				}
			}
		}
		else if(existAntennaB==0) {
			for(int i=A-1;i>=0;i--) {
				int BCFlag = 1<<i;
				if((existAntennaA&BCFlag)==BCFlag) {
					point += antennaPower[i];
//					System.out.println("B : "+antennaPower[i]);
					break;
				}
			}
			
		}else {
			
			point += caseAllMaxPoint(existAntennaA,existAntennaB);
			
//			
//			if( (existAntennaA&existAntennaB)==0) { //  겹치는 것이 존재 하지 않을 때,
//				for(int i=A-1;i>=0;i--) {
//					int BCFlag = 1<<i;
//					if((existAntennaA&BCFlag)==BCFlag) {
//						point += antennaPower[i];
////						System.out.println("A : "+antennaPower[i]);
//						break;
//					}
//				}
//				for(int i=A-1;i>=0;i--) {
//					int BCFlag = 1<<i;
//					if((existAntennaB&BCFlag)==BCFlag) {
//						point += antennaPower[i];
////						System.out.println("B : "+antennaPower[i]);
//						break;
//					}
//				}
//			}
//			else {				// 겹치는 것이 존재할 때
//				
//				
//				
//			}
		}
		
//		for(int i=A-1;i>=0;i--) {
//			int BCFlag = 1<<i;
//			boolean alreayReceive= false;//사람이 겹칠경우
//			
//			if((area[personAY][personAX]&BCFlag)==BCFlag && (!aReceive) && (!alreayReceive)) {
//				point += antennaPower[i];
//				aReceive= true;
//				alreayReceive  = true;
////				System.out.println("antennaPower "+antennaPower[i]);
//			}
//			if((area[personBY][personBX]&BCFlag)==BCFlag && (!bReceive) && (!alreayReceive)) {	//안테나가 2개 이상 겹치는 경우 없음
//				point += antennaPower[i];
//				bReceive= true;
////				System.out.println("antennaPower "+antennaPower[i]);
//			}
//		}
	}
	
	public static int caseAllMaxPoint(int existAntennaA,int existAntennaB) {
		int MaxValue = Integer.MIN_VALUE;
		
		for(int i=0 ; i < A ; i++) {
			int personAFlag = 1 << i;
			if((existAntennaA&personAFlag)==0)
				continue;
				
			for(int j=0;j < A ; j++) {
				int personBFlag = 1 << j;
				if((existAntennaB&personBFlag)==0)
					continue;
				
				if(j==i) {
					if(MaxValue<antennaPower[i])
						MaxValue=antennaPower[i];
				}
				else {
					int tmp =antennaPower[i]+antennaPower[j];

					if(MaxValue<tmp)
						MaxValue=tmp;
				}
				
			}
		}
		return MaxValue;
		}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=testCase;t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); //  몇번갈건지
			A = Integer.parseInt(st.nextToken()); //  충전기 갯수
			personA = new int[M];
			personB = new int[M];
			area = new int[10][10];
			
			///////////////////////사람 이동 정보//////////////////////////
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				personA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				personB[i] = Integer.parseInt(st.nextToken());
			}

			///////////////////////안테나 정보//////////////////////////
			int[][] antennaInfo = new int[A][4];
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++) {
					antennaInfo[i][j]=Integer.parseInt(st.nextToken());
					if(j<2)
						antennaInfo[i][j]--;
				}
			}
			Arrays.sort(antennaInfo, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) { // 오름차순
					if(o1[3] < o2[3])
						return -1;
					else if(o1[3] > o2[3])
						return 1;
					else
						return 0;
				}
				
			});
//			for(int i=0;i<A;i++) {
//			System.out.println(Arrays.toString(antennaInfo[i]));
//			}
			antennaSetting(antennaInfo);
//			print();
			
			curPersonA[0]=0;
			curPersonA[1]=0;
			curPersonB[0]=9;
			curPersonB[1]=9;
			point=0;
			move(M);
			System.out.println("#"+t+" "+point);
		}
		
/*
 *
지역을 설정. 
마스킹 코드 이용 
000 (nothing) BC1,BC2,BC3순서
111 (all)
시간마다 이동, 위치에 따라 BC 적립(겹칠 경우 둘 다 충전할 수 있도록), 

 *
 */

	}

}