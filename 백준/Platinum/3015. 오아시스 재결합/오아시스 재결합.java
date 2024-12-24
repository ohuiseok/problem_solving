import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        long count = 0;

        // 첫 번째 사람을 처리
        stack.push(new int[]{Integer.parseInt(br.readLine()), 1});

        for (int i = 1; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            int sameHeightCount = 1;

            // 스택에서 키가 작거나 같은 사람들을 제거하며 쌍의 수를 추가
            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                count += stack.peek()[1];
                if (stack.peek()[0] == height) {
                    sameHeightCount += stack.pop()[1];
                } else {
                    stack.pop();
                }
            }

            // 스택이 비어 있지 않으면 스택 최상단 사람과 현재 사람도 서로 볼 수 있음
            if (!stack.isEmpty()) {
                count++;
            }

            // 현재 키와 등장 횟수를 스택에 추가
            stack.push(new int[]{height, sameHeightCount});
        }

        // 결과 출력
        System.out.println(count);
    }
}
