import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] index = new int[]{0,0};
        int[] answer = new int[]{0,0};
    	int sum = 0;
    	int arrLength = sequence.length;
    	
    	for(index[1]=0; index[1]<sequence.length; index[1]++) {    		
    		sum += sequence[ index[1] ];
    		
    		while(sum > k) {
    			sum -= sequence[index[0]];
    			index[0]++;
    		}
    		
    		if(sum == k) {
    			if(arrLength > index[1]-index[0]) {
    				arrLength = index[1]-index[0];
    				answer[0] = index[0];
    				answer[1] = index[1];
    			}
    			else if(arrLength == index[1]-index[0] && index[0] < answer[0]  ) {

    				answer[0] = index[0];
    				answer[1] = index[1];
    			}
    		}
    		
    	}
    	
    	return answer;
    }
}