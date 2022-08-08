import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		List<Integer> person = new ArrayList<Integer>();
		int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		int index = M-1;
		StringBuilder sb = new StringBuilder("<");
		for(int i=1;i<=N;i++)
			person.add(i);
		
		while(!person.isEmpty()) {
			sb.append(person.get(index)).append(", ");
			person.remove(index);
			index+=(M-1);
			if((--N)!=0)
				index%=N;
		
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
		
		
	}

}
/*
 * 1 2 3 4 5 6 7
 * 1 2 4 5 6 7
 * 1 2 4 5 7
 * */
 