import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testCase;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int personNum = Integer.parseInt(st.nextToken());
			int submitNum = Integer.parseInt(st.nextToken());
			boolean isSubmit[] = new boolean[personNum+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<submitNum;i++) {
				isSubmit[Integer.parseInt(st.nextToken())]=true;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t);
			for(int i=1;i<=personNum;i++) {
				if(!isSubmit[i])
					sb.append(" ").append(i);
			}
			System.out.println(sb.toString());
		}
	}
}