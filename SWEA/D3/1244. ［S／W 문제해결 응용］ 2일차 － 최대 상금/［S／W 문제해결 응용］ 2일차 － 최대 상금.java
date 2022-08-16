import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//16926
public class Solution {
	static int[] arrNum;
	static int changeNum;
	static int maxValue;

	public static void print() {
		for (int i = 0; i < arrNum.length; i++) {
			System.out.print(arrNum[i]);
		}
		System.out.println();
	}

	public static void changeNumFunc( int search, int count) {
		if(changeNum==count) {
			int result = 0;
			for (int i = 0; i < arrNum.length; i++) {
				result = result * 10 + arrNum[i];
			}
//			System.out.println(Arrays.toString(arrNum));
			if(maxValue < result)
				maxValue= result;
			
			return;
		}
		
		for(int i=search;i<arrNum.length;i++) {
			for(int j=i+1;j<arrNum.length;j++) {	
				int left = arrNum[i];
				int right = arrNum[j];
				arrNum[i]=right;
				arrNum[j]=left;
				changeNumFunc(i,count+1);
				arrNum[i]=left;
				arrNum[j]=right;
			}
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			arrNum = new int[tmp.length()];
			changeNum = Integer.parseInt(st.nextToken());
			for (int i = 0; i < tmp.length(); i++) {
				arrNum[i] = tmp.charAt(i) - '0';
			}

			maxValue = Integer.MIN_VALUE;
			changeNumFunc(0,0);
			System.out.println("#" + t + " " + maxValue );
//			System.out.println("#" + t + " " +Arrays.toString(arrNum)+" => "+ resultNum(arrNum,tmpArr)+" "+check );
		}
		bw.close();
	}
	/*
	 * 배열을 돌린다. 외곽 돌리고, 그 다음외곽 돌리고. 그렇게N/2 M/2 넘어가면 안돌린다.
	 * 
	 */

}
