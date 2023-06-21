import java.util.*;
class Solution {
    
    public class Mineral implements Comparable<Mineral> {
        public int dia,iron,stone;
        
        public Mineral(){
        }
        
        @Override
        public int compareTo(Mineral other) {
            if(this.dia > other.dia )
                return -1;
            if(this.dia == other.dia && this.iron > other.iron)
                return -1;
            if(this.dia == other.dia && this.iron == other.iron && this.stone > other.stone)
                return -1;
            
            return 1;
        }
        @Override
        public String toString(){
            return "dia : "+this.dia+" iron : "+this.iron+" stone : "+this.stone;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int count = 0;
        int answer = 0;
        int length = Math.min(minerals.length, (picks[0]+picks[1]+picks[2])*5);
        PriorityQueue<Mineral> pq = new PriorityQueue<Mineral>();
        
        
        for(int i=0;i<length;i+=5){//5개씩 끊어서 읽기
            Mineral m = new Mineral();
            
            for(int j=i;j<i+5;j++){
                if(j>=length)
                    break;
                switch(minerals[j]){
                    case "diamond":
                        m.dia+=1; 
                        break;
                    case "iron":
                        m.iron+=1; 
                        break;
                    case "stone":
                        m.stone+=1; 
                        break;
                }
            }
            pq.add(m);
        }
        
        while(!pq.isEmpty()){
            Mineral m = pq.poll();
            //System.out.println(m);
            if(picks[0]>0){
                answer = answer + (m.dia+m.iron+m.stone);
                picks[0]-=1;
            }else if(picks[1]>0){
                answer = answer + (m.dia*5+m.iron+m.stone);
                picks[1]-=1;
            }else if(picks[2]>0){
                answer = answer + (m.dia*25+m.iron*5+m.stone);
                picks[2]-=1;   
            }
        }
        
        return answer;
    }
}