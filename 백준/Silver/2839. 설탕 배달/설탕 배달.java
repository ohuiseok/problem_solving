import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int fiveKilo = N/5;
		int answer = -1;
		while(fiveKilo!=0) {
			int tmp = N-fiveKilo*5;
			if (tmp%3==0)
			{
				answer = fiveKilo+tmp/3;
				break;
			}
			else {
				fiveKilo--;
			}
		}
		if(answer==-1) {
			if(N%3==0)
				answer=N/3;
		}
		System.out.println(answer);
		
	}

}
