import java.util.Scanner;

public class BOJ12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 물건의 수
        int K = sc.nextInt();  // 버틸 수 있는 무게

        int[] W = new int[N + 1];  // 무게
        int[] V = new int[N + 1];  // 가치

        int[][] dp = new int[N + 1][K + 1];

        // 물건 정보 입력
        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (W[i] > j) {  // 현재 물건을 담을 수 없는 경우
                    dp[i][j] = dp[i - 1][j];  // 이전 물건까지의 결과 그대로 사용
                } else {  // 담을 수 있는 경우
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
