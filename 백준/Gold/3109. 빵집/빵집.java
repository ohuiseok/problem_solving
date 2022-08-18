import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static char[][] area;
	static int R,C;
	static int answer = 0;
	
	public static void print() {
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[0].length; j++) {
				System.out.print(area[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean pipeGo(int y, int x) {
		if(x==C-1) {
			answer++;
//			print();
			return true;
		}
		area[y][x]='#';

		if(y-1>=0 && area[y-1][x+1]=='.')
			if(pipeGo(y-1,x+1)) {
				return true;
			}

		if(area[y][x+1]=='.')
			if(pipeGo(y,x+1)) {
				return true;
			}
		

		if(y+1<R && area[y+1][x+1]=='.')
			if(pipeGo(y+1,x+1)) {
				return true;
			}

//		area[y][x]='.';
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		area = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				area[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0;i<R;i++)
			pipeGo(i,0);

		
		System.out.println(answer);
	}

}
