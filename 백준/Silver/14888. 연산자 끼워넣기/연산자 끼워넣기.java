import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int minSum = Integer.MAX_VALUE;
	static int maxSum = Integer.MIN_VALUE;
	static int[] number;
	static int[] op;
	static int[] useOperator;
	
	public static void calculate(int index) {
		if(index==N-1)//op는 N-1개임. index는 0부터 측정되기 때문에, N-1이면 계산끝
		{	
			int sum=number[0];
			for(int i=0;i<N-1;i++) {
				switch(useOperator[i]) {
				case 0://plus
					sum=sum+number[i+1];
					break;
				case 1://minus
					sum=sum-number[i+1];
					break;
				case 2://multiplication
					sum=sum*number[i+1];
					break;
				case 3://division
					sum=sum/number[i+1];
					break;
				}
			}
			if(minSum > sum)
				minSum = sum;
			if(maxSum < sum)
				maxSum = sum;
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(op[i]>0) {
				op[i]--;
				useOperator[index]=i;
				calculate(index+1);
				op[i]++;
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		useOperator = new int[N-1];
		op	 = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++)
			number[i]=Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++)
			op[i]=Integer.parseInt(st.nextToken());
		
		calculate(0);
		bw.write(new StringBuilder("").append(maxSum).append("\n").append(minSum).toString());

//		System.out.println(maxSum);
//		System.out.println(minSum);
		bw.flush(); 
		bw.close(); 
	}
	/*
	 * 전체 경우의 수를 모두 구한다.
	 * 
	 * */
}
