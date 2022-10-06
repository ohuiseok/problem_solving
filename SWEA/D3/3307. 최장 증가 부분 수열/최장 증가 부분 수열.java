import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testCase;t++) {
			int length = Integer.parseInt(br.readLine());
			int[] arr = new int[length];
			int[] lis = new int[length];
			int max = Integer.MIN_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<length;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				lis[i] = 1;
				
				for(int j=0;j<i;j++) {
					if(arr[i] > arr[j] && lis[i] <= lis[j]) {
						lis[i] = lis[j]+1;
					}
				}
				if(max < lis[i])
					max = lis[i];
			}
			System.out.printf("#%d %d\n",t,max);
		}
	}
}
