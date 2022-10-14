import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static List<Number> num = new ArrayList<Number>();
	static boolean[] visit;
	static int length;
	static int answer = Integer.MIN_VALUE;
	static class Number{
		int number;
		char op = ' ';
		
		public Number(int number, char op) {
			super();
			this.number = number;
			this.op = op;
		}
		
	}
	
	
	private static Number calc(Number a, Number b) {
		Number ret = null;
		switch (a.op) {
		case '+':
			ret = new Number(a.number + b.number,b.op);
			break;
		case '-':
			ret = new Number(a.number - b.number,b.op);
			break;
		case '*':
			ret = new Number(a.number * b.number,b.op);
			break;
		default :
			ret = new Number(a.number,a.op);
		}
		return ret;
	}

	private static void startCalc(int index,boolean before) {
		if (index == length-1) {
			Queue<Number> n = new LinkedList<Number>();
			Number ans = new Number(0,'+');
			for(int i=0;i<=length-1;i++) {
				if(visit[i]) {
					n.add(calc(num.get(i),num.get(i+1)));
					i++;
				}else {
					n.add(num.get(i));
				}
			}
			
			while(!n.isEmpty()) {
				ans = calc(ans,n.poll());
			}
//			System.out.println(ans.number);
			if( ans.number > answer)
				answer= ans.number;
//			for(int i=0;i<length-1;i++) {
//				System.out.print(visit[i]+" ");
//			}
//			System.out.println();
			
			
			return;
		}

		visit[index] = false;
		startCalc(index + 1,false);

		if ( before == false) {
			visit[index] = true;
			startCalc(index + 1,true);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		length = Integer.parseInt(br.readLine());
		String input = br.readLine();
		for (int i = 0; i < length; i+=2) {
			if(i == length-1)
				num.add(new Number(  input.charAt(i) - '0','+' ));
			else
				num.add(new Number(  input.charAt(i) - '0',input.charAt(i+1)  ));
		}
		num.add(new Number(0,'+'));//마지막 맞추고 싶어서
		length = length / 2 + 1;
		visit = new boolean[length];

		startCalc(0,false);// 1~length
		System.out.println(answer);
	}

}
