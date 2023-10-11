import java.util.*;

class Solution {

    public class Number implements Comparable<Number>{
        public int s;
    
        public Number(int i){
            this.s = i;
        }
        
        @Override
        public int compareTo(Number o){
            String first = new StringBuffer().append(this.s).append(o.s).toString();
            String second = new StringBuffer().append(o.s).append(this.s).toString();
            
            return second.compareTo(first);
        }
        
        @Override
        public String toString(){
            return ""+s;
        }
    }
    
    public String solution(int[] numbers) {
        PriorityQueue<Number> pq = new PriorityQueue<Number>();
        StringBuffer sb = new StringBuffer();
        for(int n : numbers) {
            pq.add(new Number(n)); 
        }
        
        while(!pq.isEmpty()) {
            Number tmp = pq.poll();
            //System.out.println(tmp);
            sb.append(tmp.s);                     
        }
        
        if( sb.charAt(0) == '0' ) return "0";
        return sb.toString();
    }
}