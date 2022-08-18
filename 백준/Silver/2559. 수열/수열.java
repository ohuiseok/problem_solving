import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int maxValue = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] numArray = new int[N];	
		int store = 0;		

		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
			
			if(i<K-1) {//k까지는 그냥 저장
				store+=numArray[i];
			}
			else if(i==K-1) {
				store+=numArray[i];
				if(maxValue < store)
					maxValue = store;
			}
			else {
				store+=numArray[i];
				store-=numArray[i-K];
				if(maxValue < store)
					maxValue = store;
			}
		}
		
		System.out.println(maxValue);
	}

}
