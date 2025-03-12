import java.util.Scanner;

public class SWEA2105 {
    static int n, maxPath, row, col;
    static int[][] arr;
    static boolean[] visited;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            maxPath = -1;
            for (int i = 0; i < n - 2; i++) {
                for (int j = 0; j < n - 1; j++) {
                    visited = new boolean[101];
                    row = i;
                    col = j;
                    visited[arr[i][j]] = true;
                    dfs(0, 1, i, j);
                }
            }
            System.out.println("#" + tc + " " + maxPath);
        }
        sc.close();
    }

    public static void dfs(int dir, int cnt, int r1, int c1) {
        for (int d = dir; d < 4; d++) {
            int r2 = r1 + dx[d];
            int c2 = c1 + dy[d];

            if (r2 < 0 || r2 >= n || c2 < 0 || c2 >= n) {
                continue;
            }
            if (r2 == row && c2 == col && cnt >= 4) {
                maxPath = Math.max(maxPath, cnt);
                return;
            }
            if (visited[arr[r2][c2]]) {
                continue;
            }

            visited[arr[r2][c2]] = true;
            dfs(d, cnt + 1, r2, c2);
            visited[arr[r2][c2]] = false;
        }
    }
}