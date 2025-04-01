import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1012 {
    static int m, n, k, cnt;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            m = sc.nextInt();  // 가로
            n = sc.nextInt();  // 세로
            k = sc.nextInt();  // 배추 개수
            cnt = 0;  // 지렁이 수

            arr = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                arr[b][a] = 1;
            }

            // 전체 배열 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 방문하지 않았고, 배추가 있는 경우
                    if (!visited[i][j] && arr[i][j] == 1) {
                        bfs(i, j);  // 연결된 배추 탐색
                        cnt++;  // 지렁이 수 증가
                    }
                }
            }

            System.out.println(cnt);

        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
