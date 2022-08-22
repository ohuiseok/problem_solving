import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] allChr;
	static boolean[] isUsed;
	static char[] answer;


	public static void makeString(int vowel, int consonant, int search, int count) {
		if (count == L) {
			if(vowel<1 || consonant<2)
				return;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<L;i++)
				sb.append(answer[i]);
//			System.out.println("vowel : "+vowel+"consonant : "+consonant);
			System.out.println(sb.toString());
			return;
		}
		
		for (int i = search; i < C; i++) {
			boolean isVowel = false;
			if (isUsed[i])
				continue;
			isUsed[i] = true;
			if (allChr[i] == 'a' || allChr[i] == 'e' || allChr[i] == 'i' || allChr[i] == 'o' || allChr[i] == 'u') {
				isVowel = true;
			}
			if(isVowel)
				vowel++;
			else
				consonant++;
			answer[count] = allChr[i];
			makeString(vowel, consonant, i, count + 1);
			if(isVowel)
				vowel--;
			else
				consonant--;
			isUsed[i] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		allChr = new char[C];
		answer = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			allChr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(allChr);
		
		isUsed = new boolean[C];

		makeString(0, 0, 0, 0);
	}

}
