package 백준;


import java.util.Scanner;
//유기농 배추
public class boj1012 {
	
	static int c;
	static int r;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1,1,0,0};  //delta 탐색
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		
		for(int tc =1 ;tc<=T; tc++) {
			c = sc.nextInt();
			r =sc.nextInt();
			int cnt =sc.nextInt();
			
			map =new int[r][c];
			visited = new boolean[r][c];
			
			for(int i=0; i<cnt;i++) {
				int a =sc.nextInt();
				int b =sc.nextInt();
				map[b][a] =1;
			}
			int ans =0;
			for(int i =0; i<r;i++) {
				for(int j =0; j<c;j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						dfs(i,j);
						ans++; //dfs를 돌때만 카운트
					}
				}
			}
			
			System.out.println(ans);
			
		}
	}
	private static void dfs(int i, int j) {
		visited[i][j] =true; //방문
		for(int d =0; d<4; d++) { //델타 탐색
			int nr = i +dr[d];
			int nc = j +dc[d];
			
			if(nr<0 || nc<0 || nr>=r || nc >=c) continue; //범위
			if(map[nr][nc] ==0) continue; //노배추
			if(visited[nr][nc]) continue; //방문한 곳이면
			dfs(nr,nc);
			
		}
		
	}
	
}
