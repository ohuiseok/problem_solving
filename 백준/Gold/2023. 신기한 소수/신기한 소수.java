import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int length=0;
	static int prime=1;
	public static boolean isPrime(int num) {
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0)
				return false;
		}
		if(num==1)
			return false; 
		return true;
	}
	
	public static void primeCheck(int index) {
		if(index==length)
		{
			System.out.println(prime);
			return;
		}
		for(int i=1;i<=9;i++) {
			if(index==0)
				prime=i;
			else
				prime=prime*10+i;
			if(!isPrime(prime))	//소수아님
			{	
				if(index!=0)
				{
					prime=prime-i;
					prime/=10;
				}
				continue;
			}
			primeCheck(index+1);
			prime=prime-i;
			prime/=10;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine()," ");;
		length = Integer.parseInt(br.readLine());
		primeCheck(0);
//		
//		bw.flush(); 
//		bw.close(); 
	}
	/*
	 * N자리 소수 인데
	 * 숫자가 하나씩 입력된
	   맨 앞자리 소수 , 맨앞자리에서 2번째 소수...맨앞자리에서 N자리까지 소수
	 * 
	 * 
	 * 
	 * */
}
