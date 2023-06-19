import java.util.*;

class Solution {
    public int answer0 = 0;
    public int answer1 = 0;
    
    public int strToLength(String str){
        for(char c : str.toCharArray()){
            if(c=='0')
                answer1++;
        }
        return str.replaceAll("0","").length();
    }
    
    public String lengthToStr(int length){
        StringBuffer sb = new StringBuffer();
        
        while(length != 0){
            if(length%2 == 1)
                sb.append("1");
            else
                sb.append("0");
            
            length/=2;
        }
        
        return sb.reverse().toString();
    }
    
    public int[] solution(String s) {
        
        while(!s.equals("1")){
            answer0++;
            int length = strToLength(s);
            s = lengthToStr(length);
        }
        
        
        return new int[]{answer0,answer1};
        
    }
}