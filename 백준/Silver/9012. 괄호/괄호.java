import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		String[] answer = {"NO","YES"};
		
		for(int i=0;i<N;i++) {
			Stack<Character> ps = new Stack<Character>();
			int success = 1;
			String str = br.readLine();
			for(char tmp : str.toCharArray()) {
				if(tmp == '(')
					ps.push(tmp);
				else {
					if(ps.isEmpty()) {
						success=0;
						break;
					}
					else {
						ps.pop();
					}
				}
			}
			if(!ps.isEmpty()) {
				success=0;
			}
			System.out.println(answer[success]);
		}
	}

}
