import java.util.*;

class Solution {
    public long arr1[];// 1, -1, 1, -1 순서
    public long arr2[];// -1, 1, -1, 1 순서
    public long maxValue = Long.MIN_VALUE;
    
    public long solution(int[] sequence) {
        int arrStart1 = 1, arrStart2 = -1;
        arr1 = new long[sequence.length];
        arr2 = new long[sequence.length];
        
        arr1[0] = sequence[0] * arrStart1;
        arr2[0] = sequence[0] * arrStart2;
        
        for(int i=1; i<sequence.length ; i++){
            arrStart1 *= -1;
            arrStart2 *= -1;
            
            arr1[i] = Math.max( arr1[i-1] + (sequence[i] * arrStart1) , sequence[i]  * arrStart1 );
            arr2[i] = Math.max( arr2[i-1] + (sequence[i] * arrStart2) , sequence[i]  * arrStart2 );
            
            
        }
        
        for(int i=0; i<sequence.length ; i++){
            maxValue = Math.max(arr1[i],maxValue);
            maxValue = Math.max(arr2[i],maxValue);
        }
        
        
        return maxValue;
    }
}
//-2 3 6 1 -3 -1 -2 4
//-2 3 9 10 