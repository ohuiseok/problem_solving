import java.util.*;

class Solution {
    public int solution(int[] money) {
        int N = money.length;
        int[] firstBuyDP = new int[money.length];
        int[] firstNoBuyDP = new int[money.length];
        
        firstBuyDP[0] = money[0];//처음을 산대신 마지막은 못삼.
        firstNoBuyDP[0] = 0;
        firstBuyDP[1] = Math.max(money[1],firstBuyDP[0]);
        firstNoBuyDP[1] = money[1];
        
        for(int i=2;i<N-1;i++){//마지막 전까지만..
            firstBuyDP[i] = Math.max(money[i]+firstBuyDP[i-2],firstBuyDP[i-1]);
            firstNoBuyDP[i] = Math.max(money[i]+firstNoBuyDP[i-2],firstNoBuyDP[i-1]);
        }
        firstNoBuyDP[N-1] = Math.max(money[N-1]+firstNoBuyDP[N-3],firstNoBuyDP[N-2]);
        firstBuyDP[N-1] = firstBuyDP[N-2];
        
        //System.out.println(Arrays.toString(firstBuyDP));
        //System.out.println(Arrays.toString(firstNoBuyDP));
        return Math.max(firstBuyDP[N-1],firstNoBuyDP[N-1]);
    }
}