import java.util.*;

class Solution {
    public HashSet<String> isExist = new HashSet<>(); 
    public int maxLength;
    public class Word{
        public int number;
        public String word;
        
        public Word(int number, String word){
            this.number = number;
            this.word = word;
        }
    }
    
    public int diff(String a, String b){
        int diffNum = 0;
        for(int i=0;i<maxLength;i++){
            if(a.charAt(i)!=b.charAt(i))
                diffNum++;
        }
        
        return diffNum;
    }
        
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        maxLength = begin.length();
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(0,begin));
        
        while(!queue.isEmpty()){
            Word cur = queue.poll();
            
            if(cur.word.equals(target))
                return cur.number;
            
            if(isExist.contains(cur.word)){
                continue;
            }
            isExist.add(cur.word);
            
            for(String str : words){
                //System.out.println("[cmp]"+cur.word+" & "+str+diff(str,cur.word));
                if(!isExist.contains(str) &&  diff(str,cur.word)==1){
                    //System.out.println("input : "+ str);
                    queue.add(new Word(cur.number + 1, str));
                }
            }
            
        }
        
        return 0;
    }
}