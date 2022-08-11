import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int standard;
	static int answer;

	public static void searchIndexOf(int r, int c, int quarter) {
		//int harf = arrSize / 2;

		standard/=4;
		if (r == 0 && c == 0) {
			return;
		} else if (r < quarter && c < quarter) {
//			System.out.println("1");
			searchIndexOf(r,c,quarter/2);
		} else if (r < quarter && c >= quarter) {
//			System.out.println("2");
			answer+=standard;
			searchIndexOf(r,c%quarter,quarter/2);
		} else if (r >= quarter && c < quarter) {
//			System.out.println("3");
			answer+=(standard*2);
			searchIndexOf(r%quarter,c,quarter/2);
		} else {
//			System.out.println("4");
			answer+=(standard*3);
			searchIndexOf(r%quarter,c%quarter,quarter/2);
		}


	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int arrSize = 2;
		standard = 1;
		answer=0;
		
		for (int i = 1; i < N; i++) {
			standard *= 4;
			arrSize *= 2;
		}
		standard*=4;

		searchIndexOf(r,c,arrSize/2);
		System.out.println(answer);
		
//		searchIndexOf(r,c,arrSize/2);

	}
	/*
	 * 행과 열을 알고 그 다음 값을 구하는 과정 행과 열을 현재 배열의 행과 열 사이즈을 4등분해서 들어가는 지 묻는다.
	 * 
	 * N=1 2 
	 * 0 1 
	 * 2 3
	 * 
	 * N=2, 4 
	 * 0 4 
	 * 8 12
	 * 
	 * N=3 , 8 
	 * 0 16 
	 * 32 48
	 * 
	 * N=4 0 64
	 */
}
