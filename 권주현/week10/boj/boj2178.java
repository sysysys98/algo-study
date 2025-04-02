package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//미로탐색
public class boj2178 {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] dist;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N =sc.nextInt();
		M =sc.nextInt();
		
		map =new int[N][M];
		dist =new int [N][M];
		
		sc.nextLine();
		for(int i=0; i<N;i++) {
			String str =sc.next();
			for(int j =0; j<M; j++) {
				map[i][j] =str.charAt(j)-'0';
			}
		}
		
		int ans = bfs(0,0);
		
		
		System.out.println(ans);
		
	}


	private static int  bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		dist[i][j]=1;
		
		while(!q.isEmpty()) {
			int[] curr =q.poll();
			
			if(curr[0]==N-1 && curr[1]==M-1) {
				return dist[curr[0]][curr[1]];
			}
			for(int d =0; d<4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				
				if (map[nr][nc] == 0 || dist[nr][nc] != 0)
					continue;

				dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
				q.add(new int[] { nr, nc });
				
			}
			
			
		}
		return -1;
	}
}
