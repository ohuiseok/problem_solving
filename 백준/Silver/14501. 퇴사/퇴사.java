import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int day,maxMoney=Integer.MIN_VALUE;
	static int[] consultDay;
	static int[] consultMoney;
	
	public static void allCase(int sum,int index) {
		if(index==day+1) {
			if(maxMoney < sum)
				maxMoney = sum;
			return;
		}
		else if(index>(day+1)) {
			return;
		}
		
		if(index+consultDay[index]<=day+1)
			allCase(sum+consultMoney[index],index+consultDay[index]);
		allCase(sum,index+1);
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		day = Integer.parseInt(br.readLine());
		consultDay = new int[day+1];
		consultMoney = new int[day+1];
		
		for(int i=1;i<=day;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			consultDay[i]=Integer.parseInt(st.nextToken());
			consultMoney[i]=Integer.parseInt(st.nextToken());
		}
		
		allCase(0,1);
		System.out.println(maxMoney);
	}
	/*
	 * 전체 경우의 수를 모두 구한다.
	 * 
	 * */
}
