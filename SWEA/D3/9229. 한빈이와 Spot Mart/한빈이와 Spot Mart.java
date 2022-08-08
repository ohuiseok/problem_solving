import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static int maxWeight(int[] snack,int limit) {
		int sum=0;
		for(int i=0;i<snack.length;i++) {
			int tmpSum = 0;
			for(int j=i+1;j<snack.length;j++)
			{	
				tmpSum = snack[i]+snack[j];
				if(tmpSum <= limit && tmpSum > sum)
					sum = tmpSum;
			}
		}
		if(sum==0)
			sum=-1;
		return sum;

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testCase;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			int[] snack = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++)
				snack[i]= Integer.parseInt(st.nextToken());

//			System.out.println(Arrays.toString(snack));
			System.out.println("#"+t+" "+maxWeight(snack,limit));
		}
	}

}
