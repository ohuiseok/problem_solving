import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] team;
	static boolean[] isPaticipated;
	static int N;
	static int ability = Integer.MAX_VALUE;
	
	public static void allCase(int index,int startTeamNum,int linkTeamNum) {
		if(startTeamNum>(N/2))	//백트래킹의 핵심. 스타트팀이 반 이상일 경우가 없으므로 생각하지 않는다.
			return;
		if(linkTeamNum>(N/2))	//백트래킹의 핵심. 링크팀이 반 이상일 경우가 없으므로 생각하지 않는다.
			return;
		
		if(index==N+1) {//팀 매칭이 끝났을 때
			int startPower = 0, linkPower = 0;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i==j)	//무시
						continue;
					
					if(isPaticipated[i]==isPaticipated[j]) { // 같은 팀일 경우
						if(isPaticipated[i]) { // 스타트팀
							startPower+=team[i][j];
						}else {					//링크팀
							linkPower+=team[i][j];
						}
					}
				}
			}
			
			if( ability > Math.abs(linkPower-startPower) )
				ability=Math.abs(linkPower-startPower);
			
			return;
				
		}
		
		isPaticipated[index]=true;						//index 사람은 스타트팀 참가
		allCase(index+1,startTeamNum+1,linkTeamNum);	//index 사람은 스타트팀 참가
		isPaticipated[index]=false;						//index 사람은 링크팀 참가 
		allCase(index+1,startTeamNum,linkTeamNum+1);	//index 사람은 링크팀 참가 
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		team = new int[N+1][N+1];
		isPaticipated = new boolean[N+1];
		
		for(int i=1;i<=N;i++)//입력
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
				team[i][j] = Integer.parseInt(st.nextToken());
		}
		allCase(1,0,0);
		System.out.println(ability);
		
	}
	/*
	 * 전체 경우의 수를 모두 구한다.
	 * 
	 * */
}
