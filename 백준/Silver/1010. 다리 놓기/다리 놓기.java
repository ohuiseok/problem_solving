import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//1010
public class Main {
	static Deque<Integer> upValueList = new ArrayDeque<Integer>();
	static Deque<Integer> downValueList = new ArrayDeque<Integer>();
	public static void upFactorial(int num,long lastNum) {
		if(num<lastNum)
			return;
		upValueList.add(num);
		upFactorial(num-1,lastNum);
	}
	public static void downFactorial(int num) {
		if(num<=1)
			return;
		downFactorial(num-1);
		downValueList.add(num);
		
	}
	public static long maxBridge(int w,int e) {
		double answer=1.0;
		upFactorial(e,e-w+1);
		downFactorial(w);

		while(upValueList.isEmpty()==false||downValueList.isEmpty()==false) {
			if(!upValueList.isEmpty())
				answer*=upValueList.poll();
			if(!downValueList.isEmpty())
				answer/=downValueList.poll();
		}
		
//		System.out.println(upValue+ " "+downValue);
		return Math.round(answer);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=testCase;t++) {
			st = new StringTokenizer(br.readLine());
			int west = Integer.parseInt(st.nextToken());
			int east = Integer.parseInt(st.nextToken());
			System.out.println(maxBridge(west,east));
		}
	}

}
