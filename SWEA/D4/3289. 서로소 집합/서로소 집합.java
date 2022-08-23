import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution {
	static int[] arr;
	
	public static void make() {
		for(int i=1;i<arr.length;i++)
			arr[i]=i;
	}
	
	public static int find(int x) {
		if(arr[x] == x) return x;
		
		return find(arr[x]);
	}
	
	public static void sum(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA < rootB)
			arr[rootB] = rootA;
		else
			arr[rootA] = rootB;
	}
	
	public static int sameGroup(int a,int b) {
		if(find(a)==find(b))
			return 1;
		else
			return 0;
					
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=testCase;t++) {
			st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			make();
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int type = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(type==0)
					sum(a,b);
				else
					sb.append(sameGroup(a,b));
			}
			System.out.println(sb.toString());
		}
		
	}
	
	

}
