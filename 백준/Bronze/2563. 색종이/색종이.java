import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int width = 0;
		int[][] colorPaper = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			colorPaper[i][0]=Integer.parseInt(st.nextToken());
			colorPaper[i][1]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				
				for(int k=0;k<N;k++) {
					if( i >= colorPaper[k][0] && i < colorPaper[k][0]+10 && j >= colorPaper[k][1] && j < colorPaper[k][1]+10  )
					{
						width++;
						break;
					}
				}
				
			}
		}
		
		System.out.println(width);
//		bw.close();
	}

}
