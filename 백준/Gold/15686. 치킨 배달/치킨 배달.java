import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static List<Node> isChicken;
	static int answer=Integer.MAX_VALUE;
	static List<Node> chicken,house;
	
	public static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
	
	public static void howChicken(int index,int M,int cnt) {
		if(index == M) {
			int sum=0;
//			System.out.println(Arrays.toString(isChicken.toArray()));
			for(int j=0;j<house.size();j++) {
				int min=Integer.MAX_VALUE;
				for(int i=0;i<isChicken.size();i++) {
					int tmp = Math.abs(isChicken.get(i).x-house.get(j).x) + Math.abs(isChicken.get(i).y-house.get(j).y);
					min = Math.min(min, tmp);
				}
				sum+=min;
			}
			answer = Math.min(sum, answer);
			
			return;
		}
		
		
		for(int i=cnt;i<chicken.size();i++) {
			isChicken.add(chicken.get(i));
			howChicken(index+1,M,i+1);
			isChicken.remove(index);
		}
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		chicken = new ArrayList<Node>();
		house = new ArrayList<Node>();

		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				int tmp = Integer.parseInt(st.nextToken());

				if(tmp==1) {
					house.add(new Node(i,j));
				}
				else if(tmp==2) {
					chicken.add(new Node(i,j));	
				}
			}
		}
		isChicken = new ArrayList<Node>();//new boolean[chicken.size()];
		howChicken(0,M,0);
		bw.write(String.valueOf(answer));
		bw.flush(); 
		bw.close(); 
	}
	/*
	 * 
도시의 치킨 거리 = 모든 집의 치킨 거리의 합
도시의 치킨 거리 최솟값 출력

=> 각 치킨의 치킨 거리합 구하기 -> 가장 높은치킨만 버리기
=> 



	 * */
}
