import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
        for(int[] c : commands){
            int[] tmp = Arrays.copyOf(array,array.length); 
            Arrays.sort(tmp,c[0]-1,c[1]);
            //System.out.println(Arrays.toString(tmp));
            answer[index++] = tmp[c[0]+c[2]-2];
        }
        
        return answer;
    }
}