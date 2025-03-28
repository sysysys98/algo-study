import java.util.Scanner;

public class SWEA1949_등산로조성 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n, k, max;
	static int[][] map;
	static boolean[][] vst;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();		
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			map = new int[n][n];
			vst = new boolean[n][n];
			max = 0;
			int ans = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(max, map[i][j]);
				}
			}
			
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]==max) {
						ans = Math.max(ans, dfs(i,j,1));
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	public static int dfs(int x, int y, int e) {
		int cnt = 1;
		int maxNow = 0;
		vst[x][y] = true;
		
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];			
			
			if(nx>=0 && ny>=0 && nx<n && ny<n && !vst[nx][ny]) {
				
				if(map[nx][ny]<map[x][y]) { //더 낮은 곳
					vst[nx][ny] = true;
					maxNow = Math.max(maxNow, dfs(nx, ny, e));
					vst[nx][ny] = false;

				} else if(map[nx][ny]>=map[x][y] && e == 1) { //아직 깎을 수 있을 경우
					if (map[nx][ny]-map[x][y]+1<=k) {
						int tmp = map[nx][ny]; //현재값 백업
						map[nx][ny] -= (tmp-map[x][y]+1);
						vst[nx][ny] = true;
						maxNow = Math.max(maxNow, dfs(nx, ny, e-1));
						vst[nx][ny] = false;						
						map[nx][ny] = tmp; //복구
					}
				}
			}			
		}
		
		cnt += maxNow;
		vst[x][y] = false;
		return cnt;
	}
}
