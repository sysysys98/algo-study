import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int N, M;
    static int[][] maze;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};  // 상, 하, 좌, 우 이동
    static int[] dy = {0, 0, -1, 1};  // 상, 하, 좌, 우 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 미로의 세로 크기
        M = Integer.parseInt(st.nextToken()); // 미로의 가로 크기

        maze = new int[N][M];
        visited = new int[N][M];

        // 미로 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
                visited[i][j] = -1; // 아직 방문하지 않은 곳은 -1로 설정
            }
        }

        // BFS로 최단 경로 찾기
        bfs(0, 0);

        // 미로의 오른쪽 하단 (N-1, M-1) 위치까지 가는 최소 거리 출력
        System.out.println(visited[N-1][M-1]);
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});
        visited[startX][startY] = 1; // 시작점 방문처리 (1로 설정)

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 4방향 (상, 하, 좌, 우)으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 범위를 벗어나지 않고, 갈 수 있는 곳이라면
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == 1 && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[x][y] + 1; // 이동한 곳의 거리는 현재 위치 + 1
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}