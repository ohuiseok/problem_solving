import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isCheck = new boolean[9];
	static int[] answer = new int[7];
	static int[] cap = new int[9];
	
	public static void dwarfCheck(int[] store,int index) {
		if(index==7) {
			int sum=0;
			for(int i=0;i<7;i++)
				sum+=store[i];
			if(sum==100) {
				for(int i=0;i<7;i++)
					answer[i]=store[6-i];
			}
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(isCheck[i])
				continue;
			isCheck[i]=true;
			store[index]=cap[i];
			dwarfCheck(store,index+1);
			isCheck[i]=false;
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] store = new int[7];
		for(int i=0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cap[i]=Integer.parseInt(st.nextToken());
		}
		dwarfCheck(store,0);
		for(int i=0;i<7;i++) {
			System.out.println(answer[i]);
		}
	}
	/*
	 * 배열을 돌린다. 외곽 돌리고, 그 다음외곽 돌리고. 그렇게N/2 M/2 넘어가면 안돌린다.
	 * 
	 */

}