import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static List<int []> zeroLocation = new ArrayList<int []>();
	static int[][] area;
	static boolean onceFlag = false;
	
	public static void print() {
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				System.out.print(area[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static boolean isSuccess() {
		for(int[] loc : zeroLocation) {
			if( area[loc[0]][loc[1]] == 0)
				return false;
			boolean[] numCheck1 = new boolean[10];
			boolean[] numCheck2 = new boolean[10];
			boolean[] numCheck3 = new boolean[10];
			squareCheck(numCheck3,loc[0],loc[1]);
			for(int i=1 ; i<=9 ; i++) {
				if( numCheck1[area[loc[0]][i]])
					return false;
				if( numCheck2[area[i][loc[1]]])
					return false;
				if(!numCheck3[i])
					return false;
				numCheck1[area[loc[0]][i]] = true;
				numCheck2[area[i][loc[1]]] = true;
			}
			
		}
		
		
		return true;
	}
	
	public static void verticalCheck(boolean[] arr, int c) {
		for(int r=1;r<=9;r++ ) {
			arr[area[r][c]]= true;
		}
	}
	
	public static void horizonCheck(boolean[] arr, int r) {
		for(int c=1;c<=9;c++ ) {
			arr[area[r][c]]= true;
		}
	}
	
	public static void squareCheck(boolean[] arr, int r, int c) {
		int startR = ((r - 1)/3)*3 + 1;
		int startC = ((c - 1)/3)*3 + 1;
		for(int newR = startR ; newR<startR+3 ; newR++) {
			for(int newC = startC ; newC<startC+3 ; newC++) {
				arr[area[newR][newC]]= true;
			}
		}
	}
	
	public static void sudokuStart(int index) {
		if(zeroLocation.size() == index && (!onceFlag) && isSuccess()  ) {
			print();
			onceFlag = true;
			return;
		} 
		if(onceFlag)
			return;
		int[] loc = zeroLocation.get(index);
		boolean[] numberCheck = new boolean[10];
		verticalCheck(numberCheck,loc[1]);
		horizonCheck(numberCheck,loc[0]);
		squareCheck(numberCheck,loc[0],loc[1]);
//		System.out.println(index);
//		print();
		for(int i=1;i<=9;i++) {
			if(numberCheck[i])
				continue;
			area[loc[0]][loc[1]] = i;
			sudokuStart(index+1); 
			area[loc[0]][loc[1]] = 0;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		area = new int[10][10];
		
		for(int i=1;i<=9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			for(int j=1;j<=9;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j]==0)
					zeroLocation.add(new int[] {i,j});
			}	
		}
		
		sudokuStart(0);
		
	}
	/*
	 * zero 위치만 넣기.
	 * 가로선,세로선,사각형을 검색해서 없는 값을 찾아 넣는다.
	 * 
	 */
}
