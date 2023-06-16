import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int before = 0;
        
        Arrays.sort(targets,(o1,o2) -> o1[1]-o2[1]);//end 좌표 기준 오름차순. -> 왼쪽부터 탐색하겠다는 의미
        //System.out.println(Arrays.deepToString(targets));
        for(int i=0;i<targets.length;i++){
            if(targets[i][0]  >= before ){ //개구간이라서 같은 좌표일 경우, 서로에게 영향 안줌. 따라서 "="넣기
                                           //START 값이 END안에 들지 않을때, answer이 더해짐. 
                before = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}