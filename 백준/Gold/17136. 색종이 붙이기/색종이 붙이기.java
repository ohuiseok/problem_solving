import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] area = new int[10][10];
	static int[] paperSize = {5,5,5,5,5};// 1부터 5까지 5장씩 존재(0부터 시작인 이유는 1칸마다 1의 길이를 가져서) 
	static int answer = Integer.MAX_VALUE;
	static boolean success = false;
	
	public static void print()
	{
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
			System.out.print(area[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean isSuccess() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(area[i][j]==1)
					return false;
			}
		}
		return true;
	}
	
	public static void putColorPaper(int r, int c, int size) {
		for(int i=r;i<=r+size;i++) 
			for(int j=c;j<=c+size;j++)
				area[i][j]=0;
	}
	
	public static void putBackPaper(int r, int c, int size) {
		for(int i=r;i<=r+size;i++) 
			for(int j=c;j<=c+size;j++)
				area[i][j]=1;
	}
	
	
	public static boolean getPossiblity(int r,int c,int pSize) {
		if( r+pSize>=10 || c+pSize>=10 )
			return false;
		if(paperSize[pSize]<=0) 
			return false;
		
		for(int i=r;i<=r+pSize;i++) {
			for(int j=c;j<=c+pSize;j++) {
				if(area[i][j]==0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void allCase(int startR,int startC) {
		int c = startC + 1;
		int r = startR;
		if(c == 10) {
			c = 0;
			r++;
		}
		if(r==10 && c==0) {
			if(isSuccess()) {
				int num = 0;
				for(int a : paperSize)
					num+= 5-a;
				if(num < answer)
					answer = num;
				success = true;
			}
			return;	
		}
		
		for(int i=4;i>=0;i--)
			if(getPossiblity(r,c,i)) {
				paperSize[i]--;
				putColorPaper(r,c,i);
				allCase(r,c);
				putBackPaper(r,c,i);
				paperSize[i]++;
			}
		 
//		System.out.println("r : "+r+" c : "+c);
		if(area[r][c]==0)
			allCase(r,c);

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<10;j++) {
				area[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		allCase(0,-1);
		if(!success)
			System.out.println("-1");
		else
			System.out.println(answer);
	}

	/*
	 * 탐색 시작. 
	 * 1만나면 4,3,2,1,0,사이즈별로 가능한지 판별,
	 * 가능하면 색종이 붙일 수 있는 경우의 수만큼 붙이고 다음으로 넘어감
	 * */
}
