import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] order;
	static int[] weight;
	static boolean[] orderVisit;
	static int[] newOrder;
	static int answer;
	
	public static void orderSetting(int count) {
		if(count==N) {
			weightSet(0,0,0);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(orderVisit[i])
				continue;
			orderVisit[i]=true;
			newOrder[count]=i;
			orderSetting(count+1);
			orderVisit[i]=false;
		}
		
	}
	
	public static void weightSet(int leftWeight,int rightWeight,int count) {
		if(leftWeight<rightWeight) { // 무게 놓는 과정에서 오른 쪽이 무거우면 back
			return;
		}
		if(count==N) {
//			System.out.println(Arrays.toString(newOrder)+" "+leftWeight+" "+rightWeight);
			answer++;
			return;
		}
		
		
		
		weightSet(leftWeight+weight[newOrder[count]],rightWeight,count+1);//왼쪽에 무게를 추가
		weightSet(leftWeight,rightWeight+weight[newOrder[count]],count+1);//왼쪽에 무게를 추가
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=testCase;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			weight = new int[N];
			order = new int[N];
			orderVisit = new boolean[N];
			newOrder = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++)
				weight[i]=Integer.parseInt(st.nextToken());
		
			answer=0;
			orderSetting(0);
			System.out.println("#"+t+" "+answer);
		}
		
/*
 *
 * 
 *
왼쪽에 넣거나, 오른쪽에 놓거나..추를 다 올린다.  그 과정에서 각 무게 측정해서 오른쪽이 크면 back
순서를 바꿔가면서. 테스트. 
그러나 오른쪽 추가 왼쪽 추보다 커질때, back한다.
 */

	}

}