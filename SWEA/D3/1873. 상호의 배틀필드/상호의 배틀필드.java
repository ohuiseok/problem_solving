import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int r=0,c=0;
	static int row=0,column=0;
	
	public static void curLocation(char[][] area) {
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++) {
				switch(area[i][j]) {
				case '<':
				case '>':
				case '^':
				case 'v':
					r=i;
					c=j;
					break;
				}
			}
		
		//System.out.println("현재 위치 "+r+""+c);
	}
	
	
	public static void shoot(char[][] area) {
		switch(area[r][c]) {
		case '<':
			for(int i=c-1;i>=0;i--) {
				if(area[r][i]=='#')
					break;
				if(area[r][i]=='*') {
					area[r][i]='.';
					break;
				}
			}
			break;
		case '>':
			for(int i=c+1;i<column;i++) {
				if(area[r][i]=='#')
					break;
				if(area[r][i]=='*') {
					area[r][i]='.';
					break;
				}
			}
			break;
		case '^':
			for(int i=r-1;i>=0;i--) {
				if(area[i][c]=='#')
					break;
				if(area[i][c]=='*') {
					area[i][c]='.';
					break;
				}
			}
			break;
		case 'v':
			for(int i=r+1;i<row;i++) {
				if(area[i][c]=='#')
					break;
				if(area[i][c]=='*') {
					area[i][c]='.';
					break;
				}
			}
			break;
		}
	}
	
	
	public static void action(char[][] area,char cmd) {
		switch(cmd) {
		case 'U':
			if( r-1 >= 0 && area[r-1][c]=='.') {
				area[r][c]='.';
				r--;
			}
			area[r][c]='^';
			break;
		case 'D':
			if( r+1 < row && area[r+1][c]=='.') {
				area[r][c]='.';
				r++;
			}
			area[r][c]='v';
			break;
		case 'L':
			if( c-1 >=0 && area[r][c-1]=='.') {
				area[r][c]='.';
				c--;
			}
			area[r][c]='<';
			break;
		case 'R':
			if( c+1 < column && area[r][c+1]=='.') {
				area[r][c]='.';
				c++;
			}
			area[r][c]='>';
			break;
		case 'S':
			shoot(area);
			break;
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testCase;t++)
		{
			st=new StringTokenizer(br.readLine()," ");
			row = Integer.parseInt(st.nextToken());
			column = Integer.parseInt(st.nextToken());
			char[][] area = new char[row][column];
			int moveNum;
			char[] moveCmd;
			String tmp;
			
			
			for(int i=0;i<row;i++) {	// map 입력
				tmp = br.readLine();
				for(int j=0;j<column;j++) {
					area[i][j] = tmp.charAt(j);
				}
			}
			moveNum = Integer.parseInt(br.readLine());
			moveCmd = new char[moveNum];

			tmp = br.readLine();	//커맨드 입력
			for(int i=0;i<moveNum;i++) 
				moveCmd[i] = tmp.charAt(i);
				
			
			///////////위에는 입력////////////////
			curLocation(area);	//현재 위치 
			

//			System.out.println("Start");
//			for(int i=0;i<row;i++) { 	
//				for(int j=0;j<column;j++) 
//					System.out.print(area[i][j]);
//				System.out.println();
//			}
			
			for(char cmdStart : moveCmd)
			{	
				action(area,cmdStart);

//				System.out.println("cmd : "+cmdStart);
//				for(int i=0;i<row;i++) { 	
//					for(int j=0;j<column;j++) 
//						System.out.print(area[i][j]);
//					System.out.println();
//				}
			}
			
			System.out.print("#"+t+" ");
			for(int i=0;i<row;i++) { 	
				for(int j=0;j<column;j++) 
					System.out.print(area[i][j]);
				System.out.println();
			}
		}
	}
	
	/*
	 * (테스트 케이스 만큼 반복)
	 * {
	 * 
	 * 행 열 입력받음
	 * map 지형 입력받음
	 * 이동횟수 입력받음
	 * 이동횟수만큼 무언가 입력받음
	 * 
	 * 1. 전차의 위치 및 전차의 방향을 찾는다.
	 * 2. 입력값에 따라 이동 및 동작을 구현한다.
	 * 3. 이동횟수만큼 반복
	 * 4. 
	 * 
	 * }
	 * 
	 * 
	 * */
}