import java.util.*;

class Solution {
    
    public class Genre implements Comparable<Genre>{
        public int sumGenre;
        public int index;
        public int play;
        public String name;
        
        public Genre(String name,int sumGenre,int play, int index){
            this.name = name;
            this.sumGenre = sumGenre;
            this.index = index;
            this.play = play;
        }
        
        @Override
        public int compareTo(Genre o){
            if( this.sumGenre < o.sumGenre) return 1;//왼쪽이 작으면 바꿔. 많이 부른 것부터
            if( this.sumGenre == o.sumGenre){
                if(this.play < o.play) 
                    return 1; //왼쪽 플레이가 작으면 바꿔. 플레이 수 많은 것 부터
                else if(this.play > o.play) 
                    return -1;
                
                //아래는 같은 장르, 같은 play수
                if(this.index > o.index) return 1; //왼쪽 고유번호가 크면 바꿔. index가 작은 거 부터
                else return -1;
            }
            return -1;
            
        }
        
    }
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> sumGenre = new HashMap<String,Integer>();
        HashMap<String,Integer> maxGenre = new HashMap<String,Integer>();
        PriorityQueue<Genre> pq = new PriorityQueue<Genre>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<genres.length;i++){
            if(!sumGenre.containsKey(genres[i])){
                sumGenre.put(genres[i],plays[i]);
            }else{
                int sum = sumGenre.get(genres[i]) + plays[i];
                sumGenre.put(genres[i],sum);
            }
            maxGenre.put(genres[i],0);
        }
        
        for(int i=0;i<genres.length;i++){
            pq.add(new Genre(genres[i],sumGenre.get(genres[i]), plays[i],i));
        }       
         
        while(!pq.isEmpty()){
            Genre cur = pq.poll();
            int callNum = maxGenre.get(cur.name);
            if( callNum < 2){
                maxGenre.put(cur.name,callNum+1);
                answer.add(cur.index);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i=0;i<answer.size();i++)
            result[i] = answer.get(i);

        return result;
    }
}