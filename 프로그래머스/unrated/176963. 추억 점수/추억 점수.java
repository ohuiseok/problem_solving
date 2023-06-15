import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int resultSize = photo.length;
        int[] answer = new int[resultSize];
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        
        for(int i=0;i<resultSize;i++){
            int ret = 0;
            for(int j=0;j<photo[i].length;j++){
                System.out.println(photo[i][j]);
                if(map.containsKey(photo[i][j]))
                    ret += map.get(photo[i][j]);
            }
            answer[i] = ret;
        }
        
        
        return answer;
    }
}