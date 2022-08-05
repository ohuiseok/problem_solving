import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void plus(int[] limit,char chr) {
		switch(chr) {
		case 'A':
			limit[0]++;
			break;
		case 'C':
			limit[1]++;
			break;
		case 'G':
			limit[2]++;
			break;
		case 'T':
			limit[3]++;
			break;
		}
	}
	
	public static boolean minus(int[] limit,char chr) {
		switch(chr) {
		case 'A':
			limit[0]--;
			break;
		case 'C':
			limit[1]--;
			break;
		case 'G':
			limit[2]--;
			break;
		case 'T':
			limit[3]--;
			break;
		}
		if( limit[0]<=0 && limit[1]<=0 &&limit[2]<=0 &&limit[3]<=0  )
			return true;
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");;
		st.nextToken();			//입력받을 문자크기
		int passwordLength = Integer.parseInt(st.nextToken());	//비밀번호 길이
		
		int[] limit	= new int[4];
		int answer=0;
		
		Queue<Character> input = new LinkedList<Character>();
		Queue<Character> cmp = new LinkedList<Character>();
		
		for(char chr : br.readLine().toCharArray())
			input.offer(chr);	//비밀번호
			
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<4;i++)
			limit[i]=Integer.parseInt(st.nextToken());	//부분문자열 최소조건
		
		////////
		for(int i=0;i<passwordLength;i++) {
			char tmp =input.poll();
			cmp.offer(tmp);
			switch(tmp) {
			case 'A':
				limit[0]--;
				break;
			case 'C':
				limit[1]--;
				break;
			case 'G':
				limit[2]--;
				break;
			case 'T':
				limit[3]--;
				break;
			}
		}

		if( limit[0]<=0 && limit[1]<=0 &&limit[2]<=0 &&limit[3]<=0  )
			answer++;
		
		while(true) {
			if(input.isEmpty())
				break;
			plus(limit,cmp.poll());
			
			char chr = input.poll();
			cmp.offer(chr);
			if(minus(limit,chr))
				answer++;
//			System.out.println("answer"+answer);
		}
		System.out.println(answer);
		
//		bw.write(new StringBuilder(answer).toString());
//			
//		bw.flush(); 
//		bw.close(); 
	}
	/*
	 * ACGT로만 이루어져있어야한다.
	 * 각 알파벳의 최소 사용조건이 존재
	 * 
	 * 
	 * */
}
