import java.util.*;

class Solution {
    public boolean checkArea[][];
    public char area[][];
    public int width,height;
    public int startPoint[];
    public int endPoint[];
    
    public class Location{
        public int r,c;
        public Location(int r, int c){
            this.r=r;
            this.c=c;
        }
        @Override
        public String toString(){
            return "r : "+this.r+" c : "+this.c;
        }
    }
    
    
    public void initSetting(String[] board){
        width = board[0].length();
        height = board.length;
        
        area = new char[height][width];
        checkArea = new boolean[height][width];
        
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                area[i][j] = board[i].charAt(j);
                if(area[i][j]=='R')
                    startPoint = new int[]{i,j};
                if(area[i][j]=='G')
                    endPoint = new int[]{i,j};
                    
            }
        }
        //System.out.println(Arrays.deepToString(area));
    }
    
    public Location left(Location location){
        for(int i=location.c-1  ;i>=0;i--){
            if(area[location.r][i] == 'D' ){
                return new Location(location.r,i+1);
            }
        }
        return new Location(location.r,0);
    }
    public Location right(Location location){
        for(int i=location.c+1 ;i<width;i++){
            if(area[location.r][i] == 'D' ){
                return new Location(location.r,i-1);
            }
        }
        return new Location(location.r,width-1);
    }
    public Location up(Location location){
        for(int j=location.r-1 ;j>=0;j--){
            if(area[j][location.c] == 'D' ){
                return new Location(j+1,location.c);
            }
        }
        return new Location(0,location.c);
    }
    public Location down(Location location){
        for(int j=location.r+1 ;j<height;j++){
            if(area[j][location.c] == 'D' ){
                return new Location(j-1,location.c);
            }
        }
        return new Location(height-1,location.c);
    }
    
    public int bfs(){
        int answer = 0;
        Queue<Location> queue = new LinkedList<Location>();
        queue.add(new Location(startPoint[0],startPoint[1]));
        
        while(!queue.isEmpty()){
            Queue<Location> newQueue = new LinkedList<Location>();
            answer++;
                
            while(!queue.isEmpty()){    
                Location location = queue.poll();

                if(checkArea[location.r][location.c])
                    continue;
                checkArea[location.r][location.c] = true;
                
                //left
                Location l = left(location);
                if(l.r == endPoint[0] && l.c == endPoint[1])
                    return answer;
                newQueue.add(l);
                //System.out.print("left ");
                //System.out.println(l);

                //right
                Location r = right(location);
                if(r.r == endPoint[0] && r.c == endPoint[1])
                    return answer;
                newQueue.add(r);
                //System.out.print("right ");
                //System.out.println(r);

                //up
                Location u = up(location);
                if(u.r == endPoint[0] && u.c == endPoint[1])
                    return answer;
                newQueue.add(u);
                //System.out.print("up ");
                //System.out.println(u);

                //down
                Location d = down(location);
                if(d.r == endPoint[0] && d.c == endPoint[1])
                    return answer;
                newQueue.add(d);
                //System.out.print("down ");
                //System.out.println(d);
            }
            queue = newQueue;
        }
        
        return -1;
    }
    
    public int solution(String[] board) {
        initSetting(board);
        
        return bfs();
    }
}