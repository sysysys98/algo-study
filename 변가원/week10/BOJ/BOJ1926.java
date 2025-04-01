import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1926 {
    static int n, m, cnt, maxSquare;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();  // 세로
        m = sc.nextInt();  // 가로
        cnt = 0;  // 그림 개수
        maxSquare = 0;  // 가장 넓은 그림의 크기

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 모든 좌표 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 그림이 있고 아직 방문하지 않은 경우
                if (arr[i][j] == 1 && !visited[i][j]) {
                    // BFS로 가장 큰 그림의 넓이를 찾음
                    maxSquare = Math.max(maxSquare, bfs(i, j));
                    cnt++;  // 개수 증가
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxSquare);

    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int square = 1;  // 넓이

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // 범위 내에 있고, 아직 방문하지 않았으며, 그림이 있는 경우
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                        square++;
                    }
                }
            }
        }
        return square;
    }
}
