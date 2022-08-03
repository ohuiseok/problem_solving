import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int numberN = Integer.parseInt(st.nextToken());
		int sumN = Integer.parseInt(st.nextToken());
		int[] number = new int[numberN];
		long[] accumulate = new long[numberN];
		
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<numberN;i++) {
			number[i]=Integer.parseInt(st.nextToken());
			if(i!=0) {
				accumulate[i]+=accumulate[i-1];
			}
			accumulate[i]+=number[i];
		}
		/*
		 * 누적합
		 *  0 1 2 3 4 5
		 *  1 5 3 5 8 7
		 *  1 6 9 14 22 29
		 * */
			
		
		
		for(int t=0;t<sumN;t++) {
			long sum=0;
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken())-1;	//index값
			int end = Integer.parseInt(st.nextToken())-1;	//index값
			
			if(start!=0) {
				sum = accumulate[end]-accumulate[start-1];
			}
			else
				sum = accumulate[end];
			
			
			
			
			System.out.println(sum);
			
		}
		
		/*
		 * 
		 * 
		 * */
	}
}
