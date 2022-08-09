import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int[] card = new int[10];
	static int win,lose;
	static int[] fCard =new int[10];
	static boolean[] isfCard =new boolean[19];//사용여부
	
	public static void cardMix(int index,int[] friendCard) {//1부터 시작
		if(index==10) {
			gameStart(fCard);
			return;
		}
		
		for(int i=1;i<=9;i++) {
			if(!isfCard[i]) {
				fCard[index]=friendCard[i];
				isfCard[i]=true;
				cardMix(index+1,friendCard);
				isfCard[i]=false;
			}
		}
	}
	
	public static void gameStart(int[] friendCard) {
		int mySum=0,friendSum=0;
		for(int i=1;i<=9;i++)
		{
			if(card[i]>friendCard[i]) {
				mySum=mySum+card[i]+friendCard[i];
			}else if(card[i]<friendCard[i]) {
				friendSum=friendSum+card[i]+friendCard[i];
			}
			
		}
		if(mySum>friendSum)
			win++;
		else if(mySum<friendSum)
			lose++;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testCase;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean[] remain = new boolean[19];
			int[] friendCard = new int[10];
			int friendIndex = 0;
			
			for(int i=1;i<=9;i++) {
				card[i]=Integer.parseInt(st.nextToken());
				remain[card[i]]=true;
			}
			for(int i=0;i<=18;i++) {
				if(!remain[i]) {
					friendCard[friendIndex]=i;
					friendIndex++;
				}
			}

//			for(int i=1;i<=18;i++) 
//				System.out.print(remain[i]+" ");
//			System.out.println();
//			for(int i=1;i<=9;i++) 
//				System.out.print(card[i]+" ");
//			System.out.println();
//			for(int i=1;i<=9;i++) 
//				System.out.print(friendCard[i]+" ");
//			System.out.println();
			
			win=0;lose=0;
			cardMix(1,friendCard);
			System.out.println("#"+t+" "+win+" "+lose);
			//gameStart();
			
		}
	}

}
