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
		
		//System.out.println("νμ¬ μμΉ "+r+""+c);
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
			
			
			for(int i=0;i<row;i++) {	// map μλ ₯
				tmp = br.readLine();
				for(int j=0;j<column;j++) {
					area[i][j] = tmp.charAt(j);
				}
			}
			moveNum = Integer.parseInt(br.readLine());
			moveCmd = new char[moveNum];

			tmp = br.readLine();	//μ»€λ§¨λ μλ ₯
			for(int i=0;i<moveNum;i++) 
				moveCmd[i] = tmp.charAt(i);
				
			
			///////////μμλ μλ ₯////////////////
			curLocation(area);	//νμ¬ μμΉ 
			

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
	 * (νμ€νΈ μΌμ΄μ€ λ§νΌ λ°λ³΅)
	 * {
	 * 
	 * ν μ΄ μλ ₯λ°μ
	 * map μ§ν μλ ₯λ°μ
	 * μ΄λνμ μλ ₯λ°μ
	 * μ΄λνμλ§νΌ λ¬΄μΈκ° μλ ₯λ°μ
	 * 
	 * 1. μ μ°¨μ μμΉ λ° μ μ°¨μ λ°©ν₯μ μ°Ύλλ€.
	 * 2. μλ ₯κ°μ λ°λΌ μ΄λ λ° λμμ κ΅¬ννλ€.
	 * 3. μ΄λνμλ§νΌ λ°λ³΅
	 * 4. 
	 * 
	 * }
	 * 
	 * 
	 * */
}