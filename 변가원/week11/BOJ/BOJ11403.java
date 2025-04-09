import java.util.Scanner;

public class BOJ11403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 정점 개수
        int[][] arr = new int[N][N];  // 인접 행렬

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 플로이드-워셜 알고리즘 적용
        // i에서 j로 가는 경로가 존재하는지 확인
        for (int k = 0; k < N; k++) {  // 경유지
            for (int i = 0; i < N; i++) {  // 출발지
                for (int j = 0; j < N; j++) {  // 도착지
                    // i -> k 경로와 k -> j 경로가 존재하면 i -> j 경로도 존재
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
