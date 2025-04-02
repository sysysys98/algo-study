package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7562 {
	static int N;
	
	static int[][] dist;
	
	static int[] dr = {-1,-2,-2,-1, 1, 2, 2, 1};
	static int[] dc = {-2,-1, 1, 2, 2, 1,-1,-2};
	
	static int sr;
	static int sco;
	static int er;
	static int eco;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T =sc.nextInt();
		
		for(int tc =1; tc<=T;tc++) {
			N= sc.nextInt();
			
			dist = new int[N][N];
			
			sr =sc.nextInt();
			sco= sc.nextInt();
			er= sc.nextInt();
			eco= sc.nextInt();
			
			int ans =bfs(sr,sco);
			
			System.out.println(ans);
			
		}
	
	}
	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		dist[r][c]=0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[0]==er && curr[1]==eco) {
				return dist[er][eco];
			}
			
			for(int d =0; d<8; d++) {
				int nr =curr[0]+dr[d];
				int nc =curr[1]+dc[d];
				
				if(nr<0 || nc<0 || nr>=N ||nc>=N) continue;
				if(dist[nr][nc]!=0) continue;
				dist[nr][nc]=dist[curr[0]][curr[1]]+1;
				q.add(new int[] {nr,nc});
			}
		}
		
		return -1;
	}
}
