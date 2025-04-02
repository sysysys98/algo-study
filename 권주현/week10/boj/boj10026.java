package 백준;

import java.util.Scanner;

//적록색약
public class boj10026 {
	
	static int N;
	static char[][] map;
	static char[][] map2;
	static boolean[][] visited;
	static char color;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		map = new char[N][N];
		map2 = new char[N][N];
		sc.nextLine();
		
		for(int i=0; i<N; i++) {
			String str =sc.next();
			for(int j =0; j<N;j++) {
				map[i][j] =str.charAt(j);	
				if(map[i][j]=='G') {
					map2[i][j]='R';
				}else {
					map2[i][j]=map[i][j];
				}
			}
		}
		
		visited = new boolean[N][N];
		
		int normal=0;
		for(int i=0; i<N; i++) {
			for(int j =0; j<N;j++) {
				if(!visited[i][j]) {
					color = map[i][j];
					dfs(i,j,map);
					normal++;
				}
				
				
			}
		}
		
		int sick=0;
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j =0; j<N;j++) {
				if(!visited[i][j]) {
					
					color = map2[i][j];
					
					dfs(i,j,map2);
					sick++;
				}
				
				
			}
		}
		System.out.println(normal +" " +sick);
		
	}

	static void dfs(int i, int j,char[][] mapp) {
		visited [i][j] =true;
		for(int d =0; d<4;d++) {
			int nr = i+ dr[d];
			int nc = j+ dc[d];
			
			if(nr<0 || nc <0 || nr>=N ||nc>=N) continue;
			if(mapp[nr][nc]!=color || visited[nr][nc]) continue;
			
			dfs(nr,nc,mapp);
			
		}
		
	}



}
