import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] num = new int[N][N];
		long[][] addNum = new long[N][N];
		int x1,y1,x2,y2;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			long[] addTmp = new long[N];
			
			for(int j=0;j<N;j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
				if(i!=0)
					addNum[i][j]+=addNum[i-1][j];
				
				if(j!=0) {
					addTmp[j]+=addTmp[j-1];
				}
				addTmp[j]+=num[i][j];
				addNum[i][j]+=addTmp[j];
			}	
		}
		
		for(int t=0;t<M;t++) {
			long answer=0;
			st = new StringTokenizer(br.readLine()," ");
			x1=Integer.parseInt(st.nextToken())-1;
			y1=Integer.parseInt(st.nextToken())-1;
			x2=Integer.parseInt(st.nextToken())-1;
			y2=Integer.parseInt(st.nextToken())-1;
			answer=addNum[x2][y2];
			
			if( x1>0 && y1>0)
			{
				answer-=addNum[x1-1][y2];
				answer-=addNum[x2][y1-1];
				answer+=addNum[x1-1][y1-1];
			}
			else if( x1>0 && y1==0)
			{
				answer-=addNum[x1-1][y2];
			}
			else if( x1==0 &&y1>0)
			{
				answer-=addNum[x2][y1-1];
			}
			
			
			System.out.println(answer);
		}
		
		
//		for(int i=0;i<N;i++) {	//누적합 확인용
//			for(int j=0;j<N;j++) 
//				System.out.print(addNum[i][j]+" ");
//			System.out.println();
//		}
		
		
		
		
	}
}
