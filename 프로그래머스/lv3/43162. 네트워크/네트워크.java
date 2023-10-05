import java.util.*;

class Solution {
    public int connect[];
    
    public int find(int a){
        if(connect[a] == a) return a;
        
        return find(connect[a]);
    }
    
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA > rootB) connect[rootA] = rootB;
        else connect[rootB] = rootA;
    }
    
    public int solution(int n, int[][] computers) {
        HashSet<Integer> answer = new HashSet<Integer>();
        connect = new int[n];
        
        for(int i=0;i<n;i++)
            connect[i] = i;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && computers[i][j] == 1){
                    union(i,j);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            int num = find(i);
            if(!answer.contains(num))
                answer.add(num);
        }
        
        
        return answer.size();
    }
}