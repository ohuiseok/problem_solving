import java.util.*;

class Solution {
    public int topN;
    public boolean conn[][];
    public int diff = Integer.MAX_VALUE;
    
    public int calc(int left,int right){
        int a=0,b=0;
        boolean check[] = new boolean[topN+1];
        
        Queue<Integer> leftQueue = new LinkedList<Integer>();
        leftQueue.add(left);
        while(!leftQueue.isEmpty()){
            int now = leftQueue.poll();
            if(check[now]) continue;
            a++;
            check[now] = true;
            for(int l=1; l<=topN ;l++) {
                if(conn[now][l]) leftQueue.add(l);
            }
        }
        
        Queue<Integer> rightQueue = new LinkedList<Integer>();
        rightQueue.add(right);
        while(!rightQueue.isEmpty()){
            int now = rightQueue.poll();
            if(check[now]) continue;
            b++;
            check[now] = true;
            for(int r=1; r<=topN ;r++) {
                if(conn[now][r]) rightQueue.add(r);
            }
        }
        //System.out.println(" a: "+a+" b: "+b);
        return Math.abs(a-b);
    }
    
    public int solution(int n, int[][] wires) {
        
        conn = new boolean[n+1][n+1];
        topN = n;
        
        for(int arr[] : wires){
            conn[arr[0]][arr[1]] = true;
            conn[arr[1]][arr[0]] = true;
        }
        
        
        for(int arr[] : wires){
            conn[arr[0]][arr[1]] = false;
            conn[arr[1]][arr[0]] = false;
            int result = calc(arr[0],arr[1]);
            //System.out.println(" cut : "+arr[0]+" , "+" "+arr[1]+" result:"+result+" \n");
            diff = Math.min(diff,result);
            conn[arr[0]][arr[1]] = true;
            conn[arr[1]][arr[0]] = true;
        }
        
        return diff;
    }
}