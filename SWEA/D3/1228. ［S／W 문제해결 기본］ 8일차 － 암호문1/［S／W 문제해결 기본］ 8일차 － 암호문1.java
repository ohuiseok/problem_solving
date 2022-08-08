import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int testCase=1; testCase<=10;testCase++) {
			br.readLine();
			List<Integer> secret = new ArrayList<Integer>();  
			st = new StringTokenizer(br.readLine()," ");
			
			while(st.hasMoreElements())
				secret.add(Integer.parseInt(st.nextToken()));
			br.readLine();
			st = new StringTokenizer(br.readLine(),"I");

			while(st.hasMoreElements()) {
				StringTokenizer tmp = new StringTokenizer(st.nextToken()," ");
				int index = Integer.parseInt(tmp.nextToken());
				int cnt = Integer.parseInt(tmp.nextToken());
				
				for(int i=0; i<cnt ; i++)
					secret.add(index++,  Integer.parseInt(tmp.nextToken()));
				
			}
			System.out.print("#"+testCase);
			for(int i=0;i<10;i++)
				System.out.print(" "+secret.get(i));
			System.out.println();
		}	
	}

}
