import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    //재귀는 반복
    //즉, for문 문제는 재귀로
    //    재귀문제는 for문 문제로 풀 수 있다. 라고 배움


    //https://www.acmicpc.net/problem/17478
    public static int num;

    public static void repeat(int count) {
        if (count == num) {///COUNT  = 2 == NUM
            for (int i = 0; i < count; i++) {
                System.out.print("____");
            }
            System.out.println("\"재귀함수가 뭔가요?\"");

            for (int i = 0; i < count; i++) {
                System.out.print("____");
            }
            System.out.print("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");

            for (int i = 0; i < count; i++) {
                System.out.print("____");
            }
            System.out.println("라고 답변하였지.");

            return;
        }
        //COUNT = 0 //COUNT = 1
        for (int i = 0; i < count; i++) {
            System.out.print("____");
        }
        System.out.println("\"재귀함수가 뭔가요?\"");

        for (int i = 0; i < count; i++) {
            System.out.print("____");
        }
        System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");

        for (int i = 0; i < count; i++) {
            System.out.print("____");
        }
        System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");

        for (int i = 0; i < count; i++) {
            System.out.print("____");
        }
        System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        //COUNT = 0은 임시 실행하고 넘어감
        //COUNT = 1은 임시 실행하고 넘어감
        repeat(count + 1);
        //COUNT = 1은 마저 실행하고 넘어감
        //COUNT = 0은 마저 실행하고 넘어감

        for (int i = 0; i < count; i++) {
            System.out.print("____");
        }
        System.out.println("라고 답변하였지.");

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        repeat(0);

    }
}
