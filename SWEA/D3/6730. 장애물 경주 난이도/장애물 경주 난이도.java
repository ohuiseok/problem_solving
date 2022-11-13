import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int upMax =0,downMax=0;
			int before = Integer.parseInt(st.nextToken());
			for(int i=1;i<N;i++)
			{
				int cmp = Integer.parseInt(st.nextToken());
				if(before < cmp ) {
					upMax = Integer.max(upMax, cmp-before);
				}else if(before > cmp) {
					downMax = Integer.max(downMax, before-cmp);
				}
				before = cmp;
			}
			System.out.printf("#%d %d %d\n",t,upMax,downMax);
		}

	}
}
