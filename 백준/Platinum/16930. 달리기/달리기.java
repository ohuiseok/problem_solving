

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, K;
    public static char area[][];
    public static int isVisited[][];
    public static Location startPoint;
    public static Location endPoint;
    public static final int dirX[] = new int[]{-1, 1, 0, 0};
    public static final int dirY[] = new int[]{0, 0, 1, -1};

    public static class Location {
        public int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void printTest() {
        for (int i = 0; i < isVisited.length; i++) {

            for (int j = 0; j < isVisited[0].length; j++) {
                System.out.print(isVisited[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println();
    }

    public static int bfs() {
        Deque<Location> queue = new LinkedList<>();
        queue.offer(startPoint);
        isVisited[startPoint.x][startPoint.y] = 0;

        while (!queue.isEmpty()) {

            Location cur = queue.poll();

            for (int j = 0; j < 4; j++) {
                for (int i = 1; i <= K; i++) {
                    int moveX = dirX[j] * i + cur.x;
                    int moveY = dirY[j] * i + cur.y;
                    if( !(moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) ){
                        break;
                    }
                    if (area[moveX][moveY] == '#') {
                        break;
                    }
                    if(isVisited[moveX][moveY] < isVisited[cur.x][cur.y] + 1)//그 곳에서의 방향 전환도 이미 했을 것 이므로
                        break;

                    if (area[moveX][moveY] == '.' && isVisited[moveX][moveY] > isVisited[cur.x][cur.y] + 1) {
                        queue.offer(new Location(moveX, moveY));
                        isVisited[moveX][moveY] = isVisited[cur.x][cur.y] + 1;
                    }

                }
            }
        }


        return isVisited[endPoint.x][endPoint.y] == Integer.MAX_VALUE ? -1 : isVisited[endPoint.x][endPoint.y];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        area = new char[N][M];
        isVisited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                area[i][j] = line.charAt(j);
                isVisited[i][j] = Integer.MAX_VALUE;
            }
        }

        st = new StringTokenizer(br.readLine());
        startPoint = new Location(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        endPoint = new Location(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        System.out.println(bfs());


    }
}
