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
	static List<Integer> number;
	static List<Character> operator;
	static List<Integer> remainNumber;//빼기할 것들 순서대로 빼주기만 하면 된다.
	
	public static void allSum() {

		int tmp=number.get(0);
		for(int i=0;i<operator.size();i++) {
			if(operator.get(i)=='-') {
				remainNumber.add(tmp);
				tmp=number.get(i+1);
			}
			else if(operator.get(i)=='+'){
				tmp+=number.get(i+1);
			}
		}
		remainNumber.add(tmp);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(),"");
		number = new ArrayList<Integer>();
		operator = new ArrayList<Character>();
		remainNumber = new ArrayList<Integer>();
		String str = br.readLine();
		int answer = 0;
		
		number.add(str.charAt(0)-'0');
		for(int i=1;i<str.length();i++) {
			if(Character.isDigit(str.charAt(i))) {//숫자
				if(Character.isDigit(str.charAt(i-1))) {//과거는 숫자
					int a = number.get(number.size()-1)*10+(str.charAt(i)-'0');
					number.remove( number.size()-1);
					number.add(a);
				}
				else {//과거는 연산자
					number.add(str.charAt(i)-'0');
				}
				
			}
			else {//연산자
				operator.add(str.charAt(i));
			}
		}
		
		allSum();
		
		answer =remainNumber.get(0);
		for(int i=1;i<remainNumber.size();i++) {
			answer-=remainNumber.get(i);
		}
		System.out.println(answer);
	}
	
	/*
	 * 
순서가 중요. 순서를 배정하고, 계산한다.




	 * */
}
