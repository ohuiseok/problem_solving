import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		int[] answer = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if(stack.isEmpty())
				stack.push(i);
			else{
				if(input[i] > input[stack.peek()]) {
					int size = stack.size();
					while(size>0) {
						int index = stack.peek();
						if(input[index] < input[i]) {
							answer[index] = input[i];
							stack.pop();
						}
						else
							break;
						size--;
					}
					stack.push(i);
				}
				else {
					stack.push(i);
				}
			}
		}
		
		while(!stack.isEmpty()) {
			int index = stack.pop();
			answer[index] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(answer[i]).append(" ");
		}
		sb.append("\n");
		System.out.println(sb.toString());
		
		br.close();
	}

}
