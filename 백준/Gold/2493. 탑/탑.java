import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static Stack<int[]> top = new Stack<int[]>();
	
	public static int internalCheck(int index,int input) {
		if(top.isEmpty()) {
			top.add(new int[]{index,input});
			return 0;
		}
		int answer=0;
		while(!top.isEmpty()) {
			if(top.peek()[1] >= input ) {
				answer = top.peek()[0];
				top.add(new int[]{index,input});
				return answer;
			}else
			{
				top.pop();
			}
		}
		top.add(new int[]{index,input});
		return 0;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()),index=0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] answer = new int[N];
		
		while(st.hasMoreElements()) {
			int tmp = Integer.parseInt(st.nextToken());
			answer[index++]=internalCheck(index,tmp);
		}
		for(int i=0;i<N;i++)
			System.out.print(answer[i]+" ");
		
	}

}
 