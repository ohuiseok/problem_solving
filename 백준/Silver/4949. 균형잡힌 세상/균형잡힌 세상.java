import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	
	public static void lineCheck(String str) {
		Stack<Character> stack = new Stack<Character>();
		for(char chr : str.toCharArray()) {
			if(chr=='(' || chr=='[')
				stack.push(chr);
			if(chr==')' || chr==']') {
				if(stack.isEmpty()) {
					System.out.println("no");
					return;
				}
				char tmp = stack.pop();
				if( (tmp=='(' && chr!=')') || (tmp=='[' && chr!=']')) {
					System.out.println("no");
					return;
				}
			}
		}
		if(!stack.isEmpty()) {
			System.out.println("no");
		}
		else {
			System.out.println("yes");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		while(true) {
			String str = br.readLine();
			if(str.equals("."))
				break;
			lineCheck(str);
		}
		
	}
	/*
	 * . 체크
     괄호 체크 
	 * 
	 */
}
