import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		String S = st.nextToken();
		st = new StringTokenizer(br.readLine(), " ");
		int testCase = Integer.parseInt(st.nextToken());
		int[][] frontSearch = new int[S.length()][27]; 
		
		frontSearch[0][S.charAt(0)-'a']++;
		for(int i=1;i<S.length();i++) {
			char frontChr = S.charAt(i);
			frontSearch[i][frontChr-'a']++;
			for(int j=0;j<27;j++)
				frontSearch[i][j]+=frontSearch[i-1][j];
		}
		
		for(int t=1;t<=testCase;t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int chr = st.nextToken().charAt(0)-'a';
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int num;
			if(start !=0)
				num = frontSearch[end][chr] - frontSearch[start-1][chr];
			else
				num = frontSearch[end][chr] ;
			
			sb.append(num).append("\n");
		}
		System.out.println(sb.toString());
//		for(int j=0;j<=25;j++) {
//			char tmp = (char)('a'+j);
//			System.out.print(tmp+" ");
//		}
//		System.out.println();
//		for(int i=0;i<S.length();i++) {
//			for(int j=0;j<=26;j++) {
//				System.out.print(frontSearch[i][j]+" ");
//				
//			}
//			System.out.println();
//		}
		
	}

}
