import java.util.Scanner;

public class BOJ11404 {
    static final int INF = Integer.MAX_VALUE  // 무한대

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 도시의 수
        int m = sc.nextInt();  // 버스의 수
        int[][] arr = new int[n + 1][n + 1];  // 인접 행렬

        // 자기 자신의 거리는 0으로 두고 나머지는 무한대로 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();  // 시작 도시
            int b = sc.nextInt();  // 도착 도시
            int c = sc.nextInt();  // 비용

            // 같은 경로가 여러 개일 수 있으므로 최소 비용만 저장
            arr[a][b] = Math.min(arr[a][b], c);
        }

        // 플로이드-워셜 알고리즘 적용
        for (int k = 1; k <= n; k++) {  // 경유지
            for (int i = 1; i <= n; i++) {  // 출발지
                for (int j = 1; j <= n; j++) {  // 도착지
                    // i에서 j로 가는 최단거리 갱신
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == INF) {
                    arr[i][j] = 0;
                }

                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
