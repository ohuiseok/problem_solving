import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
//16935
public class Main {
	/*
최소 동전 -> 가장높은 금액부터 빼기   
	* */

	public static int coinNum(int[] coin,int money) {
		int index = coin.length-1;
		int answer = 0;
		while(money>0) {
			if(money/coin[index]!=0) {
				answer += money/coin[index];
				money = money%coin[index];
//				System.out.println("money "+money+" coin"+coin[index]);
			}
			index--;
				
		}
		return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		
		System.out.println(coinNum(coin,K));
		
	}

}


