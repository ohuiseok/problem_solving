import java.util.*;

class Solution {
    public int accArea[][];
    public int mainBoard[][];
    
    
    public int checkArea(){
        int result = 0;
        for(int i=0;i<mainBoard.length;i++){
            for(int j=0;j<mainBoard[0].length;j++)
                if(mainBoard[i][j] + accArea[i][j] >0 ) result++;
        }
        return result;
    }
    
    public void sumDegree(int r1,int c1,int r2,int c2,int degree){
        accArea[r2][c2] += degree;
        accArea[r1][c1] += degree;
        accArea[r2][c1] -= degree;
        accArea[r1][c2] -= degree;
    }
    
    public void subDegree(int r1,int c1,int r2,int c2,int degree){
        accArea[r2][c2] -= degree;
        accArea[r1][c1] -= degree;
        accArea[r2][c1] += degree;
        accArea[r1][c2] += degree;
    }
    
    public void calcAccArea(){
        for(int i=0 ; i < accArea.length; i++){
            for(int j = 1 ; j< accArea[i].length ; j++){ //좌에서 우로 누적
                accArea[i][j] +=accArea[i][j-1];
            }
        }
        
        for(int i=0 ; i < accArea[0].length; i++){
            for(int j = 1 ; j< accArea.length ; j++){ //위에서 아래로 누적
                accArea[j][i] +=accArea[j-1][i];
            }
        }
        
    }
    
    public int solution(int[][] board, int[][] skill) {
        mainBoard = board;
        accArea = new int[board.length+1][board[0].length+1]; // 누적합
        
        for(int s[] : skill){
            switch(s[0]){
                case 1 :
                    subDegree(s[1],s[2],s[3]+1,s[4]+1,s[5]);
                    break;
                case 2 :
                    sumDegree(s[1],s[2],s[3]+1,s[4]+1,s[5]);
                    break;
            }
        }
        calcAccArea();
        //System.out.println(Arrays.deepToString(accArea));
        return checkArea();
    }
}