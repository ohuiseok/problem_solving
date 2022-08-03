import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int N,M;
	static long flyMax = Long.MIN_VALUE;
	public static void flyMaxResearch(long[][] addNum,int x1,int y1,int flySize) {
		
		int x2=x1+flySize,y2=y1+flySize;
		long answer=0;
        
		if(x2>=addNum.length || y2>=addNum.length)
			return;
        
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
		
		if(flyMax < answer)
			flyMax=answer;
		
	}
	
	public static void main(String[] args) throws IOException  {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		
		for(int t=1;t<=testCase;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
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

			flyMax = Long.MIN_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) 
					flyMaxResearch(addNum,i,j,M-1);
			}
				
				
			System.out.println("#"+t+" "+flyMax);
		}
		
	}
	/*
	 * 테스트 케이스 숫자 입력받음
	 * (테스트 케이스 만큼 반복)
	 * {
	 * 배열 크기 입력
	 * 파리채 크기 입력
	 * 파리개체수 입력
	 * { 입력받으면서 누적도 동시에
	 * (다만, 누적할 때 범위를 파리채 크기만큼만 입력받기
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * */
}