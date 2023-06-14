import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> playersMap = new HashMap<>();
        for(int i=0; i<players.length; i++) playersMap.put(players[i], (i));//key:이름, value:인덱스
        
        for(int i=0;i<callings.length;i++){
            String tmp = players[ playersMap.get(callings[i])-1 ];
            players[playersMap.get(callings[i])-1 ] = players[ playersMap.get(callings[i])  ];
            players[playersMap.get(callings[i])  ]=tmp;


            playersMap.put(callings[i], playersMap.get(callings[i])-1);
            playersMap.put(tmp, playersMap.get(tmp)+1);
        }
        
        return players;
    }
}