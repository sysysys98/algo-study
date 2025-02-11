import java.util.Scanner;

public class BOJ1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] arr = new int[N + 1];
        int num = 1;
        int cnt = 0;

        while (true) {
            arr[num]++;  // 현재 위치한 사람이 공을 받음
            
            if (arr[num] == M) {  // 공을 M번 받았다면 게임 종료
                break;
            } else if (arr[num] % 2 == 1) {  // 현재 사람이 받은 공의 개수가 홀수이면 시계 방향으로 L만큼 이동
                num += L;
                if (num > N) {
                    num -= N;
                }
                cnt++;
            } else {  // 현재 사람이 받은 공의 개수가 짝수이면 반시계 방향으로 L만큼 이동
                num -= L;
                if (num <= 0) {
                    num += N;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
