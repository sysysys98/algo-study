package 백준;

import java.util.Scanner;

public class boj1926 {
	//그림
	
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int extent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n= sc.nextInt();
		m= sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i =0; i<n;i++) {
			for(int j =0; j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		int cnt =0;
		int max =0;
		for(int i =0; i<n;i++) {
			for(int j =0; j<m;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					extent=0;
					dfs(i,j);
					if(extent>max) max =extent;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
		
		
		
	}
	static void dfs(int i, int j) {
		
		visited[i][j] =true;
		extent++;
		for(int d =0; d<4;d++) {
			int nr = i+dr[d];
			int nc = j +dc[d];
			
			if(nr<0 || nc<0 || nr>=n ||nc>=m) continue;
			if(map[nr][nc]==0 || visited[nr][nc]) continue;
			dfs(nr,nc);
			
		}
		
	}
	

}
