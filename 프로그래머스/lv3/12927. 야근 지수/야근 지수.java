import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works) pq.offer((long)w);
        
        while(n>0){
            long temp = pq.poll()-1;
            if(temp < 0 ) return 0;
            pq.offer(temp);
            n--;
        }
        while(!pq.isEmpty()){
            long atom = pq.poll();
            //System.out.println(atom);
            answer = answer + (atom * atom);
        }
        return answer;
    }
}