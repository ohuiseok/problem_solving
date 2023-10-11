import java.util.*;

class Solution {
    
    public void print(Integer[] n){
        for(Integer m : n) System.out.print(" "+m);
        System.out.println();
    }
    
    public int solution(int[] citations) {
        Integer[] c = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(c, Collections.reverseOrder());
        
        int answer = 0;
        print(c);
        for(int i=0;i<c.length;i++){
            int value = c[i];
            int order = i+1;
            if(value>=order) 
                answer = order;
        }
        
        return answer;
    }
}