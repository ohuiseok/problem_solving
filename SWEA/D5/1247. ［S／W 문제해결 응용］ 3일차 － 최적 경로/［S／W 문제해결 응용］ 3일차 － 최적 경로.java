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
	static int[] start;
	static int[] end;
	static int[][] middle;
	static int minValue = Integer.MAX_VALUE,customerN;
	static int[] ord;
	static boolean[] isUsed;
	public static void print() {
		
	}
	
	public static int checkDistance(int[] order) {
		int distance=0;
		
		distance+=Math.abs(start[0]-middle[order[0]][0])+Math.abs(start[1]-middle[order[0]][1]);
		for(int i=0;i<middle.length-1;i++)
			distance+=Math.abs(middle[order[i]][0]-middle[order[i+1]][0])  +  Math.abs(middle[order[i]][1]-middle[order[i+1]][1]);
		distance+=Math.abs(middle[order[middle.length-1]][0]-end[0])  +  Math.abs(middle[order[middle.length-1]][1]-end[1]);
		
		return distance;
	}

	public static void allCase(int count) {
		if(count==customerN) {
//			System.out.println(Arrays.toString(ord));
			int tmp = checkDistance(ord);
			if(minValue > tmp )
				minValue = tmp;
			return;
		}
		
		for(int i=0;i<customerN;i++) {
			if(isUsed[i])
				continue;
			isUsed[i]=true;
			ord[count]=i;
			allCase(count+1);
			isUsed[i]=false;
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
			customerN = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			start = new int[] {Integer.parseInt(st.nextToken())  ,Integer.parseInt(st.nextToken()) };
			end = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			middle = new int[customerN][2];
			
			ord = new int[customerN];
			isUsed = new boolean[customerN];
			
			for(int i=0;i<customerN;i++) {
				int[] tmp = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
				middle[i] =tmp;
			}
			minValue = Integer.MAX_VALUE;
			allCase(0);
			System.out.println("#"+t+" "+minValue);
			
		}
		bw.close();
	}
	/*
	 * 배열을 돌린다. 외곽 돌리고, 그 다음외곽 돌리고. 그렇게N/2 M/2 넘어가면 안돌린다.
	 * 
	 */

}
